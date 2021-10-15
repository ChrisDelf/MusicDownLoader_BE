CREATE TABLE users (
    id uuid NOT NULL PRIMARY KEY ,
    name VARCHAR(100) NOT NULL

);


CREATE TABLE song (
    id int NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    artist VARCHAR(100) NOT NULL,
    downloadDate VARCHAR(100) NOT NULL

);