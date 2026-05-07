select * from sales;

-- 별칭(Alias)
-- 컬럼이나 테이블에 임시 이름을 붙이는 기능
-- 컬럼의 이름을 보기 좋게 변경
-- 테이블 이름을 짧게 줄인다.
-- 함수를 걸었을 때 너무 길어지면 별명을 줄 수 있다.
select category as "카테고리", avg_amount as "평균 판매량"
from (
	select category, avg(sales_amount) as avg_amount
	from sales
	group by category
) as t;

-- 부서별 평균을 inline view를 활용하여 조회하기
-- 출력 컬럼 : department, avg_salary
select department as "부서", avg_salary as "평균 급여"
from (
	select  department, avg(salary) as avg_salary
	from employee
	group by department
) as dept_avg;

-- 평균 급여가 5000 이상인 부서만 조회하기
select department as "부서", avg_salary as "평균 급여"
from (
	select department, AVG(salary) as avg_salary
	from employee
	group by department
	having AVG(salary) >= 5000
) as dept;

-- 각 부서의 최고 급여 조회하기
select department as "부서", max_salary as "급여"
from (
	select department, max(salary) as max_salary
	from employee
	group by department
)as dept_max;

-- SALES 테이블을 이용하여 지역별 판매 건수를 서브쿼리를 이용하여 조회하기
select *
from (
	select region, sum(sales_amount)
	from sales
	group by region
) as t;

-- 지역별로 최고 판매금액, 최저 판매금액, 최고와 최저 판매금액의 차이 조회하기
select
	region as '지역',
	max_amount as '최고 판매 금액',
	min_amount as '최저 판매 금액',
	result_amount as '최고 최저 판매금의 차이'
from (
	select 
		region,
		max(sales_amount) as max_amount,
		MIN(sales_amount) as min_amount,
		max(sales_amount) - MIN(sales_amount) as result_amount
	from sales
	group by region 
) as re;

-- 카테고리별 총 판매금액 조회 후 평균보다 높은 카테고리 조회하기
-- 1. 카테고리별 총 판매금액
-- 2. 그 결과들의 평균
select *
from (
	select category,
	SUM(sales_amount) as total_price
	from sales
	group by category
) as t
where total_price > (
	select AVG(total_price)
	from(
		select category,
			SUM(sales_amount) as total_price
		from sales
		group by category
	) as x
);

-- 상관 서브쿼리(Correlated Subquery)
-- 서브쿼리가 바깥쪽 쿼리의 값을 참조하는 서브쿼리
-- 서브쿼리가 혼자 실행될 수 없고, 바깥쪽 쿼리의 각 행마다 반복 실행되는 구조
select *
from sales
where sales_amount > (
	select AVG(sales_amount)
	from sales
);

-- 1. 전체 평균 가격을 구한다.
-- 2. 각 상품 가격과 비교한다.
-- 서브쿼리 1번 실행 -> 메인쿼리를 실행한다.

-- 상관 서브쿼리
select *
from sales s1
where sales_amount > (
	select AVG(sales_amount) as '평균'
	from sales s2
	where s2.region = s1.region
);

-- 서브쿼리에서 바깥쪽 쿼리의 s1.region을 참조하고 있다.
-- 각 행마다 자기 지역의 평균 가격을 구해서 비교하게 된다.
-- 서울 행 -> 서울 평균과 비교
-- 부산 행 -> 부산 평균과 비교
-- 대구 행 -> 대구 평균과 비교

-- 실행 방식
-- 1. 바깥쪽 쿼리에서 행을 하나 꺼낸다.
-- 2. 그 행의 값을 서브 쿼리에 전달한다.
-- 3. 서브쿼리를 실행한다.
-- 4. 결과를 비교하고,
-- 5. 다음 행으로 이동한다.

select region, AVG(sales_amount)
from sales
where region = '서울'
group by region;

-- having절 서브쿼리
select department, AVG(salary)
from employee
group by department
having avg (salary) > (
	select avg(salary) from employee
);

-- INSERT 서브쿼리
insert into employee_practice
select * from employee where salary >= 6000;

select * from employee_practice;

create table employee_practice(
	emp_id int primary key,
	emp_name varchar(100),
	department varchar(100),
	salary int
);

-- UPDATE 서브쿼리
-- 김철수와 같은 부서의 사람들 급여 10% 인상
update employee
set salary = salary * 1.1
where department = (
	select department
	from (
		select department
		from employee
		where emp_name = '김철수') t
);

select * from employee;

-- DELETE 서브쿼리
delete from employee
where salary < (
	select avg_salary
	from (
		select avg(salary) as avg_salary
		from employee
	) t
); 

select * from employee;

CREATE TABLE student (
  id INT PRIMARY KEY,
  name VARCHAR(50)
);

INSERT INTO student (id, name) VALUES
(1, '철수'),
(2, '영희'),
(3, '민수');

CREATE TABLE enroll (
  id INT PRIMARY KEY,
  student_id INT,
  class_name VARCHAR(50),
  constraint fk_enroll_student foreign key (student_id)
  references student(id)
);

INSERT INTO enroll (id, student_id, class_name) VALUES
(1, 1, '데이터베이스'),
(2, 1, '자바'),
(3, 2, '데이터베이스');

INSERT into enroll values(4,null,'파이썬');

-- INNER JOIN
-- 학생 이름, 수업명을 조회하기
select name, class_name
from student s
inner join enroll e
	on s.id = e.student_id;

-- inner 생략 가능
select name, class_name
from student s
join enroll e
	on s.id = e.student_id;

-- 고객
-- 상품
-- 주문
drop table product;

CREATE TABLE customer (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(30),
    grade VARCHAR(20)
);

CREATE TABLE product (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(50),
    category VARCHAR(30),
    price INT
);

CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    product_id INT,
    quantity INT,
    order_date DATE,
    CONSTRAINT fk_orders_customer
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    CONSTRAINT fk_orders_product
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

INSERT INTO customer VALUES
(1, '김민준', 'VIP'),
(2, '이서연', '일반'),
(3, '박지훈', 'VIP'),
(4, '최유나', '일반'),
(5, '정하늘', '실버');

INSERT INTO product VALUES
(101, '노트북', '전자제품', 1200000),
(102, '마우스', '전자제품', 50000),
(103, '키보드', '전자제품', 80000),
(201, '의자', '가구', 150000),
(202, '책상', '가구', 300000);

INSERT INTO orders VALUES
(1, 1, 101, 1, '2026-05-01'),
(2, 1, 102, 2, '2026-05-01'),
(3, 2, 201, 1, '2026-05-02'),
(4, 3, 101, 1, '2026-05-02'),
(5, 3, 202, 1, '2026-05-03'),
(6, 4, 103, 3, '2026-05-03'),
(7, 5, 201, 2, '2026-05-04'),
(8, 5, 102, 1, '2026-05-04');

-- 고객명, 삼품명, 주문수량, 주문일자 조회하기
select customer_name, product_name, quantity, order_date
from orders o
join customer c
on o.customer_id = c.customer_id
join product p
on o.product_id = p.product_id;

-- 고객별 총 구매 금액
select customer_name, sum(quantity * price) as total_price
from orders o
join customer c
	on o.customer_id = c.customer_id
join product p
	on o.product_id = p.product_id
group by c.customer_name;

-- 총 구매금액이 100만원 이상인 고객 조회하기
select customer_name, sum(quantity * price) as TOTAL_PRICE
from orders o
join customer c
	on o.customer_id = c.customer_id
join product p
	on o.product_id = p.product_id
group by c.customer_name
having TOTAL_PRICE >= 1000000;

-- 카테고리별 총 매출 조회
select category, sum(quantity * price) as TOTAL_PRICE
from orders o
join product p
	on o.product_id = p.product_id
group by p.category;

-- vip 고객의 주문내역 조회하기
-- 이름, 등급, 제품명, 주문수량, 주문날짜
select customer_name, grade, product_name, quantity, order_date 
from orders o
join customer c
	on o.customer_id = c.customer_id
join product p
	on o.product_id = p.product_id
where c.grade = 'VIP';

-- LEFT OUTER JOIN
select name, class_name
from student s 
left outer join enroll e
	on s.id = e.student_id;

-- 민수는 수강내역이 없지만, 왼쪽 테이블에 존재하므로 반드시 나온다.
-- 대신 enroll에 값이 없기 때문에 null로 채워진다.

INSERT INTO customer VALUES
(6, '한지민', '일반');

INSERT INTO product VALUES
(203, '소파', '가구', 700000);

-- 주문내역이 한 번도 없는 고객의 이름을 조회하세요
select customer_name 
from customer c  
left outer join orders o  
	on o.customer_id = c.customer_id
where order_id is null;

-- 모든 고객의 주문 건수를 조회하세요
-- 주문이 없는 고객은 0으로 출력되게 하세요.
select customer_name, count(order_id)
from customer c
left outer join orders o 
	on o.customer_id = c.customer_id
group by c.customer_name;

-- RIGHT OUTER JOIN
-- 오른쪽 테이블을 기준으로 전부 출력하는 join
select name, class_name
from student s 
right outer join enroll e
	on s.id = e.student_id;

-- '모든 수강 기록을 기준으로 학생 이름을 붙여줘' 라는 의미
-- 실문에서는 LEFT JOIN을 더 자주 사용하고, RIGTH JOIN은
-- 방향만 바뀐 개념이라 잘 쓰지 않는 편이다.

-- FULL OUTER JOIN
-- 양쪽 테이블의 모든 데이터를 조회
-- 일치하면 연결, 일치하지 않으면 없는 쪽을 NULL로 표시
-- MySQL은 Full Outer Join을 직접 지원하지는 않는다.
-- LEFT JOIN과 RIGHT JOIN을 UNION으로 합쳐서 구현한다.

-- UNION : 두 가지 SELECT 결과를 이어붙인다.
-- 중복제거를 자동으로 해준다.
-- UNION ALL : 중복 제거 없이 모두 출력이 된다.
select name, class_name
from student s 
left outer join enroll e
	on s.id = e.student_id
union
select name, class_name
from student s 
right outer join enroll e
	on s.id = e.student_id;


-- CROSS JOIN

CREATE TABLE color (
  name VARCHAR(20)
);

INSERT INTO color VALUES ('빨강'), ('파랑');

CREATE TABLE size (
  name VARCHAR(20)
);

INSERT INTO size VALUES ('S'), ('M'), ('L');

select c.name, e.name
from color c
cross join size e;

-- CROSS JOIN은 일반적인 조회에서는 많이 사용하지 않으나,
-- 모든 조합이 필요한 경우 사용한다.

-- SELF JOIN
CREATE TABLE employees (
  id INT PRIMARY KEY,
  name VARCHAR(50),
  manager_id INT  -- 상사의 id
);

INSERT INTO employees VALUES
(1, '대표', NULL),
(2, '팀장', 1),
(3, '사원A', 2),
(4, '사원B', 2);

-- 사원이 누구를 상사로 두고 있는지 조회하기
select
	e.name as employrr_name,
	m.name as manager_name
from employees e
left outer join employees m
on e.manager_id = m.id; # 사원의 매니저 ID와 상사의 ID가 같은 행끼리 붙여라

---------

-- 모든 고객과 상품의 가능한 조합을 조회하기
select c.customer_name, p.product_name 
from customer c 
cross join product p;

-- 모든 상품 조합 개수 조회하기
select count(*)
from customer c 
cross join product p;

-- 모든 고객과 전자제품 카테고리 상품 조합 조회하기
select c.customer_name, p.product_name 
from customer c 
cross join product p
where p.category = '전자제품';

-- CUSTOMER 테이블에 추천인 아이디 컬럼 추가(recommender_id)
-- 자료형은 int
alter table customer add recommender_id int;

UPDATE customer
SET recommender_id = NULL
WHERE customer_id = 1;

UPDATE customer
SET recommender_id = 1
WHERE customer_id = 2;

UPDATE customer
SET recommender_id = 1
WHERE customer_id = 3;

UPDATE customer
SET recommender_id = 2
WHERE customer_id = 4;

UPDATE customer
SET recommender_id = 3
WHERE customer_id = 5;

-- 고객명과 추천인 이름을 조회하기
select
	c.customer_name as customer,
	r.customer_name as recommender
from customer c 
join customer r
on c.recommender_id  = r.customer_id 

-- 추천인이 없는 고객 조회하기
select * from customer where recommender_id is null;

-- 추천 관계 문장 출력하기
-- ex) 이서연의 추천인은 김민준
select
	concat(c.customer_name,'의 추천인은 ',
	r.customer_name) as 'relation_info'
from customer c 
join customer r
on c.recommender_id  = r.customer_id 
	
-- 가장 많은 고객을 추천한 사람순으로 조회하기 (내림차순)
select r.customer_name as '추천인',
count(*) as '추천 횟수'
from customer c
join customer r
on c.recommender_id = r.customer_id
group by r.customer_name;
	
-- 고객테이블과 주소테이블을 이용하여
-- 고객의 이름, 성, 주소를 조회하기
select c.first_name, c.last_name, a.address 
from customer c
join address a
on c.address_id = a.address_id;

create view customer_address_view as
	select c.first_name, c.last_name, a.address 
	from customer c
	join address a
	on c.address_id = a.address_id;

-- 복잡한 select를 테이블처럼 사용할 수 있다.
select * from customer_address_view;

-- 영화 제목(film), 
-- 영화 번호(film),
-- 카테코리(film_category),
-- 대여로(film)를 조회하는 select문을 
-- film_category_view라는 이름의 view로 만들기
create view film_category_view as
	select f.film_id, f.title, c.name, f.rental_duration
		from film_category fc 
		join film f 
		on fc.film_id = f.film_id
		join category c
		on fc.category_id = c.category_id;

drop view film_category_view;

create view film_category_view as
	select 
		f.film_id,
		f.title,
		c.name,
		f.rental_rate
	from film f
		join film_category fc ON f.film_id = fc.film_id
		join JOIN category c ON fc.category_id = c.category_id;

select * from film_category_view;

drop view film_category_view;


create view film_category_view as
	select f.film_id, f.title, c.name, f.rental_rate
		from film_category fc 
		join film f 
		on fc.film_id = f.film_id
		join category c
		on fc.category_id = c.category_id;

select * from film_category_view;

-- 고객별 영화 대여 횟수를 customal_table_count_view로 만들기

create view customal_table_count_view as
select 
	c.customer_id,
	c.first_name,
	c.last_name,
	count(r.rental_id) as rental_count
	from customer c 
	join rental r 
	on c.customer_id = r.customer_id
group by
	c.customer_id,
	c.first_name,
	c.last_name;

select * from customal_table_count_view;



drop view film_category_view;

create view film_category_view as
	select 
		f.film_id,
		f.title,
		c.name,
		f.rental_rate
	from film f
		join film_category fc ON f.film_id = fc.film_id
		join category c ON fc.category_id = c.category_id;

select * from film_category_view;

-- 30번 이상 빌려본 고객의 정보를 조회하세요
select * from customal_table_count_view
where rental_count >= 30;

-- 1. 상품 테이블(product)에서 '노트북'의 가격보다
-- 비싼 모든 상품의 이름과 가격을 조회하세요. 
select product_name, price
from product
where price > (
	select price
	from product
	where product_name = '노트북'
);

-- 2. 주문 테이블(orders)에서 'VIP' 등급의 고객들이
-- 주문한 상품들의 상품 번호(product_id)와 상품명을 조회하세요.
-- (중복된 상품명은 제거하고 출력하세요.)
select p.product_id, p.product_name 
from product p 
join orders o on p.product_id = o.product_id
where o.customer_id in(
	select customer_id
	from customer
	where grade = 'VIP'
);

-- 3. 고객별로 총 주문 횟수를 구하고,
-- 그 주문 횟수가 전체 고객의 평균 주문 횟수보다 많은
-- 고객의 이름과 주문 횟수를 조회하세요.
select customer_name, order_count
from (
	select c.customer_name, count(o.order_id) as order_count
	from customer c
	left join orders o on c.customer_id = o.customer_id
	group by c.customer_id, c.customer_name
) as t
where t.order_count > (
	select avg(sub.cnt)
	from(
		select count(order_id) as cnt
		from orders
		group by customer_id
	)as sub
);

-- 4. 상품 테이블(product)에서 자신이 속한 카테고리의 평균 가격보다
-- 비싼 상품의 이름, 카테고리, 가격을 조회하세요.
-- 힌트: 메인 쿼리의 카테고리와 서브쿼리의 카테고리를 연결
-- (WHERE p1.category = p2.category)해야 합니다.

select p.product_name, p.category, p.price 
from product p
where p.price > (
	select avg(p2.price)
	from product p2 
	where p2.category = p.category
);






