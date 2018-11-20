package proj.polypong;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameController extends Application {
	
	public static final Color BACKGROUNDCOLOR = Color.rgb(29, 32, 44);
	public static final String GAMETITLE = "PolyPong";
	public static Stage theStage;
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle(GAMETITLE);
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
		}
		theStage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
