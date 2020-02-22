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
	

		
	
	@Override
	public String toString() {
		String tabs;
		if (this.name.length() >= 18) {
			tabs = "\t";
		} else if (this.name.length() <= 7) {
			tabs = "\t\t\t";
		} else {
			tabs = "\t\t";
		}
		return this.uniqueID + "\t" + this.name + tabs + "$" + this.price + "\t" + this.quantity + " In Stock";
	}
}
