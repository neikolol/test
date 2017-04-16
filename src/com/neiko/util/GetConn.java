package com.neiko.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConn {
	private static final String url = "jdbc:mysql://localhost/world";
	private static final String user = "root";
	private static final String password = "neiko";
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws SQLException{
		 Connection conn = DriverManager.getConnection(url, user, password);
		 return conn;
	}
}
