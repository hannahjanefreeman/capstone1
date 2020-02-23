package com.techelevator;

public class ChipClass extends VendingItem {

	public ChipClass(String name, String price, int quantity, String uniqueID) {
		super(name, price, quantity, uniqueID);
		
	}
	
	@Override
	public String makeNoise() {
		return "Crunch Crunch, Yum!";
	}
}
