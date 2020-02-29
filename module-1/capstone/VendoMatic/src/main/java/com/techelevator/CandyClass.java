package com.techelevator;

import java.math.BigDecimal;

public class CandyClass extends VendingItem {

	public CandyClass(String name, BigDecimal price, int quantity, String uniqueID) {
		super(name, price, quantity, uniqueID);
	}
	
	@Override
	public String makeNoise() {
		return "Munch munch, Yum!";
	}

}
