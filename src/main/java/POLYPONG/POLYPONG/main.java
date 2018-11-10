package POLYPONG.POLYPONG;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class main extends Application{
	
	enum GameStatus { PLAY, PAUSE }
	
	public static final String GAMETITLE = "PolyPong";
	public static final double GAMEWIDTH = 900.0;
	public static final double GAMEHEIGHT = 500.0;
	public static final double PADDLEHEIGHT = 100.0;
	public static final double BALLRADIUS = 10.0;
	public static final double BALLSPEED = -1.05;
	public static final Color BACKGROUNDCOLOR = Color.rgb(29, 32, 44);
	public static final Color STATUSBARCOLOR = Color.rgb(166, 161, 159);
	public static final double STATUSBARHEIGHT = 40.0;
	public static final String P1DOWN = "S";
	public static final String P1UP = "W";
	public static final String P2DOWN = "DOWN";
	public static final String P2UP = "UP";
	public static final String PAUSEBUTTON = "P";
	
	private GameStatus gameStatus = GameStatus.PAUSE;
	private Timeline timeline;
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle(GAMETITLE);
    	Pane canvas = new Pane();
    	Scene scene = new Scene(canvas, GAMEWIDTH, GAMEHEIGHT, BACKGROUNDCOLOR);
    	Ball ball = new Ball(BALLRADIUS, Color.WHITE);
        ball.relocate(GAMEWIDTH/2, GAMEHEIGHT/2 - BALLRADIUS/2);
        Paddle p1Paddle = new Paddle(5, GAMEHEIGHT/2 - PADDLEHEIGHT/2, 10, PADDLEHEIGHT, Color.WHITE);
        Paddle p2Paddle = new Paddle(GAMEWIDTH - 15, GAMEHEIGHT/2 - PADDLEHEIGHT/2, 10, PADDLEHEIGHT, Color.WHITE);
        StatusBar statusBar = new StatusBar(GAMEWIDTH, STATUSBARHEIGHT, STATUSBARCOLOR);
        canvas.getChildren().addAll(ball, p1Paddle, p2Paddle, statusBar);
        stage.setScene(scene);
        stage.show();
        
        scene.setOnKeyPressed(event -> {
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
            if (codeString.equals(PAUSEBUTTON)) {
            	System.out.println("pausing");
            	if (gameStatus == GameStatus.PAUSE) {
                	timeline.play();
                	gameStatus = GameStatus.PLAY;
            	} else {
            		timeline.pause();
            		gameStatus = GameStatus.PAUSE;
            	}
            }
        });
        
        scene.setOnKeyReleased(event -> {
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
        });
        
        EventHandler<ActionEvent> eventHandler = e -> {
        	ball.setLayoutX(ball.getLayoutX() + ball.xVelocity);
        	ball.setLayoutY(ball.getLayoutY() + ball.yVelocity);
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
            Bounds bounds = canvas.getBoundsInLocal();
            if (ball.hitLeftWall()) {
            	if (p1Paddle.ballCollides(ball)) {
            		ball.xVelocity *= BALLSPEED;
            	} else {
            		System.out.println("P2 Wins!");
            		timeline.pause();
            	}
            } else if (ball.hitRightWall(GAMEWIDTH)) {
            	if (p2Paddle.ballCollides(ball)) {
            		ball.xVelocity *= BALLSPEED;
            	} else {
            		System.out.println("P1 Wins!");
            		timeline.pause();
            	}
            }
            if((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) || 
                    (ball.getLayoutY() <= (bounds.getMinY() + STATUSBARHEIGHT + ball.getRadius()))){
            	ball.yVelocity = -ball.yVelocity;
            }
        };
        
        timeline = new Timeline(new KeyFrame(Duration.millis(5), eventHandler));
    	timeline.setCycleCount(Timeline.INDEFINITE);
	}
    
    public static void main(String[] args) {
        launch();
    }
}
