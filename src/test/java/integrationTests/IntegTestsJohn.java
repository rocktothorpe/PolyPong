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
	public void testPaddleUpDown() {
		
		int initialPos = 150;
		Paddle p = new Paddle(5, initialPos, 10, 100, Color.WHEAT);
		p.slideDown(255);
		p.slideUp(10);
		
	
		assertEquals(initialPos,p.getY(),.001);		
	}

	@Test
	public void testSetScore() {
		
		Score s = new Score("John", 42);
		String bob = s.toString(); // Nate overloaded this
		assertEquals("John 42", bob);			
	}

}
