package proj.polypong;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Settings extends Window {
	
	public Settings() {
		super();
	}
	
	@Override
	public Scene drawWindow() {
        Scene scene = new Scene(this, width, height);
        scene.getStylesheets().add("stylesheet.css");
		this.setStyle("-fx-background-color: #22262f;");
		
		windowTitle = new Label("SETTINGS");
		
		// game mode controls
		HBox modeBox = new HBox();
		Button multiPlayer = new Button("PLAYER VS PLAYER");
		Button singlePlayer = new Button("PLAYER VS MACHINE");
		multiPlayer.getStyleClass().add("custom-button");
		singlePlayer.getStyleClass().add("custom-button");
		Label mode = new Label("Mode: ");
		modeBox.getChildren().addAll(mode, multiPlayer, singlePlayer);
		modeBox.setAlignment(Pos.CENTER);
		modeBox.setSpacing(10.0);
		
		// paddle controls
		HBox paddleBox = new HBox();
		Button small = new Button("SMALL");
		Button medium = new Button("MEDIUM");
		Button large = new Button("LARGE");
		small.getStyleClass().add("custom-button");
		medium.getStyleClass().add("custom-button");
		large.getStyleClass().add("custom-button");
		Label paddleSize = new Label("Paddle Size: ");
		paddleBox.getChildren().addAll(paddleSize, small, medium, large);
		paddleBox.setAlignment(Pos.CENTER);
		paddleBox.setSpacing(10.0);
		
		// ball speed controls
		HBox ballSpeedBox = new HBox();
		Button slowSpeed = new Button("SLOW");
		Button mediumSpeed = new Button("MEDIUM");
		Button fastSpeed = new Button("FAST");
		slowSpeed.getStyleClass().add("custom-button");
		mediumSpeed.getStyleClass().add("custom-button");
		fastSpeed.getStyleClass().add("custom-button");
		Label ballSpeed = new Label("Ball Speed: ");
		ballSpeedBox.getChildren().addAll(ballSpeed, slowSpeed, mediumSpeed, fastSpeed);
		ballSpeedBox.setAlignment(Pos.CENTER);
		ballSpeedBox.setSpacing(10.0);
		
		// ball image controls
		Label ballImage = new Label("Ball Image: ");
		
		// adding all controls to a vbox
		VBox menuBox = new VBox();
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setSpacing(10.0);
        menuBox.getChildren().addAll(modeBox, paddleBox, ballSpeedBox, ballImage);
        
		// back button
		Button back = new Button("X");
		back.getStyleClass().add("back-button");
        
        back.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even ) {
    			new GameController().changetoScene("Menu");
    		}
    	});
        
        StackPane.setAlignment(back, Pos.TOP_LEFT);
        StackPane.setAlignment(windowTitle, Pos.TOP_CENTER);
        StackPane.setAlignment(menuBox, Pos.CENTER);
        this.getChildren().addAll(back, menuBox);
        return scene;
	}
}
