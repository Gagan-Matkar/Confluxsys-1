package com.example.rbac.dao;

import java.util.List;

import com.example.rbac.model.Permission;

public interface PermissionDAO {
	
	void createPermission(Permission permission);
	Permission getPermissionById(int permissionId);
	List<Permission> getAllPermission();
	void updatePermission(Permission permission);
	void deletePermission(int permissionId);
	

}
