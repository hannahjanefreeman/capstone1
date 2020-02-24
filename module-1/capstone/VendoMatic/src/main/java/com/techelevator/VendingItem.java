package com.techelevator;

public abstract class VendingItem {
	
	protected String name;
	protected double price;
	protected int quantity;
	protected String uniqueID;
	
	public VendingItem(String name, double price, int quantity, String uniqueID) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.uniqueID = uniqueID;
	}
	
	public void checkQuantity() {
		if(this.quantity == 0) {
			System.out.println("SOLD OUT");
		}
	}
	
	public abstract String makeNoise();
	
	
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
