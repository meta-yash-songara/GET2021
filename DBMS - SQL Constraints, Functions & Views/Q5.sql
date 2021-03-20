/* 1st */
create view orderInfo as
select po.order_id, po.order_date,
		u.user_name, u.user_phone, 
		po.order_amount, p.product_name,
		o.product_status, o.product_id, o.quantity
from user as u
inner join product_order as po on po.user_id = u.user_id
left outer join order_item as o on o.order_id = po.order_id
left outer join product as p on p.product_id = o.product_id
where datediff(curdate(), po.order_date) <= 60;

/* 2nd */
select product_name
from orderInfo
where product_status = 'shipped'
group by product_id;

/* 3rd */
select product_name
from orderInfo
group by product_id
order by sum(quantity) desc
limit 5;