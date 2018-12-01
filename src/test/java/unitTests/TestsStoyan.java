/*
 * Stoyan Shukerov's 2 Unit Tests
 * 
 */
package unitTests;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import javafx.scene.paint.Color;
import proj.polypong.*;

public class TestsStoyan {
	
	@Test
	public void testHitLeftWall() {
		
		double ballRadius = 40.0;
		SettingsValues sv = new SettingsValues();
		Ball ball = new Ball(ballRadius, Color.WHITE);
		assertTrue(ball.hitLeftWall());
		
	}
	
	@Test
	public void testHitRightWall() {
		
		double ballRadius = 40.0;
		SettingsValues sv = new SettingsValues();
		Ball ball = new Ball(ballRadius, Color.WHITE);
		assertTrue(!ball.hitRightWall(400.0));
		
	}
}
