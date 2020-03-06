package com.techelevator;

import org.junit.*;
import java.math.BigDecimal;
import org.junit.Test;

public class CandyClassTest {

	@Test
	public void doesWonkaReturnDollarFifty() {
		CandyClass wonka = new CandyClass("Wonka", BigDecimal.valueOf(1.50), "5", "B3");
		Assert.assertEquals(BigDecimal.valueOf(1.50), wonka.price);
	}
	
	@Test
	public void doesCrunchieReturnB4DollarSeventyFive() {
		CandyClass crunchie = new CandyClass("Crunchie", BigDecimal.valueOf(1.75), "5", "B4" );
		Assert.assertEquals("B4", crunchie.uniqueID);
	}
	
	@Test
	public void doesCrunchieReturnDollarSeventyFive() {
		CandyClass crunchie = new CandyClass("Crunchie", BigDecimal.valueOf(1.75), "5", "B4" );
		Assert.assertEquals(BigDecimal.valueOf(1.75), crunchie.price);
	}
	
	@Test
	public void doesWonkaReturnB3() {
		CandyClass wonka = new CandyClass("Wonka", BigDecimal.valueOf(1.50), "5", "B3");
		Assert.assertEquals("B3", wonka.uniqueID);
	}
	
}
