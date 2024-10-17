package com.example.rbac.service;

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

}
