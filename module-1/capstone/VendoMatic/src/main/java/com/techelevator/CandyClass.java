package com.techelevator;

public class CandyClass extends VendingItem {

	public CandyClass(String name, String price, int quantity, String uniqueID) {
		super(name, price, quantity, uniqueID);
		// TODO Auto-generated constructor stub
	}
	
	public String getNoise() {
		return "Munch munch, Yum!";
	}

}
