package proj.polypong;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Menu extends  Window {
	private static final String BUTTON = "BUTTON";
	private static final String MAINBUTTON = "mainmenu-button";
	
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
		playGame.getStyleClass().remove(BUTTON);
		playGame.getStyleClass().addAll(MAINBUTTON, "play-button");
		Button viewScoreboard = new Button("");
		viewScoreboard.getStyleClass().remove(BUTTON);
		viewScoreboard.getStyleClass().addAll(MAINBUTTON, "scoreboard-button");
		Button settings  = new Button("");
		settings.getStyleClass().remove(BUTTON);
		settings.getStyleClass().addAll(MAINBUTTON, "settings-button");
		Button tutorial = new Button("");
		tutorial.getStyleClass().remove(BUTTON);
		tutorial.getStyleClass().addAll(MAINBUTTON, "tutorial-button");
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
