package com.techelevator;

public class CandyClass extends VendingItem {

	public CandyClass(String name, String price, int quantity, String uniqueID) {
		super(name, price, quantity, uniqueID);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String makeNoise() {
		return "Munch munch, Yum!";
	}

}
