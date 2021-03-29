package com.metacube.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Assignment1 {
	
	public static void main(String[] args) throws SQLException {
		
		Scanner scn = new Scanner(System.in);
		Query query = new Query();
		JDBC jdbc = new JDBC();
		
		try( Connection connection = jdbc.connect(); ){
			System.out.println("Enter user id : ");
			int user_id = scn.nextInt();
			
			try(PreparedStatement statement = connection.prepareStatement(query.returnQuery(user_id));){
				ResultSet resultSet = statement.executeQuery();
				
				System.out.println("Order Id\tOrder Date\tOrder Amount");
				while(resultSet.next()){
					System.out.println(resultSet.getInt("order_id") + "\t"
										+ resultSet.getDate("order_date") + "\t"
										+ resultSet.getDouble("order_amount"));
				}
				
				scn.close();
			}
		}
		
	}

}
