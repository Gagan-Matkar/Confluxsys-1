package com.example.rbac;

import java.sql.SQLException;
import java.util.List;

public class App {
	public static void main(String[] args) throws SQLException {
		List<String[]> p=Accesspolicy.induceAccessPolicy();
		
		for(String[] policy : p) {
            System.out.printf("%-10s %-15s %-10s%n", policy[0], policy[1], policy[2]);

		}
	}

}
