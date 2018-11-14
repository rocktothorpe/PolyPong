package proj.polypong;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameController extends Application {
	
	public static final double GAMEWIDTH = 900.0;
	public static final double GAMEHEIGHT = 500.0;
	public static final Color BACKGROUNDCOLOR = Color.rgb(29, 32, 44);
	public static final String GAMETITLE = "PolyPong";
	public static Stage theStage;
	
    @Override
    public void start(Stage stage) {
    	    	
    	stage.setTitle(GAMETITLE);
    	theStage = stage;
    	final Menu menu = new Menu(GAMEWIDTH, GAMEHEIGHT, BACKGROUNDCOLOR, this);
    	menu.drawMainMenu(stage);
    	
    }
    
    public void changetoScene(String scene) {
    	if (scene == "Game") {
    		final Game game = new Game(GAMEWIDTH, GAMEHEIGHT, theStage);
	    	game.runGame();
    	}
    	
    }
    
    public static void main(String[] args) {
        launch();
    }
}
