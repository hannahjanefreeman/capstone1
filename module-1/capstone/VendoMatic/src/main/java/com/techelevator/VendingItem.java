package com.techelevator;

public class VendingItem {
	
	protected String name;
	protected String price;
	protected int quantity;
	protected String uniqueID;
	
	public VendingItem(String name, String price, int quantity, String uniqueID) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.uniqueID = uniqueID;
	}
	
	
}
