package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class GumClassTest {
	
	@Test
	public void doesUChewsReturnD1() {
		GumClass uChews = new GumClass("UChews", BigDecimal.valueOf(0.85), "5", "D1" );
		Assert.assertEquals("D1", uChews.uniqueID);
	}
	
	@Test
	public void doesUChewsReturnEightyFiveCents() {
		GumClass uChews = new GumClass("UChews", BigDecimal.valueOf(0.85), "5", "D1" );
		Assert.assertEquals(BigDecimal.valueOf(0.85), uChews.price);
	}
	
	@Test
	public void doesChicletsReturnSeventyFiveCents() {
		GumClass chiclets = new GumClass("chiclets", BigDecimal.valueOf(0.75), "5", "D3" );
		Assert.assertEquals(BigDecimal.valueOf(0.75), chiclets.price);
	}
	
	@Test
	public void doesUchewsReturnD3() {
		GumClass chiclets = new GumClass("chiclets", BigDecimal.valueOf(0.75), "5", "D3" );
		Assert.assertEquals("D3", chiclets.uniqueID);
	}

}
