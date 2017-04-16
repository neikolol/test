package com.neiko.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.neiko.util.GetConn;

public class SimpleQuery {
	/**
	 * simpleQuery打印到控制台
	 */
	@Test
	public void Query() throws SQLException{
		String querySql = "SELECT * FROM CITY";
		Connection conn = GetConn.getConn();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(querySql);
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		
		while(rs.next()){
			for (int i = 1; i < columnCount; i++) {
				System.out.print(rs.getString(i)+".");
			}
			System.out.println("");
		}
	}
}
