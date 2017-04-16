package com.neiko.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import org.junit.Test;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;

import com.neiko.dao.City;
import com.neiko.util.GetConn;

public class Query2Dao {
	/**
	 * Query���װ��������
	 */
	List<City> CityList = new ArrayList<City>();
	List<String> CityAttr = new ArrayList<String>();
	
	@Test
	public void Query() throws SQLException {
		String QuerySQL = "SELECT * FROM CITY";
		Connection conn = GetConn.getConn();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(QuerySQL);
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		
		Object proxyInstance = Proxy.newProxyInstance(this.getClass().getClassLoader(), this.getClass().getInterfaces(), new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return null;
			}
		});
		
		while(rs.next()){
			City city = new City();
			for (int i = 1; i < columnCount; i++) {
				CityAttr.add(rs.getString(i));
			}
			Iterator<String> it = CityAttr.iterator();
			while(it.hasNext()){
				city.setID(it.next());
				city.setName(it.next());
				city.setDistrict(it.next());
				city.setCountryCode(it.next());
			}
			CityList.add(city);
			CityAttr.clear();
		}
		System.out.println(CityList);
		System.out.println(CityList.size());
	}
	
	/**
	 * query���װ��������  ������д����̬��д��
	 * 	1.���ͳһ�����class�������ݿ�table��  (����hibernate ORM���ñ�),��newInstance
	 * 	2.��ΰѲ�ѯ�������Է�װ��������
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@Test
	public void QueryAdvance() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String ClassAndTable = "City";
		String QuerySQL = "SELECT * FROM "+ClassAndTable;
		
		Connection conn = GetConn.getConn();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(QuerySQL);
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		
		
		Object instance = Class.forName(ClassAndTable).newInstance();
		System.out.println(instance);
		while(rs.next()){
			
			/*for (int i = 1; i < columnCount; i++) {
				CityAttr.add(rs.getString(i));
			}
			Iterator<String> it = CityAttr.iterator();
			while(it.hasNext()){
				instance.setID(it.next());
				instance.setName(it.next());
				instance.setDistrict(it.next());
				instance.setCountryCode(it.next());
			}
			CityList.add(instance);
			CityAttr.clear();*/
		}
		System.out.println(CityList);
		System.out.println(CityList.size());
	}
	
	/**
	 * lookColumnNameΪ�˴���city����
	 * 
	 * @throws SQLException
	 */
	@Test
	public void LookColumnName() throws SQLException {
		String QuerySQL = "SELECT * FROM CITY";
		Connection conn = GetConn.getConn();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(QuerySQL);
		ResultSetMetaData metaData = rs.getMetaData();

		for (int i = 1; i < metaData.getColumnCount(); i++) {
			System.out.print(metaData.getColumnName(i) + ".");
		}
	}
}
