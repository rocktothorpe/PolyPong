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
	
	private GameController gc;
	private SettingsValues sv;
	
	public Settings(GameController gc, SettingsValues sv) {
		super();
		this.gc = gc;
		this.sv = sv;
	}
	
	@Override
	public Scene drawWindow() {
        Scene scene = new Scene(this, width, height);
        scene.getStylesheets().add("stylesheet.css");
		this.setStyle("-fx-background-color: #22262f;");
		String buttonStyle = "custom-button";
		String labelStyle = "settings-label";
		
		windowTitle = new Label("SETTINGS");
		
		// game mode controls
		HBox modeBox = new HBox();
		Button multiPlayer = new Button("PLAYER VS PLAYER");
		Button singlePlayer = new Button("PLAYER VS MACHINE");
		multiPlayer.getStyleClass().add(buttonStyle);
		singlePlayer.getStyleClass().add(buttonStyle);
		Label mode = new Label("Mode: ");
		mode.getStyleClass().add(labelStyle);
		modeBox.getChildren().addAll(mode, multiPlayer, singlePlayer);
		modeBox.setAlignment(Pos.CENTER);
		modeBox.setSpacing(10.0);
		
		// paddle controls
		HBox paddleBox = new HBox();
		Button small = new Button("SMALL");
		Button medium = new Button("MEDIUM");
		Button large = new Button("LARGE");
		small.getStyleClass().add(buttonStyle);
		medium.getStyleClass().add(buttonStyle);
		large.getStyleClass().add(buttonStyle);
		Label paddleSize = new Label("Paddle Size: ");
		paddleSize.getStyleClass().add(labelStyle);
		paddleBox.getChildren().addAll(paddleSize, small, medium, large);
		paddleBox.setAlignment(Pos.CENTER);
		paddleBox.setSpacing(10.0);
		
		// ball speed controls
		HBox ballSpeedBox = new HBox();
		Button slowSpeed = new Button("SLOW");
		Button mediumSpeed = new Button("MEDIUM");
		Button fastSpeed = new Button("FAST");
		slowSpeed.getStyleClass().add(buttonStyle);
		mediumSpeed.getStyleClass().add(buttonStyle);
		fastSpeed.getStyleClass().add(buttonStyle);
		Label ballSpeed = new Label("Ball Speed: ");
		ballSpeed.getStyleClass().add(labelStyle);
		ballSpeedBox.getChildren().addAll(ballSpeed, slowSpeed, mediumSpeed, fastSpeed);
		ballSpeedBox.setAlignment(Pos.CENTER);
		ballSpeedBox.setSpacing(10.0);
		
		// ball image controls
		HBox ballImageBox = new HBox();
		//ballImageBox.getStyleClass().add("settings-box");
		Button falessi = new Button("");
		Button mammen = new Button("");
		falessi.getStyleClass().add("falessi-button");
		mammen.getStyleClass().add("mammen-button");
		Label ballImage = new Label("Ball Image: ");
		ballImage.getStyleClass().add(labelStyle);
		ballImageBox.getChildren().addAll(ballImage, falessi, mammen);
		ballImageBox.setAlignment(Pos.CENTER);
		ballImageBox.setSpacing(10.0);
	
		falessi.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBallImage("falessi");
    		}
    	});
		
		mammen.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBallImage("mammen");
    		}
    	});
		
		// adding all controls to a vbox
		VBox menuBox = new VBox();
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setSpacing(10.0);
        menuBox.getChildren().addAll(modeBox, paddleBox, ballSpeedBox, ballImageBox);
        
		// back button
		Button back = new Button("X");
		back.getStyleClass().add("back-button");
        
        back.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			gc.changetoScene("Menu");
    		}
    	});
        
        // trash code to get this barely working
        small.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setPaddleSize("small");
    		}
    	});
		
        medium.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setPaddleSize("medium");
    		}
    	});
		
		large.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setPaddleSize("large");
    		}
    	});
		
        StackPane.setAlignment(back, Pos.TOP_LEFT);
        StackPane.setAlignment(windowTitle, Pos.TOP_CENTER);
        StackPane.setAlignment(menuBox, Pos.CENTER);
        this.getChildren().addAll(menuBox, back);
        return scene;
	}
}
