-- 꽃 테이블과 화분 테이블 2개가 필요하고 꽃을 구매할 때 화분도 같이 구매한다.
-- 꽃은 꽃 이름(PK), 색깔, 가격이 존재한다.
-- 화분 제품번호(PK), 화분 색깔(VARCHAT(200)), 모양, 꽃 이름이 존재한다.
# 꽃 FLOWER
# 이름(PK) VARCHAT(200)
# ----------
# 색깔 VARCHAT(200)
# 가격 INT
#
# 화분 POT
# 제품번호(PK) VARCHAT(100)
# ----------
# 화분 색깔 VARCHAT(200)
# 모양 VARCHAT(100)
# 꽃 이름 VARCHAT(200)

CREATE TABLE FLOWER (
    flowerName VARCHAR(200) PRIMARY KEY,
    color VARCHAR(200),
    price INT
);

create table POT(
	pot_ID VARCHAR(100) primary key,
	pot_Color VARCHAR(200),
	shape VARCHAR(100),
	flowerName VARCHAR(200),
	
	constraint FK_POT_FLOWER foreign key (flowerName)
	references flower (flowerName)
);

CREATE TABLE User (
    user_ID INT PRIMARY KEY,
    user_Name VARCHAR(100) NOT NULL
);

CREATE TABLE Post (
    post_ID INT PRIMARY KEY,
    user_ID INT,
    title VARCHAR(500) NOT NULL,
    content TEXT,
    
    CONSTRAINT FK_POST_USER FOREIGN KEY (user_ID)
    REFERENCES User(user_ID) 
);

CREATE TABLE Comment (
    comment_ID INT PRIMARY KEY,
    post_ID INT,
    user_ID INT,
    content TEXT NOT NULL,
    createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT FK_COMMENT_POST FOREIGN KEY (post_ID)
    REFERENCES Post(post_ID),
    CONSTRAINT FK_COMMENT_USER FOREIGN KEY (user_ID)
    REFERENCES User(user_ID) 
);


















