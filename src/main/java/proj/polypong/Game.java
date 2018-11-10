package proj.polypong;

import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Game {
	
	public static final String GAMETITLE = "PolyPong";
	public static final double GAMEWIDTH = 900.0;
	public static final double GAMEHEIGHT = 500.0;
	public static final double PADDLEHEIGHT = 100.0;
	public static final double BALLRADIUS = 10.0;
	public static final double BALLSPEED = -1.05;
	public static final Color BACKGROUNDCOLOR = Color.rgb(29, 32, 44);
	public static final double STATUSBARHEIGHT = 40.0;
	public static final String P1DOWN = "S";
	public static final String P1UP = "W";
	public static final String P2DOWN = "DOWN";
	public static final String P2UP = "UP";
	public static final String PAUSEBUTTON = "P";
	
	public Ball ball;
	public Paddle p1Paddle;
	public Paddle p2Paddle;
	public StatusBar statusBar;
	
	public Game() {
		ball = new Ball(BALLRADIUS, Color.WHITE);
        ball.relocate(GAMEWIDTH/2, GAMEHEIGHT/2 - BALLRADIUS/2);
        p1Paddle = new Paddle(5, GAMEHEIGHT/2 - PADDLEHEIGHT/2, 10, PADDLEHEIGHT, Color.WHITE);
        p2Paddle = new Paddle(GAMEWIDTH - 15, GAMEHEIGHT/2 - PADDLEHEIGHT/2, 10, PADDLEHEIGHT, Color.WHITE);
        statusBar = new StatusBar(GAMEWIDTH, STATUSBARHEIGHT);
	}
	
	public void movePaddles() {
    	if (p1Paddle.isLowering) {
    		p1Paddle.slideDown(GAMEHEIGHT);
    	} else if (p1Paddle.isRaising) {
    		p1Paddle.slideUp(STATUSBARHEIGHT);
    	}
    	if (p2Paddle.isLowering) {
    		p2Paddle.slideDown(GAMEHEIGHT);
    	} else if (p2Paddle.isRaising) {
    		p2Paddle.slideUp(STATUSBARHEIGHT);
    	}
    }
	
	public void checkCollisions(Pane canvas, Timeline timeline) {
    	if (ball.hitLeftWall()) {
        	if (p1Paddle.ballCollides(ball)) {
        		ball.xVelocity *= BALLSPEED;
        	} else {
        		timeline.pause();
        	}
        } else if (ball.hitRightWall(GAMEWIDTH)) {
        	if (p2Paddle.ballCollides(ball)) {
        		ball.xVelocity *= BALLSPEED;
        	} else {
        		timeline.pause();
        	}
        }
    	Bounds bounds = canvas.getBoundsInLocal();
        
        if((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) || 
                (ball.getLayoutY() <= (bounds.getMinY() + STATUSBARHEIGHT + ball.getRadius()))){
        	ball.yVelocity = -ball.yVelocity;
        }
    }
	
	
}
