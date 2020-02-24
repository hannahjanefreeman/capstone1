package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DrinkClassTest {
	
	@Test
	public void doesDrSaltReturnC2DollarFifty() {
		DrinkClass drSalt = new DrinkClass("Dr. Salt", "1.50", 5, "C2" );
		Assert.assertSame("C2", drSalt.uniqueID);
		Assert.assertSame("1.50", drSalt.price);
	}
	
	@Test
	public void doesHeavyReturnC4DollarFifty() {
		DrinkClass heavy = new DrinkClass("Heavy", "1.50", 5, "C4" );
		Assert.assertSame("C4", heavy.uniqueID);
		Assert.assertSame("1.50", heavy.price);
	}

}
