/*
 * Raquel Bonilla's 2 Integration Tests
 * 
 */
package integrationTests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import proj.polypong.SettingsValues;

public class IntegTestsRaquel {
	@Test
	public void testSetAndGetPaddleSizeSmall() {
		
		SettingsValues set = SettingsValues.getInstance();
		String size = "small";
		set.setPaddleSize(size);
		double getsize = set.getPaddleSize();
		
		double answer = 50.0;
		
		assertEquals(answer, getsize, 0.01);
	}
	
	@Test
	public void testSetAndGetPaddleSizeMedium() {
		
		SettingsValues set = SettingsValues.getInstance();
		String size = "medium";
		set.setPaddleSize(size);
		double getsize = set.getPaddleSize();
		
		double answer = 75.0;
		
		assertEquals(answer, getsize, 0.01);
	}

}
