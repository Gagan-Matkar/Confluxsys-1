package com.example.rbac;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class App {
	
    private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws SQLException, IOException {
		Accesspolicy accesspolicy = new Accesspolicy();

		try {
            logger.info("Starting the process...");

		List<String[]> p=accesspolicy.induceAccessPolicy();
		CSVwriter.writeToCsv("induced_access_policy.csv", p, new String[] {"user", "role","policy"});
        logger.info("CSV generated for induced access policies");

		
		List<String[]> r = accesspolicy.suggestRole();
		CSVwriter.writeToCsv("suggested_roles.csv", r, new String[] {"user", "role"});
        logger.info("CSV generated for suggested role assignments");
        
        logger.info("Process completed successfully.");


		}catch (SQLException | IOException e) {
			// TODO: handle exception
			
			logger.error("AN error occoured during the process ," ,e);
			
		}
		
	}

}
