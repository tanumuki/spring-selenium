DROP TABLE IF EXISTS user;
CREATE TABLE user AS SELECT * FROM CSVREAD('classpath:tables/user.csv');
DROP TABLE IF EXISTS cookies;
CREATE TABLE cookies AS SELECT * FROM CSVREAD('classpath:tables/cookies.csv');