package proj.polypong;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Menu extends  Window {
	
	public Menu() {
		super();
	}

	@Override
	public Scene drawWindow() {
		this.setStyle("-fx-background-color: "+ toRGBCode(backgroundcolor)+";");
		Button playGame = new Button("Play Game");
		Button viewScoreboard = new Button("Scoreboard");
		Button settings  = new Button("Settings");
		
        Scene scene = new Scene(this, width, height, Color.BLACK);
        
        playGame.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even ) {
    			new GameController().changetoScene("Game");
    		}
    	});
        
        settings.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even ) {
    			new GameController().changetoScene("Settings");
    		}
    	});
        
        VBox menuBox = new VBox();
        menuBox.getChildren().addAll(playGame, viewScoreboard, settings);
        this.getChildren().addAll(menuBox);
        return scene;
	}
}
