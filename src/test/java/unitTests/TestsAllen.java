package unitTests;

import org.junit.Test;

import junit.framework.TestCase;
import proj.polypong.SettingsValues;

/*
 * Allen Deng's 2 Unit Tests
 */

public class TestsAllen extends TestCase {

	
	@Test
	public void testSetBallSpeedM() {
		SettingsValues set = SettingsValues.getInstance();
		String speed = "medium";
		set.setBallSpeed(speed);
		
		assertEquals(set.ballSpeed, "medium");
		assertTrue(set.ballSpeed == speed);
	}
	
	@Test
	public void testGetBallSpeedM() {
		SettingsValues set = SettingsValues.getInstance();
		set.ballSpeed = "medium";
		double output = set.getBallSpeed();
		double correct = -1.2;
		
		assertEquals(output, correct, 0.01);
	}
	
	
	

}
