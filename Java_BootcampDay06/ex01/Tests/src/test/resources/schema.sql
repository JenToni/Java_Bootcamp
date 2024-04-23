CREATE SCHEMA if NOT EXISTS shop;

CREATE TABLE if NOT EXISTS shop.product (
    id INTEGER PRIMARY KEY,
    name varchar(25),
    price INT);