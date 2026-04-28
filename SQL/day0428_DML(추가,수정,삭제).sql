-- film 테이블에서 길이가 60분 이상 90분 이하인
-- 영화를 조회하세요
select title, length from film
where length between 60 and 90;

-- film 테이블에서 등급이 G또는 PG도는 PG-13인 영화의 제목과 길이, 등급을
-- 조회해주세요.
select title, length, rating from film
where rating in ('G','PG','PG-13'); 

-- actor 테이블에서 이름이 A로 시작하는 배우의 이름을 조회하기
select first_name, last_name  from  actor
where first_name like 'A%';

-- film테이블에서 제목에 LOVE가 포함된 영화의 제목을 조회하기
select title from film
where title like '%LOVE%';

-- actor 테이블에서 이름이 A로 시작하고 총 3글자인 배우의 이름을 조회하기
select first_name from actor
where first_name like 'A__';

-- actor에서 이름의 두 번째 글자가 A인 배우를 조회하기
select first_name from actor
where first_name like '_A%';

-- actor에서 이름이 정확히 4글자인 배우의 이름 조회하기
select first_name from actor
where first_name like '____';

-- NOT LIKE
-- 패턴이 일치하지 않는 데이터를 조회할 때 사용

select title from film
where title not like 'A%'; -- A로 시작하지 않는 것들을 조회

-- customer 테이블에서 이메일이 .org로 끝나는 고객을 조회하기
select first_name, email from customer
where email like '%.org';

-- film 테이블에서 제목에 dinosaur가 포함되어 있지 않은 영화의 제목을 조회하기
select title from film
where title not like '%dinosaur%';

-- 

-- INSERT(추가)

create table FRULT(
	id INT primary key,
	name VARCHAR(30),
	price INT
);

insert into frult (id, name, price)
values  (1, '사과' , 3000),
		(2, '바나나' , 2000),
		(3, '포도' , 5000);

insert into frult (id, name, price)
values (4, '복숭아' , 6000);

-- SELECT가 된 결과를 추가하는 방법

create table FRULT_BACKUP(
	id INT primary key,
	name VARCHAR(30),
	price INT
);

insert into frult_backup (id, name, price)
select id, name, price
from frult
where price <= 3000;

select * from frult_backup;

-- 일부 컬럼만 추가하기
insert into frult (id)
values (5);


-- 컬럼명을 생략하는 INSERT
insert into frult values (6, '딸기', 3900);

-- null 값을 직접 넣을 수 있다.
insert into frult values (7, '키위', null);

-- DEFAULT 값 사용하기
insert into tlb_student (id, naem, major, birth)
values (1, '홍길동', '컴퓨터공학', '2020-01-01');

select * from tlb_student;

insert into tlb_student (id, naem, major,gender,birth)
values (2, '이영희','산업디자인','W','2020-01-01');

select * from tlb_student;

insert into tlb_student (id, naem, major,gender,birth)
values (3, '김철수','화학공학','M','1980-01-02');

select * from tlb_student;

insert into flower (flowerName,color,price)
values ('장미','빨간색',3000),
	   ('해바라기','노란색',6000),
	   ('튤립','보라색',5000),
	   ('안개꽃','흰색',2000);

select * from flower;

-- 화분 테이블에 추가하기
select * from pot;

insert into pot (pot_ID,pot_Color,shape,flowerName)
values ('2026001','흰색','타원형','장미');

select * from pot;

insert into pot (pot_ID,pot_Color,shape,flowerName)
values ('2026002','검은색','네모','해바라기');

select * from pot;


-- tbl_student 테이블에 홍길동의 이름을 김길동으로 바꿔라
update tlb_student
set naem = '김길동'
where id = 1;

select * from tlb_student;

update tlb_student
set gender = default
where id = 3;

update flower
set flowerName = '진달래'
where color = '보라색' and price >= 5000;

select * from flower;

create table actor_practice as
select actor_id, first_name, last_name, last_update
from sakila.actor;

select * from actor_practice;

-- 배우 번호가 1번인 배우의 이름을 'JAMES'로 수정하기
update actor_practice
set first_name = 'JAMES'
where actor_id = 1;

select * from actor_practice;

-- 배우 번호가 2번인 배우의 이름을 'MINA', 성을 'LEE'로 수정하기
update actor_practice
set first_name = 'MINA', last_name ='LEE'
where actor_id = 2;

select * from actor_practice;

create table film_practice as
select *
from sakila.film;

-- 영화 번호가 1번인 영화의 대여 가격(rental_rate)을 4.99로 수정하기
update film_practice
set rental_rate = 4.99
where film_id = 1;

-- 배우 테이블에서 이름이 A로 시작하는 배우의 성을 'TEST'로 바꾸기
update actor_practice
set last_name = 'TEST'
where first_name like 'A%';

-- 영화 테이블에서 등급이 'R', 또는 'NC-17'인 영화의 대여기간을 3으로 수정하기
update film_practice
set rental_duration = 3
where rating in ('R','NC-17');

-- 영화 번호가 1인 영화에 대해 대여기간을 1증가 시키기
select title, rental_duration from film_practice
where film_id = 1;

update film_practice
set rental_duration = rental_duration + 1
where film_id = 1;

select * from film_practice;

-- 영화 테이블의 대여료를 10% 인상하세요
UPDATE film_practice
SET rental_rate = rental_rate * 1.1; 

-- 배우 테이블에서 id가 1인 배우 삭제하기
delete from actor_practice
where actor_id = 1;

select * from actor_practice where actor_id = 1;

-- 여러 행을 삭제
-- 이름이 JOHN인 배우 삭제하기
delete from actor_practice
where first_name  = 'JOHN';

-- LIKE를 이용한 삭제
-- 이름이 A로 시작하는 배우 삭제하기
delete from actor_practice
where first_name like 'A%';

-- 데이터만 전부 삭제하기
-- delete from actor_practice;

-- 외래키 컬럼이 데이터를 참조하고 있으면 참조 당하는 쪽의 데이터를
-- 먼저 삭제할 수 없다.
-- 외래키를 설정할 때 on delete CASCADE 설정을 주게 되면
-- 같이 삭제 된다.

-- POT 테이블에서 장미꽃을 담고있는 화분 데이터 삭제하기
delete from pot
where pot_id = '2026001';

-- flower 테이블의 장미 삭제하기
delete from flower
where flower_name = '장미';

create table PRODUCT(
	no INT primary key,
	name VARCHAR(100),
	price INT,
	p_date DATE
);

insert into product (no, name, price, p_date)
values  (1000,'컴퓨터',100,'2021-04-15'),
		(1002,'냉장고',200,'2021-03-29'),
		(1003,'에어컨',300,'2020-12-15'),
		(1004,'오디오',20,'2020-12-15'),
		(1001,'세탁기',60,'2021-04-15');


update product
set price = price + 20
where no = 1000;

delete from product
where name = '세탁기';

select name, price from product;

update product
set price = price - 1900
where no = 1000;

select name, price from product;

-- 사용자 생성하기
create user 'student_user'@'localhost'
identified by '1234';

-- 사용자 확인하기
-- MySQL 사용자는 mysql.user 테이블에서 확인할 수 있다.
select user, host from mysql.user;

-- 사용자에게 권한 주기
-- GRANT
-- GRANT 권한 ON 데이터베이스명.테이블명 TO '사용자명'@'접속위치';

-- sakila 데이터베이스의 actor 테이블을 조회할 수 있는 권한 주기
grant select on sakila.actor to 'student_user'@'localhost';

select * from actor;

-- sakila 데이터베이스의 다른 테이블에도 접근할 수 있다.
grant select,insert,update on sakila.* to 'student_user'@'localhost';

-- 모든 권한 부여하기
grant all privileges
on sakila.*
to 'student_user'@'localhost';

-- 권한 확인하기
show grants for 'student_user'@'localhost';

-- REVOKE
-- 사용자에게 부여한 권한을 회수하는 명령어
-- REVOKE 권한 ON 데이터베이스명.테이블명 FROM '사용자명'@'접속위치';

revoke select 
on sakila.actor
from 'student_user'@'localhost';

revoke all privileges
on sakila.*
from 'student_user'@'localhost';

show grants for 'student_user'@'localhost';

-- 자주 쓰이는 권한의 종류
-- select, insert, update, delete -> 데이터 관련 
-- create, drop, alter -> 테이블 관련 

drop user 'student_user'@'localhost';

-- 모든 위치에서 접속이 가능한 'test_user' 사용자를 생성하기
-- 비밀번호는 1234
create user 'test_user'@'localhost'
identified by '1234';

-- test_user 에게 sakila 데이터베이스의 film 테이블에 조회, 추가 권한을 부여하기
grant select, insert
on sakila.film
to 'test_user'@'localhost';

-- test_user의 권한을 확인하기
show grants for 'test_user'@'localhost';

-- test_user에게 부여한 sakila.film의 조회권한을 회수하세요
revoke select
on sakila.film
from 'test_user'@'localhost';

-- test_user를 삭제하세요
drop user 'test_user'@'localhost';


-- 영화 가격 수정하기
select title, rental_rate from film_practice;

start transaction;

-- 임시 상태
update film_practice
set rental_rate = rental_rate + 1
where film_id = 1;

-- ROLLBACK을 통해 되돌리기
rollback;

-- COMMIT 을 해서 확정하기
commit;


create table Employee(
	emp_id INT primary key,
	emp_name VARCHAR(50),
	salary INT
);

insert into employee (emp_id, emp_name ,salary)
values  (1, '김철수', 3000),
		(2, '이영희', 4000),
		(3, '박민수', null);

update employee
set salary = salary * 1.1
where emp_name = '이영희';

select * from film_practice
where rental_duration between 5 and 7
and rental_rate in(2.99,4.99);

select user_id from post;

drop table employee;











