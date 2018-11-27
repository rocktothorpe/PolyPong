package POLYPONG.POLYPONG;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import proj.polypong.Paddle;

public class TestsAlec extends TestCase {

	@Test
	public void testPaddleDown(){
		int initialPos = 150;
		Paddle p = new Paddle(5, initialPos, 10, 100, Color.WHEAT);
		p.slideDown(255);
		assertTrue(p.getY() > initialPos);	
	}
	
	@Test
	public void testPaddleUp(){
		int initialPos = 150;
		Paddle p = new Paddle(5, initialPos, 10, 100, Color.WHEAT);
		p.slideUp(10);
		
		assertTrue(p.getY() < initialPos);
	}
}
