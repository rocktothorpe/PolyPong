/*
 * Alec Williams' 2 Integration Tests
 * 
 */
package integrationTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import proj.polypong.GameController;
import proj.polypong.Settings;
import proj.polypong.SettingsValues;

public class IntegTestsAlec {
	@Test
	public void testBallSpeedMedium() {
		
		GameController gc = new GameController();
		SettingsValues set = SettingsValues.getInstance();

		String ballSpeed = "medium";
		set.setBallSpeed(ballSpeed);
		
		assertEquals(set.getBallSpeed(),-1.2,0.01);		
	}

	@Test
	public void testBallSpeedFast() {
		
		GameController gc = new GameController();
		SettingsValues set = SettingsValues.getInstance();

		String ballSpeed = "fast";
		set.setBallSpeed(ballSpeed);
		
		assertEquals(set.getBallSpeed(),-1.25,0.01);		
	}

}
