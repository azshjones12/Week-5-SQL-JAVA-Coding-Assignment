CREATE DATABASE IF NOT EXISTS tvshows;

USE tvshows;

DROP TABLE IF EXISTS tvshows;

CREATE TABLE tvshows (
	id int(10) NOT NULL AUTO_INCREMENT,
    first_name varchar(25) NOT NULL,
    last_name varchar(25) NOT NULL,
    tvshow_name varchar(50) NOT NULL,
    PRIMARY KEY(id)
);

SHOW databases;
USE tvshows;
SHOW tables;
desc tvshows;
INSERT INTO tvshows(first_name, last_name, tvshow_name) values("Terri", "Johnson", "Fresh Prince of Bel-Air");
SELECT * FROM tvshows;