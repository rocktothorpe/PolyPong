package proj.polypong;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameController extends Application {
	
	enum GameStatus { PLAY, PAUSE }
	
	private GameStatus gameStatus = GameStatus.PAUSE;
	private Timeline timeline;
	
    @Override
    public void start(Stage stage) {
    	
    	final Game game = new Game();
    	
    	stage.setTitle(Game.GAMETITLE);
    	Pane canvas = new Pane();
    	Scene scene = new Scene(canvas, Game.GAMEWIDTH, Game.GAMEHEIGHT, Game.BACKGROUNDCOLOR);
        
        canvas.getChildren().addAll(game.ball, game.p1Paddle, game.p2Paddle, game.statusBar);
        stage.setScene(scene);
        stage.show();
        
        scene.setOnKeyPressed(event -> pressedKey(event, game));
        
        scene.setOnKeyReleased(event -> releasedKey(event, game));
        
        EventHandler<ActionEvent> eventHandler = e -> {
        	game.ball.setLayoutX(game.ball.getLayoutX() + game.ball.xVelocity);
        	game.ball.setLayoutY(game.ball.getLayoutY() + game.ball.yVelocity);
        	
        	game.movePaddles();
        	game.checkCollisions(canvas, timeline);
        	
        };
        
        timeline = new Timeline(new KeyFrame(Duration.millis(5), eventHandler));
    	timeline.setCycleCount(Timeline.INDEFINITE);
	}
    
    public void releasedKey(KeyEvent event, Game game) {
    	String codeString = event.getCode().toString();
        if (codeString.equals(Game.P1DOWN)) {
        	game.p1Paddle.isLowering = false;
        } else if (codeString.equals(Game.P1UP)) {
        	game.p1Paddle.isRaising = false;
        } 
        if (codeString.equals(Game.P2DOWN)) {
        	game.p2Paddle.isLowering = false;
        } else if (codeString.equals(Game.P2UP)) {
        	game.p2Paddle.isRaising = false;
        }
    }
    
    public void pressedKey(KeyEvent event, Game game) {
    	String codeString = event.getCode().toString();
        if (codeString.equals(Game.P1DOWN)) {
        	game.p1Paddle.isLowering = true;
        } else if (codeString.equals(Game.P1UP)) {
        	game.p1Paddle.isRaising = true;
        } 
        if (codeString.equals(Game.P2DOWN)) {
        	game.p2Paddle.isLowering = true;
        } else if (codeString.equals(Game.P2UP)) {
        	game.p2Paddle.isRaising = true;
        }
        if (codeString.equals(Game.PAUSEBUTTON)) {
        	if (gameStatus == GameStatus.PAUSE) {
            	timeline.play();
            	gameStatus = GameStatus.PLAY;
        	} else {
        		timeline.pause();
        		gameStatus = GameStatus.PAUSE;
        	}
        }
    }
    
    public static void main(String[] args) {
        launch();
    }
}
