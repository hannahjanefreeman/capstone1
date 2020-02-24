package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ChipClassTest {
	
	@Test
	public void doesStackersReturnA2DollarFortyFive() {
		ChipClass stackers = new ChipClass("Stackers", "1.45", 5, "A2" );
		Assert.assertSame("A2", stackers.uniqueID);
		Assert.assertSame("1.45", stackers.price);
	}
	
	@Test
	public void doesGrainWavesReturnA3TwoSeventyFive() {
		ChipClass grainWaves = new ChipClass("Grain Waves", "2.75", 5, "A3" );
		Assert.assertSame("A3", grainWaves.uniqueID);
		Assert.assertSame("2.75", grainWaves.price);
	}

}
