package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
public static Connection getConnection() throws SQLException {
		
		//For compatibility with other technologies/frameworks will need to register our Driver
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:postgresql://javafs200803.czjvsq707ohh.us-east-2.rds.amazonaws.com:5432/postgres1";
		String username = "postgres";
		String password = "password"; 
		
		return DriverManager.getConnection(url, username, password);
	}
//	
//	public static void main(String[] args) {
//		
//		//Try with resources block. The try statement will stake a method that creates a resource, that will
//		//automatically be closed at the end of the try or catch block. It avoids the need for a finally block.
//		try(Connection conn = ConnectionUtil.getConnection()){
//			System.out.println("connection successful");
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}

}
