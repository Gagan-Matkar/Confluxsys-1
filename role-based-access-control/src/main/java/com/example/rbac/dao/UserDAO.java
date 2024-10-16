package com.example.rbac.dao;

import java.util.List;

import com.example.rbac.model.User;

public interface UserDAO {
	void createUser(User user);
	User getUserById(int id );
	List<User> getAllUsers();
	void updateUser(User user);
	void deleteUser(int userId);

}
