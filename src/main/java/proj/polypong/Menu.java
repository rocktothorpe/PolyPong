package proj.polypong;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.*;
import java.util.logging.*;

public class Menu extends  Window {
	
	private GameController gc;
	private static final Logger LOGGER =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
	public Menu(GameController gc) {
		super();
		this.gc = gc;
	}

	@Override
	public Scene drawWindow() {
		this.setStyle("-fx-background-color: #002000;");
		Button playGame = new Button("Play Game");
		Button viewScoreboard = new Button("Scoreboard");
		Button settings  = new Button("Settings");
		Rectangle logo = new Rectangle(400,200);
		try {
			Image logoImage = new Image(new FileInputStream("images/Logo.png"));
			logo.setFill(new ImagePattern(logoImage));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			LOGGER.log(Level.WARNING,"file was not found - oh no");
		}
		
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
        
        viewScoreboard.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even ) {
    			gc.changetoScene("Scoreboard");
    		}
    	});
        VBox logoBox = new VBox();
        VBox menuBox = new VBox();
        logoBox.setAlignment(Pos.TOP_CENTER);
        logoBox.getChildren().addAll(logo);
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setSpacing(10.0);
        menuBox.getChildren().addAll(playGame, viewScoreboard, settings);
        this.getChildren().addAll(logoBox, menuBox);
        this.setAlignment(Pos.CENTER);
        return scene;
	}
}
