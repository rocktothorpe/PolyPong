/*
 * Raquel Bonilla's 2 Unit Tests
 * 
 */
package unitTests;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import proj.polypong.SettingsValues;

public class TestsRaquel {
	
	@Test
	public void testSetPaddleSize() {
		
		SettingsValues set = SettingsValues.getInstance();
		String size = "small";
		set.setPaddleSize(size);
		
		Assert.assertTrue(set.paddleSize == size);
	}
	
	@Test
	public void testGetPaddleSizeSmall() {
		SettingsValues set = SettingsValues.getInstance();
		set.paddleSize = "small";
		
		double size = set.getPaddleSize();
		double correct = 50.0;
		assertEquals(correct, size, 0.01);
		
	}

}
