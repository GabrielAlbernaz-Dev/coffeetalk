package com.coffeetalk.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static Connection connection;
	private static ConnectionManager instance;
	
	private ConnectionManager() {}
	
	public static synchronized ConnectionManager getInstance() throws SQLException {
		if(instance == null) {
			instance = new ConnectionManager();
		} else if (instance.getConnection().isClosed()) {
            instance = new ConnectionManager();
        }
		
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		final String dbHost = "localhost";
		final String dbPort = "3306";
		final String dbName = "coffeetalk";
		final String dbUsername = "root";
		final String dbPassword = "";
		final String dbUrl = String.format("jdbc:mysql://%s:%s/%s", dbHost, dbPort, dbName);
		
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	connection = DriverManager.getConnection(dbUrl,dbUsername, dbPassword);
	    } catch (ClassNotFoundException e) {
	    	System.out.println(e.getMessage());
	    }
	    
	    return connection;
	}
}
