package com.metacube.JDBC;

public class Query {
	
	public String returnQuery(int id){
		String q1 = "select p.order_id, p.order_date, p.order_amount from product_order as p"
					+ " inner join order_item as o on p.order_id = o.order_id"
					+ " where p.user_id = " + id + " and product_status = 'shipped' "
					+ " order by order_date";
		
		return q1;
	}
	
	public String getQuery2(){
		String q2 = "insert into image(url, product_id) values (?, ?)";
		return q2;
	}
	
	public String getQuery3(){
		String q3 = "update product as p"
					+ " inner join order_item as o"
					+ " on o.product_id = p.product_id"
					+ " inner join product_order as po"
					+ " on o.order_id = po.order_id"
					+ " set p.active = 0"
					+ " where datediff(curdate(), po.order_date)/365 > 1";
		
		return q3;
	}
	
	public String getQuery4(){
		String q4 = "select p.cat_name, count(p.parent_cat_id) as Sub_categories"
					+ " from category as c"
					+ " inner join category as p"
					+ " on c.parent_cat_id = p.cat_id"
					+ " group by p.cat_id"
					+ " order by p.cat_name";
		
		return q4;
	}

}
