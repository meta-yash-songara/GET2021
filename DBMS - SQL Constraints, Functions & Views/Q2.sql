/* 1st Question */
select p.product_id, product_name, count(*) as category_count
from product_cat
inner join category on product_cat.cat_id = category.cat_id
inner join product as p on p.product_id = product_cat.product_id
group by product_cat.product_id;

/* 2nd Question */
select rupees_range, count(product_id) as Item_count
from (select product_id,
		case when product_price between 0 and 100 then '0 - 100'
			when product_price between 100 and 500 then '100 - 500'
			when product_price > 500 then 'Above 500'
		end as rupees_range
		from product) as a
group by rupees_range;

/* 3rd Question */
select cat_name, count(*) as product_count
from product_cat 
inner join category on product_cat.cat_id = category.cat_id
group by product_cat.cat_id;