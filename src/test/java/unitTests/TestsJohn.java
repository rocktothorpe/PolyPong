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
		
		SettingsValues set = SettingsValues.getInstance();
		String speed = "slow";
		set.setBallSpeed(speed);
		
		Assert.assertTrue(set.ballSpeed == speed);
	}
	
	@Test
	public void testGetBallSpeedS() {
		SettingsValues set = SettingsValues.getInstance();
		set.ballSpeed = "slow";
		double output = set.getBallSpeed();
		double correct = -1.05;
		
		assertEquals(correct, output, 0.01);
		
	}
	
}
