/*
 * Allen Deng's 2 Integration Tests
 * 
 */



package integrationTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import proj.polypong.SettingsValues;

public class IntegTestAllen {
	
	@Test
	public void testSetAndGetColor1Background() {
		SettingsValues setting = new SettingsValues();
		String newBackground = "color1";
		setting.setBackgroundColor(newBackground);
		assertEquals("color1", setting.backgroundColor);
		
		String colorString = setting.getBackgroundColor();
		
		assertTrue(colorString == "#336967");
	}
	
	@Test
	public void testSetAndGetColor3BackGround() {
		SettingsValues setting = new SettingsValues();
		String newBackground = "color3";
		setting.setBackgroundColor(newBackground);
		assertEquals("color3", setting.backgroundColor);
		
		String colorString = setting.getBackgroundColor();
		assertTrue(colorString == "#5C6B8B");
	}
	
}
