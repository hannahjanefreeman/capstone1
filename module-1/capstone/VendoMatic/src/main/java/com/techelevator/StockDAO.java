package com.techelevator;

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;


public class StockDAO {
	
	private final File ITEM_STOCK_FILE = new File("C:\\Users\\Student\\workspace\\java-module-1-capstone-team-4\\module-1\\capstone\\java\\vendingmachine.csv");
	
	public StockDAO() {
		//MAYBE ADD SOMETHING HERE
	}
	
	public File getItemStockFile() {
		return this.ITEM_STOCK_FILE;
	}
	
	public void getStockInfoFromFile() throws FileNotFoundException {
		Scanner scanFile = new Scanner(getItemStockFile());
		while(scanFile.nextLine() != null) {
			
		}
		
	}
	
}
