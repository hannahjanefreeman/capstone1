 package com.techelevator;

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StockDAO {
	
	private File itemStockFile = new File("C:\\Users\\Student\\workspace\\java-module-1-capstone-team-4\\module-1\\capstone\\java\\vendingmachine.csv");
	private int maxItemQuantity = 5;
	private List<VendingItem> products;
	
	public File getItemStockFile() {
		return this.itemStockFile;
	}
	
	public int getMaxItemQuantity() {
		return this.maxItemQuantity;
	}
	
	//CTOR////////////////////////////////////////////////
	public StockDAO() {
		this.products = new ArrayList<VendingItem>();
	}
		
	public void getStockInfoFromFile() throws FileNotFoundException {
		try(Scanner scanFile = new Scanner(getItemStockFile())) {
			
			while(scanFile.hasNextLine()) {
				String fileLine = scanFile.nextLine();
				String[] lineContents = fileLine.split("[|]");
				String itemType = lineContents[lineContents.length-1];
				
				
				if(itemType.equals("Chip")) {
					ChipClass chip = new ChipClass(lineContents[1], lineContents[2], 
							getMaxItemQuantity(), lineContents[0]);
					products.add(chip);
				} 
				if(itemType.equals("Drink")) {
					DrinkClass drink = new DrinkClass(lineContents[1], lineContents[2], 
							getMaxItemQuantity(), lineContents[0]);
					products.add(drink);
				}
				if(itemType.equals("Gum")) {
					GumClass gum = new GumClass(lineContents[1], lineContents[2], 
							getMaxItemQuantity(), lineContents[0]);
					products.add(gum);
				}
				if(itemType.equals("Candy")) {
					CandyClass candy = new CandyClass(lineContents[1], lineContents[2], 
							getMaxItemQuantity(), lineContents[0]);
					products.add(candy);
				}
			} 
		}
	}
	
	public void getProductList() {
		for(VendingItem item : products) {
			System.out.println(item.toString());
		}
	}
	
	 
	public void itemSelection(double userWallet) {
		
		try(Scanner userSelection = new Scanner(System.in)) {
			
			System.out.print("What would you like? (ex. A1) ");
			String itemSelection = userSelection.nextLine().toUpperCase();
			
			for(int i = 0; i < products.size(); i++) {
				if(itemSelection.equals(products.get(i).uniqueID)) {
					System.out.println(products.get(i).name + " " +
										products.get(i).price + " " +
										userWallet);
					System.out.println(products.get(i).makeNoise());
					products.get(i).quantity -= 1;
				}
			}
		}
	}
}
