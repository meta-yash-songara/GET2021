package com.metacube.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
	
	public Connection connect() throws SQLException{
		String host = "jdbc:mysql://localhost:3306/";
		String dbName = "StoreFront";
		String mySqlUrl = host + dbName;
		String userId = "root";
		String pass = "yash";
		
		Connection connection;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(mySqlUrl, userId, pass);
			return connection;
		}catch(ClassNotFoundException e){
			System.out.println("Failed to load driver !!!");
		}catch(SQLException e){
			System.out.println("SQL connection error !!!");
			e.printStackTrace();
		}
		
		return null;
	}

}
