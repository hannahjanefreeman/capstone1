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
	
	public double getCashFromUser(double userCash) {
		wallet = Double.parseDouble(in.nextLine());
		if (wallet < 0.0) {
			System.out.println("Not valid");
		} 
		if (wallet > 10.0) {
			System.out.println("Can not accept amount");
		}
		return wallet;
	}
}
