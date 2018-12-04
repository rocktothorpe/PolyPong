package proj.polypong;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameController extends Application {
	
	public static final Color BACKGROUNDCOLOR = Color.rgb(29, 32, 44);
	public static final String GAMETITLE = "PolyPong";
	public static Stage theStage;
	public static SettingsValues sv;
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle(GAMETITLE);
    	staticValues(stage);
    	changetoScene("Menu");
    }
    
    private static void staticValues(Stage stage)
    {
    	sv = new SettingsValues();
    	theStage = stage;
    }
    
    public void changetoScene(String scene) {
    	if (scene == "Game") {
    		Window game = new Game(this, sv);
    		Scene gameScene = game.drawWindow();
    		theStage.setScene(gameScene);
    	} else if (scene == "Menu") {
    		Window menu = new Menu(this);
    		Scene menuScene = menu.drawWindow();
    		theStage.setScene(menuScene);
		} else if (scene == "Settings") {
			Window settings = new Settings(this, sv);
			Scene settingsScene = settings.drawWindow();
			theStage.setScene(settingsScene);
		} else if (scene == "Scoreboard") {
			Window scoreboard = new Scoreboard(this);
			Scene scoreboardScene = scoreboard.drawWindow();
			theStage.setScene(scoreboardScene);
		} else if (scene == "NewScore") {
			Window newScore = new NewScore(this);
			Scene newScoreScene = newScore.drawWindow();
			theStage.setScene(newScoreScene);
		} else if(scene == "Tutorial") {
			Window tutorial = new Tutorial(this);
			Scene tutorialScene = tutorial.drawWindow();
			theStage.setScene(tutorialScene);
		}
		theStage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
