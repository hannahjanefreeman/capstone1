 package com.techelevator;

import java.util.Scanner;
import java.io.File;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class StockDAO {
	
	private File itemStockFile = new File("C:\\Users\\Student\\workspace\\java-module-1-capstone-team-4\\module-1\\capstone\\java\\vendingmachine.csv");
	private int maxItemQuantity = 5;
	private Scanner in;
	private List<VendingItem> products;
	private String userSelectedItem;
	private BigDecimal userSelectedItemPrice;
	
	public File getItemStockFile() {
		return this.itemStockFile;
	}
	
	public int getMaxItemQuantity() {
		return this.maxItemQuantity;
	}
	
	public List<VendingItem> getProductsList() {
		return this.products;
	}
	
	public String getUserSelectedItem() {
		return this.userSelectedItem;
	}
	
	public BigDecimal getUserSelectedItemPrice() {
		return this.userSelectedItemPrice;
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
				BigDecimal priceOfItem = BigDecimal.valueOf(Double.parseDouble
						(lineContents[2]));
				String uniqueId = lineContents[0];
				String itemName = lineContents[1];
				String itemType = lineContents[lineContents.length - 1];
				
				if(itemType.equals("Chip")) {
					ChipClass chip = new ChipClass(itemName, priceOfItem, 
							getMaxItemQuantity(), uniqueId); 		
					products.add(chip);
				} 
				if(itemType.equals("Drink")) {
					DrinkClass drink = new DrinkClass(itemName, priceOfItem, 
							getMaxItemQuantity(), uniqueId );
					products.add(drink);
				}
				if(itemType.equals("Gum")) {
					GumClass gum = new GumClass(itemName, priceOfItem, 
							getMaxItemQuantity(), uniqueId);
					products.add(gum);
				}
				if(itemType.equals("Candy")) {
					CandyClass candy = new CandyClass(itemName, priceOfItem, 
							getMaxItemQuantity(), uniqueId);
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
	
	 
	public BigDecimal itemSelection(BigDecimal userWallet) {
		System.out.print("What would you like? (ex. A1) ");
		String itemSelection = in.nextLine().toUpperCase();
				
		for(int i = 0; i < products.size(); i++) {
			if(itemSelection.equals(products.get(i).uniqueID)) {
				userWallet = userWallet.subtract(products.get(i).price);
				
				products.get(i).quantity -= 1;
				userSelectedItem = products.get(i).name;
				userSelectedItemPrice = products.get(i).price;
				
				System.out.println(products.get(i).name + " " +
									products.get(i).price + " " +
									userWallet);
				
				System.out.println(products.get(i).makeNoise());
			}
		}
		return userWallet;
	}
	
	public BigDecimal finishTransaction(BigDecimal userWallet) {
		final BigDecimal QUARTER = BigDecimal.valueOf(.25);
		final BigDecimal DIME = BigDecimal.valueOf(.10);
		final BigDecimal NICKEL = BigDecimal.valueOf(.05);
		final BigDecimal PENNY = BigDecimal.valueOf(.01);
		
		int quarterCnt = 0;
		int dimeCnt = 0;
		int nickelCnt = 0;
		int pennyCnt = 0;
		
		while(userWallet.compareTo(BigDecimal.ZERO) > 0) {
			
			if(userWallet.compareTo(QUARTER) >= 0) {
				userWallet = userWallet.subtract(QUARTER);
				quarterCnt++;
				
			}else if(userWallet.compareTo(DIME) >= 0) {
				userWallet = userWallet.subtract(DIME);
				dimeCnt++;
			}else if(userWallet.compareTo(NICKEL) >= 0) {
				userWallet = userWallet.subtract(NICKEL);
				nickelCnt++;
			}else {
				userWallet = userWallet.subtract(PENNY);
				pennyCnt++;
			}
		}
		
		System.out.print(quarterCnt + " Quarters ");
		System.out.print(dimeCnt + " Dimes ");
		System.out.print(nickelCnt + " Nickels ");
		System.out.println(pennyCnt + " Pennies");
		
		return userWallet;
	}
}
