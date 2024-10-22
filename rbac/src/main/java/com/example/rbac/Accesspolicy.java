package com.example.rbac;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Accesspolicy {
	
	public static  List<String[]> induceAccessPolicy () throws SQLException{
		
		List<String[]> results = new ArrayList<>();
		
		String query = "select ua.user1 , ua.entitlement , ap.policy from user_access ua\n"
				+ "join access_policies ap on ua.entitlement = ap.entitlement\n"
				+ "where ua.policy is null ;";
		
		
		try( Connection con = DatabaseConnection.connect();
				PreparedStatement stmt = con.prepareStatement(query);
				ResultSet rs = stmt.executeQuery()) {
			
			while(rs.next()) {
				
				String userId = rs.getString("user1");
				String entitlement = rs.getString("entitlement");
				String policy = rs.getString("policy");
				
				results.add(new String[] {userId , entitlement, policy});
				
			}
			
			
		}
	
		
		
		
		
		
		return results;
		
		
		
		
	}

}
