CREATE TABLE product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    price INT NOT NULL,
    stock INT NOT NULL
);

INSERT INTO product(product_name, category, price, stock) VALUES
('기계식 키보드', '전자기기', 120000, 20),
('무선 마우스', '전자기기', 50000, 50),
('모니터 받침대', '가구', 35000, 30),
('사무용 의자', '가구', 200000, 10),
('텀블러', '생활용품', 25000, 100),
('노트북 거치대', '전자기기', 70000, 15);

CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    total_price INT NOT NULL,
    order_date DATETIME DEFAULT NOW()
);

-- 전체 상품 조회 프로시저 만들기
-- get_all_procedure
-- product 테이블의 전체 상품을 조회한다.
-- 가격이 높은 순서대로 정렬한다.

delimiter //
create procedure get_all_procedure()
begin
	select *
	from product
	order by price desc;
end //
delimiter ;

call get_all_procedure();

-- 상품 ID로 상품 조회하기
-- 이름 : get_product_by_id
-- 상품 id를 전달 받아서 해당 상품 정보를 조회하세요.
delimiter //
create procedure get_product_by_id(
	in p_product_id int
)
begin
	select *
	from product
	where product_id = p_product_id;
end //
delimiter ;

call get_product_by_id(1);

-- 카테고리별 상품 조회하기
-- 이름 : get_products_by_category
-- 카테고리명을 입력받는다.
-- 해당 카테고리의 상품만 조회한다.
-- 가격이 낮은 순으로 정렬한다.
delimiter //
create procedure get_products_by_category(
	in p_category varchar(50)
)
begin
	select *
	from product
	where category = p_category
	order by price asc;
end //
delimiter ;

call get_products_by_category('전자기기');

-- 상품 재고를 반환받기
-- 이름 : get_product_stock
-- 상품 ID를 입력받는다.
-- 해당 상품의 재고를 OUT 매개변수로 반환한다.
-- 호출 후 세션 변수로 결과를 확인한다.
delimiter //
create procedure get_product_stock(
	in p_product_id int,
	out p_stock int
)
begin
	select stock
	into p_stock
	from product
	where product_id = p_product_id;
end //
delimiter ;

call get_product_stock(1,@my_stock);
select @my_stock as '현재 재고';

-- 상품 추가 프로시저 만들기
-- 이름 : insert_product
-- 상품명, 카테고리, 가격, 재고를 입력 받아서 product 테이블에 상품을 추가한다
-- 추가 후 전체 상품 목록을 조회한다.
delimiter //
create procedure insert_product(
	in p_product_name varchar(100),
	in p_category varchar(50),
	in p_price int,
	in p_stock int
)
begin
	insert into product(
		product_name,
		category,
		price,
		stock
	) values (
		p_product_name,
		p_category,
		p_price,
		p_stock
	);

	select * from product;
end //
delimiter ;

call insert_product('키캣','전자기기',4000,10);

-- 상품 가격 수정하기
-- 이름 : update_product_price
-- 상품 ID와 변경할 가격을 입력 받는다.
-- 해당 상품의 가격을 수정한다.
-- 수정된 행이 있으면 "가격이 수정되었습니다."
-- 수정된 행이 없으면 "해당 상품이 없습니다."
-- ROW_COUNT() : 변경된 행의 개수
delimiter //
create procedure update_product_price(
	in p_product_id int,
	in p_price int
)
begin
	update product
	set price = p_price
	where product_id = p_product_id;
	
	if row_count() > 0 then
		select '가격이 수정되었습니다.' as message;
	else
		select '해당 상품이 없습니다.' as message;
	end if;
end //
delimiter ;

call update_product_price(7,4000);
call update_product_price(8,5000);

-- 상품은 있으면 수정하고 없으면 추가하기
-- 이름 : upsert_product
-- 상품 id, 상품명, 카테고리, 가격, 재고를 입력받는다.
-- 입력받은 상품 id가 product테이블에 존재하면, 상품 정보를 수정한다.
-- 존재하지 않으면 새로운 상품을 추가한다.
-- 처리 결과를 메시지로 출력한다.
delimiter //
create procedure upsert_product(
	in p_product_id int,
	in p_product_name varchar(100),
	in p_category varchar(50),
	in p_price int,
	in p_stock int
)
begin
if exists (select 1 from product where product_id = p_product_id) then
	update product
	set product_name = p_product_name,
		category = p_category,
		price = p_price,
		stock = p_stock
	where product_id = p_product_id; 
	
	select '상품이 변경 되었습니다.' as message;

else insert into product(
		product_id,
		product_name,
		category,
		price,
		stock) values (
		p_product_id,
		p_product_name,
		p_category,
		p_price,
		p_stock);

		select '상품이 추가 되었습니다.' as message;
	end if;
end // 
delimiter ;

call upsert_product(8,'USB 허브', '전자기기',30000,40);
call upsert_product(9,'침대', '가구',100000,10);

-- 상품 id가 있으면 삭제하고 없으면 없다 메시지 출력하기
-- 이름 : delete_product_if_exists
-- 상품 id를 입력받고 해당 상품 id가 있으면 삭제한다.
-- 해당 상품 id가 없으면 "데이터가 없습니다."를 출력한다.
-- 삭제 성공 시 "삭제되었습니다."를 출력한다.
delimiter //
create procedure delete_product_if_exists(
	in p_product_id int
)
begin
	delete from product
	where product_id = p_product_id;
	
	if row_count() > 0 then
		select '삭제되었습니다.' as message;
	else
		select '데이터가 없습니다.' as message;
	end if;
end //
delimiter ;

call delete_product_if_exists(8);

-- 주문 처리 프로시저 만들기
-- 이름 : order_product
-- 상품 ID와 주문 수량을 입력받는다.
-- 상품이 존재하지 않으면 "상품이 존재하지 않습니다." 출력하기
-- 재고가 부족하면 "재고가 부족합니다" 출력하기
-- 재고가 충분하면 orders 테이블에 주문을 추가한다.
-- 주문 후 product테이블의 재고를 차감한다.
-- 주문 성공 시 "주문이 완료되었습니다."를 출력한다.
delimiter //
create procedure order_product(
	in p_product_id int,
	in p_quantity int
)
begin
	declare v_stock int;
	declare v_price int;

	select stock, price
	into v_stock, v_price
	from product
	where product_id = p_product_id;

if v_stock is null then
	select '상품이 존재하지 않습니다.' as message;

elseif v_stock < p_quantity then
	select '재고가 부족합니다.' as message;
	
else
	insert into orders (product_id, quantity, total_price, order_date )
	values (p_product_id,p_quantity,v_price * p_quantity, now());
	
	update product
	set stock = stock - p_quantity
	where product_id = p_product_id;
	
	select '주문이 완료되었습니다.' as message;
end if;
	
end //
delimiter ;

call order_product(9,20);

-- 가격 등급 조회 프로시저
-- 이름 : get_price_grade
-- 상품 id를 입력받는다.
-- 가격이 100,000원 이상이면 "고가 상품"이라고 출력하기
-- 50,000원 이상 100,000 미만이면 "중간 가격 상품"을 출력하기
-- 상품 가격이 50,000원 미만이면 "저가 상품" 출력하기
-- 상품이 없으면 "상품이 없습니다." 출력하기

delimiter //
create procedure get_price_grade(
	in p_product_id int
)
begin
	declare v_price int;

select price
into v_price
from product
where product_id = p_product_id;

if v_price is null then
	select '상품이 없습니다.';
	
elseif v_price >= 100000 then
	select '고가 상품' as message;

elseif v_price >= 50000 then
	select '중간 가격 상품' as message;

else select '저가 상품' as message;

end if;

end //
delimiter ;

call get_price_grade(6);