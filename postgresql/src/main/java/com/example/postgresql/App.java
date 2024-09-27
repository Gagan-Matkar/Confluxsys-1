package com.example.postgresql;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args ) 
    {
    	logger.info("Application started");
        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "postgres";
        String password = "Gagan@confluxsys";
        
        try(Connection conn  = DriverManager.getConnection(url, user, password)){
        	logger.info("connected to the database successfully !!");
        	
//        	String query = "SELECT *  FROM employees";
//        	logger.debug("executing query : {} ", query);
        	
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error( "An error occoured : {}" ,e.getMessage());
		}finally {
			logger.info("application finished");
		}
     
        
    }
}
