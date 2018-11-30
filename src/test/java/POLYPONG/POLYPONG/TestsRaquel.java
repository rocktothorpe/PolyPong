/*
 * Raquel Bonilla's 2 Unit Tests
 * 
 */
package POLYPONG.POLYPONG;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import proj.polypong.SettingsValues;

public class TestsRaquel {
	
	@Test
	public void testSetPaddleSize() {
		
		SettingsValues set = new SettingsValues();
		String size = "small";
		set.setPaddleSize(size);
		
		Assert.assertTrue(set.paddleSize == size);
	}
	
	@Test
	public void testGetPaddleSize() {
		SettingsValues set = new SettingsValues();
		set.paddleSize = "small";
		
		double size = set.getPaddleSize();
		double correct = 50.0;
		assertEquals(correct, size, 0.01);
		
	}

}
