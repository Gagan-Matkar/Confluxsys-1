package com.example.rbac.util;

import org.slf4j.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.LoggerFactory;

public class DatabaseConnection {
	private static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);

	private static final String url = "jdbc:postgresql://localhost:5432/postgres";
	private static final String username = "postgres";
	private static final String password = "Gagan@confluxsys";

	public static Connection getConnection() {

		Connection connection = null;
		logger.info("Attempting to establish the connection to the database ...");
		try {
			connection = DriverManager.getConnection(url, username, password);
			logger.info("Database connection eastablished successfully.");
		} catch (SQLException e) {
			// TODO: handle exception

			logger.error("error occoured while eastablishing connection - {}", e.getMessage());
			;
		}

		return connection;
	}

	public static void testConnection() {
		try (Connection conn = getConnection()) {
			if (conn != null && !conn.isClosed()) {
				System.out.println("Connection to the database was successful!");
			}
		} catch (SQLException e) {
			System.out.println("Failed to connect to the database.");
			e.printStackTrace();
		}
	}

}
