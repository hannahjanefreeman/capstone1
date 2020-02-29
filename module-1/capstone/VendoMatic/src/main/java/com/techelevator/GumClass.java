package com.techelevator;

import java.math.BigDecimal;

public class GumClass extends VendingItem {

	public GumClass(String name, BigDecimal price, int quantity, String uniqueID) {
		super(name, price, quantity, uniqueID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String makeNoise() {
		return "Chew Chew, Yum!";
	}
}
