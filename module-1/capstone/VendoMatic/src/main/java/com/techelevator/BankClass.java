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
		boolean flag = true;
		
		while(flag) {
			System.out.print("Enter Amount (Up to $10): ");
			double enteredAmount = Double.parseDouble(in.nextLine());
			this.wallet += enteredAmount;
			if(getWallet() > 0.0 && getWallet() <= 10.00) {
				System.out.println("Current amount: " + "$" +getWallet());
			} 
			
			if(getWallet() > 10.0) {
				this.wallet -= enteredAmount;
				System.out.println("MAX is $10, Current amount: " + "$" +getWallet());
			}
			
			System.out.print("Do you want to insert more? (yes/no) ");
			String userInput = in.nextLine().toLowerCase();
			
			if(userInput.equals("yes")) {
				System.out.println("Current amount: " + "$" + getWallet());
			} else {
				flag = false;
			}
			
		}
		
		out.println("Current amount: " + "$" + getWallet());
		out.flush();
		return getWallet();
	}
	
	public double checkUserWalletAmount(double amountRemaining) {
		if(getWallet() == 0.0) {
			System.out.println("You Broke, feed me money yungboul");
		}
		return this.wallet = amountRemaining;
	}
	
	
	

}
