-- 1. 현재 데이터베이스 문자셋 확인
SELECT SCHEMA_NAME AS 'database', DEFAULT_CHARACTER_SET_NAME AS 'character_set', DEFAULT_COLLATION_NAME AS 'collation'
FROM information_schema.SCHEMATA;

-- 2. 데이터베이스 생성
CREATE DATABASE IF NOT EXISTS `test_back`
CHARACTER SET utf8mb4
COLLATE utf8mb4_general_ci;

-- 3. 테이블 생성
USE `test_back`;
CREATE TABLE IF NOT EXISTS test_back (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100)
);

-- 1. 기존 테이블 삭제
DROP TABLE IF EXISTS Menu;
DROP TABLE IF EXISTS Restaurant;

-- 2. Restaurant 테이블 생성
CREATE TABLE Restaurant (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    phoneNumber VARCHAR(20) NOT NULL
);

-- 3. Menu 테이블 생성
CREATE TABLE Menu (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    price DOUBLE NOT NULL,
    description VARCHAR(50) NOT NULL,
    restaurant_id BIGINT NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES Restaurant(id)
);



