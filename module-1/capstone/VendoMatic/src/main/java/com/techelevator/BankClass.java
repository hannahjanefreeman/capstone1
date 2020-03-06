package com.techelevator;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.math.BigDecimal;

public class BankClass {
	
	private PrintWriter out;
	private Scanner in;
	private BigDecimal wallet;
	
	public BigDecimal getWallet() {
		return wallet;
	}

	public BankClass(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
		this.wallet = BigDecimal.ZERO;
	}
	
	public BigDecimal getCashFromUser() {
		boolean flag = true;
		
		while(flag) {
			System.out.print("Enter Amount (Up to $10): ");
			BigDecimal enteredAmount = 
					BigDecimal.valueOf(Double.parseDouble(in.nextLine()));
			this.wallet = getWallet().add(enteredAmount);
			
			if(getWallet().compareTo(BigDecimal.ZERO) < 0) {
				this.wallet = BigDecimal.ZERO;
				System.out.println("Can't have negative amount");
			}
			
			if(getWallet().compareTo(BigDecimal.TEN) > 0) {
				this.wallet = getWallet().subtract(enteredAmount);
				System.out.println("MAX is $10, Current amount: " + "$" +getWallet());
			}
			
			if(getWallet().compareTo(BigDecimal.ZERO) >= 0 &&
					getWallet().compareTo(BigDecimal.TEN) <= 0) {
				
				System.out.println("Current amount: " + "$" +getWallet());
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
	
	public BigDecimal checkUserWalletAmount(BigDecimal amountRemaining) {
		if(getWallet().equals(BigDecimal.ZERO)) {
			this.wallet = BigDecimal.ZERO;
			System.out.println("$" + this.wallet + " You have no money");
			System.out.println("Thank you, Come Again!");
			System.exit(1);
		}else {
			this.wallet = amountRemaining;
		}
		return this.wallet;
	}
	
	
	

}
