package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class DrinkClassTest {
	
	@Test
	public void doesDrSaltReturnC2() {
		DrinkClass drSalt = new DrinkClass("Dr. Salt", BigDecimal.valueOf(2.50), "5", "C2" );
		Assert.assertEquals("C2", drSalt.uniqueID);
	}
	
	@Test
	public void doesDrSaltReturn2DollarFifty() {
		DrinkClass drSalt = new DrinkClass("Dr. Salt", BigDecimal.valueOf(2.50), "5", "C2" );
		Assert.assertEquals(BigDecimal.valueOf(2.50), drSalt.price);
	}
	
	@Test
	public void doesHeavyReturnC4() {
		DrinkClass heavy = new DrinkClass("Heavy", BigDecimal.valueOf(2.50), "5", "C4" );
		Assert.assertEquals("C4", heavy.uniqueID);
	}
	
	@Test
	public void doesHeavyReturn2DollarFifty() {
		DrinkClass heavy = new DrinkClass("Heavy", BigDecimal.valueOf(2.50), "5", "C4" );
		Assert.assertEquals(BigDecimal.valueOf(2.50), heavy.price);
	}

}
