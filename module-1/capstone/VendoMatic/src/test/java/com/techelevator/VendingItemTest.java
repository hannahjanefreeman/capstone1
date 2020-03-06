package com.techelevator;

import org.junit.*;

public class VendingItemTest {
	
	@Test
	public void doesZeroReturnSoldOut() {
		//VendingItem moonpie = new VendingItem();
		//VendingItem moonpie = new VendingItem("Moonpie", "1.80", 0, "B1");
		Assert.assertEquals("Does quantity = 0 return SOLD OUT", "SOLD OUT", 0);
	}

}
