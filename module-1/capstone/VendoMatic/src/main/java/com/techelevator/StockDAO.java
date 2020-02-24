 package com.techelevator;

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StockDAO {
	
	private File itemStockFile = new File("C:\\Users\\Student\\workspace\\java-module-1-capstone-team-4\\module-1\\capstone\\java\\vendingmachine.csv");
	private int maxItemQuantity = 5;
	private Scanner in;
	private List<VendingItem> products;
	
	public File getItemStockFile() {
		return this.itemStockFile;
	}
	
	public int getMaxItemQuantity() {
		return this.maxItemQuantity;
	}
	
	public List<VendingItem> getProductsList() {
		return this.products;
	}
	
	//CTOR////////////////////////////////////////////////
	public StockDAO(InputStream in) {
		this.products = new ArrayList<VendingItem>();
		this.in = new Scanner(in);
	}
		
	public void getStockInfoFromFile() throws FileNotFoundException {
		try(Scanner scanFile = new Scanner(getItemStockFile())) {
			
			while(scanFile.hasNextLine()) {
				String fileLine = scanFile.nextLine();
				String[] lineContents = fileLine.split("[|]");
				String itemType = lineContents[lineContents.length - 1];
				
				
				if(itemType.equals("Chip")) {
					ChipClass chip = new ChipClass(lineContents[1], lineContents[2], 
							5, lineContents[0]);
					products.add(chip);
				} 
				if(itemType.equals("Drink")) {
					DrinkClass drink = new DrinkClass(lineContents[1], lineContents[2], 
							5, lineContents[0]);
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
	
	public void displayProductList() {
		for(VendingItem item : products) {
			System.out.println(item.toString());
		}
	}
	
	 
	public double itemSelection(double userWallet) {
		System.out.print("What would you like? (ex. A1) ");
		String itemSelection = in.nextLine().toUpperCase();
				
		for(int i = 0; i < products.size(); i++) {
			if(itemSelection.equals(products.get(i).uniqueID)) {
				userWallet -= Double.parseDouble(products.get(i).price);
				products.get(i).quantity -= 1;
				System.out.println(products.get(i).name + " " +
									products.get(i).price + " " +
									userWallet);
				System.out.println(products.get(i).makeNoise());
						
			}
		}
		return userWallet;
	}
	
	public void finishTransaction(double userWallet) {
		double changeDue = userWallet;
		int change = (int) (Math.ceil(changeDue * 100));
		int quarters = Math.round((int)change/25);
		change = change % 25;
		int dimes = Math.round((int)change/10);
		change = change % 10;
		int nickels = Math.round((int)change/5);
		change = change % 5;
		int pennies = Math.round((int)change/1);
		
		System.out.print("Quarters " + quarters);
		System.out.print(" Dimes " + dimes);
		System.out.print(" Nickels " + nickels); 
		System.out.print(" Pennies " + pennies);
	}
}
