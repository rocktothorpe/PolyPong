package proj.polypong;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Scoreboard extends Window {
	
	private GameController gc;
	
	public Scoreboard(GameController gc) {
		super();
		this.gc = gc;
	}
	
	@Override
	public Scene drawWindow() {
		Scene scene = new Scene(this, width, height);
		scene.getStylesheets().add("stylesheet.css");
		this.setStyle("-fx-background-color: #22262f;");
		
		// back button
		Button back = new Button("X");
		back.getStyleClass().add("back-button");
        
        back.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			gc.changetoScene("Menu");
    		}
    	});
        
        StackPane.setAlignment(back, Pos.TOP_LEFT);
        this.getChildren().addAll(back);
		
		return scene;
	}
	
}
