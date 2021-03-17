/* DELETE PREVIOUS DATA FROM TABLES */
delete from address;
delete from category;
delete from order_address;
delete from order_item;
delete from product;
delete from product_cat;
delete from product_image;
delete from product_order;
delete from user;

/* INSERT DATA INTO USER */
insert into user(user_name, user_phone, user_type)
values ('Yash', 9588935381, 'admin'),
('Neha', 9660310922, 'customer'),
('Shailesh', 8278645125, 'customer'),
('Nilesh', 8245645125, 'customer');

select * from user;

/* INSERT DATA INTO CATEGORY */
insert into category(cat_name, parent_cat_id)
values ('Books', NULL),
('Motivational', 1),
('Fictional', 1),
('Mysteries', 1),
('Mobile Phones', NULL),
('Apple', 5),
('Oneplus', 5),
('Samsung', 5);

select * from category;

/* INSERT INTO PRODUCT */
insert into product(product_name, product_price, product_quantity)
values ('Think like a monk', 45, 10),
('One Arranged Murder', 400, 25),
('iPhone 11 pro 256 gb', 99999.99, 5),
('OnePlus 9 Pro', 59999, 8);

select * from product;

/* INSERT INTO PRODUCT CATEGORY */
insert into product_cat(product_id, cat_id)
values (1, 2),
(2, 4),
(3, 6),
(4, 7);

select * from product_cat;

/* INSERT INTO PRODUCT IMAGES */
insert into product_image(image_name, product_id)
values ('TLAM', 1),
('iPhone 11 front', 3),
('iPhone 11 back', 3),
('Oneplus9', 4);

select * from product_image;

/* INSERT INTO ADDRESS */
insert into address(locality, city, state_name, zip_code)
values ('Talheti', 'Abu Road', 'Rajasthan', 307026),
('Pipali Chowk', 'Sanchore', 'Rajasthan', 343041);

select * from address;

/* INSERT INTO PRODUCT ORDER */
insert into product_order(user_id, order_date)
values (2, '2021-03-17'),
(3, '2021-01-20');

select * from product_order;

/* INSERT INTO ORDER ITEM */
insert into order_item(order_id, product_id, quantity, product_status)
values (1, 3, 1, 'shipping'),
(2, 1, 2, 'returned');

select * from order_item;

/* INSERT INTO ORDER ADDRESS */
insert into order_address(order_id, address_id)
values (1, 1),
(2, 2);

select * from order_address;

/* DATA FETCHING */
select product.product_id, product_name, cat_name, product_price
from product
inner join product_cat on product.product_id = product_cat.product_id
inner join category on product_cat.cat_id = category.cat_id
where product_quantity > 0
order by product.product_id desc;

select product_name from product
left outer join product_image on product.product_id = product_image.product_id
where product_image.image_id is NULL;

select cat.cat_id, cat.cat_name,
ifnull(parent.cat_name, 'Top Category') as parent_cat_name
from category as cat
left outer join category as parent
on cat.parent_cat_id = parent.cat_id
order by parent.cat_name, cat.cat_name;

select cat.cat_id, cat.cat_name, p.cat_name as parent_cat_name
from category as cat
right outer join category as p
on cat.parent_cat_id = p.cat_id
where cat.cat_name is not NULL;

select product_name, product_price
from product as p
inner join product_cat as cat
on p.product_id = cat.product_id
inner join category as c
on c.cat_id = cat.cat_id
where cat_name = 'Books';

select * from product
where product_quantity < 50;