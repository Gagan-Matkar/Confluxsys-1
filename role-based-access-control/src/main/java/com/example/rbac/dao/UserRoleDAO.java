package com.example.rbac.dao;

import java.util.List;

import com.example.rbac.model.UserRole;

public interface UserRoleDAO {
	void assignRoleToUser(UserRole userRole);

	void removeRoleFromUser(int userId, int roleId);

	List<Integer> getRolesForUser(int userId);

}
