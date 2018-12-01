package proj.polypong;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Settings extends Window {
	
	private GameController gc;
	private SettingsValues sv;
	private String toggleBtnStyle = "custom-button";
	private String labelStyle = "settings-label";
	
	public Settings(GameController gc, SettingsValues sv) {
		super();
		this.gc = gc;
		this.sv = sv;
	}
	
	private HBox genModeBox() {
		// game mode controls
		HBox modeBox = new HBox();
		Button multiPlayer = new Button("PLAYER VS PLAYER");
		Button singlePlayer = new Button("PLAYER VS MACHINE");
		multiPlayer.getStyleClass().add(toggleBtnStyle);
		singlePlayer.getStyleClass().add(toggleBtnStyle);
		Label mode = new Label("Mode: ");
		mode.getStyleClass().add(labelStyle);
		modeBox.getChildren().addAll(mode, multiPlayer, singlePlayer);
		modeBox.setAlignment(Pos.CENTER);
		modeBox.setSpacing(10.0);
		
		return modeBox;
	}
	
	private HBox genPaddleBox() {
		// paddle controls
		HBox paddleBox = new HBox();
		ToggleButton small = new ToggleButton("SMALL");
		ToggleButton medium = new ToggleButton("MEDIUM");
		ToggleButton large = new ToggleButton("LARGE");
		
		// add to a toggle group
		ToggleGroup paddleGroup = new ToggleGroup();
		small.setToggleGroup(paddleGroup);
		medium.setToggleGroup(paddleGroup);
		large.setToggleGroup(paddleGroup);
		
		// add button style
		small.getStyleClass().add(toggleBtnStyle);
		medium.getStyleClass().add(toggleBtnStyle);
		large.getStyleClass().add(toggleBtnStyle);
		
		Label paddleSize = new Label("Paddle Size: ");
		paddleSize.getStyleClass().add(labelStyle);
		
		// add to box and format
		paddleBox.getChildren().addAll(paddleSize, small, medium, large);
		paddleBox.setAlignment(Pos.CENTER);
		paddleBox.setSpacing(10.0);
		
        // button actions
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
		
		return paddleBox;
	}
	
	private HBox genBallSpeedBox() {
		// ball speed controls
		HBox ballSpeedBox = new HBox();
		Button slowSpeed = new Button("SLOW");
		Button mediumSpeed = new Button("MEDIUM");
		Button fastSpeed = new Button("FAST");
		slowSpeed.getStyleClass().add(toggleBtnStyle);
		mediumSpeed.getStyleClass().add(toggleBtnStyle);
		fastSpeed.getStyleClass().add(toggleBtnStyle);
		Label ballSpeed = new Label("Ball Speed: ");
		ballSpeed.getStyleClass().add(labelStyle);
		ballSpeedBox.getChildren().addAll(ballSpeed, slowSpeed, mediumSpeed, fastSpeed);
		ballSpeedBox.setAlignment(Pos.CENTER);
		ballSpeedBox.setSpacing(10.0);
		
		return ballSpeedBox;
	}
	
	private HBox genBallImageBox() {
		String imageBtnStyle = "image-button";

		// ball image controls
		HBox ballImageBox = new HBox();
		ToggleButton falessi = new ToggleButton("");
		ToggleButton mammen = new ToggleButton("");
		ToggleButton gharibyan = new ToggleButton("");
		ToggleButton lupo = new ToggleButton("");
		ToggleButton staley = new ToggleButton("");
		ToggleButton clements = new ToggleButton("");
		ToggleButton eckhardt = new ToggleButton("");
		
		// add to a toggle group
		ToggleGroup ballImageGroup = new ToggleGroup();
		falessi.setToggleGroup(ballImageGroup);
		mammen.setToggleGroup(ballImageGroup);
		gharibyan.setToggleGroup(ballImageGroup);
		lupo.setToggleGroup(ballImageGroup);
		staley.setToggleGroup(ballImageGroup);
		clements.setToggleGroup(ballImageGroup);
		eckhardt.setToggleGroup(ballImageGroup);
		
		// add button style
		falessi.getStyleClass().addAll(imageBtnStyle, "falessi");
		mammen.getStyleClass().addAll(imageBtnStyle, "mammen");
		gharibyan.getStyleClass().addAll(imageBtnStyle, "gharibyan");
		lupo.getStyleClass().addAll(imageBtnStyle, "lupo");
		staley.getStyleClass().addAll(imageBtnStyle, "staley");
		clements.getStyleClass().addAll(imageBtnStyle, "clements");
		eckhardt.getStyleClass().addAll(imageBtnStyle, "eckhardt");
		
		Label ballImage = new Label("Ball Image: ");
		ballImage.getStyleClass().add(labelStyle);

		// add to box and format		
		ballImageBox.getChildren().addAll(ballImage, falessi, mammen, gharibyan, eckhardt, lupo, staley, clements);
		ballImageBox.setAlignment(Pos.CENTER);
		ballImageBox.setSpacing(10.0);
	
        // button actions
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

		gharibyan.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBallImage("gharibyan");
    		}
    	});
    	
    	lupo.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBallImage("lupo");
    		}
    	});
		
		staley.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBallImage("staley");
    		}
    	});
		
		clements.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBallImage("clements");
    		}
    	});

		eckhardt.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBallImage("eckhardt");
    		}
    	});
		
		return ballImageBox;
	}
	
	@Override
	public Scene drawWindow() {

        Scene scene = new Scene(this, width, height);
        scene.getStylesheets().add("stylesheet.css");
		this.setStyle("-fx-background-color: #22262f;");
		
		windowTitle = new Label("SETTINGS");
		
		// generate horizontal boxes
		HBox modeBox = genModeBox();
		HBox paddleBox = genPaddleBox();
		HBox ballSpeedBox = genBallSpeedBox();
		HBox ballImageBox = genBallImageBox();
		
		// adding all controls to a vertical box
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
		
        StackPane.setAlignment(back, Pos.TOP_LEFT);
        StackPane.setAlignment(windowTitle, Pos.TOP_CENTER);
        StackPane.setAlignment(menuBox, Pos.CENTER);
        this.getChildren().addAll(menuBox, back);
        return scene;
	}
}
