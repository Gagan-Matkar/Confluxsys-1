package com.example.rbac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.rbac.dao.impl.UserDAOImpl;
import com.example.rbac.model.Role;
import com.example.rbac.model.User;
import com.example.rbac.service.RoleService;
import com.example.rbac.service.UserService;
import com.example.rbac.util.DatabaseConnection;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(com.example.rbac.util.JdbcConfig.class);
        // Get RoleService bean from the context
		RoleService roleservice  = context.getBean(RoleService.class);
        // Create a new role

		Role role = new Role(0, "Admin","Admin role");
		Role role1 = new Role(0, "Admin1","Admin role1");

		Role role2 = new Role(0, "Admin2","Admin role2");

		Role role3 = new Role(0, "Admin3","Admin role3");

		Role role4 = new Role(0, "Admin4","Admin role4");

		
		
		
		roleservice.createRole(role);
		
        // Fetch and print all roles

		roleservice.getAllRoles().forEach(r -> System.out.println(r.getRoleName()));
		
		Role fetchedRole = roleservice.getRoleById(1);
		
		if(fetchedRole != null) {
			fetchedRole.setDescription("updated admin role description");
			roleservice.updateRole(fetchedRole);
		}
		
		roleservice.deleteRole(2);
		
		
		UserDAOImpl userDAO = new UserDAOImpl();

		UserService userService = new UserService(userDAO);

		DatabaseConnection.testConnection();

		User user = new User("aditya1211", "conflux@123", "adi@gmail.com");

		userService.createUser(user);
		System.out.println("User created: " + user);

	}
}
