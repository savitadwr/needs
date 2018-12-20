CREATE USER 'admin'@'%' IDENTIFIED BY 'test';
GRANT ALL ON *.* TO 'admin'@'%' WITH GRANT OPTION;

CREATE DATABASE needs;

USE needs;

CREATE TABLE test_needs (
  test_id                   BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  description               VARCHAR(255) NOT NULL
);