/* 1st */
select u.user_id, user_name, user_phone, count(*) as orders_count
from user as u
inner join product_order on product_order.user_id = u.user_id
where datediff(curdate(), order_date) <= 30
group by u.user_id;

/* 2nd */
select u.user_name
from user as u
inner join product_order on product_order.user_id = u.user_id
where datediff(curdate(), order_date) <= 30
group by u.user_id
order by order_amount desc
limit 10;

/* 3rd */
select p.product_id, p.product_name, count(p.product_id) * order_item.quantity as no_of_products
from order_item
inner join product_order on order_item.order_id = product_order.order_id
inner join product as p on p.product_id = order_item.product_id
where datediff(curdate(), product_order.order_date) <= 60
group by order_item.product_id
order by count(p.product_id) * order_item.quantity desc
limit 20;

/* 4th */
select extract(month from order_date) as month, sum(order_amount) as Grand_total
from product_order
where datediff(curdate(), order_date) / 365 <= 1
group by month;

/* 5th */
alter table product
add active boolean default 1;

update product
left outer join order_item on product.product_id = order_item.product_id
left outer join product_order on product_order.order_id = order_item.order_id
set product.active = 0
where datediff(curdate(), product_order.order_date) > 90
or order_item.order_id is null;

/* 6th */
select p.product_id, product_name
from product_cat as pc
inner join category as c on pc.cat_id = c.cat_id
inner join product as p on p.product_id = pc.product_id
where c.cat_name in ('OnePlus', 'Motivational');

/* 7th */
select product_name
from order_item as oi
inner join product as p on oi.product_id = p.product_id
where oi.product_status = 'returned'
group by oi.product_id, oi.product_status
order by count(*)
limit 10;