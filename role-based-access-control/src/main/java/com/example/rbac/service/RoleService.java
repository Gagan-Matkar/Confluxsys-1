package com.example.rbac.service;

import java.util.List;

import com.example.rbac.dao.RoleDAO;
import com.example.rbac.model.Role;

public class RoleService {
	private final RoleDAO roleDAO;
	
	public RoleService(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
		
	}
	
	public void createRole(Role role) {
		roleDAO.createRole(role);
		System.out.println("Role Created successfully : " + role.getRoleId());
		
	}
	
	
	public Role getRoleById(int roleId) {
		
		return roleDAO.getRoleById(roleId);
	}
	
	public List<Role> getAllRoles(){
		return roleDAO.getAllRoles();
	}
	
	public void updateRole(Role role) {
		roleDAO.updateRole(role);
		System.out.println("Role updated Successfully : " +role.getRoleName());
	}
	
	public void deleteRole(int roleId) {
		roleDAO.deleteRole(roleId);
		System.out.println("Role deleted Successfully with Id : " + roleId);
	}

}
