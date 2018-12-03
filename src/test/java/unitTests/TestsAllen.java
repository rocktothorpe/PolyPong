package unitTests;

/*
 * Allen Deng's 2 Unit Tests
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import junit.framework.TestCase;
import proj.polypong.SettingsValues;

class TestsAllen {

	
	@Test
	public void testSetBallSpeedM() {
		SettingsValues set = new SettingsValues();
		String speed = "medium";
		set.setBallSpeed(speed);
		
		assertEquals(set.ballSpeed, "medium");
		assertTrue(set.ballSpeed == speed);
	}
	
	@Test
	public void testGetBallSpeedM() {
		SettingsValues set = new SettingsValues();
		set.ballSpeed = "medium";
		double output = set.getBallSpeed();
		double correct = -1.2;
		
		assertEquals(output, correct, 0.01);
	}
	
	
	

}
