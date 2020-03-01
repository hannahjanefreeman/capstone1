package com.techelevator;

import java.math.BigDecimal;

public class GumClass extends VendingItem {

	public GumClass(String name, BigDecimal price, String quantity, String uniqueID) {
		super(name, price, quantity, uniqueID);
		
	}

	@Override
	public String makeNoise() {
		return "Chew Chew, Yum!";
	}
}
