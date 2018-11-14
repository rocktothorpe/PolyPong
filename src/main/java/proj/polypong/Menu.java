package proj.polypong;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Menu {
	
	public double gamewidth;
	public double gameheight;
	public Color backgroundcolor;
	GameController gc;
	
	public Menu(double gameWidth, double gameHeight, Color backgroundColor, GameController gc) {
		this.gc = gc;
		gamewidth = gameWidth;
		gameheight = gameHeight;
		backgroundcolor = backgroundColor;
	}
	
	public void drawMainMenu(Stage stage) {
		// declare main menu buttons
		Button playGame = new Button("Play Game");
		Button viewScoreboard = new Button("Scoreboard");
		Button settings  = new Button("Settings");
		
		// scene and pane declared and set
		Pane canvas = new Pane();
        Scene scene = new Scene(canvas, gamewidth, gameheight, Color.BLACK);
        
        playGame.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even ) {
    	    	gc.changetoScene("Game");
    		}
    	});
        
        HBox menuBox = new HBox();
        menuBox.getChildren().addAll(playGame, viewScoreboard, settings);
        canvas.getChildren().addAll(menuBox);
        stage.setScene(scene);
        stage.show();
	}
}
