package proj.polypong;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class NewScore extends Window {
	
	private GameController gc;
	
	private TextField usernameField;
	private Button saveScoreButton;
	
	public NewScore(GameController gc) {
		super();
		this.gc = gc;
	}
	
	private boolean validName(String input) {
		return !input.chars().allMatch(Character::isLetter);
	}
	
	@Override
	public Scene drawWindow() {
		this.getStylesheets().add("stylesheet.css");
        this.setStyle("-fx-background-color: #000000;");
        Scene scene = new Scene(this, width, height, Color.WHITE);
        
        VBox input = new VBox();
        input.setSpacing(10.0);
        input.setAlignment(Pos.CENTER);
        
        
        usernameField = new TextField();
        usernameField.setMaxWidth(120);
		usernameField.setLayoutY((height/2) - (usernameField.getHeight()/2));
		usernameField.setLayoutX((width/2) - (usernameField.getWidth()/2));
		usernameField.textProperty().addListener((observable, oldValue, newValue) -> {
		    if (validName(newValue)) {
		    	usernameField.setText(oldValue);
		    }
		    int length = usernameField.getText().length();
		    saveScoreButton.setDisable(!(length >= 3 && length <= 15));
		});
		
		EventHandler<ActionEvent> saveScore = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) { 
            	List<Score> scores = Score.getScores("scores.txt");
            	boolean exists = false;
            	for (int i = 0; i < scores.size(); i++) {
            		if (usernameField.getText().equals(scores.get(i).name)) {
            			scores.get(i).scoreVal++;
            			exists = true;
            		}
            	}
            	if (!exists) {
            		scores.add(new Score(usernameField.getText(), 1));
            	}
            	Score.writeToFile(scores, "scores.txt");
            	gc.changetoScene("Scoreboard");
            } 
        }; 
		
		saveScoreButton = new Button();
        saveScoreButton.getStyleClass().add("custom-button");
		saveScoreButton.setDisable(true);
		saveScoreButton.setText("Save");
		saveScoreButton.setLayoutY((height/2) - (usernameField.getHeight()/2) + 50);
		saveScoreButton.setLayoutX((width/2) - (saveScoreButton.getWidth()/2));
		saveScoreButton.setOnAction(saveScore); 
		
		input.getChildren().addAll(usernameField, saveScoreButton);
		this.getChildren().addAll(input);
        
        return scene;
    }
	
}
