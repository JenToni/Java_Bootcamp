CREATE SCHEMA if NOT EXISTS service;

CREATE TABLE if NOT EXISTS service.user (
    id INTEGER IDENTITY PRIMARY KEY,
    login varchar(50),
    password varchar(50),
    authenticated boolean not null
);