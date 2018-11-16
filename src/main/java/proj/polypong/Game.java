package proj.polypong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Game extends Pane implements Window {
	
	enum GameStatus { PLAY, PAUSE }
	public static final double PADDLEHEIGHT = 100.0;
	public static final double BALLRADIUS = 10.0;
	public static final double BALLSPEED = -1.05;
	public static final Color BACKGROUNDCOLOR = Color.rgb(0,122, 42);
	public static final double STATUSBARHEIGHT = 40.0;
	public static final String P1DOWN = "S";
	public static final String P1UP = "W";
	public static final String P2DOWN = "DOWN";
	public static final String P2UP = "UP";
	public static final String PAUSEBUTTON = "P";
	public static final String RESTARTBUTTON = "R";
	
	private GameStatus gameStatus = GameStatus.PAUSE;
	
	public Ball ball;
	public Paddle p1Paddle;
	public Paddle p2Paddle;
	public StatusBar statusBar;
	private Timeline timeline;
	
	public Game() {
		super();
		initGame();
	}
	
	public static String toRGBCode( Color color )
    {
        return String.format( "#%02X%02X%02X",
            (int)( color.getRed() * 255 ),
            (int)( color.getGreen() * 255 ),
            (int)( color.getBlue() * 255 ) );
    }
	
	private void initGame() {
		ball = new Ball(BALLRADIUS, Color.WHITE);
        ball.relocate(width/2, height/2 - BALLRADIUS/2);
        p1Paddle = new Paddle(5, height/2 - PADDLEHEIGHT/2, 10, PADDLEHEIGHT, Color.WHITE);
        p2Paddle = new Paddle(width - 15, height/2 - PADDLEHEIGHT/2, 10, PADDLEHEIGHT, Color.WHITE);
        statusBar = new StatusBar(width, STATUSBARHEIGHT);
	}
    
    @Override
	public Scene drawWindow() {
        Scene scene = new Scene(this, width, height, Color.WHITE);
        
        this.getChildren().addAll(ball, p1Paddle, p2Paddle, statusBar);
        this.setStyle("-fx-background-color: "+ toRGBCode(Game.BACKGROUNDCOLOR)+";");
        
        scene.setOnKeyPressed(event -> pressedKey(event));
        
        scene.setOnKeyReleased(event -> releasedKey(event));
        
        EventHandler<ActionEvent> eventHandler = e -> {
            ball.setLayoutX(ball.getLayoutX() + ball.xVelocity);
            ball.setLayoutY(ball.getLayoutY() + ball.yVelocity);
            
            movePaddles();
            checkCollisions(this, timeline);
            
        };
        
        timeline = new Timeline(new KeyFrame(Duration.millis(5), eventHandler));
        timeline.setCycleCount(Timeline.INDEFINITE);
        return scene;
    }
    
    public void releasedKey(KeyEvent event) {
        String codeString = event.getCode().toString();
        if (codeString.equals(P1DOWN)) {
            p1Paddle.isLowering = false;
        } else if (codeString.equals(P1UP)) {
            p1Paddle.isRaising = false;
        } 
        if (codeString.equals(P2DOWN)) {
            p2Paddle.isLowering = false;
        } else if (codeString.equals(P2UP)) {
            p2Paddle.isRaising = false;
        }
    }
    
    public void pressedKey(KeyEvent event) {
        String codeString = event.getCode().toString();
        if (codeString.equals(P1DOWN)) {
            p1Paddle.isLowering = true;
        } else if (codeString.equals(P1UP)) {
            p1Paddle.isRaising = true;
        }
        
        if (codeString.equals(P2DOWN)) {
            p2Paddle.isLowering = true;
        } else if (codeString.equals(P2UP)) {
            p2Paddle.isRaising = true;
        }
        
        if (codeString.equals(RESTARTBUTTON)) {
        	new GameController().changetoScene("Game");
        }
        
        if (codeString.equals(PAUSEBUTTON)) {
            if (gameStatus == GameStatus.PAUSE) {
                timeline.play();
                gameStatus = GameStatus.PLAY;
            } else {
                timeline.pause();
                gameStatus = GameStatus.PAUSE;
            }
        }
    }
    
	public void movePaddles() {
    	if (p1Paddle.isLowering) {
    		p1Paddle.slideDown(height);
    	} else if (p1Paddle.isRaising) {
    		p1Paddle.slideUp(STATUSBARHEIGHT);
    	}
    	if (p2Paddle.isLowering) {
    		p2Paddle.slideDown(height);
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
        } else if (ball.hitRightWall(width)) {
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
