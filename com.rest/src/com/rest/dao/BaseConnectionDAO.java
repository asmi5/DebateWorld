package com.rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;  

public class BaseConnectionDAO {
	
	//private JdbcTemplate jdbcTemplate; 
	private static Connection finalConnection;
	
	public Connection getFinalConnection() {
		return finalConnection;
	}

	public void setFinalConnection() {	
		Connection connection =null;		
		try {			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/debate_world", "root", "root");			
		} catch (Exception e) {
			System.out.println(e);
		}
		this.finalConnection = connection;
	}
	

	/*public static Connection createConnection() {
		Connection connection =null;		
		try {			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/debate_world", "root", "root");			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return connection;
	}*/
}
