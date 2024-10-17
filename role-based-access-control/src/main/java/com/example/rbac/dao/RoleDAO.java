package com.example.rbac.dao;

import java.util.List;

import com.example.rbac.model.Role;

public interface RoleDAO {
	void createRole(Role role);

	Role getRoleById(int roleId);

	List<Role> getAllRoles();

	void updateRole();

	void deleteRole();

}
