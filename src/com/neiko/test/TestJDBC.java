package com.neiko.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.neiko.util.GetConn;

public class TestJDBC {
	List<String> databases = new ArrayList<String>();
	String sql = "SELECT SCHEMA_NAME FROM 'infomation_schema'.'SCHEMATA'";
	String SelectSQL = "SELECT * FROM COUNTRY";
	@Test
	public void getDatabase() throws SQLException{
		Connection conn = GetConn.getConn();
		Statement st = conn.createStatement();
		
		DatabaseMetaData metaData = conn.getMetaData();
		
		System.out.println("���ݿ��Ʒ����..."+metaData.getDatabaseProductName());
		System.out.println("���ݿ��Ʒ�汾��..."+metaData.getDatabaseProductVersion());
		System.out.println("��ǰ�������ݿ��ַ..."+metaData.getURL());
		System.out.println("���ݿ���֪���û�..."+metaData.getUserName());
		
		PreparedStatement ps = conn.prepareStatement(SelectSQL);
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData metaData2 = rs.getMetaData();
		
		//��ò�ѯ����е�����
		int columnCount = metaData2.getColumnCount();
		//��õ�ǰ�����
		String tableName = metaData2.getTableName(1);
		//��õ�ǰ��i������
		for(int i  = 1 ; i < columnCount ; i++){
			String columnName = metaData2.getColumnName(i);
			System.out.println(columnName);
		}
		/*System.out.println(tableName);
		System.out.println(columnCount);*/
		
		
		/*while (rs.next()) {
			for(int i = 1 ; i < columnCount ; i++){
				if(i != columnCount-1){
					System.out.print(rs.getString(i)+"\t\t");
				}else{
					System.out.print(rs.getString(i));
				}
			}
			System.out.println("");
		}*/
	}
	
	public void testConnTable() throws SQLException{
//		sql = "select * from city";
//		Connection conn = GetConn.getConn();
//		Statement st = conn.createStatement();
//		
//		ResultSet rs = st.executeQuery(sql);
//		ResultSetMetaData metaData = rs.getMetaData();
//		int columnCount = metaData.getColumnCount();
//		
//		System.out.println(columnCount);
		
//		while (rs.next()) {
//		}
		System.out.println(1);
	}
}
