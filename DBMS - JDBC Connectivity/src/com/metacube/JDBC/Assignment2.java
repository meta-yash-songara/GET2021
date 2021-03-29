package com.metacube.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assignment2 {
	
	public static void insertImage(List<String> url, int id) throws SQLException{
		JDBC jdbc = new JDBC();
		Query query = new Query();
		
		try(Connection connection = jdbc.connect();
				PreparedStatement statement = connection.prepareStatement(query.getQuery2());){
				connection.setAutoCommit(false);
				
				for(int i = 0; i < url.size(); i++){
					statement.setString(1, url.get(i));
					statement.setInt(2, id);
					statement.addBatch();
				}
				
				int[] result = statement.executeBatch();
				System.out.println("Row inserted : " + result.length);
				System.out.println("--------------------------------");
				connection.commit();
		}
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		try{
			List<String> url = new ArrayList<String>();
			
			System.out.println("------------------------------");
			System.out.println("Enter product id : ");
			int product_id = scn.nextInt();
			System.out.println("------------------------------");
			
			url.add("one_arranged_murder_front.jpg"); 
			url.add("one_arranged_murder_back.jpg"); 
			
			insertImage(url, product_id);
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			scn.close();
		}
		
	}
	
}
