package com.metacube.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Assignment3 {

	public static void main(String[] args) throws SQLException{
		JDBC jdbc = new JDBC();
		Query query = new Query();
		
		try(Connection connection = jdbc.connect();
				PreparedStatement statement = connection.prepareStatement(query.getQuery3());){
			
			int res = statement.executeUpdate();
			System.out.println("Row affected : " + res);
			
		}
	}
	
}
