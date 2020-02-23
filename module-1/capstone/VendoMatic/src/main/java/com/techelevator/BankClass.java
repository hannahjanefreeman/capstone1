package com.techelevator;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class BankClass {
	
	private PrintWriter out;
	private Scanner in;
	private double wallet;
	
	public double getWallet() {
		return wallet;
	}

	public BankClass(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
		this.wallet = 0.0;
	}
	
	public double getCashFromUser() {
		double walletAmount = 0;
		boolean flag = true;
		
		while(flag) {
			System.out.print("Enter Amount: ");
			
			walletAmount = Double.parseDouble(in.nextLine());
			if(walletAmount > 0.0 && walletAmount <= 10.00) {
				this.wallet += walletAmount;
			} else {
				System.out.println("Not Accepted");
			}
		
			if (this.wallet < 0.0) {
				System.out.println("Can't have negative balance");
				this.wallet = 0.0;
				return getWallet();
			} 
			
			if (this.wallet > 10.0) {
				System.out.println("Wallet amount too large");
				this.wallet -= walletAmount;
				System.out.println("Current amount: " + getWallet());
				
			}
			
			System.out.print("Do you want to insert more? (yes/no) ");
			String userInput = in.nextLine().toLowerCase();
			
			if(userInput.equals("yes")) {
				System.out.println("Current amount: " + getWallet());
			} else {
				flag = false;
			}
			
		}
		
		out.println("Current amount: " + getWallet());
		out.flush();
		return getWallet();
	}
	
	public void checkUserWalletAmount() {
		if(getWallet() == 0.0) {
			System.out.println("You Broke, feed me money boi");
		}
	}
	
	
	

}
