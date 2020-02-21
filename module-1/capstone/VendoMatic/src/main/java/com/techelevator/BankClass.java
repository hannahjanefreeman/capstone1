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
		System.out.print("Enter Amount: ");
		double walletAmount = Double.parseDouble(in.nextLine());
		if (walletAmount < 0.0) {
			System.out.println("Not valid, Wallet equals zero");
			walletAmount = 0.0;
			return walletAmount;
		} 
		if (walletAmount > 10.0) {
			System.out.println("Can not accept amount, Wallet equals zero");
			walletAmount = 0.0;
			return walletAmount;
		}
		out.println("Current amount: " + walletAmount);
		out.flush();
		return wallet += walletAmount;
	}
}
