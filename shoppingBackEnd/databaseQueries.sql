
/*Oracle Database*/
CREATE TABLE category(
    id NUMBER(10),
    name varchar2(50),
    description varchar2(255),
    image_url varchar2(50),
    is_active varchar2(5),
    CONSTRAINT category_pk PRIMARY KEY (id),
    CONSTRAINT is_active_ck check(is_active in ('TRUE','FALSE'))
    );
CREATE SEQUENCE seq_Id
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

INSERT INTO CATEGORY (ID,NAME, DESCRIPTION, IMAGE_URL, IS_ACTIVE) VALUES (id_sequence.nextval,'Laptop','This is a Laptop.','cat_101.jpg','TRUE');

INSERT INTO CATEGORY (ID,NAME, DESCRIPTION, IMAGE_URL, IS_ACTIVE) VALUES (id_sequence.nextval,'Mobile','This is a Mobile.','cat_102.jpg','TRUE');

INSERT INTO CATEGORY (ID,NAME, DESCRIPTION, IMAGE_URL, IS_ACTIVE) VALUES (id_sequence.nextval,'TV','This is a TV.','cat_103.jpg','TRUE');


CREATE SEQUENCE id_sequence
      INCREMENT BY 1
      START WITH 1
      NOMAXVALUE
      NOCYCLE
      CACHE 10;
/*End Category Table*/
      
 CREATE TABLE user_detail (
    user_id NUMBER(10),
	first_name varchar2(50),
	last_name varchar2(50),
	role varchar2(50),
	enabled varchar2(5),
	password varchar2(60),
	email varchar2(100),
	contact_number varchar2(15),
	CONSTRAINT user_detail_pk PRIMARY KEY (user_id),
	CONSTRAINT enabled_ck check(enabled in ('TRUE','FALSE'))
);
CREATE SEQUENCE user_id_sequence
      INCREMENT BY 1
      START WITH 1
      NOMAXVALUE
      NOCYCLE
      CACHE 10;
/*insert User dat*/
INSERT INTO USER_DETAIL (USER_ID, FIRST_NAME, LAST_NAME, ROLE, ENABLED, PASSWORD, EMAIL, CONTACT_NUMBER) VALUES (user_id_sequence.nextval, 'sekh', 'mahadi', 'ADMIN', 'TRUE', '1234', 'msekh36@gmail.com', '01923012012');
INSERT INTO USER_DETAIL (USER_ID, FIRST_NAME, LAST_NAME, ROLE, ENABLED, PASSWORD, EMAIL, CONTACT_NUMBER) VALUES (user_id_sequence.nextval, 'sekh', 'maenul', 'USER', 'TRUE', '12345', 'msekh@gmail.com', '0177755546');
INSERT INTO USER_DETAIL (USER_ID, FIRST_NAME, LAST_NAME, ROLE, ENABLED, PASSWORD, EMAIL, CONTACT_NUMBER) VALUES (user_id_sequence.nextval, 'sekh', 'Rupon', 'USER', 'TRUE', '12345', 'sekhrupon@gmail.com', '01715194976');
INSERT INTO USER_DETAIL (USER_ID, FIRST_NAME, LAST_NAME, ROLE, ENABLED, PASSWORD, EMAIL, CONTACT_NUMBER) VALUES (user_id_sequence.nextval, 'sekh', 'Niaz', 'USER', 'TRUE', '12345', 'sekhniaz@gmail.com', '0172541761');

CREATE TABLE product (
	p_id NUMBER,
	code VARCHAR2(20),
	name VARCHAR2(50),
	brand VARCHAR2(50),
	description VARCHAR2(255),
	unit_price DECIMAL(10,2),
	quantity NUMBER,
	is_active varchar2(5),
	category_id NUMBER,
	supplier_id NUMBER,
	purchases NUMBER DEFAULT 0,
	views NUMBER DEFAULT 0,
	CONSTRAINT p_active_ck check(is_active in('TRUE','FALSE')),
	CONSTRAINT pk_product_id PRIMARY KEY (p_id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(user_id)	
);
CREATE SEQUENCE p_id_sequence
      INCREMENT BY 1
      START WITH 1
      NOMAXVALUE
      NOCYCLE
      CACHE 10;
-- adding five products
INSERT INTO product (p_id,code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES (p_id_sequence.nextval,'PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 18000, 5, 'TRUE', 3, 18, 0, 0 );

INSERT INTO product (p_id,code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES (p_id_sequence.nextval,'PRDDEF124NUHC', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, 'TRUE', 3,18, 0, 0 );

INSERT INTO product (p_id,code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES (p_id_sequence.nextval,'PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5,'TRUE', 3, 18, 0, 0 );

INSERT INTO product (p_id,code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES (p_id_sequence.nextval,'PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, 'TRUE', 2, 18, 0, 0 );

INSERT INTO product (p_id,code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES (p_id_sequence.nextval,'PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5,'TRUE', 2, 18, 0, 0 );

INSERT INTO product (p_id,code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES (p_id_sequence.nextval,'PRDABCXYZDEFX', 'Sony 10', 'Sony', 'This is one of the best TV series from dell that can be used!', 48000, 5,'TRUE', 1, 18, 0, 0 );


-- the address table to store the user billing and shipping addresses
CREATE TABLE address (
	id NUMBER,
	user_id int,
	address_line_one VARCHAR2(100),
	address_line_two VARCHAR2(100),
	city VARCHAR2(20),
	division VARCHAR2(20),
	country VARCHAR2(20),
	postal_code VARCHAR2(10),
	is_billing VARCHAR2(5),
	is_shipping VARCHAR2(5),
	CONSTRAINT billing_ck check(is_billing in('TRUE','FALSE')),
	CONSTRAINT shipping_ck check(is_shipping in('TRUE','FALSE')),
	CONSTRAINT fk_address_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (user_id),
	CONSTRAINT pk_address_id PRIMARY KEY (id)
);
CREATE SEQUENCE address_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
 -- the cart table to store the user cart top-level details
CREATE TABLE cart (
	id NUMBER,
	user_id INTEGER,
	grand_total DECIMAL(10,2),
	cart_lines INTEGER,
	CONSTRAINT fk_cart_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (user_id),
	CONSTRAINT pk_cart_id PRIMARY KEY (id)
);
