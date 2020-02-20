 package com.techelevator;

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StockDAO {
	
	private final File ITEM_STOCK_FILE = new File("C:\\Users\\Student\\workspace\\java-module-1-capstone-team-4\\module-1\\capstone\\java\\vendingmachine.csv");
	private int maxItemQuantity = 5;
	
	public File getItemStockFile() {
		return this.ITEM_STOCK_FILE;
	}
	
	public int getMaxItemQuantity() {
		return this.maxItemQuantity;
	}
	
	public StockDAO() {
		//MAYBE ADD SOMETHING HERE
	}
	
	List<VendingItem> products = new ArrayList<VendingItem>();
		
	
	public void getStockInfoFromFile() throws FileNotFoundException {
		Scanner scanFile = new Scanner(getItemStockFile());
		String fileLine = scanFile.nextLine();
		
		while(fileLine != null) {	
			String[] lineContents = fileLine.split("[|]");
			String itemType = lineContents[lineContents.length-1];
			if(itemType.equals("Chip")) {
				ChipClass chip = new ChipClass(lineContents[1], lineContents[2], getMaxItemQuantity(), lineContents[0]);
				products.add(chip);
			} 
			if(itemType.equals("Drink")) {
				DrinkClass drink = new DrinkClass(lineContents[1], lineContents[2], getMaxItemQuantity(), lineContents[0]);
				products.add(drink);
			}
			if(itemType.equals("Gum")) {
				GumClass gum = new GumClass(lineContents[1], lineContents[2], getMaxItemQuantity(), lineContents[0]);
				products.add(gum);
			}
			if(itemType.equals("Candy")) {
				CandyClass candy = new CandyClass(lineContents[1], lineContents[2], getMaxItemQuantity(), lineContents[0]);
				products.add(candy);
			}
		} 
		
	}
	
}
