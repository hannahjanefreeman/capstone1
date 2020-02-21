package com.techelevator;

import java.io.FileNotFoundException;

public class VendoMaticCLI {
	private static final String MAIN_MENU_ITEM_DISPLAY = "******************* ITEM DISPLAY ******************";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT =	"Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	
	//private static StockDAO stock = new StockDAO();
	private Menu menu;
	
	public void run() {
		while(true) {
			StockDAO stockList = new StockDAO();
			
			System.out.println(MAIN_MENU_ITEM_DISPLAY + "\n");
			stockList.getProductList();
			
			if()
		}
	}
	
	public VendoMaticCLI(Menu menu) {
		this.menu = menu;
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
	}

}
