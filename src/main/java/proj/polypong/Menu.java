package proj.polypong;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Menu extends Pane implements Window {
	
	public Color backgroundcolor;
	
	public Menu() {
		super();
	}

	@Override
	public Scene drawWindow() {
		Button playGame = new Button("Play Game");
		Button viewScoreboard = new Button("Scoreboard");
		Button settings  = new Button("Settings");
		
        Scene scene = new Scene(this, width, height, Color.BLACK);
        
        playGame.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even ) {
    			new GameController().changetoScene("Game");
    		}
    	});
        
        HBox menuBox = new HBox();
        menuBox.getChildren().addAll(playGame, viewScoreboard, settings);
        this.getChildren().addAll(menuBox);
        return scene;
	}
}
