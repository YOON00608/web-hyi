CREATE TABLE sales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    region VARCHAR(20) NOT NULL,
    category VARCHAR(20) NOT NULL,
    product_name VARCHAR(50) NOT NULL,
    sales_amount INT NOT NULL,
    sales_date DATE NOT NULL
);

INSERT INTO sales (region, category, product_name, sales_amount, sales_date) VALUES
('서울', '전자제품', '노트북', 1200000, '2026-05-01'),
('서울', '전자제품', '마우스', 50000, '2026-05-01'),
('서울', '가구', '의자', 150000, '2026-05-02'),
('서울', '가구', '책상', 300000, '2026-05-02'),
('부산', '전자제품', '노트북', 1100000, '2026-05-01'),
('부산', '전자제품', '키보드', 80000, '2026-05-02'),
('부산', '가구', '의자', 130000, '2026-05-03'),
('부산', '가구', '책상', 280000, '2026-05-03'),
('대구', '전자제품', '마우스', 45000, '2026-05-01'),
('대구', '전자제품', '키보드', 75000, '2026-05-02'),
('대구', '가구', '의자', 120000, '2026-05-03'),
('대구', '가구', '책상', 250000, '2026-05-03');

-- 1. 지역별 매출 합게와 전체 매출 합계 조회
-- sales 테이블에서 지역별 매출 합계를 구하고, 마지막에 전체 합계도 함께 출력하기
-- region을 기준으로 그룹화
-- sum(sales_amount) 사용하기

select region, sum(sales_amount)
from sales
group by region with rollup;

-- 2. ROLLUP 결과의 NULL을 ‘전체합계’로 표시하기
-- 문제 1의 결과에서 NULL로 표시되는 전체 합계 행을 전체합계로 출력하시오.
select IFNULL(region,'전체 합계'), sum(sales_amount)
from sales
group by region with rollup;

-- 3. 지역별, 카테고리별 매출 합계와 소계 조회
-- 지역과 카테고리별 매출 합계를 구하고, 
-- 각 지역별 소계와 전체 합계도 함께 출력하시오.
select region, category, sum(sales_amount)
from sales
group by region, category with rollup;

-- 4. 지역별, 카테고리별 매출 소계를 보기 좋게 출력하기
-- 문제 3의 결과에서 NULL 값을 보기 좋은 문자로 바꾸시오.
select
	IFNULL(region,'지역 전체'),
	IFNULL(category, '지역 소계'),
	sum(sales_amount)
from sales
group by region, category with rollup;

-- 5. 지역별, 카테고리별 판매 건수와 매출 합계 조회
-- 지역별, 카테고리별로 판매 건수와 매출 합계를 구하고,
-- 지역별 소계와 전체 합계를 함께 출력하시오.
select region, category, count(*), sum(sales_amount)
from sales
group by region, category with rollup;

-- 6. 날짜별 매출 합계와 전체 합계 조회
-- 판매일자별 매출 합계를 구하고, 전체 매출 합계도 함께 출력하시오.
select IFNULL(cast(sales_date as char), '전체기간'), SUM(sales_amount)
from sales
group by sales_date with rollup;

-- 7. 특정 지역만 필터링한 뒤 ROLLUP 적용하기
-- 서울과 부산 데이터만 대상으로 지역별, 카테고리별 매출 합계와 소계를 구하시오.
select region, category, sum(sales_amount)
from sales
where region in('서울','부산')
group by region, category with rollup;

-- 8. 매출 합계가 1,000,000원 이상인 그룹만 조회하기
-- 지역별 매출 합계를 구한 뒤, 매출 합계가 1,000,000원 이상인 그룹만 출력하시오.
select region, sum(sales_amount)
from sales
group by region
having sum(sales_amount) >= 1000000;

CREATE TABLE employee (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,
    emp_name VARCHAR(30),
    department VARCHAR(30),
    salary INT
);

INSERT INTO employee (emp_name, department, salary) VALUES
('김철수', '개발팀', 7000),
('이영희', '개발팀', 7000),
('박민수', '개발팀', 5000),
('최유리', '인사팀', 6000),
('정하늘', '인사팀', 4000),
('한지민', '인사팀', 4000);

-- 급여가 높은 순으로 순번 부여하기
select *, rank()over(order by salary desc)
from employee;

-- 다음과 같은 형식으로 결과를 출력하세요
-- 개발팀 - 김철수 - 1위
select
	concat(
	department,
	'-',
	emp_name,
	'-',
	rank()over(order by salary desc),
	'위')
from employee;

-- 개발팀 직원들의 급요 순위를 출력하기
select
	emp_name,
	department,
	salary,
	rank()over(order by salary desc)
from employee
where department = '개발팀';


-- 부서별 순위
select
	emp_name,
	department,
	salary,
	rank()over(partition by department order by salary desc)
from employee;

CREATE TABLE board (
    board_id INT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(30),
    title VARCHAR(100),
    created_at DATETIME
);

INSERT INTO board(category, title, created_at) VALUES
('공지', '사이트 점검 안내', '2026-05-01 09:00:00'),
('공지', '회원가입 정책 변경', '2026-05-01 14:30:00'),
('자유', '오늘 점심 뭐 드셨나요?', '2026-05-02 12:10:00'),
('자유', '주말에 영화 추천 부탁드립니다', '2026-05-02 18:45:00'),
('질문', 'MySQL VARCHAR와 TEXT 차이가 뭔가요?', '2026-05-03 10:20:00'),
('질문', 'JOIN이 너무 어려운데 공부 방법 있을까요?', '2026-05-03 16:00:00'),
('후기', '리액트 강의 정말 도움이 됐습니다', '2026-05-04 11:15:00'),
('후기', '스프링부트 프로젝트 후기 남깁니다', '2026-05-04 19:40:00'),
('공지', '서버 점검 완료 안내', '2026-05-05 08:30:00'),
('자유', '요즘 공부할만한 기술 추천해주세요', '2026-05-05 21:05:00');

-- 카테고리별 최신 글을 자주 조회한다면
select *
from board
where category = '공지'
order by created_at desc;

create index idx_board_category_created
on board(category, created_at);

-- explain 으로 인덱스 사용 여부 확인
explain
select *
from board
where category = '공지'
order by created_at desc;

-- -> Index lookup on board using idx_board_category_created (category = '공지') (reverse)  (cost=0.8 rows=3)
-- board 테이블에서 idx_board_category_created 인덱스를 사용하여
-- category = '공지' 조건 데이터를 찾았고,
-- 역순으로 읽었으며
-- 예상 비용은 0.8 (cpu 사용량, 디스크 읽기, 메모리 사용량)
-- 예상 결과 행 수는 3개이다.

show index from board;

CREATE TABLE product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(50),
    category VARCHAR(30),
    price INT,
    stock INT,
    created_at DATE
);

INSERT INTO product
(product_name, category, price, stock, created_at)
VALUES
('노트북', '전자제품', 1200000, 10, '2026-05-01'),
('마우스', '전자제품', 30000, 100, '2026-05-02'),
('키보드', '전자제품', 80000, 50, '2026-05-03'),
('모니터', '전자제품', 350000, 20, '2026-05-04'),
('책상', '가구', 250000, 15, '2026-05-01'),
('의자', '가구', 120000, 30, '2026-05-02'),
('침대', '가구', 800000, 5, '2026-05-03'),
('텀블러', '생활용품', 25000, 200, '2026-05-04'),
('청소기', '생활용품', 500000, 8, '2026-05-05'),
('에어프라이어', '가전제품', 180000, 12, '2026-05-06');

-- 상품 검색용 인덱스 생성하기
-- product_name 컬럼에 인덱스를 생성하기
create index idx_product_name
on product(product_name);

-- 복합 인덱스 생성하기
-- 카테고리별 가격 검색을 빠르게 하기 위해 category, price 기준으로
-- 인덱스 생성하기
create index idx_product_price
on product(category, price);

-- product 테이블에 생성된 인덱스를 확인하기
show index from product;

-- idx_product_price 삭제하기
drop index idx_product_price on product;

-- 다음의 쿼리가 인덱스를 사용하는지 확인하기
select *
from product
where product_name = '노트북';

explain
select *
from product
where product_name = '노트북';

-- 1. 단일행 서브쿼리
-- 서브쿼리문의 결과가 1개의 값만 반환할 때 그 값을 이용하여 메인쿼리를 처리
-- 전체 평균 금액보다 큰 금액을 판 데이터 조회
select * 
from sales
where sales_amount > (select avg(sales_amount) from sales);

-- 사원테이블에서 박민수 사원의 급여보다 많이 받는 인사팀 직원을 조회하기
select *
from employee
where 
	department = '인사팀' and salary
	> (select salary from employee where emp_name = '박민수');

-- 전체 직원의 평균 급여보다 급여를 많이 받는 직원의 이름과 급여를 조회
select emp_name, salary
from employee
where
	salary > (select avg(salary) from employee);

-- 전체 직원 중 가장 높은 급여를 받는 직원의 이름과 급여를 조회
select emp_name, salary
from employee
where
	salary = (select max(salary) from employee);

-- 다중 행 서브쿼리
-- 서브쿼리가 여러 개의 결과를 반환

-- 개발팀 직원들이 받는 급여와 같은 급여를 받는 직원 조회하기
-- IN : 서브쿼리에서 조회된 값 중 하나라도 일치하는 것
select
	emp_name,
	department,
	salary
from employee
where salary in(
	select salary
	from employee
	where department = '개발팀');

-- ANY : 여러 값들 중 하나라도 조건을 만족하면 참
-- 인사팀 직원 중 한명이라도 받는 급여보다 높은 급여를 받는 직원 조회하기
select 
	emp_name,
	department,
	salary
from employee
where salary > any(
	select salary
	from employee
	where department = '인사팀'
);


-- ALL : 여러 값들 전부에 대해 조건을 만족해야 한다.
-- 인사팀의 모든 직원보다 급여가 높은 직원을 조회하기
select 
	emp_name,
	department,
	salary
from employee
where salary > all(
	select salary
	from employee
	where department = '인사팀'
);

-- sales 테이블에서 서울에서 판매된 상품명과 같은 상품을 판매한
-- 전체 데이터를 조회하기
select *
from sales
where product_name in(
	select product_name
	from sales
	where region = '서울'
);

-- 부산에서 판매된 카테고리와 같은 카테고리에 속한 상품을 모두 조회하기
select *
from sales
where category in(
	select category
	from sales
	where region = '부산'
);

-- 대구에서 판매된 전자제품과 같은 상품명을 가진 상품을 모둔 조회하기
select *
from sales
where product_name in(
	select product_name
	from sales
	where region =  '대구' and category = '전자제품'
);

-- 대구에서 판매된 상품 가격 중 하나라도 비싼 상품을 조회하기
select *
from sales
where sales_amount > any(
	select sales_amount
	from sales
	where region = '대구'
);

-- 부산의 가구 가격 중 하나보다 저렴한 상품을 조회하기
select *
from sales
where sales_amount < any(
	select sales_amount
	from sales
	where region = '부산' and category = '가구'
);

-- 대구에서 판매된 모든 상품보다 비싼 상품을 조회하기
select *
from sales
where sales_amount > all(
	select sales_amount 
	from sales
	where region = '대구'
);

-- 서울에서 판매된 모든 가구보다 저렴한 상품을 조회하기
select *
from sales
where sales_amount < all(
	select sales_amount 
	from sales
	where region = '서울' and category = '가구'
);


-- 다중컬럼 서브쿼리
-- 서브쿼리가 여러 컬럼을 동시에 반환하는 것
-- select 컬럼명
-- from 테이블명
-- where(컬럼1, 컬럼2) in(
--	select 컬럼1, 컬럼2
--	from 테이블명
-- );

-- 각 부서의 최고 급여를 받는 직원 조회하기
select department, max(salary)
from employee
group by department;

select emp_name, department, salary
from employee
where (department,salary) in(
	select department, max(salary)
	from employee
	group by department
);

-- 각 부서에서 가장 낮은 급여를 받는 직원의 이름, 부서, 급여 조회하기
select emp_name,department,salary
from employee
where(department,salary)in(
	select department, min(salary)
	from employee
	group by department
);

-- 부서별 최고 급여와 동일한 급여를 받는 직원의 이름, 부서, 급여 조회하기
select emp_name,department,salary
from employee
where(department,salary) in (
	select department, MAX(salary)
	from employee
	group by department
);

-- 전체 평균 급여 이상을 받는 직원의 이름, 부서, 급여 조회하기
select emp_name,department,salary
from employee
where salary >= (select avg(salary) from employee);

-- 각 부서 최고 급여 직원의 사번, 이름, 부서 조회하기
select emp_id, emp_name, department 
from employee
where (department,salary) in(
	select department, max(salary)
	from employee
	group by department
); 

-- 부서별 최저 급여를 받는 직원을 제외한 나머지 직원의 이름, 부서, 급여 조회하기
select emp_name,department,salary
from employee
where (department,salary) not in (
	select department, min(salary)
	from employee
	group by department
);

-- 각 부서에서 최고 급여를 받는 직원이 몇 명인지 조회하기
select department, count(*)
from employee
where (department,salary) in (
	select department, max(salary)
	from employee 
	group by department
)
group by department;


-- 김철수와 같은 부서, 같은 급여를 받는 직원 조회하기
select emp_name,department,salary 
from employee
where (department,salary) = (
	select department, salary
	from employee
	where emp_name = '김철수'
) and emp_name != '김철수';


