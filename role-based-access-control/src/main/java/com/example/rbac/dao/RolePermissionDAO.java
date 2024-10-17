package com.example.rbac.dao;

import java.util.List;

import com.example.rbac.model.RolePermission;

public interface RolePermissionDAO {

	void assignPermissionToRole(RolePermission rolepermission);

	void removePermissionFromRole(int roleId, int permissionId);

	List<Integer> getPermissionForRole(int roleId);
}
