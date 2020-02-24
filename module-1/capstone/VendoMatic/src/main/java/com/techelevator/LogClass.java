package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class LogClass {
	
	private File log = new File ("C:\\Users\\Student\\workspace\\java-module-1-capstone-team-4\\module-1\\capstone\\java", "log.txt");

		
	public void transacationLog(String uniqueID, String itemSelection, String price, double wallet) throws FileNotFoundException {
		
		try(PrintWriter logJawn = new PrintWriter(log)) {
			LocalDate date = LocalDate.now();
			LocalTime time = LocalTime.now();
			
				String printDate = date.toString();
				String printTime = time.toString();
				
				logJawn.println(printDate + " " + printTime + " " + itemSelection + " $" + price + " $" + wallet);
		}
	}
}
