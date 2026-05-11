-- CASE문

-- product 테이블에서 상품명, 재고, 
-- 재고가 50개 이상이면 '재고 많음'
-- 10개 이상이면 '재고 보통'
-- 그 미만이면 '재고 부족'
select 
	product_name,
	stock,
	case
		when stock >= 50 then '재고 많음'
		when stock >= 10 then '재고 보통'
		else '재고부족'
	end as 'stock_sratus'
from product;

-- when은 조건
-- then은 조건이 참일 때 반환할 값
-- else는 어떠한 조건도 만족하지 않을 때 반환할 값
-- end는 case문의 끝을 의미한다.
-- 범위 조건은 큰 조건부터 작은 조건 순서대로 작성해야 한다.

-- 특정 컬럼의 값이 무엇인지 비교할 때 사용할 수 있다.
select 
	product_name,
	category,
	case category
		when '전자기기' then '전자제품 코너'
		when '가구' then '가구 코너'
		when '생활용품' then '생활용품 코너'
		else '기타 코너'
	end as display_area
from product;

-- case문은 select 절에서 사용되며 실제 테이블에 없는 가상의 결과 컬럼을 만들 수 있다.

-- case문은 order by에서도 사용할 수 있다.
-- 재고가 없는 순으로 정렬
select 
	product_name,
	stock
from product
order by 
	case
		when stock = 0 then 1
		when stock < 10 then 2
		when stock < 30 then 3
		else 4
	end,
	stock;
	
-- update문에서도 사용할 수 있다.
alter table product add column status varchar(20);

update product
set status =
	case
		when stock <= 10 then '재고 부족'
		else '판매중'
	end;

select * from product;

-- group by와 집계에도 자주 사용된다.
-- 상품이 가격대별로 몇 개씩 있는지 조회하기
select
	case
		when price >= 100000 then '고가'
		when price >= 50000 then '중가'
		else '저가'
	end as price_level,
	count(*) as product_count
from product
group by 
	price_level;

-- sum과 case를 같이 사용하면 보견별 집계가 가능하다.
-- 조건별 개수를 직접 계산한다.
select 
	sum(case when category = '전자기기' then 1 else 0 end) as electronics_countm,
	sum(case when category = '가구' then 1 else 0 end) as furniture_count,
	sum(case when category = '생활용품' then 1 else 0 end) as lide_count
from product;

-- 카테고리별로 그룹을 만든다.
select 
	category, count(*)
from product p
group by category;

CREATE TABLE student_score (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(30),
    subject VARCHAR(30),
    score INT,
    attendance_rate INT
);

INSERT INTO student_score VALUES
(1, '김철수', 'Java', 95, 98),
(2, '이영희', 'Java', 82, 90),
(3, '박민수', 'Java', 67, 75),
(4, '최유리', 'Database', 88, 92),
(5, '정하늘', 'Database', 73, 80),
(6, '한지민', 'Database', 55, 60),
(7, '강민호', 'Python', 100, 100),
(8, '윤서연', 'Python', 45, 50);

-- 점수 등급 출력하기
-- 90점 이상 A
-- 80점 이상 B
-- 70점 이상 C
-- 60점 이상 D
-- 그 외 F
-- 출력 컬럼 : student_name, score, grade

select 
	student_name,
	score,
	case
		when score >= 90 then 'A'
		when score >= 80 then 'B'
		when score >= 70 then 'C'
		when score >= 60 then 'D'
		else 'F'
	end as grade
from student_score;

-- 출석 상태 출력하기
-- 95이상 우수
-- 80이상 보통
-- 그 외 위험
-- 출력 컬럼 : 이름, 출석률, 출석 상태
select 
	student_name,
	attendance_rate,
	case
		when attendance_rate >= 95 then '우수'
		when attendance_rate >= 80 then '보통'
		else '위험'
	end as '출석 상태'
from student_score;

-- 과목별 난이도 표시하기
-- java -> 중급
-- Database -> 어려움
-- Python -> 쉬움
-- 출력컬럼 : subject, difficulty

select 
	subject,
	case subject
		when 'Java' then '중급'
		when 'Database' then '어려움'
		when 'Python' then '쉬움'
	end as difficulty
from student_score;

-- 장학생 여부 출력
-- 점수가 >= 90 이고, 출석률 >= 90
-- 둘 다 만족하면 '장학생'
-- 아니면 '일반 학생'
select 
	student_name,
	score,
	attendance_rate,
	case
		when score >= 90 and attendance_rate >= 90 then '장학생'
		else '일반 학생'
	end as '장학생 여부'
from student_score;

-- grade 컬럼을 추가한 후 다음 기준으로 값을 저장하기
-- 90점 이상 A
-- 80점 이상 B
-- 70점 이상 C
-- 60점 이상 D
-- 그 외 F
alter table student_score add column grade varchar(20);

update student_score
set grade =
	case
		when score >= 90 then 'A'
		when score >= 80 then 'B'
		when score >= 70 then 'C'
		when score >= 60 then 'D'
		else 'F'
	end;
	
select * from student_score;

-- WHILE문의 기본 문법
-- WHILE 조건 DO
-- 실행문;
-- END WHILE;

create table LOOP_TEST(
	num int
);

delimiter //
create procedure while_example()
begin
	declare v_num int default 1;
	
	while v_num <= 5 do
		insert into loop_test values (v_num);
		set v_num = v_num + 1;
	end while;
end //
delimiter ;

call while_example();

select * from loop_test;

-- repeat
-- 무조건 한 번 실행 후 조건 검사
-- repeat
-- 실행문;
-- until 조건
-- end repeat;
delimiter //
create procedure repeat_exmaple()
begin
	declare v_num int default 6; 
	
	repeat
		insert into loop_test values (v_num);
		set v_num = v_num + 1;
		
		until v_num > 10 -- 조건이 거짓이면 반복, 참이면 종료
	end repeat;
end //
delimiter ;

call repeat_exmaple();

select * from loop_test;

-- LOOP
-- 무한반복 기반
-- 직접 종료 조건을 만들어야 한다.
-- label : LOOP
-- 실행문;
-- IF 조건 THEN LEAVE label;
-- END IF;
-- END LOOP;

DELIMITER //
create procedure LOOP_EXAMPLE()
begin
	declare v_num int default 11;

	my_loop : loop
		insert into loop_test values(v_num);
		set v_num = v_num + 1; 
	
	if v_num > 16 then
		leave my_loop;
	end if;
end loop;
end //
DELIMITER ;

call LOOP_EXAMPLE();

select * from loop_test;

create table loop_result(
	value_text varchar(100)
);

-- while문을 이용하여 1 ~ 20 까지의 수 중 짝수만 저장하세요.
delimiter // 
create procedure even_numbers()
begin
	declare v_num int default 1;
	
	while v_num <= 20 do
	
	if v_num % 2 = 0 then
		insert into loop_result values (v_num);
	end if;
	
		set v_num = v_num + 1;
	end while;
end // 
delimiter ;

call even_numbers();
select * from loop_result;

delete from loop_result;

-- repeat문을 사용하여 1부터 10까지의 총합 구하기

delimiter //
create procedure repeat_total_sum()
begin
	declare v_num int default 1;
	declare v_total int default 0;

	repeat
		set v_total = v_total + v_num;
		set v_num = v_num + 1;
	
	until v_num > 10
	end repeat;
	
	select v_total as '1부터 10까지의 총합';
end //
delimiter ;

call repeat_total_sum();