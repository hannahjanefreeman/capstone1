package com.techelevator;

import java.math.BigDecimal;

public abstract class VendingItem {
	
	protected String name;
	protected BigDecimal price;
	protected String quantity;
	protected String uniqueID;
	
	public String getName() {
		return this.name;
	}
	
	public BigDecimal getPrice() {
		return this.price;
	}
	
	public String getQuantity() {
		return this.quantity;
	}
	
	public String uniqueID() {
		return this.uniqueID;
	}
	
	public VendingItem(String name, BigDecimal price, String quantity, String uniqueID) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.uniqueID = uniqueID;
	}
	
	public boolean isSoldOut() {
		if(this.quantity.equals("0")){
			this.quantity = "SOLD OUT";
			return true;
		}
		return false;
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
