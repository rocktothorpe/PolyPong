package proj.polypong;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

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
	
	private GameController gc;
	
	private Vector<Score> scores = new Vector<Score>();
	
	class ScoreComparator implements Comparator<Score> {
	    public int compare(Score o1, Score o2) {
	        return o2.score.compareTo(o1.score);
	    }
	}
	
	
	public Scoreboard(GameController gc) {
		super();
		this.gc = gc;
	}
	
	@Override
	public Scene drawWindow() {
		
		this.scores = Score.getScores();
		Comparator<Score> comparator = new ScoreComparator();
		Collections.sort(this.scores, comparator);
		
		Scene scene = new Scene(this, width, height);
		scene.getStylesheets().add("stylesheet.css");
		this.setStyle("-fx-background-color: #22262f;");
		String labelStyle = "scoreboard-label";
		
		// back button
		Button back = new Button("X");
		back.getStyleClass().add("back-button");
        
        back.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			gc.changetoScene("Menu");
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
        
        Color colors[] = new Color[]{Color.RED, Color.BLUE, Color.GREEN};
        for (int i = 0; i < this.scores.size(); i++) {
        	HBox scores = new HBox();
            scores.setAlignment(Pos.CENTER);
            Label name = new Label(this.scores.get(i).name);
            name.getStyleClass().add(labelStyle);
            name.setTextFill(Color.WHITE);
            Label spacer = new Label("      ");
            spacer.getStyleClass().add(labelStyle);
            Label score = new Label("" + this.scores.get(i).score);
            score.getStyleClass().add(labelStyle);
            score.setTextFill(Color.WHITE);
            
            scores.getChildren().addAll(name, spacer, score);
            allScores.getChildren().add(scores);
        }        
        
        this.getChildren().addAll(allScores, back);
		
		return scene;
	}
	
}
