package com.metacube.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Assignment4 {

	public static void main(String[] args) throws SQLException{
		
		JDBC jdbc = new JDBC();
		Query query = new Query();
		
		try(Connection connection  = jdbc.connect();
				PreparedStatement statement = connection.prepareStatement(query.getQuery4());){
			
			ResultSet resultSet = statement.executeQuery();
			
			System.out.println("----------------------------");
			System.out.println("Cat_name \tSub Cat");
			System.out.println("----------------------------");
			
			while(resultSet.next()){
				System.out.println(resultSet.getString(1) + "\t"
									+ resultSet.getInt(2));
			}
			
			System.out.println("----------------------------");
			
		}
		
	}
	
}
