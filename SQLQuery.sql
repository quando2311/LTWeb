CREATE DATABASE LTWeb;
USE LTWeb;

CREATE TABLE AdminTbl(
	USERNAME VARCHAR(255),
	PASSWORD VARCHAR(255)
);

CREATE TABLE PhoneTbl(
	phone_id int PRIMARY KEY IDENTITY(1,1), 
	phone_name NVARCHAR(255), 
	price NVARCHAR(255),
	imgURL NVARCHAR(255),
	brand NVARCHAR(255),
	screen NVARCHAR(255),
	OS NVARCHAR(255),
	CPU NVARCHAR(255),
	RAM NVARCHAR(255),
	camera NVARCHAR(255),
	battery NVARCHAR(255)
);


CREATE TABLE USERTbl(
	ID INT PRIMARY KEY IDENTITY(1, 1),
	full_name NVARCHAR(255),
	phone_number VARCHAR(20),
	email VARCHAR(50),
	address NVARCHAR(255),
	id_citizen VARCHAR(15)
);

CREATE TABLE BillTbl(
	id INT PRIMARY KEY IDENTITY(1,1),
	id_customer INT FOREIGN KEY REFERENCES USERTbl(ID),
	purchase_date DATE,
	total_product INT, 
	total_price INT
);

CREATE TABLE PurchaseTbl(
	id INT PRIMARY KEY IDENTITY(1,1),
	id_bill INT FOREIGN KEY REFERENCES BillTbl(id),
	id_product INT FOREIGN KEY REFERENCES PhoneTbl(phone_id),
	amount INT
);

SELECT * FROM PhoneTbl;

INSERT INTO PhoneTbl VALUES ('test', 'test', 'test', 'test', 'test', 'test', 'test', 'test', 'test', 'test');
