-- 고객이름, 주문한 제품명을 left outer join을 이용하여 조회하기
-- on에 조건을 걸기
select c.customer_name as '고객이름', p.product_name as '제품명'
from customer c 
left outer join orders o
	on c.customer_id = o.customer_id
left outer join product p
	on o.product_id = p.product_id and p.product_name = '노트북';

create table customer(
	customer_id int AUTO_INCREMENT primary key,
	customer_name varchar(50),
	city varchar(30),
	grade varchar(20)
);

create table product(
	product_id int AUTO_INCREMENT primary key,
	product_name varchar(100),
	category varchar(50),
	price int,
	stock int
);

create table orders(
	order_id int AUTO_INCREMENT primary key,
	customer_id int,
	order_date date,
	status varchar(20),
	foreign key(customer_id) references customer(customer_id)
);

create table order_item(
	order_item int AUTO_INCREMENT primary key,
	order_id int,
	product_id int,
	quantity int,
	foreign key(order_id) references orders(order_id),
	foreign key(product_id) references product(product_id)
);

INSERT INTO customer (customer_name, city, grade) VALUES
('김민준', '서울', 'VIP'),
('이서연', '부산', 'GOLD'),
('박지훈', '대구', 'SILVER'),
('최유진', '서울', 'VIP'),
('정하늘', '광주', 'GOLD');

INSERT INTO product (product_name, category, price, stock) VALUES
('기계식 키보드', '전자기기', 120000, 20),
('무선 마우스', '전자기기', 50000, 50),
('모니터 받침대', '가구', 35000, 30),
('사무용 의자', '가구', 200000, 10),
('텀블러', '생활용품', 25000, 100),
('노트북 거치대', '전자기기', 70000, 15);

INSERT INTO orders (customer_id, order_date, status) VALUES
(1, '2026-05-01', '완료'),
(1, '2026-05-03', '완료'),
(2, '2026-05-04', '완료'),
(3, '2026-05-05', '취소'),
(4, '2026-05-06', '완료'),
(5, '2026-05-07', '완료');

INSERT INTO order_item (order_id, product_id, quantity) VALUES
(1, 1, 1),
(1, 2, 2),
(2, 5, 3),
(3, 3, 2),
(3, 6, 1),
(4, 1, 1),
(5, 4, 2),
(6, 5, 5);

-- view 이름 : v_order_detail
-- 조회할 컬럼
-- order_id, quantity -> order_item
-- customer_name, city -> customer
-- product_name, category -> product
-- order_date, status -> orders
-- price * quantity (별칭 order_amount)

create view v_order_detail as
select 
	oi.order_id,
	oi.quantity,
	c.customer_name,
	c.city,
	p.product_name,
	p.category,
	o.order_date,
	o.status,
	(p.price * oi.quantity) as order_amount
from order_item oi 
	join product p on oi.product_id = p.product_id
	join orders o  on oi.order_id = o.order_id
	join customer c on o.customer_id = c.customer_id;

select * from v_order_detail;

-- v_order_detail view를 사용하여
-- 주문 금액이 100,000 이상인 데이터만 조회하기
-- 조회 컬럼 : 주문자 이름, 제품명, 주문금액
select customer_name, product_name, order_amount
from v_order_detail
where order_amount >= 100000;

-- view 기반 통계 view 생성하기
-- v_order_detail을 사용하여 고객별 총 구매금액을 저장하는 v_customer_detail
-- view 만들기
-- customer_name, 총 구매 금액(total_amount)
-- 취소 주문은 제외한다.

create view v_customer_detail as
select 
	customer_name,
	sum(order_amount) as total_amount
from v_order_detail
where status = '완료'
group by customer_name;

select * from v_customer_detail;

-- v_customer_detail 를 활용해서 총 구매금액이 200000이상인 고개만 조회하는
-- v_vip_customer 뷰 만들기

create view v_vip_customer as
select *
from v_customer_detail
where total_amount >= 200000;

-- v_customer_detail을 활용하여
-- 구매금액 순위를 조회하기
-- 이름, 구매가격, 순위
select 
	customer_name,
	total_amount,
	rank()over(order by total_amount desc) as amount_rank
from v_customer_detail;

-- v_order_detail을 사용하여 카테고리별 총 매출 조회하기

select
	category,
	SUM(order_amount) as total_sales
from v_order_detail
where status = '완료'
group by category;

-- v_customer_detail 뷰를 사용하여 전체 평균 구매금액보다 높은 고객만 조회하기
select *
from v_customer_detail
where total_amount > (
	select AVG(total_amount)
	from v_customer_detail
);

-- 삭제 오류 예시
create view v_order_detail2 as
select
	order_id,
	status
from orders;

create view v_completed_order as
select *
from v_order_detail2
where status = '완료';

drop view v_order_detail2;

-- select * from v_completed_order; -> 에러 발생

-- 혹시나 삭제를 하게 된다면 마지막부터 역순으로 삭제하는 것을 권장한다.

-- 마지막에 실행된 INSERT가 만든 AUTO_INCREMENT값을 반환한다.
-- 한 번에 데이터를 추가할 때는 그 INSERT문에서 처음 생성된
-- AUTO_INCREMENT값을 반환한다.
select LAST_INSERT_ID();

-- 프로시저 만들기
DELIMITER //
create procedure hello_proc()
begin 
	select 'HELLO MYSQL';
end
DELIMITER ;

call hello_proc();

-- product 테이블의 전체 내용을 조회하는
-- show_product 프로시저 만들고 호출하여 결과 확인하기
DELIMITER //
create procedure show_product()
begin
	select * FROM product;
end
DELIMITER ;

call show_product();

-- 프로시저 삭제
drop procedure hello_proc;

-- 프로시저 목록 확인
show procedure status;

-- 변수 추가하기 
DELIMITER //
create procedure VARIABLE_PROC()
begin
	declare num int;
	set num = 100;
	select num;
end
DELIMITER ;

call VARIABLE_PROC();

-- product에서 101번의 제품 가격을 v_price
-- 변수에 넣어서 조회하는 get_product_price() 프로시저 만들기

DELIMITER //
create procedure get_product_price()
begin
	declare v_price int;
	
	select price 
	into v_price -- 테이블 조회 결과를 변수에 대입
	from product
	where product_id = 101;
	
	select v_price as product_price;
	
end
DELIMITER ;

call get_product_price();


-- DELIMITER //
-- create procedure get_product_price()
-- begin
-- 	declare v_price int;
-- 	
-- 	set v_price = (
-- 	select price
-- 	from product
-- 	where product_ud = 101;
-- 	)
-- 	
-- 	select v_price as product_price;
-- end
-- DELIMITER ;

DELIMITER //
create procedure find_product(in p_id int)
begin
	select *
	from product
	where product_id = p_id;
end
DELIMITER ;

call find_product(101);

DELIMITER //
create procedure GET_STOCK(
	in p_id INT,
	out p_stock INT
)
begin
	select stock
	into p_stock
	from product
	where product_id = p_id;
end
DELIMITER ;

call GET_STOCK(1,@result_stock);
select @result_stock;

-- INOUT 변수를 통해서 숫자를 전달받고, 10을 더한 뒤 내보내는
-- increase_number 프로시저 만들기
DELIMITER //
create procedure increase_number(inout p_num int)
	begin
		set p_num = p_num + 10;
	end
DELIMITER ;

-- 세션변수는 declare 없이 선언이 가능하다.
set @num = 5;

call increase_number(@num);

select @num;

DELIMITER //
create procedure check_stock(in p_id int)
begin
	declare v_stock int;

	select stock
	into v_stock
	from product
	where product_id = p_id;
	
	if v_stock >= 10 then
		select '재고가 충분합니다.' as message;
	elseif v_stock = 0 then
		select '품절입니다.' as message;
	end if;
end //
DELIMITER ;

call check_stock(6);

-- save_product 프로시저 만들기
-- product_id를 매개변수로 전달하여 조회가 된다면 상품정보를 수정하기
-- 조회가 안 된다면 새로운 상품을 추가하기
-- 매개변수는 다음과 같다.
-- p_product_id
-- p_product_name
-- p_category
-- p_price
-- p_stock
DELIMITER //

create procedure save_product(
    in p_product_id INT,
    in p_product_name VARCHAR(100),
    in p_category VARCHAR(50),
    in p_price INT,
    in p_stock INT
)
begin
   declare v_count int;

	select count(*)
	into v_count
	from product
	where product_id = p_product_id;
	
	if v_count = 0 then
    	insert into product (
        	product_id,
        	product_name,
        	category,
        	price,
        	stock)
        values (
			p_product_id,
			p_product_name,
			p_category,
			p_price,
			p_stock);   
	else
        update product 
        set product_name = p_product_name,
            category = p_category,
            price = p_price,
            stock = p_stock
        where product_id = p_product_id;
    end if;
end //

DELIMITER ;

call save_product(7,'USB 허브', '전자기기',30000,40);
call SAVE_PRODUCT(1,'기계식 키보드','전자기기',150000,50);
select * from product;

-- delete_product 프로시저 만들기
-- 전달받은 product_id가 있으면 해당 데이터 삭제하기
-- 존재하지 않으면 '데이터가 없습니다' 라고 출력하기
DELIMITER //
create procedure DELETE_PRODUCT(
   in P_PRODUCT_ID INT
)
begin
   declare V_COUNT INT;

   select COUNT(*)
   into v_count
   from product
   where product_id = p_product_id;
   
   if V_COUNT = 0 then
      select '데이터가 없습니다.' as MESSAGE;
   else
      delete from PRODUCT where PRODUCT_ID = P_PRODUCT_ID;
      select '삭제가 완료되었습니다.' as MESSAGE;
   end if;
end //
DELIMITER ;

call DELETE_PRODUCT(7);

-- 문제1. 특정 상품의 재고를 확인하고,
-- 재고가 설정값보다 적으면 지정된 양만큼 늘려준 뒤
-- "현재까지 총 몇 번의 보충이 있었는지"를 변수에 담기
-- 프로시저 이름: sp_replenish_stock
-- 매개변수
-- IN p_product_id INT
-- IN p_min_stock INT
-- IN p_add_qty INT
-- OUT p_final_stock INT
DELIMITER //
create procedure sp_replenish_stock(
	IN p_product_id INT,
 	IN p_min_stock INT,
 	IN p_add_qty INT,
 	OUT p_final_stock INT
)

begin
	declare v_curr_stock INT;
	
	select stock 
	into v_curr_stock
	from product
	where product_id = p_product_id;

	if v_curr_stock < p_min_stock then
		update product	
		set stock = stock + p_add_qty
		where product_id = p_product_id;
	
		select stock
		into p_final_stock
		from product
		where product_id = p_product_id;
	
	else
		set p_final_stock = v_curr_stock;
		select '재고가 충분합니다.' as message;
	end if;
end //
DELIMITER ;

CALL sp_replenish_stock(101, 5, 50, @res_stock);
SELECT @res_stock AS '업데이트 후 재고';