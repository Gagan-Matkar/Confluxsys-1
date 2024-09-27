package com.srccodes.log.logback;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import org.slf4j.*;


public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	private static final String url = "jdbc:postgresql://localhost:5432/demo";
	private static final String user = "postgres";
	private static final String password = "Gagan@confluxsys";
	private static Connection connection ;

	public static void main(String[] args) {
		
		
		try {
			logger.info("Application started");
			connection = DriverManager.getConnection(url, user,password);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("choose an operation to do - ");
				System.out.println("1. Create Employee");
				System.out.println("2. read Employee");
				System.out.println("3. update employee");
				System.out.println("4. delete employee");
				System.out.println("5. Exit");
				
				
				int choice = sc.nextInt();
				sc.nextLine();
				
				switch (choice) {
				case 1:
					System.out.println("Enter the employee name :");
					String name = sc.nextLine();
					createEmployee(name);
					break;
					
					
				case 2:
					readEmployees();
					break;
					
				case 3:
					System.out.println("enter employee id to update: ");
					int idToUpdate = sc.nextInt();
					sc.nextLine();
					System.out.println("enter the new employee name: ");
					String newName = sc.nextLine();
					updateEmployee(idToUpdate, newName);
					break;
					
				case 4 :
					System.out.println("enter employee Id to delete: ");
					int idToDelete = sc.nextInt();
					deleteEmployee(idToDelete);
					break;
					
				case 5:
					System.out.println("exiting the system");
					return;
					
				default:
					System.out.println("Invalid choice . please try again");
				}
				
				
			}
			
			
		
		
		
	
//		logger.trace("hello");
//		
//		String name = "Gagan";
//		
//		logger.debug("hi, {}" ,name);
//		logger.info("welcome to the staring of  the program");
//		logger.warn("dummy warning message");
//		logger.error("dummy error");
			
			
			
			
		
		
        
        
       
        	
        	
        	
        	
        	
        	
        	
//        	String query = "SELECT *  FROM employees";
//        	logger.debug("executing query : {} ", query);
//        	
//        	try(Statement stmt = conn.createStatement();
//        			ResultSet rs = stmt.executeQuery(query)){
//        		
//        		while(rs.next()) {
//        			int id = rs.getInt("id");
//        			String name = rs.getString("name");
//        			
//        			logger.info("employee ID: {} , Name: {}" , id, name);
//        		}
//        		
//        	}
//        	
//        	logger.info("query executed successfully");
        	
        	
        	
        	
        	
        	
        	
        	
        	
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()); 
			logger.error( "An error occoured : {}" ,e.getMessage());
		}finally {
			try {
				if( connection != null && !connection.isClosed()) {
					connection.close();
					logger.info("closing the database connection");
				}
				
			} catch (SQLException e2) {
				// TODO: handle exception
				logger.error("error closing connection : {}" , e2.getMessage());
			}
			logger.info("Application closed successfully");
		}
		
		
		
		
		
	}
	
	private static void createEmployee(String name) {
		String insertSQL = "INSERT INTO employees (name) VALUES ('"+name+"')";
		try(Statement stmt = connection.createStatement()){
			stmt.executeUpdate(insertSQL);
			logger.info("Employee '{}' created successfully" , name );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error("Error creating employee: {}", e.getMessage());
		}
	}
	
	private static void readEmployees() {
		String query = "SELECT * FROM employees ORDER BY id";
		logger.debug("executing query {}", query);
		
		try (Statement stmt = connection.createStatement()) {
			
			ResultSet rs = stmt.executeQuery(query);
			logger.info("reading employees");
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				logger.info("Employee ID: {} , Name: {}", id , name);
				System.out.println("Employee ID: " + id + "Employee name: "+ name);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			logger.error("Error reading Employee: {}", e.getMessage());
			
		}
	}
	
	private static void updateEmployee(int id , String newName) {
		String updateSQL = "UPDATE employees SET name = '" + newName +"'WHERE id = "+id;
		try(Statement stmt = connection.createStatement()) {
			int rowsAffected = stmt.executeUpdate(updateSQL);
			if(rowsAffected > 0) {
				logger.info("employee ID {} updated to '{}'." , id , newName);
				
			}else {
				logger.warn("No employee found with ID {} .", id);
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			logger.error("Error updating employee: {}" , e.getMessage());
		}
	}
	
	
	public static void deleteEmployee(int id) {
		String deleteSQL = "DELETE FROM employees WHERE id = " + id;
		try(Statement stmt = connection.createStatement()) {
			
			int rowsAffected = stmt.executeUpdate(deleteSQL);
			
			if(rowsAffected > 0) {
				logger.info("employee ID {} deleted." , id);
				
			}else {
				logger.warn("no employee found with ID {}.", id);
			}
			
			
		} catch (SQLException e) {

			// TODO: handle exception
			logger.error("error deleting employee: {}" , e.getMessage());
			
		}
		
		
	}

}
