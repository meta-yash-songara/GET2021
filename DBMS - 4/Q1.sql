/*Question 1*/

drop function if exists ordersInAMonth;

delimiter $$

create function ordersInAMonth(month INT, year INT) returns bigint
begin
	declare order_count bigint;
	select count(order_id) into order_count from product_order
	where EXTRACT(month from order_date) = month and EXTRACT(year from order_date) = year;
	return order_count;
end$$

delimiter ;

select ordersInAMonth(3, 2021) as No_Of_Orders;

/*Question 2*/
drop function if exists maxMonthOrders;

delimiter $$

create function maxMonthOrders(year INT) returns INT
begin
	declare month INT;
	select EXTRACT(month from order_date) into month
	from product_order
	where EXTRACT(year from order_date) = year
	group by month
	order by COUNT(order_id) DESC
	limit 1;
	return month;
end$$

delimiter ;

select maxMonthOrders(2021) as max_order_month;