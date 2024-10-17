package com.example.rbac;

import com.example.rbac.dao.impl.UserDAOImpl;
import com.example.rbac.model.User;
import com.example.rbac.service.UserService;
import com.example.rbac.util.DatabaseConnection;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		UserDAOImpl userDAO = new UserDAOImpl();

		UserService userService = new UserService(userDAO);

		DatabaseConnection.testConnection();

		User user = new User("aditya1211", "conflux@123", "adi@gmail.com");

		userService.createUser(user);
		System.out.println("User created: " + user);

	}
}
