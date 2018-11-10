package proj.polypong;

import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Game {
	
	public final String GAMETITLE = "PolyPong";
	public final double GAMEWIDTH = 900.0;
	public final double GAMEHEIGHT = 500.0;
	public final double PADDLEHEIGHT = 100.0;
	public final double BALLRADIUS = 10.0;
	public final double BALLSPEED = -1.05;
	public final Color BACKGROUNDCOLOR = Color.rgb(29, 32, 44);
	public final double STATUSBARHEIGHT = 40.0;
	public final String P1DOWN = "S";
	public final String P1UP = "W";
	public final String P2DOWN = "DOWN";
	public final String P2UP = "UP";
	public final String PAUSEBUTTON = "P";
	
	public Ball ball;
	public Paddle p1Paddle;
	public Paddle p2Paddle;
	public StatusBar statusBar;
	
	public Game() {
		this.ball = new Ball(this.BALLRADIUS, Color.WHITE);
        ball.relocate(this.GAMEWIDTH/2, this.GAMEHEIGHT/2 - this.BALLRADIUS/2);
        this.p1Paddle = new Paddle(5, this.GAMEHEIGHT/2 - this.PADDLEHEIGHT/2, 10, this.PADDLEHEIGHT, Color.WHITE);
        this.p2Paddle = new Paddle(this.GAMEWIDTH - 15, this.GAMEHEIGHT/2 - this.PADDLEHEIGHT/2, 10, this.PADDLEHEIGHT, Color.WHITE);
        this.statusBar = new StatusBar(this.GAMEWIDTH, this.STATUSBARHEIGHT);
	}
	
	public void movePaddles() {
    	if (this.p1Paddle.isLowering) {
    		this.p1Paddle.slideDown(this.GAMEHEIGHT);
    	} else if (this.p1Paddle.isRaising) {
    		this.p1Paddle.slideUp(this.STATUSBARHEIGHT);
    	}
    	if (this.p2Paddle.isLowering) {
    		this.p2Paddle.slideDown(this.GAMEHEIGHT);
    	} else if (this.p2Paddle.isRaising) {
    		this.p2Paddle.slideUp(this.STATUSBARHEIGHT);
    	}
    }
	
	public void checkCollisions(Pane canvas, Timeline timeline) {
    	if (this.ball.hitLeftWall()) {
        	if (this.p1Paddle.ballCollides(this.ball)) {
        		this.ball.xVelocity *= this.BALLSPEED;
        	} else {
        		timeline.pause();
        	}
        } else if (this.ball.hitRightWall(this.GAMEWIDTH)) {
        	if (this.p2Paddle.ballCollides(this.ball)) {
        		this.ball.xVelocity *= this.BALLSPEED;
        	} else {
        		timeline.pause();
        	}
        }
    	Bounds bounds = canvas.getBoundsInLocal();
        
        if((this.ball.getLayoutY() >= (bounds.getMaxY() - this.ball.getRadius())) || 
                (this.ball.getLayoutY() <= (bounds.getMinY() + this.STATUSBARHEIGHT + this.ball.getRadius()))){
        	this.ball.yVelocity = -this.ball.yVelocity;
        }
    }
	
	
}
