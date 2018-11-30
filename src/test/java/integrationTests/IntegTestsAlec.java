/*
 * Nathan Macfarlane's 2 Integration Tests
 * 
 */
package integrationTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import proj.polypong.Game;
import proj.polypong.GameController;
import proj.polypong.SettingsValues;

public class IntegTestsAlec {
	@Test
	public void testMovePaddles() {
		
		double paddleStartLoc, paddleEndLoc;
		GameController gc = new GameController();
		SettingsValues set = new SettingsValues();
		
		//String size = "large";
		//set.setPaddleSize(size);
		//gc.changetoScene("Game");
		Game g = new Game(gc,set);
	
		/**
		//set paddle starting location
		paddleStartLoc = g.p1Paddle.getY();
		g.p1Paddle.isLowering = true;
		g.movePaddles();
		g.p1Paddle.isLowering = false;
		paddleEndLoc = g.p1Paddle.getY();

		
		assertTrue(paddleStartLoc != paddleEndLoc);
		**/
	}

}
