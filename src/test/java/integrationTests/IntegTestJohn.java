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
		
		assertTrue("#395C6B" == settingValues.getBackgroundColor());
		
	}
	
	@Test
	public void testSetAndGetBallImage() {
		SettingsValues settingValues = new SettingsValues();
		settingValues.setBallImage("clements");
		assertTrue("clements" == settingValues.curhead);
		
	}

}
