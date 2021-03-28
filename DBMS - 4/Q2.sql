/*Question 1*/
drop procedure if exists averageSales;

delimiter $$

create procedure averageSales(in month INT, in year INT)
begin
	select o.product_id, AVG(o.quantity) as avg_sale
	from product_order as po inner join order_item as o
	on po.order_id = o.order_id and EXTRACT(month from po.order_date) = month
		and EXTRACT(year from po.order_date) = year
	group by o.product_id;
end $$

delimiter ;

Call averageSales(3, 2021);

/*Question 2*/
drop procedure if exists getOrderDetail;

delimiter $$

create procedure getOrderDetail(in startDate DATE, in endDate DATE)
begin
	declare start DATE;
	if(startDate > endDate) then
		select date_sub(endDate, INTERVAL DAYOFMONTH(endDate)-1 DAY) into start;
	else
		select startDate into start;
	end if;
	
	select po.order_id, po.order_date, o.product_id, o.product_status, po.order_amount
	from product_order as po
	inner join order_item as o
	on po.order_id = o.order_id
	where po.order_date between start and endDate;
end $$

delimiter ;

call getOrderDetail('2021-03-30', '2021-02-19');