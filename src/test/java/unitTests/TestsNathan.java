/*
 * Nathan Macfarlane's 2 Unit Tests
 * 
 */
package unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import proj.polypong.SettingsValues;

public class TestsNathan {
		
	@Test
	public void testGetPaddleSizeMedium() {
		SettingsValues set = new SettingsValues();
		set.paddleSize = "medium";
		
		double size = set.getPaddleSize();
		double correct = 75.0;
		assertEquals(correct, size, 0.01);
		
	}
	@Test
	public void testGetPaddleSizeLarge() {
		SettingsValues set = new SettingsValues();
		set.paddleSize = "large";
		
		double size = set.getPaddleSize();
		double correct = 100.0;
		assertEquals(correct, size, 0.01);
		
	}

}
