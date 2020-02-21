package com.techelevator;

import java.io.FileNotFoundException;

public class VendoMaticCLI {
	private static final String MAIN_MENU_ITEM_DISPLAY = "******************* ITEM DISPLAY ******************";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	
	private static StockDAO stock = new StockDAO();
	
	public VendoMaticCLI() {
		
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(MAIN_MENU_ITEM_DISPLAY + "\n");
		
		stock.getStockInfoFromFile();
		stock.getProductList();
		
		
	}

}
