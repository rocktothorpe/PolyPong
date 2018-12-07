/*
 * Alec Williams' 2 Integration Tests
 * 
 */
package integrationTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import proj.polypong.SettingsValues;

public class IntegTestsAlec {
	@Test
	public void testBallSpeedMedium() {
		SettingsValues set = SettingsValues.getInstance();

		String ballSpeed = "medium";
		set.setBallSpeed(ballSpeed);
		
		assertEquals(set.getBallSpeed(),-1.2,0.01);		
	}

	@Test
	public void testBallSpeedFast() {
		SettingsValues set = SettingsValues.getInstance();

		String ballSpeed = "fast";
		set.setBallSpeed(ballSpeed);
		
		assertEquals(set.getBallSpeed(),-1.25,0.01);		
	}

}
