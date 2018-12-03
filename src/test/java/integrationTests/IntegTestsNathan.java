/*
 * Nathan Macfarlane's 2 Integration Tests
 * 
 */
package integrationTests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import proj.polypong.SettingsValues;

public class IntegTestsNathan {
	@Test
	public void testSetAndGetPaddleSizeMedium() {
		
		SettingsValues set = new SettingsValues();
		String size = "large";
		set.setPaddleSize(size);
		double getsize = set.getPaddleSize();
		
		double answer = 100.0;
		
		assertEquals(answer, getsize, 0.01);
	}
	

	@Test
	public void testSetGetBallSpeedS() {
		
		SettingsValues set = new SettingsValues();
		String speed = "slow";
		set.setBallSpeed(speed);
		double output = set.getBallSpeed();
		
		Assert.assertTrue(set.ballSpeed == speed);
		double correct = -1.05;
		
		assertEquals(correct, output, 0.01);
	}
	
		

}
