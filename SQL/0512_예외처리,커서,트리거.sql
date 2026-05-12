create table MEMBER(
	member_id int primary key,
	member_name varchar(50) not null
);

delimiter // 
create procedure INSERT_MEMBER()
begin
	declare continue HANDLER for 1062
	
	begin
		select '이미 존재하는 회원 ID입니다.' as message;
	end;
	
	-- PK 값이 중복됨
	insert into member(member_id,member_name)
	values (1,'김철수');
	
	select '프로시저가 끝까지 실행되었습니다.' as result;
	
end //
delimiter ;

call INSERT_MEMBER();
-- 두 번째 insert에서 기본키 중복 에러가 발생하지만,
-- continue handler가 처리했기 때문에 프로시저가 끝까지 실행된다.

delimiter // 
create procedure INSERT_MEMBER_EXIT()
begin
	declare EXIT HANDLER for 1062
	
	begin
		select '중복 오류가 발생하여 프로시저를 종료합니다.' as message;
	end;
	
	-- PK 값이 중복됨
	insert into member(member_id,member_name)
	values (1,'김철수');
	
	select '이 문장은 실행되지 않습니다.' as result;
	
end //
delimiter ;

call INSERT_MEMBER_EXIT();

-- SELECT INTO 결과가 없을 때 처리하기
-- SELECT ... INTO는 조회 결과를 변수에 넣을 때 사용한다.
-- 조회 결과가 없으면 NOT FOUND 상황이 발생할 수 있다.

-- 프로시저명 : FIND_PRODUCT
-- 매개변수 : IN P_ID INT
-- ID를 통해 상품의 이름과 가격을 조회하기
-- 조회되는 게 없으면 '해당 상품이 없습니다.' 라고 조회하기

delimiter //
create procedure FIND_PRODUCT(
	in p_id int
)
begin
	-- 결과를 담을 변수 선언
	declare v_name varchar(50);
	declare v_price int;
	
	-- 에러 핸들러 선언
	declare continue HANDLER for not found
	
	begin
		select '해당 상품이 없습니다.' as message;
	end;
	
	-- 데이터 조회 및 변수 대입
	select product_name, price
	into v_name, v_price
	from product
	where product_id = p_id;
	
	-- 데이터가 존재할 경우에만 결과 출력
	if v_name is not null then
		select v_name as '상품명', v_price as '가격';
	end if;
	
end //
delimiter ;

call FIND_PRODUCT(1);
call FIND_PRODUCT(10); -- 해당 상품이 없습니다.


delimiter //
create procedure FIND_PRODUCT_SAFE(
	in p_id int
)
begin
	
	declare v_name varchar(50);
	declare v_price int;
	
	-- 플래그 변수
	-- 특정 상황이 발생했는지 기억해두는 변수 
	declare v_not_found boolean default false;
	
	declare continue HANDLER for not found
	
	begin
		set v_not_found = true;
	end;
	
	
	select product_name, price
	into v_name, v_price
	from product
	where product_id = p_id;
	
	if v_not_found then
		select '해당 상품이 없습니다.' as message;
	else
		select v_name as '상품명', v_price as '가격';
	end if;
	
end //
delimiter ;

call FIND_PRODUCT_SAFE(1);
call FIND_PRODUCT_SAFE(11);

-- SQLEXCEPTION으로 전체 SQL 오류 처리하기
-- 다양한 예외를 처리할 수 있다는 장점이 있으나
-- 어떤 예외가 발생했는지 알기 어렵다.

DELIMITER //

CREATE PROCEDURE add_product(
    IN p_id INT,
    IN p_name VARCHAR(50),
    in p_category varchar(50),
    IN p_price INT,
    IN p_stock INT,
    IN p_status varchar(50)
)
BEGIN
   
    DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
       SELECT '상품 등록 중 오류가 발생했습니다.' AS message;
    END;

    INSERT INTO product (product_id, product_name, category, price, stock, status)
    VALUES (p_id, p_name,p_category ,p_price, p_stock, p_status);

    SELECT '상품 등록 성공' AS message;

END //
DELIMITER ;

call add_product(11, '노트북 거치대', '전자기기' , 70000, 15,'판매중');

-- SIGNAL
-- 강제로 예외를 발생시키는 기능
-- PK중복, NOT NULL 위반, FOREIGN KEY 위반같은 상황에서는
-- 자동으로 예외가 발생한다.
-- 재고가 부족하면 주문 금지, 나이가 0보다 작으면 저장 금지, 이미 탈퇴한 회원은 주문 금지
-- 같은 비즈니스 로직도 검사를 해야한다.

DELIMITER //
create procedure order_product2(
    in p_id int, -- 제품 아이디
    in p_order_count int -- 주문 개수
)
begin
	declare v_stock int;
	
	declare exit handler for sqlexception
	begin
		select '주문 처리 중 오류가 발생했습니다.' as message;
	end;
	
	-- 프로시저를 호출할 때 전달한 제품 ID를 통해서 
	-- stock을 조회하여 v_stock에 대입하기
	select stock 
	into v_stock 
	from product
	where product_id = p_id;
	
	-- 주문량보다 재고가 부족할 때 강제로 예외 발생시키기
	if p_order_count > v_stock then
		signal sqlstate '45000'
		set message_text = '재고가 부족합니다.';
	end if;
	
	update product p
	set stock = stock - p_order_count
	where p.product_id = p_id;
	
	select '주문 완료' as message;
end //
DELIMITER ;

call order_product2(1,5);

CREATE TABLE user_account (
    user_id VARCHAR(30) PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE
);

-- 회원 추가 프로시저 작성하기
-- 프로시저 이름 : add_user_handler
-- 아이디, 이름, 이메일을 입력 받는다.
-- 정상 등록되면 '회원가입 성공'을 출력한다
-- 아이디 또는 이메일이 중복되면 '아이디 또는 이메일이 중복되었습니다.' 출력하기
delimiter //
create procedure add_user_handler(
	in p_id varchar(30),
	in p_name varchar(50),
	in p_email varchar(100)
)
begin
	declare exit handler for 1062
	
	begin
		select '아이디 또는 이메일이 중복되었습니다.' as message;
	end;
	
	insert into user_account(user_id,user_name,email)
	values (p_id, p_name, p_email);
	
	select '회원 가입 성공' as message;
	
end // 
delimiter ;

call add_user_handler('cake','홍길동','user@naver.com');

-- 도서 대여 처리 프로시저
CREATE TABLE book (
    book_id INT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(50),
    stock INT
);

CREATE TABLE book_rental (
    rental_id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT,
    rental_count INT,
    rental_date DATETIME DEFAULT NOW()
);

INSERT INTO book VALUES
(1, '혼자 공부하는 SQL', '우재남', 3),
(2, '이것이 자바다', '신용권', 5),
(3, '스프링 부트 입문', '김개발', 1),
(4, '리액트 시작하기', '이프론트', 0);

-- 문제
-- 도서 id와 대여 권수를 입력받아 도서를 대여하는 프로시저 rental_book 만들기
-- 요구사항
-- 도서 id와 대여 권수를 입력받는다.

-- 도서가 존재하지 않으면 '존재하지 않는 도서입니다.' 출력 
-- 대여 권수가 0이하면 '대여 권수는 1권 이상이어야 합니다.' 출력
-- 재고가 부족하면 '대여 가능한 재고가 부족합니다.' 출력

-- 정상 대여면 반복문을 사용하여 대여 권수만큼 'x 권 대여 처리중 ...' 이라고 출력
-- 정상 대여 후 book 테이블의 재고를 차감한다.
-- book_rental 테이블에 대여 내역을 추가한다.
-- 예외처리는 handler를 사용한다.

delimiter //
create procedure rental_book(
	in p_id int,
	in p_rental_count int
)
begin
	declare v_title varchar(100);
	declare v_stock int;
	declare v_i int default 1;
	declare v_not_found boolean default false;
	
	declare continue handler for not found
		set v_not_found = true;
	
	select stock, title 
	into v_stock, v_title
	from book
	where book_id = p_id;
	
	if v_not_found then
		select '존재하지 않는 도서입니다.' as message;
	
	elseif p_rental_count <= 0 then
		select '대여 권수는 1권 이상이어야 합니다.' as message;
		
	elseif v_stock < p_rental_count then
		select '대여 가능한 재고가 부족합니다.' as message;
	
	else 
		while v_i <= p_rental_count do
			select concat(v_i, '권 대여 처리중...') as progress;
			set v_i = v_i + 1;
		end while;
	
		update book
			set stock = stock - p_rental_count
			where book_id = p_id;
		
		insert into book_rental (book_id, rental_count)
		values (p_id,p_rental_count);
		
		select CONCAT(v_title, ' 대여가 완료 되었습니다.') as message;
		
	end if;
end // 
delimiter ;

call rental_book(88,1);

-- CURSOR
-- select 결과를 한 줄씩 꺼내서 처리하는 기능

select * from product; -- 결과를 한 번에 보여준다.

-- 커서를 사용하는 이유
-- 모든 상품을 하나씩 확인하면서 처리하고 싶을 때.
-- case, update를 사용해서 한 번에 처리할 수도 있지만,
-- 만약 행마다 복잡한 로직을 실행해야 한다면 CURSOR를 사용하는 게 유용하다.

-- 상품 한 행을 조회 -> 재고 상태 판단 -> 다른 테이블에 기록 -> 조건에 따라 추가 작업

-- 커서의 기본 구조
-- DECLARE 커서이름 CURSOR FOR
-- SELECT 컬럼 FROM 테이블명
-- OPEN 커서이름;
-- FETCH 커서이름 INTO 변수1, 변수2;
-- CLOSE 커서이름;

--  커서도 프로시저 안에서 사용을 해야한다.

DELIMITER //
create procedure print_book_stock()
begin
	declare v_title varchar(100);
	declare v_stock int;
	declare done boolean default false;
	
	declare book_cursor cursor for
	select title, stock
	from book;
	
	declare continue handler for not found
	begin
		set done = true;
	end;
	
	open book_cursor;
	
	-- 모든 행을 다 읽은 뒤 다시 fetch하면 더 이상 가져올 행이 없다.
	-- 이때 not found 예외가 발생한다.
	read_loop : loop
		fetch book_cursor into v_title, v_stock;
		
		if done then
			leave read_loop;
		end if;
		
		select CONCAT(v_title, '재고: ', v_stock,'권') as result;
	end loop;
		
		close book_cursor;
end //
DELIMITER ;

call print_book_stock();

-- student_score 테이블의 모든 학생을 커서로 한 명씩 읽어
-- 다음 형식으로 출력하는 print_student_score 프로시저 만들기
-- 김철수 - Java 점수 : 92점 

delimiter //
create procedure print_student_score()
begin 
	declare v_name varchar(100);
	declare v_subject varchar(50);
	declare v_score int;
	declare done boolean default false;
	
	declare student_score cursor for
	select student_name, subject, score
	from student_score;
	
	declare continue handler for not found
		set done = true;

	open student_score;
	
	score_loop : loop
		
		fetch student_score into v_name,v_subject, v_score;
		
		if done then
			leave score_loop;
		end if;
		
		select CONCAT(v_name, '-', v_subject, '점수 : ', v_score, '점') as result;
		
	end loop;
	
	close student_score;
	
end // 
delimiter ;

call print_student_score();

CREATE TABLE fail_student_log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    student_name VARCHAR(50),
    subject VARCHAR(50),
    score INT,
    reason VARCHAR(100),
    created_at DATETIME DEFAULT NOW()
);

-- 커서를 이용한 과락 학생 기록하기
-- student_score 테이블에서 점수가 60점 미만인 학생만 커서로 찾아서
-- fail_student_log 테이블에 기록하는 insert_fail_student_log 작성하기

delimiter //
create procedure insert_fail_student_log()
begin
    -- 변수 선언
    declare v_id int;
    declare v_name varchar(50);
    declare v_subject varchar(50);
    declare v_score int;
    declare v_reason varchar(100) default '점수 미달';
    declare done boolean default false;

    -- 커서 선언 (student_id 포함)
    declare log_cursor cursor for
    select student_id, student_name, subject, score
    from student_score;

    -- 핸들러 선언
    declare continue handler for not found
        set done = true;

    open log_cursor;

    log_loop : loop
        -- 커서에서 변수로 데이터 가져오기
        fetch log_cursor into v_id, v_name, v_subject, v_score;

        -- 데이터를 모두 읽었으면 루프 종료
        if done then
            leave log_loop;
        end if;

        -- 60점 미만인 경우만 로그 테이블에 기록
        if v_score < 60 then
            insert into fail_student_log (student_id, student_name, subject, score, reason)
            values (v_id, v_name, v_subject, v_score, v_reason);
        end if;

    end loop;

    close log_cursor;
end //
delimiter ;

call insert_fail_student_log();

select * from fail_student_log;

-- Trigger 
-- insert, update, delete가 발생했을 때 자동으로 실행되는 sql 프로그램
-- 주문이 들어오면 재고 자동 차감
-- 회원 정보가 수정되면 수정 로그를 저장
-- 급여가 음수가 입력되면 막기
-- 게시글이 삭제되면 기록 남기기 

-- 프로시저는 직접 호출해야 실행이 된다.
-- 트리거는 자동으로 실행된다.

-- 트리거 작동 시점
-- BEFORE : 데이터가 저장, 수정, 삭제 되기 전에 실행
-- AFTER : 데이터가 저장, 수정, 삭제 된 후에 실행

-- 실행 이벤트
-- INSERT : 데이터 추가 시 실행
-- UPDATE : 데이터 수정 시 실행
-- DELETE : 데이터 삭제 시 실행

-- NEW : 새로 들어오거나 수정될 값
-- OLD : 기존에 있던 값
-- DELIMITER //
-- CREATE TRIGGER 트리거명
-- [BEFORE 또는 AFTER] [INSERT 또는 UPDATE 또는 DELETE] 
-- ON 테이블명
-- FOR EACH ROW 
-- BEGIN
-- 실행할 SQL;
-- END //
-- DELIMITER ;

CREATE TABLE board (
    board_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    content TEXT,
    writer VARCHAR(50),
    view_count INT DEFAULT 0,
    status VARCHAR(20) DEFAULT 'ACTIVE',
    created_at DATETIME DEFAULT NOW(),
    updated_at DATETIME
);

CREATE TABLE board_log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    board_id INT,
    action_type VARCHAR(20),
    old_title VARCHAR(100),
    new_title VARCHAR(100),
    log_message VARCHAR(255),
    created_at DATETIME DEFAULT NOW()
);

-- board 테이블에 게시글이 추가되면 board_log테이블에
-- 등록 로그를 남기는 트리거 작성하기

delimiter //
create trigger trg_board_after_insert
after insert on board
for each row

begin
	insert into board_log(log_id,action_type,new_title,log_message)
	values (
		new.board_id, -- 새로 추가된 값을 가져온다.
		'insert',
		new.title,
		'게시글이 등록되었습니다.'
	);
end // 
delimiter ;

-- board 테이블에 데이터 추가하기
insert into board(title, content, writer)
values ('첫 번째 게시글','트리거 실습입니다.','홍길동');

select * from board;
select * from board_log;


-- 게시글이 수정됐을 때 로그를 기록하는 트리거
-- 게시글 제목이 수정되면 변경 전 제목과 변경 후 제목을 board_log 테이블에 저장
delimiter //
create trigger trg_board_after_update
after update on board
for each row

begin
	if old.title <> new.title then
		insert into board_log(
			board_id,
			action_type,
			old_title,
			new_title,
			log_message
		) values (
			new.board_id,
			'update',
			old.title,
			new.title,
			'게시글 제목이 수정되었습니다.'
		);
	end if;
end // 
delimiter ;

update board
	set title = '새 제목'
where board_id = 1;
	
select * from board_log;

select * from board;

-- 게시글이 수정될 때마다 board테이블의 update_at에 현재 시간을 자동 저장하는
-- trg_board_before_update 만들기
-- 1. 기존에 같은 이름의 트리거가 있다면 삭제
delimiter //

create trigger trg_board_before_update
before update on board
for each row
begin
  
    set new.updated_at = now();
end //

delimiter ;

update board
	set content = '수정하기'
where board_id = 1;

select * from board;
select * from board_log;