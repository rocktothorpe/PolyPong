/*
 * Allen Deng's 2 Integration Tests
 * 
 */



package integrationTests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import proj.polypong.SettingsValues;

public class IntegTestAllen {
	
	@Test
	public void testSetAndGetColor1Background() {
		SettingsValues setting = new SettingsValues();
		String newBackground = "color1";
		setting.setBackgroundColor(newBackground);
		assertEquals(setting.backgroundColor, "color1");
		
		String colorString = setting.getBackgroundColor();
		
		assertEquals(colorString, "#80A4ED");
	}
	
	@Test
	public void testSetAndGetColor3BackGround() {
		SettingsValues setting = new SettingsValues();
		String newBackground = "color3";
		setting.setBackgroundColor(newBackground);
		assertEquals(setting.backgroundColor, "color3");
		
		String colorString = setting.getBackgroundColor();
		assertEquals(colorString, "#E01A4F");
	}
	
}
