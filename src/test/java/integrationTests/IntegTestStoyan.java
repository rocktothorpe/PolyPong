/*
 * Stoyan Shukerov's 2 integration tests 
 * 
 */

package integrationTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import proj.polypong.SettingsValues;

public class IntegTestStoyan {

	@Test
	public void testSetAndGetBallSpeedMedium() {
		
		SettingsValues set = SettingsValues.getInstance();
		String speed = "medium";
		set.setBallSpeed(speed);
		double ballSpeed = set.getBallSpeed();
		
		double answer = -1.2;
		
		assertEquals(answer, ballSpeed, 0.01);
	}
	

	@Test
	public void testSetGetBallSpeedFast() {
		
		SettingsValues set = SettingsValues.getInstance();
		String speed = "fast";
		set.setBallSpeed(speed);
		double output = set.getBallSpeed();
	
		
		double correct = -1.25;
		
		assertEquals(correct, output, 0.01);
	}
	
}
