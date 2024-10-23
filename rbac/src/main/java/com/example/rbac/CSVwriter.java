package com.example.rbac;

import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.csv.CSVFormat;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVwriter {
    private static final Logger logger = LoggerFactory.getLogger(CSVwriter.class);

	public static void writeToCsv(String filename, List<String[]> data, String[] headers) throws IOException {
        logger.info("Writing data to CSV file: {}", filename);

		try(FileWriter out = new FileWriter(filename);
				CSVPrinter printer = new CSVPrinter(out ,CSVFormat.DEFAULT.withHeader(headers))){
			for(String[] record : data) {
				printer.printRecord((Object[]) record);
			}
		}
        logger.info("Successfully wrote {} records to CSV file: {}", data.size(), filename);
		
		
	}
	

}
