package com.techelevator;

import static org.junit.Assert.assertEquals;
import org.junit.*;

public class VendingItemTest {
	
	@Test
	public void doesZeroReturnSoldOut() {
		Assert.assertEquals("Does quantity = 0 return SOLD OUT", 0, "SOLD OUT");
	
	}

}
