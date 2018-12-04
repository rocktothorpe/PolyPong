/*
 * John Nightingale's 2 Integration Tests
 * 
 */

package integrationTests;

import static org.junit.Assert.*;

import org.junit.Test;
import proj.polypong.*;

public class IntegTestJohn {

	@Test
	public void testSetAndGetColor2Background() {
		SettingsValues settingValues = new SettingsValues();
		settingValues.setBackgroundColor("color2");
		
		assertEquals(settingValues.backgroundColor, "color2");
		
		assertEquals(settingValues.getBackgroundColor(), "#395C6B");
		
		
	}
	
	@Test
	public void testSetAndGetBallImage() {
		SettingsValues settingValues = new SettingsValues();
		settingValues.setBallImage("clements");
		assertEquals(settingValues.curhead, "clements");
		
	}

}
