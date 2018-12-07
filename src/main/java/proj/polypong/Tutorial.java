package proj.polypong; 

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Tutorial extends Window {
	
	private static final Logger LOGGER =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
	
	public Tutorial() {
		super();
	}
	
	@Override
	public Scene drawWindow() {
		
		
		Scene scene = new Scene(this, width, height);
		Rectangle page = new Rectangle(width,height);
		scene.getStylesheets().add("stylesheet.css");
		this.setStyle("-fx-background-color: #22262f;");
		
		// back button
		Button back = new Button("X");
		back.getStyleClass().add("back-button");
        
        back.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			GameController.changetoScene("Menu");
    		}
    	});
        
        try {
			Image logoImage = new Image(new FileInputStream("images/tutorialPage.png"));
			page.setFill(new ImagePattern(logoImage));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			LOGGER.log(Level.WARNING,"file was not found - oh no");
		}
        
        StackPane.setAlignment(back, Pos.TOP_LEFT);
        VBox output = new VBox();
        StackPane.setAlignment(output, Pos.TOP_LEFT);
        output.getChildren().add(page);
        this.getChildren().addAll(output, back);
		
		return scene;
	}
	
}
