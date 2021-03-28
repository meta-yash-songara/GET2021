/*Question 1*/

alter table product add index productNameIndex(product_name);
alter table product add index productPriceIndex(product_price);
show index from product;

alter table category add index catNameIndex(cat_name);
show index from category;

alter table product_order add index orderDateIndex(order_date);
show index from product_order;