package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

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

	//METHOD THAT RUNS PROGRAM//////////////////////
	public void run() throws FileNotFoundException {
		
		//INSTANTIATE CLASSES///////////////////////
		StockDAO stockList = new StockDAO(System.in);
		BankClass userWallet = new BankClass(System.in, System.out);
		LogClass log = new LogClass();
		stockList.getStockInfoFromFile();
		
		BigDecimal updatedWallet = BigDecimal.ZERO;
		
		while(true) {
			System.out.println(MAIN_MENU_ITEM_DISPLAY + "\n");
			stockList.displayProductList();
			System.out.println();
			
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				choice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
				
				if(choice.equals(SUB_MENU_OPTION_FEED)) {
					updatedWallet = userWallet.getCashFromUser();
					System.out.println();
					log.transacationLog(SUB_MENU_OPTION_FEED, updatedWallet , updatedWallet);
				}
				
				if(choice.equals(SUB_MENU_OPTION_SELECT)) {
					stockList.displayProductList();
					System.out.println();
					userWallet.checkUserWalletAmount(updatedWallet);
					updatedWallet = userWallet.checkUserWalletAmount(stockList.itemSelection
							(userWallet.getWallet()));
					log.transacationLog(stockList.getUserSelectedItem(), stockList.getUserSelectedItemPrice(), updatedWallet);
					
				}
				
				if(choice.equals(SUB_MENU_OPTION_FINISH)) {
					BigDecimal moneyLeftOver = userWallet.getWallet();
					updatedWallet = userWallet.checkUserWalletAmount(stockList.finishTransaction(userWallet.getWallet()));
					log.transacationLog(SUB_MENU_OPTION_FINISH, moneyLeftOver, updatedWallet);
					System.exit(1);
				}
			}
			
			if(choice.contentEquals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank you!");
				System.exit(1);
			}
		}
	}

	//CTOR///////////////////////////
	public VendoMaticCLI(Menu menu) {
		this.menu = menu;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendoMaticCLI vendingMachine = new VendoMaticCLI(menu);
		vendingMachine.run();
	}
}
