package proj.polypong;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Menu extends  Window {
	
	private GameController gc;
	
	public Menu(GameController gc) {
		super();
		this.gc = gc;
	}

	@Override
	public Scene drawWindow() {
		this.setStyle("-fx-background-color: #22262f;");
		Button playGame = new Button("Play Game");
		Button viewScoreboard = new Button("Scoreboard");
		Button settings  = new Button("Settings");
		
        Scene scene = new Scene(this, width, height, Color.BLACK);
        
        playGame.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even ) {
    			gc.changetoScene("Game");
    		}
    	});
        
        settings.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even ) {
    			gc.changetoScene("Settings");
    		}
    	});
        
        VBox menuBox = new VBox();
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setSpacing(10.0);
        menuBox.getChildren().addAll(playGame, viewScoreboard, settings);
        this.getChildren().addAll(menuBox);
        this.setAlignment(Pos.CENTER);
        return scene;
	}
}
