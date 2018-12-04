package proj.polypong; 

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Tutorial extends Window {
	
	private GameController gc;
	
	
	
	class ScoreComparator implements Comparator<Score> {
	    public int compare(Score o1, Score o2) {
	        return o2.scoreVal.compareTo(o1.scoreVal);
	    }
	}
	
	
	public Tutorial(GameController gc) {
		super();
		this.gc = gc;
	}
	
	@Override
	public Scene drawWindow() {
		
		
		Scene scene = new Scene(this, width, height);
		scene.getStylesheets().add("stylesheet.css");
		this.setStyle("-fx-background-color: #22262f;");
		String labelStyle = "tutorial-label";
		
		// back button
		Button back = new Button("X");
		back.getStyleClass().add("back-button");
        
        back.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			gc.changetoScene("Menu");
    		}
    	});
        
        StackPane.setAlignment(back, Pos.TOP_LEFT);
        
        VBox output = new VBox();
        Label objective = new Label("objective: hit the ball past your opponent's paddle");
        Label controls = new Label("use W, S, Up arrow, Down arrow to move your paddle");
        Label morecontrols = new Label("\tP - play game/ pause game\n" + "\tR - replay/reset game");
        objective.setTextFill(Color.WHITE);
        objective.getStyleClass().add(labelStyle);
        controls.setTextFill(Color.WHITE);
        controls.getStyleClass().add(labelStyle);
        morecontrols.setTextFill(Color.WHITE);
        morecontrols.getStyleClass().add(labelStyle);
        output.setAlignment(Pos.CENTER);
        output.getChildren().addAll(objective,controls,morecontrols);
        this.getChildren().addAll(output, back);
		
		return scene;
	}
	
}
