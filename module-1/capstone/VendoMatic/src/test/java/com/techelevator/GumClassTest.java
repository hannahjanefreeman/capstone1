package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class GumClassTest {
	
	@Test
	public void doesUChewsReturnD1EightyFiveCents() {
		GumClass uChews = new GumClass("UChews", "0.85", 5, "D1" );
		Assert.assertSame("D1", uChews.uniqueID);
		Assert.assertSame("0.85", uChews.price);
	}
	
	@Test
	public void doesUchewsReturnD1EightyFiveCents() {
		GumClass chiclets = new GumClass("chiclets", "0.75", 5, "D3" );
		Assert.assertSame("D3", chiclets.uniqueID);
		Assert.assertSame("0.75", chiclets.price);
	}

}
