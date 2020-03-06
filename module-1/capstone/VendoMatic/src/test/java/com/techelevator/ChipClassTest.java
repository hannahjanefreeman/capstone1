package com.techelevator;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

public class ChipClassTest {
	
	@Test
	public void doesStackersReturnA2() {
		ChipClass stackers = new ChipClass("Stackers", BigDecimal.valueOf(1.45), "5", "A2" );
		Assert.assertEquals("A2", stackers.uniqueID);
	}
	
	@Test
	public void doesStackersReturnDollarFortyFive() {
		ChipClass stackers = new ChipClass("Stackers", BigDecimal.valueOf(1.45), "5", "A2" );
		Assert.assertEquals(BigDecimal.valueOf(1.45), stackers.price);
	}
	
	@Test
	public void doesGrainWavesReturnA3() {
		ChipClass grainWaves = new ChipClass("Grain Waves", BigDecimal.valueOf(2.75), "5", "A3" );
		Assert.assertEquals("A3", grainWaves.uniqueID);
	}

	@Test
	public void doesGrainWavesReturnTwoSeventyFive() {
	ChipClass grainWaves = new ChipClass("Grain Waves", BigDecimal.valueOf(2.75), "5", "A3" );
	Assert.assertEquals(BigDecimal.valueOf(2.75), grainWaves.price);
	}
}
