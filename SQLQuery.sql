CREATE DATABASE LTWeb;
USE LTWeb;

CREATE TABLE PhoneTbl(
	phone_id int PRIMARY KEY IDENTITY(1,1), 
	phone_name VARCHAR(255), 
	price varchar(255),
	imgURL varchar(255),
	brand VARCHAR(255),
	screen VARCHAR(255),
	OS VARCHAR(255),
	CPU VARCHAR(255),
	RAM VARCHAR(255),
	camera VARCHAR(255),
	battery VARCHAR(255)
);