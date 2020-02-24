package com.techelevator;

import java.io.FileNotFoundException;

public class VendoMaticCLI {
	private static final String MAIN_MENU_ITEM_DISPLAY = "******************* ITEM DISPLAY ******************";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT =	"Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String SUB_MENU_OPTION_FEED = "Feed Money";
	private static final String SUB_MENU_OPTION_SELECT = "Select Product";
	private static final String SUB_MENU_OPTION_FINISH = "Finish Transaction";
	private static final String[] SUB_MENU_OPTIONS = { SUB_MENU_OPTION_FEED, SUB_MENU_OPTION_SELECT, 
			SUB_MENU_OPTION_FINISH };
	
	
	private Menu menu;

	////METHOD THAT RUNS PROGRAM/////////////////////	
	public void run() throws FileNotFoundException {
		StockDAO stockList = new StockDAO(System.in);
		BankClass userWallet = new BankClass(System.in, System.out);
		stockList.getStockInfoFromFile();
		
		while(true) {
			System.out.println(MAIN_MENU_ITEM_DISPLAY + "\n");
			stockList.displayProductList();
			System.out.println();
			
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				choice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
				
				if(choice.equals(SUB_MENU_OPTION_FEED)) {
					userWallet.getCashFromUser();
					System.out.println();
					choice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
				}
				if(choice.equals(SUB_MENU_OPTION_SELECT)) {
					stockList.displayProductList();
					System.out.println();
					userWallet.checkUserWalletAmount(stockList.itemSelection
							(userWallet.getWallet()));
					
				}
				if(choice.equals(SUB_MENU_OPTION_FINISH)) {
					stockList.finishTransaction(userWallet.getWallet());
					choice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);

				}
			}
			if(choice.contentEquals(MAIN_MENU_OPTION_EXIT)) {
				System.exit(1);
			}
		}
	}

	////CTOR///////////////////////////////////
	public VendoMaticCLI(Menu menu) {
		this.menu = menu;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendoMaticCLI vendingMachine = new VendoMaticCLI(menu);
		vendingMachine.run();
	}
}
