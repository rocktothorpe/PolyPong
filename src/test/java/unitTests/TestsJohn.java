/*
 * John Nightingale's 2 Unit Tests
 * 
 */
package unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import proj.polypong.SettingsValues;

public class TestsJohn {
	@Test
	public void testSetBallSpeedS() {
		
		SettingsValues set = new SettingsValues();
		String speed = "slow";
		set.setBallSpeed(speed);
		
		Assert.assertTrue(set.ballSpeed == speed);
	}
	
	@Test
	public void testGetBallSpeedS() {
		SettingsValues set = new SettingsValues();
		set.ballSpeed = "SLOW";
		double output = set.getBallSpeed();
		double correct = -1.05;
		
		assertEquals(output, correct, 0.01);
		
	}
	
}