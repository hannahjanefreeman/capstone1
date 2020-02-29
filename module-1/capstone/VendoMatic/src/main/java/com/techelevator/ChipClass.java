package com.techelevator;

import java.math.BigDecimal;

public class ChipClass extends VendingItem {

	public ChipClass(String name, BigDecimal price, int quantity, String uniqueID) {
		super(name, price, quantity, uniqueID);
		
	}
	
	@Override
	public String makeNoise() {
		return "Crunch Crunch, Yum!";
	}
}
