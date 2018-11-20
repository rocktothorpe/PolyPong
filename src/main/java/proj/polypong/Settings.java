package proj.polypong;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Settings extends Window {
	
	@Override
	public Scene drawWindow() {
		this.setStyle("-fx-background-color: "+ toRGBCode(backgroundcolor)+";");
		
		windowTitle = new Label("SETTINGS");
		
		// game mode controls
		HBox modeBox = new HBox();
		Button multiPlayer = new Button("Player vs Player");
		Button singlePlayer = new Button("Player vs Machine");
		Label mode = new Label("Mode: ");
		modeBox.getChildren().addAll(mode, multiPlayer, singlePlayer);
		modeBox.setAlignment(Pos.CENTER);
		modeBox.setSpacing(10.0);
		
		// paddle controls
		HBox paddleBox = new HBox();
		Button small = new Button("Small");
		Button medium = new Button("Medium");
		Button large = new Button("Large");
		Label paddleSize = new Label("Paddle Size: ");
		paddleBox.getChildren().addAll(paddleSize, small, medium, large);
		paddleBox.setAlignment(Pos.CENTER);
		paddleBox.setSpacing(10.0);
		
		// ball speed controls
		HBox ballSpeedBox = new HBox();
		Button slowSpeed = new Button("Slow");
		Button mediumSpeed = new Button("Medium");
		Button fastSpeed = new Button("Fast");
		Label ballSpeed = new Label("Ball Speed: ");
		ballSpeedBox.getChildren().addAll(ballSpeed, slowSpeed, mediumSpeed, fastSpeed);
		ballSpeedBox.setAlignment(Pos.CENTER);
		ballSpeedBox.setSpacing(10.0);
		
		// ball image controls
		Label ballImage = new Label("Ball Image: ");
	
        Scene scene = new Scene(this, width, height);
        
//        playGame.setOnAction(new EventHandler<ActionEvent>() {
//    		public void handle(ActionEvent even ) {
//    			new GameController().changetoScene("Game");
//    		}
//    	});
        
        VBox menuBox = new VBox();
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setSpacing(10.0);
        menuBox.getChildren().addAll(windowTitle, modeBox, paddleBox, ballSpeedBox, ballImage);
        this.getChildren().addAll(menuBox);
        this.setAlignment(Pos.CENTER);
        return scene;
	}
}
