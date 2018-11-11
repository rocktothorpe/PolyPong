package proj.polypong;
import javafx.application.Application;
import javafx.stage.Stage;

public class GameController extends Application {
	
	public static final double GAMEWIDTH = 900.0;
	public static final double GAMEHEIGHT = 500.0;
	public static final String GAMETITLE = "PolyPong";
    @Override
    public void start(Stage stage) {
    	    	
    	stage.setTitle(GAMETITLE);
    	
    	final Game game = new Game(GAMEWIDTH, GAMEHEIGHT);
    	game.runGame(stage);
    }
    
    public static void main(String[] args) {
        launch();
    }
}
