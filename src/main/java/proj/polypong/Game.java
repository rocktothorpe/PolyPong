package proj.polypong;

import java.io.FileNotFoundException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.transform.Rotate;

public class Game extends Window {
	
	enum GameStatus { PLAY, PAUSE }
	public static final double BALLRADIUS = 40.0;
	
	public static final double STATUSBARHEIGHT = 40.0;
	public static final String P1DOWN = "S";
	public static final String P1UP = "W";
	public static final String P2DOWN = "DOWN";
	public static final String P2UP = "UP";
	public static final String PAUSEBUTTON = "P";
	public static final String RESTARTBUTTON = "R";
	public  double ballSpeed = -1.05;
	public  String gameBackgroundColor = "#80A4ED";
	public  double paddleHeight = 100.0;
	
	private GameStatus gameStatus = GameStatus.PAUSE;
	private SettingsValues sv;
	
	public Ball ball;
	public Paddle p1Paddle;
	public Paddle p2Paddle;
	public StatusBar statusBar;
	private Timeline timeline;
	
	VBox pauseLabelBG = new VBox();
	Label bg = new Label();
	Label pauseLabel = new Label("PAUSED");
	
	
	public Game() {
		super();
		this.sv = SettingsValues.getInstance();
		initGame();
	}
	
	private void initGame() {
		ball = new Ball(BALLRADIUS, Color.WHITE);
		ball.changeFill(sv.ballImage);
		paddleHeight = sv.getPaddleSize();
		ballSpeed = sv.getBallSpeed();
        ball.relocate(width/2, height/2 - BALLRADIUS/2);
        p1Paddle = new Paddle(5, height/2 - paddleHeight/2, 10, paddleHeight, Color.WHITE);
        p2Paddle = new Paddle(width - 15, height/2 - paddleHeight/2, 10, paddleHeight, Color.WHITE);
        statusBar = new StatusBar(width, STATUSBARHEIGHT);
	}
    
    @Override
	public Scene drawWindow() {
        Pane pane = new Pane();
        pane.getChildren().addAll(ball, p1Paddle, p2Paddle, statusBar);
		pane.getStylesheets().add("stylesheet.css");
        pane.getStyleClass().add(sv.getBackgroundColorS());
        Scene scene = new Scene(pane, width, height, Color.WHITE);
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() { 
        	public void handle(KeyEvent event) {
            String codeString = event.getCode().toString();
            switch(codeString)
            {
            	case P1DOWN:  
            		p1Paddle.isLowering = true;
            		break;
            	case P1UP:
            		p1Paddle.isRaising = true;
            		break;
            	case P2DOWN:
            		p2Paddle.isLowering = true;
            		break;
            	case P2UP:
            		 p2Paddle.isRaising = true;
            		 break;
            	case RESTARTBUTTON:
            		GameController.changetoScene("Game");
            		break;
            	case PAUSEBUTTON:
            		if (gameStatus == GameStatus.PAUSE) {
            			pane.getChildren().remove(bg);
            			pane.getChildren().remove(pauseLabelBG);
            			pauseLabelBG.getChildren().remove(pauseLabel);
                        timeline.play();
                        gameStatus = GameStatus.PLAY;
                    } else {
                        timeline.pause();
                        pauseLabelBG.setMinHeight(height);
                        pauseLabelBG.setMinWidth(width);
                        pauseLabelBG.setAlignment(Pos.CENTER);
                        bg = new Label();
                        bg.setStyle("-fx-background-color: black;");
                        bg.setOpacity(0.5);
                        bg.setMinWidth(width);
                        bg.setMinHeight(height);
                        pauseLabel.setTextFill(Color.WHITE);
                        pauseLabelBG.getChildren().addAll(pauseLabel);
                        pane.getChildren().addAll(bg, pauseLabelBG);
                        gameStatus = GameStatus.PAUSE;
                    }
            		break;
            	default:
            		break;		
            }
        }	
        });
       
        scene.setOnKeyReleased( new EventHandler<KeyEvent>() {
        	public void handle(KeyEvent event) {
            String codeString = event.getCode().toString();
            switch(codeString)
            {
            	case P1DOWN:  
            		p1Paddle.isLowering = false;
            		break;
            	case P1UP:
            		p1Paddle.isRaising = false;
            		break;
            	case P2DOWN:
            		p2Paddle.isLowering = false;
            		break;
            	case P2UP:
            		 p2Paddle.isRaising = false;
            		 break;
            	default:
            		break;
            }
        }
    });
        
        EventHandler<ActionEvent> eventHandler = e -> {
            ball.setLayoutX(ball.getLayoutX() + ball.xVelocity);
            ball.setLayoutY(ball.getLayoutY() + ball.yVelocity);
            ball.getTransforms().add(new Rotate(ball.ballRot,0,0));
            movePaddles();
            checkCollisions(pane, timeline);
        };
        
        timeline = new Timeline(new KeyFrame(Duration.millis(5), eventHandler));
        timeline.setCycleCount(Timeline.INDEFINITE);
        return scene;
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
        		if (Math.abs(ball.xVelocity * ballSpeed) > 9) {
        			ballSpeed = -1.0;
        		}
        		ball.xVelocity *= ballSpeed;
        		ball.ballRot*=ballSpeed;
        		switchBall(ball);
        	} else {
        		timeline.pause();
        		GameController.changetoScene("NewScore");
        	}
        } else if (ball.hitRightWall(width)) {
        	if (p2Paddle.ballCollides(ball)) {
        		if (Math.abs(ball.xVelocity * ballSpeed) > 9) {
        			ballSpeed = -1.0;
        		}
        		ball.xVelocity *= ballSpeed;
        		ball.ballRot*=ballSpeed;
        		switchBall(ball);
        	} else {
        		timeline.pause();
        		GameController.changetoScene("NewScore");
        	}
        }
    	Bounds bounds = canvas.getBoundsInParent();
        
        if((ball.getLayoutY() >= (bounds.getMaxY() - (ball.getRadius()+.01))) || 
                (ball.getLayoutY() <= (bounds.getMinY() + STATUSBARHEIGHT + ball.getRadius()))){
        	ball.yVelocity = -ball.yVelocity;
        }
    }
	
	public void switchBall(Ball ball) {
		// change imageHead if mixed mode
		if (sv.curhead == "mixed") {
			try {
				ball.changeFill(sv.nextBallImage());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}
}
