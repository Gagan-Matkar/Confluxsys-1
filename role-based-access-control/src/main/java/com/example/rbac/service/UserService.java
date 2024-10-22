package com.example.rbac.service;

import java.util.List;

import com.example.rbac.dao.UserDAO;
import com.example.rbac.dao.impl.UserDAOImpl;
import com.example.rbac.model.User;

public class UserService {
	private UserDAO userDAO;

	public UserService(UserDAO userDAO) {

		this.userDAO = userDAO;
	}

	public void createUser(User user) {
		userDAO.createUser(user);
	}
	public User getUserById(int userId) {
		return userDAO.getUserById(userId);
	}
	
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
	}
	
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	
	public void deleteUser(int userId) {
		userDAO.deleteUser(userId);
	}

}
