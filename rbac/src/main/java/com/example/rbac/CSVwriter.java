package com.example.rbac;

import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVFormat;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVwriter {

	public static void writeToCsv(String filename, List<String[]> data, String[] headers) throws IOException {
		
		try(FileWriter out = new FileWriter(filename);
				CSVPrinter printer = new CSVPrinter(out ,CSVFormat.DEFAULT.withHeader(headers))){
			
		}
				
		
	}
	

}
