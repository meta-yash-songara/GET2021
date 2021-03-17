/* Q1 */
select po.order_id, order_date, sum(quantity * p.product_price) as order_total
from product_order as po
inner join order_item as oi on po.order_id = oi.order_id
inner join product as p on p.product_id = oi.product_id
group by order_id
order by order_date desc
limit 50;

/* Q2 */
create view update_amount as
select o.order_id, sum(quantity * p.product_price) as total
from product_order as o
inner join order_item as i on o.order_id = i.order_id
inner join product as p on p.product_id = i.product_id
group by o.order_id;

select * from update_amount;

/* Q3 */
select o.order_id
from product_order as o
inner join order_item as i on o.order_id = i.order_id
where datediff(curdate(), o.order_date) > 10
and i.product_status in ('cancelled', 'returned')
group by order_id; 

/* Q4 */
select user.user_name
from user 
inner join product_order on user.user_id = product_order.user_id
where datediff(curdate(), product_order.order_date) / 30 >= 1;

/* Q5 */
select u.user_name, o.order_id
from user as u
inner join product_order as o
on u.user_id = o.user_id
where datediff(curdate(), o.order_date) < 15;

/* Q6 */
select product_id
from order_item
where product_status = 'shipping'
and order_id = 1;

/* Q7 */
select i.product_id, o.order_date
from product_order as o 
inner join order_item as i on o.order_id = i .order_id
inner join product as p on p.product_id = i.product_id
where p.product_price between 20 and 50;