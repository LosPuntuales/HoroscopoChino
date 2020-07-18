package com.desafiolatam.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
	private static Connection conn=null;
	
	private Singleton() {
		String url = "jdbc:mysql://localhost:3306/horoscopo_chino?serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		String usuario = "testUsr";
		String password = "test_2020?";
		
		try {
			Class.forName(driver);
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn = DriverManager.getConnection(url,usuario,password);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

		
	}
	
	public static Connection getConnection() {
		if (conn==null) {
			new Singleton();
		}
		return conn;
	}
}
