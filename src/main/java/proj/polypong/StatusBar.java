package proj.polypong;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class StatusBar extends HBox { 
	
	public StatusBar(double gameWidth, double statusBarHeight, GameController gc) {
		super ();
		this.setStyle("-fx-background-color: #22262f;");
		this.setPrefWidth(gameWidth);
		Button back = new Button("X");
		back.getStyleClass().add("back-button");
        
        back.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			gc.changetoScene("Menu");
    		}
    	});
		this.getChildren().addAll(back);
	}
	
}
