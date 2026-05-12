-- 프로시저 이름 : even_sum
-- 입력받은 두 숫자 사이의 짝수만 더하여 결과 출력하기
-- 시작값과 끝값은 in 매개변수로 받는다.
-- while 사용
-- 짝수만 누적
-- 결과는 select로 출력하기
delimiter //
create procedure even_sum(
	in p_start int,
	in p_end int)
begin
	declare v_num int;
	declare v_total int default 0;

set v_num = p_start;

while v_num <= p_end do
	if mod(v_num, 2) = 0 then
		set v_total = v_total + v_num;
	end if;

	set v_num = v_num + 1;
end while;

select p_start as '시작', p_end as '끝', v_total as '짝수 합계';
end //
delimiter ;

call even_sum(1, 5);

-- 회원등급 자동 변경
create table customer (
    customer_id INT primary key,
    customer_name VARCHAR(50),
    total_amount INT,
    grade VARCHAR(20)
);

insert into customer
values
	(1,'김철수',120000,null),
	(2,'이영희',80000,null),
	(3,'박민수',300000,null);

-- 모든 회원을 반복 조회하면서 등급 갱신하기
-- 프로시저 이름 : update_customer_grade
-- 조건
-- 구매금액      등급
-- 20만원 이상      VIP
-- 10만원 이상      GOLD
-- 나머지         SILVER

delimiter //
create procedure update_customer_grade()
begin
	declare v_id int default 1;
	declare v_max_id int;
	declare v_amount int;

-- 전체 고객 수(최대ID) 파악
	select
		max(customer_id)
		into v_max_id
		from customer;

-- 루프 시작 
	while v_id <= v_max_id do

	-- 현재 고객의 금액 조회
		select total_amount
			into v_amount
			from customer
			where customer_id = v_id;
	
-- 금액이 존재할 때만 업데이트
		if v_amount is not null then
			update customer
		set grade = 
		 	case 
				when total_amount >= 200000 then 'VIP'
				when total_amount >= 100000 then 'GOLD'
				else 'SILVER'
			end	

-- 현재 행만 업데이트
			where customer_id = v_id;
		end if;

-- 다음 고객으로 넘어가기
		set v_id = v_id + 1;

	end while;

select customer_name, total_amount, grade from customer;
end //
delimiter ;

call update_customer_grade();

-- 새로운 회원을 추가
-- 4, 최민준, 250000, null
-- 새 회원의 등급을 정해주세요.

insert into customer
values (4,'최민준',250000,null);

call update_customer_grade();

create table cart (
    cart_id INT primary key,
    product_name VARCHAR(50),
    price INT
);

insert into cart
values(1,'마우스',30000),(2,'키보드',50000),(3,'모니터',200000);

-- 장바구니 금액을 누적하면서 배송비를 계산하시오
-- 프로시저 이름 : cart_amount
-- 누적금액 100000원 이상 -> 배송비 0원
-- 미만 -> 배송비 3000원
-- 상품을 하나씩 읽으며 누적
-- select를 이용하여 조회하기

delimiter //
create procedure calcault_cart_total()
begin
	declare v_id int default 1; -- 시작값 
	declare v_max_id int; -- 종교값 
	declare v_price int default 0; -- 가격을 담을 변수 
	declare v_total int default 0; -- 총합을 담을 변수 
	declare v_delivery_fee int; -- 배송비를 담을 변수

select max(cart_id)
	into v_max_id
	from cart;

while v_id <= v_max_id do
	select price
	into v_price
	from cart
	where cart_id = v_id;
	
	-- 가격이 null이 아니라면 
	if v_price is not null then
		-- v_total에 누적시키고 
		set v_total = v_total + v_price;
	
		if v_total >= 100000 then
			set v_delivery_fee = 0;
		else 
			set v_delivery_fee = 3000;
		end if;

select
	v_total as '총 상품 금액',
	v_delivery_fee as '배송비';

end if;

	set v_id = v_id + 1;
end while; 
end //
delimiter ;

call calcault_cart_total();
