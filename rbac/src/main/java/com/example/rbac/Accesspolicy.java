package com.example.rbac;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Accesspolicy {
	private static final Logger logger = LoggerFactory.getLogger(Accesspolicy.class);

	public List<String[]> induceAccessPolicy() throws SQLException {

		logger.info("Starting the policy induction for legacy access");
		List<String[]> results = new ArrayList<>();

		String query = "select ua.user1 , ua.entitlement , ap.policy from user_access ua\n"
				+ "join access_policies ap on ua.entitlement = ap.entitlement\n" + "where ua.policy is null ;";

		try (Connection con = DatabaseConnection.connect();
				PreparedStatement stmt = con.prepareStatement(query);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				logger.info("executing query : {}", query);

				String userId = rs.getString("user1");
				String entitlement = rs.getString("entitlement");
				String policy = rs.getString("policy");
				logger.debug("Processing user: {}, entitlement: {}", userId, entitlement);

				results.add(new String[] { userId, entitlement, policy });
				logger.info("Induced policy : for user {}", userId);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			logger.error("Error while induing policy ,", e);
		}
		logger.info("Finished policy induction");
		return results;

	}

	public List<String[]> suggestRole() throws SQLException {
		logger.info("Starting role assignment suggestion for legacy access.");

		List<String[]> result = new ArrayList<>();

		String query = "select ua.user1, ap.role from user_access ua \n"
				+ "inner join access_policies ap on ua.entitlement = ap.entitlement \n" + "where ua.policy IS NULL;";

		try (Connection con = DatabaseConnection.connect();
				PreparedStatement stmt = con.prepareStatement(query);
				ResultSet rs = stmt.executeQuery();

		) {
			logger.info("executing query : {}", query);

			while (rs.next()) {

				String user = rs.getString("user1");
				String role = rs.getString("role");

				result.add(new String[] { user, role });

			}

		} catch (SQLException e) {
			// TODO: handle exception

			logger.error("Error while role assignment for legacy access ,", e);
		}

		return result;

	}

}
