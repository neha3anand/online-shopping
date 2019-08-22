CREATE TABLE category (
id IDENTITY,
name VARCHAR(50),
description VARCHAR(255),
image_url VARCHAR(50),
is_active BOOLEAN,

CONSTRAINT pk_category_id PRIMARY KEY (id)



);
INSERT INTO category(name,description,image_url,is_active) VALUES('MOBILE','description','up.jpg',true);
INSERT INTO category(name,description,image_url,is_active) VALUES('LAPTOP','description','down.jpg',true);
INSERT INTO category(name,description,image_url,is_active) VALUES('WATCHES','description','download.jpg',true);

CREATE TABLE user_detail (
id IDENTITY,
first_name VARCHAR(50),
last_name VARCHAR(50),
role VARCHAR(50),
enabled BOOLEAN,
password VARCHAR(50),
email VARCHAR(100),
contact_number VARCHAR(15),
CONSTRAINT pk_user_id PRIMARY KEY(id),

);
INSERT INTO user_detail(first_name,last_name,role,enabled,password,email,contact_number)
VALUES('NEHA','ANAND','ADMIN',true,'admin','neha03@gmai.com','123456789');


INSERT INTO user_detail(first_name,last_name,role,enabled,password,email,contact_number)
VALUES('SAUMYA','TIWARI','SUPPLIER',true,'123','somu@gmai.com','987654321');

INSERT INTO user_detail(first_name,last_name,role,enabled,password,email,contact_number)
VALUES('MONIKA','TIWARI','SUPPLIER',true,'123','monu@gmai.com','456789123');


CREATE TABLE product(
id IDENTITY,
code VARCHAR(20),
name VARCHAR(50),
brand VARCHAR(50),
description VARCHAR(255),
unit_price DECIMAL(10,2),
quantity INT,
is_active BOOLEAN,
category_id INT,
supplier_id INT,
purchases INT DEFAULT 0,
views INT DEFAULT 0,
CONSTRAINT pk_product_id PRIMARY KEY(id),
CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(id),
CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),

);
INSERT INTO product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES('111','POCO','XIOMI','GAMING PHONE','20000',8,true,1,2);



INSERT INTO product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES('222','MAC BOOK','APPLE','MAC WINDOWS','50000',5,true,2,2);



INSERT INTO product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES('333','RAGA','TITAN','WATER PROOF','5000',6,true,3,3);









