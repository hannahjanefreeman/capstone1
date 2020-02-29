package com.techelevator;

import java.math.BigDecimal;

public class DrinkClass extends VendingItem {

	public DrinkClass(String name, BigDecimal price, int quantity, String uniqueID) {
		super(name, price, quantity, uniqueID);
	}
	
	@Override
	public String makeNoise() {
		return "Glug Glug, Yum!";
	}

}
