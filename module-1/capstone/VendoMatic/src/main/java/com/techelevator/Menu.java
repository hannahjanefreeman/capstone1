package com.techelevator;

import java.util.Scanner;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;


public class Menu {
	private Scanner in;
	private PrintWriter out;
	
	
	public Menu(InputStream input, OutputStream output) {
		this.in = new Scanner(input);
		this.out = new PrintWriter(output);
		
	}
	
	public void displayMenuOptions(Object[] object) {
		for(int i = 0; i < object.length; i++) {
			int optionNum = i + 1;
			System.out.println(optionNum + ") " + object[i]);
		}
	}
	
	
	
	

}
