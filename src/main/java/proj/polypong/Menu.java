package proj.polypong;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Menu extends  Window {
	private static final String button = "button";
	private static final String mainbutton = "mainmenu-button";
	
	private GameController gc; 
	public Menu(GameController gc) {
		super();
		this.gc = gc;
	}

	@Override
	public Scene drawWindow() {
		this.setStyle("-fx-background-color: #22262f;");
        this.getStylesheets().add("stylesheet.css");
		Button playGame = new Button("");
		playGame.getStyleClass().remove(button);
		playGame.getStyleClass().addAll(mainbutton, "play-button");
		Button viewScoreboard = new Button("");
		viewScoreboard.getStyleClass().remove(button);
		viewScoreboard.getStyleClass().addAll(mainbutton, "scoreboard-button");
		Button settings  = new Button("");
		settings.getStyleClass().remove(button);
		settings.getStyleClass().addAll(mainbutton, "settings-button");
		Button tutorial = new Button("");
		tutorial.getStyleClass().remove(button);
		tutorial.getStyleClass().addAll(mainbutton, "tutorial-button");
		Label logo = new Label("");
		logo.getStyleClass().add("logo");
        Scene scene = new Scene(this, width, height);
        
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
        
        viewScoreboard.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even ) {
    			gc.changetoScene("Scoreboard");
    		}
    	});
        
        tutorial.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even ) {
    			gc.changetoScene("Tutorial");
    		}
    	});
        
        VBox logoBox = new VBox();
        HBox menuBox = new HBox();
        logoBox.setAlignment(Pos.TOP_CENTER);
        logoBox.getChildren().addAll(logo);
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setSpacing(10.0);
        menuBox.getChildren().addAll(playGame, viewScoreboard, settings, tutorial);
        this.getChildren().addAll(logoBox, menuBox);
        this.setAlignment(Pos.CENTER);
        return scene;
	}
}
