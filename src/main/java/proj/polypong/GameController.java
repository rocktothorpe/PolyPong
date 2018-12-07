package proj.polypong;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameController extends Application {
	
	public static final Color BACKGROUNDCOLOR = Color.rgb(29, 32, 44);
	public static final String GAMETITLE = "PolyPong";
	public static Stage theStage;
    private static GameController single_instance = null; 
	

	public static GameController getGC() 
    { 
        if (single_instance == null) 
            single_instance = new GameController(); 
  
        return single_instance; 
    } 
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle(GAMETITLE);
    	// Instantiate setting values
    	SettingsValues.getInstance();
    	theStage = stage;
    	changetoScene("Menu");
    }
    
    public void changetoScene(String scene) {
    	if (scene == "Game") {
    		Window game = new Game();
    		Scene gameScene = game.drawWindow();
    		theStage.setScene(gameScene);
    	} else if (scene == "Menu") {
    		Window menu = new Menu();
    		Scene menuScene = menu.drawWindow();
    		theStage.setScene(menuScene);
		} else if (scene == "Settings") {
			Window settings = new Settings();
			Scene settingsScene = settings.drawWindow();
			theStage.setScene(settingsScene);
		} else if (scene == "Scoreboard") {
			Window scoreboard = new Scoreboard();
			Scene scoreboardScene = scoreboard.drawWindow();
			theStage.setScene(scoreboardScene);
		} else if (scene == "NewScore") {
			Window newScore = new NewScore();
			Scene newScoreScene = newScore.drawWindow();
			theStage.setScene(newScoreScene);
		} else if(scene == "Tutorial") {
			Window tutorial = new Tutorial();
			Scene tutorialScene = tutorial.drawWindow();
			theStage.setScene(tutorialScene);
		}
		theStage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
