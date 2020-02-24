package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class LogClass {
	
	private File log = new File ("C:\\Users\\Student\\workspace\\java-module-1-capstone-team-4\\module-1\\capstone\\VendoMatic", "log.txt");

	public LogClass() {
		
	}
	
	public void transacationLog(String itemSelection, double price, double wallet) throws FileNotFoundException {
		try(PrintWriter logJawn = new PrintWriter(new FileOutputStream(log, true))) {
			LocalDate date = LocalDate.now();
			LocalDateTime time = LocalDateTime.now();
			String pattern = "hh:mm:ss a";
			String printDate = date.toString();
			String printTime = time.format(DateTimeFormatter.ofPattern(pattern));
				
			logJawn.println(printDate + " " + printTime + " " + itemSelection + " $" + price + " $" + wallet);
		}
	}
}
