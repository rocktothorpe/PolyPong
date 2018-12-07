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

public class Scoreboard extends Window {

	class ScoreComparator implements Comparator<Score> {
	    public int compare(Score o1, Score o2) {
	        return o2.scoreVal.compareTo(o1.scoreVal);
	    }
	}
	
	
	public Scoreboard() {
		super();
	}
	
	@Override
	public Scene drawWindow() {
		 List<Score> scores = Score.getScores("scores.txt");
		Comparator<Score> comparator = new ScoreComparator();
		Collections.sort(scores, comparator);
		
		Scene scene = new Scene(this, width, height);
		scene.getStylesheets().add("stylesheet.css");
		this.setStyle("-fx-background-color: #22262f;");
		String labelStyle = "scoreboard-label";
		
		// back button
		Button back = new Button("X");
		back.getStyleClass().add("back-button");
        
        back.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			GameController.changetoScene("Menu");
    		}
    	});
        
        StackPane.setAlignment(back, Pos.TOP_LEFT);
        
        VBox allScores = new VBox();
        allScores.setSpacing(10.0);
        Label scoresTitle = new Label("Scoreboard");
        scoresTitle.setTextFill(Color.WHITE);
        scoresTitle.getStyleClass().add(labelStyle);
        allScores.setAlignment(Pos.CENTER);
        allScores.getChildren().add(scoresTitle);
        
        for (int i = 0; i < scores.size(); i++) {
        	HBox scoresBox = new HBox();
        	scoresBox.setSpacing(20);
            scoresBox.setAlignment(Pos.CENTER);
            Label name = new Label(scores.get(i).name);
            name.getStyleClass().add(labelStyle);
            name.setTextFill(Color.WHITE);
            name.setMinWidth(200);
            name.setAlignment(Pos.CENTER_RIGHT);
            
            Label score = new Label("" + scores.get(i).scoreVal);
            score.getStyleClass().add(labelStyle);
            score.setMinWidth(200);
            score.setAlignment(Pos.CENTER_LEFT);
            score.setTextFill(Color.WHITE);
            
            scoresBox.getChildren().addAll(name, score);
            allScores.getChildren().add(scoresBox);
        }        
        
        this.getChildren().addAll(allScores, back);
		
		return scene;
	}
	
}
