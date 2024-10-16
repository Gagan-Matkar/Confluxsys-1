package com.example.rbac.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static final String url = "jdbc:postgresql://localhost:5432/demo";
	private static final String username = "postgres";
	private static final String password = "Gagan@confluxsys";

public static Connection getConnection() {
	
	Connection connection = null ;
	try {
		connection = DriverManager.getConnection(url , username, password);
		
	}catch (SQLException e) {
		// TODO: handle exception
		
		e.printStackTrace();
	}
	
	return connection;
}


}
