package proj.polypong;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Settings extends Window {
	
	private GameController gc;
	private SettingsValues sv;
	private static final String TOGGLEBTNSTYLE = "custom-button";
	private static final String LABELSTYLE = "settings-label";
	private static final String RADIOBUTTON = "radio-button";
	private static final String MEDIUM = "MEDIUM";
	private static final String COLOR1 = "color1";
	private static final String COLOR2 = "color2";
	private static final String COLOR3 = "color3";
	private static final String FALESSI = "falessi";
	private static final String GHARIBYAN = "gharibyan";
	private static final String CLEMENTS = "clements";
	private static final String ECKHARDT = "eckhardt";
	private static final String STALEY = "staley";
	private static final String LUPO = "lupo";
	private static final String MAMMEN = "mammen";
	private static final String MIXED = "mixed";
	
	public Settings(GameController gc) {
		super();
		this.gc = gc;
		this.sv = SettingsValues.getInstance();
	}
	
	private HBox genModeBox() {
		// game mode controls
		HBox modeBox = new HBox();
		RadioButton multiPlayer = new RadioButton("PLAYER VS MACHINE");
		RadioButton singlePlayer = new RadioButton("PLAYER VS PLAYER");

		// add to a toggle group
		ToggleGroup paddleGroup = new ToggleGroup();
		multiPlayer.setToggleGroup(paddleGroup);
		singlePlayer.setToggleGroup(paddleGroup);

		// add button style
		multiPlayer.getStyleClass().remove(RADIOBUTTON);
		singlePlayer.getStyleClass().remove(RADIOBUTTON);
		multiPlayer.getStyleClass().add(TOGGLEBTNSTYLE);
		singlePlayer.getStyleClass().add(TOGGLEBTNSTYLE);
		
		Label mode = new Label("Mode: ");
		mode.getStyleClass().add(LABELSTYLE);
		
		// add to box and format
		modeBox.getChildren().addAll(mode, singlePlayer, multiPlayer);
		modeBox.setAlignment(Pos.CENTER);
		modeBox.setSpacing(10.0);
		
		// decision tree for current setting
		if (sv.gameMode == "multiPlayer") {
			multiPlayer.setSelected(true);
		}
		else if (sv.gameMode == "singlePlayer") {
			singlePlayer.setSelected(true);
		}

        // button actions
		return modeBox;
	}
	
	private HBox genPaddleBox() {
		// paddle controls
		HBox paddleBox = new HBox();
		RadioButton small = new RadioButton("SMALL");
		RadioButton medium = new RadioButton(MEDIUM);
		RadioButton large = new RadioButton("LARGE");
		
		// add to a toggle group
		ToggleGroup paddleGroup = new ToggleGroup();
		small.setToggleGroup(paddleGroup);
		medium.setToggleGroup(paddleGroup);
		large.setToggleGroup(paddleGroup);
		
		// add button style
		small.getStyleClass().remove(RADIOBUTTON);
		medium.getStyleClass().remove(RADIOBUTTON);
		large.getStyleClass().remove(RADIOBUTTON);
		small.getStyleClass().add(TOGGLEBTNSTYLE);
		medium.getStyleClass().add(TOGGLEBTNSTYLE);
		large.getStyleClass().add(TOGGLEBTNSTYLE);
		
		Label paddleSize = new Label("Paddle Size: ");
		paddleSize.getStyleClass().add(LABELSTYLE);
		
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
    			sv.setPaddleSize(MEDIUM);
    		}
    	});
		
		large.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setPaddleSize("large");
    		}
    	});


		// decision tree for current setting
		if (sv.paddleSize == "small") {
			small.setSelected(true);
		}
		else if (sv.paddleSize == MEDIUM) {
			medium.setSelected(true);
		}
		else if (sv.paddleSize == "large") {
			large.setSelected(true);
		}
		
		return paddleBox;
	}
	
	private HBox genBallSpeedBox() {
		// ball speed controls
		HBox ballSpeedBox = new HBox();
		RadioButton slowSpeed = new RadioButton("SLOW");
		RadioButton mediumSpeed = new RadioButton(MEDIUM);
		RadioButton fastSpeed = new RadioButton("FAST");
		
		// add to a toggle group
		ToggleGroup paddleGroup = new ToggleGroup();
		slowSpeed.setToggleGroup(paddleGroup);
		mediumSpeed.setToggleGroup(paddleGroup);
		fastSpeed.setToggleGroup(paddleGroup);

		// add button style
		slowSpeed.getStyleClass().remove(RADIOBUTTON);
		mediumSpeed.getStyleClass().remove(RADIOBUTTON);
		fastSpeed.getStyleClass().remove(RADIOBUTTON);
		slowSpeed.getStyleClass().add(TOGGLEBTNSTYLE);
		mediumSpeed.getStyleClass().add(TOGGLEBTNSTYLE);
		fastSpeed.getStyleClass().add(TOGGLEBTNSTYLE);

		Label ballSpeed = new Label("Ball Speed: ");
		ballSpeed.getStyleClass().add(LABELSTYLE);
		
		// add to box and format
		ballSpeedBox.getChildren().addAll(ballSpeed, slowSpeed, mediumSpeed, fastSpeed);
		ballSpeedBox.setAlignment(Pos.CENTER);
		ballSpeedBox.setSpacing(10.0);
		
        // button actions
        slowSpeed.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBallSpeed("slow");
    		}
    	});
		
        mediumSpeed.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBallSpeed(MEDIUM);
    		}
    	});
		
		fastSpeed.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBallSpeed("fast");
    		}
    	});
		
		// decision tree for current setting
		if (sv.ballSpeed == "slow") {
			slowSpeed.setSelected(true);
		}
		else if (sv.ballSpeed == "medium") {
			mediumSpeed.setSelected(true);
		}
		else if (sv.ballSpeed == "fast") {
			fastSpeed.setSelected(true);
		}
		
		return ballSpeedBox;
	}

	private HBox genBackroungColorBox() {
		String colorBtnStyle = "color-button";
		// ball speed controls
		HBox backgroundBox = new HBox();
		RadioButton color1 = new RadioButton("");
		RadioButton color2 = new RadioButton("");
		RadioButton color3 = new RadioButton("");
		
		// add to a toggle group
		ToggleGroup ballSpeedGroup = new ToggleGroup();
		color1.setToggleGroup(ballSpeedGroup);
		color2.setToggleGroup(ballSpeedGroup);
		color3.setToggleGroup(ballSpeedGroup);

		// add button style
		color1.getStyleClass().remove(RADIOBUTTON);
		color2.getStyleClass().remove(RADIOBUTTON);
		color3.getStyleClass().remove(RADIOBUTTON);
		color1.getStyleClass().addAll(colorBtnStyle, COLOR1);
		color2.getStyleClass().addAll(colorBtnStyle, COLOR2);
		color3.getStyleClass().addAll(colorBtnStyle, COLOR3);

		Label ballSpeed = new Label("Background Color: ");
		ballSpeed.getStyleClass().add(LABELSTYLE);
		
		// add to box and format
		backgroundBox.getChildren().addAll(ballSpeed, color1, color2, color3);
		backgroundBox.setAlignment(Pos.CENTER);
		backgroundBox.setSpacing(10.0);
		
        // button actions
        color1.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBackgroundColor(COLOR1);
    		}
    	});
		
        color2.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBackgroundColor(COLOR2);
    		}
    	});
		
		color3.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBackgroundColor(COLOR3);
    		}
    	});
				
		// decision tree for current setting
		if (sv.backgroundColor == COLOR1) {
			color1.setSelected(true);
		}
		else if (sv.backgroundColor == COLOR2) {
			color2.setSelected(true);
		}
		else if (sv.backgroundColor == COLOR3) {
			color3.setSelected(true);
		}
		return backgroundBox;
	}

	private HBox genBallImageBox() {
		String imageBtnStyle = "image-button";

		// ball image controls
		HBox ballImageBox = new HBox();
		RadioButton falessi = new RadioButton("");
		RadioButton mammen = new RadioButton("");
		RadioButton gharibyan = new RadioButton("");
		RadioButton lupo = new RadioButton("");
		RadioButton staley = new RadioButton("");
		RadioButton clements = new RadioButton("");
		RadioButton eckhardt = new RadioButton("");
		RadioButton mixed = new RadioButton("");
		
		// add to a toggle group
		ToggleGroup ballImageGroup = new ToggleGroup();
		falessi.setToggleGroup(ballImageGroup);
		mammen.setToggleGroup(ballImageGroup);
		gharibyan.setToggleGroup(ballImageGroup);
		lupo.setToggleGroup(ballImageGroup);
		staley.setToggleGroup(ballImageGroup);
		clements.setToggleGroup(ballImageGroup);
		eckhardt.setToggleGroup(ballImageGroup);
		mixed.setToggleGroup(ballImageGroup);
		
		// add button style
		falessi.getStyleClass().remove(RADIOBUTTON);
		mammen.getStyleClass().remove(RADIOBUTTON);
		gharibyan.getStyleClass().remove(RADIOBUTTON);
		lupo.getStyleClass().remove(RADIOBUTTON);
		staley.getStyleClass().remove(RADIOBUTTON);
		clements.getStyleClass().remove(RADIOBUTTON);
		eckhardt.getStyleClass().remove(RADIOBUTTON);
		mixed.getStyleClass().remove(RADIOBUTTON);
		falessi.getStyleClass().addAll(imageBtnStyle, FALESSI);
		mammen.getStyleClass().addAll(imageBtnStyle, MAMMEN);
		gharibyan.getStyleClass().addAll(imageBtnStyle, GHARIBYAN);
		lupo.getStyleClass().addAll(imageBtnStyle, LUPO);
		staley.getStyleClass().addAll(imageBtnStyle, STALEY);
		clements.getStyleClass().addAll(imageBtnStyle, CLEMENTS);
		eckhardt.getStyleClass().addAll(imageBtnStyle, ECKHARDT);
		mixed.getStyleClass().addAll(imageBtnStyle, MIXED);
		
		Label ballImage = new Label("Ball Image: ");
		ballImage.getStyleClass().add(LABELSTYLE);

		// add to box and format		
		ballImageBox.getChildren().addAll(ballImage, falessi, mammen, gharibyan, eckhardt, lupo, staley, clements, mixed);
		ballImageBox.setAlignment(Pos.CENTER);
		ballImageBox.setSpacing(10.0);
	
        // button actions
		falessi.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBallImage(FALESSI);
    		}
    	});
		
		mammen.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBallImage(MAMMEN);
    		}
    	});

		gharibyan.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBallImage(GHARIBYAN);
    		}
    	});
    	
    	lupo.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBallImage(LUPO);
    		}
    	});
		
		staley.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBallImage(STALEY);
    		}
    	});
		
		clements.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBallImage(CLEMENTS);
    		}
    	});

		eckhardt.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBallImage(ECKHARDT);
    		}
    	});
		
		mixed.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			sv.setBallImage(MIXED);
    		}
    	});
		
		// decision tree for current setting
		if (sv.curhead == FALESSI) {
			falessi.setSelected(true);
		}
		else if (sv.curhead == GHARIBYAN) {
			gharibyan.setSelected(true);
		}
		else if (sv.curhead == CLEMENTS) {
			clements.setSelected(true);
		}
		else if (sv.curhead == ECKHARDT) {
			eckhardt.setSelected(true);
		}
		else if (sv.curhead == STALEY) {
			staley.setSelected(true);
		}
		else if (sv.curhead == LUPO) {
			lupo.setSelected(true);
		}
		else if (sv.curhead == MAMMEN) {
			mammen.setSelected(true);
		}
		else if (sv.curhead == MIXED) {
			mixed.setSelected(true);
		}

		return ballImageBox;
	}
	
	@Override
	public Scene drawWindow() {

        Scene scene = new Scene(this, width, height);
        scene.getStylesheets().add("stylesheet.css");
		this.setStyle("-fx-background-color: #22262f;");
		
		Label settingsLabel = new Label("");
		settingsLabel.getStyleClass().add("settings-heading");
		
		// generate horizontal boxes
		HBox modeBox = genModeBox();
		HBox paddleBox = genPaddleBox();
		HBox ballSpeedBox = genBallSpeedBox();
		HBox ballImageBox = genBallImageBox();
		HBox backgroundBox = genBackroungColorBox();
		
		// adding all controls to a vertical box
		VBox menuBox = new VBox();
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setSpacing(15.0);
        menuBox.getChildren().addAll(modeBox, paddleBox, ballSpeedBox, ballImageBox, backgroundBox);
        
		// back button
		Button back = new Button("X");
		back.getStyleClass().add("back-button");
        
        back.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent even) {
    			gc.changetoScene("Menu");
    		}
    	});
		
        StackPane.setAlignment(back, Pos.TOP_LEFT);
        StackPane.setAlignment(settingsLabel, Pos.TOP_CENTER);
        StackPane.setAlignment(menuBox, Pos.CENTER);
        this.getChildren().addAll(settingsLabel, menuBox, back);
        return scene;
	}
}
