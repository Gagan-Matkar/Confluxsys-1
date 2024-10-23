package com.example.rbac;

import org.slf4j.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.LoggerFactory;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres"; 
    private static final String DB_USER = "postgres"; 
    private static final String DB_PASSWORD = "Gagan@confluxsys"; 
    
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);

    public static Connection connect() throws SQLException {
    	logger.info("Connecting to the database...");
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            logger.info("Connection established.");
            return conn;
        } catch (SQLException e) {
            logger.error("Failed to connect to the database.", e);
            throw e;
        }

    }
}
