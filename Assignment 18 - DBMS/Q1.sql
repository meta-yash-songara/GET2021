Drop database StoreFront;

Create database StoreFront;
use StoreFront;

create table User(
user_id int not null AUTO_INCREMENT,
user_name varchar(25),
user_phone bigint,
user_type varchar(30) CHECK(user_type IN ('admin', 'customer')),
primary key(user_id)
);

create table Product(
product_id int not null AUTO_INCREMENT,
product_name varchar(30),
product_price decimal(10, 4),
product_quantity int,
primary key(product_id)
);

create table Category(
cat_id int not null AUTO_INCREMENT,
cat_name varchar(50),
parent_cat_id int default -1,
primary key(cat_id)
);

create table Product_Cat(
product_id int,
cat_id int,
foreign key (product_id) references Product(product_id),
foreign key (cat_id) references Category(cat_id)
);

create table Product_Image(
image_id int not null AUTO_INCREMENT,
image_name varchar(50),
product_id int,
primary key(image_id),
foreign key(product_id) references Product(product_id)
);

create table Address(
address_id int not null AUTO_INCREMENT,
locality varchar(30),
city varchar(30),
state_name varchar(30),
zip_code int,
primary key(address_id)
);

create table Product_Order(
order_id int not null AUTO_INCREMENT,
user_id int,
order_amount decimal(10, 4),
order_date date,
primary key(order_id),
foreign key(user_id) references User(user_id)
);

create table Order_Address(
order_id int,
address_id int,
foreign key(order_id) references Product_Order(order_id),
foreign key(address_id) references Address(address_id)
);

create table Order_Item(
order_id int,
product_id int,
quantity int,
product_status varchar(20) CHECK(product_status IN ('shipping', 'returned', 'cancelled')),
foreign key(order_id) references Product_Order(order_id),
foreign key(product_id) references Product(product_id)
);

show tables;

set FOREIGN_KEY_CHECKS = 0;
drop table Product;
set FOREIGN_KEY_CHECKS = 1;

create table Product(
product_id int not null AUTO_INCREMENT,
product_name varchar(30),
product_price decimal(10, 4),
product_quantity int,
primary key(product_id)
);