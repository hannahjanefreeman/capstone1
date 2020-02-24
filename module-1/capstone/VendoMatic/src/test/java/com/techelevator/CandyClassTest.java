package com.techelevator;

import org.junit.*;
import org.junit.Test;

public class CandyClassTest {

	@Test
	public void doesWonkaReturnB3DollarFifty() {
		CandyClass wonka = new CandyClass("Wonka", "1.50", 5, "B3" );
		Assert.assertSame("B3", wonka.uniqueID);
		Assert.assertSame("1.50", wonka.price);
	}
	
	@Test
	public void doesCrunchieReturnB4DollarSeventyFive() {
		CandyClass crunchie = new CandyClass("Crunchie", "1.75", 5, "B4" );
		Assert.assertSame("B4", crunchie.uniqueID);
		Assert.assertSame("1.75", crunchie.price);
	}
	
}
