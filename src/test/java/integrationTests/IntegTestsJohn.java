/*
 * John Nightingale' 2 Integration Tests
 * 
 */
package integrationTests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import javafx.scene.paint.Color;
import proj.polypong.Paddle;
import proj.polypong.Score;


public class IntegTestsJohn {
	@Test
	public void testpaddleslidesupanddown() {
		
		int initialPos = 150;
		Paddle p = new Paddle(5, initialPos, 10, 100, Color.WHEAT);
		p.slideDown(255);
		p.slideUp(10);
		
	
		assertEquals(p.getY(),initialPos,.001);		
	}

	@Test
	public void testPaddlesnotmovingupatstartofGame() {
		
		Score s = new Score("John", 42);
		String bob = s.toString();
		assertEquals(bob,"John 42");			
	}

}
