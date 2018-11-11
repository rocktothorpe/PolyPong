package proj.polypong;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameController extends Application {
	
	public static final double GAMEWIDTH = 900.0;
	public static final double GAMEHEIGHT = 500.0;
	public static final Color BACKGROUNDCOLOR = Color.rgb(29, 32, 44);
	public static final String GAMETITLE = "PolyPong";
    @Override
    public void start(Stage stage) {
    	    	
    	stage.setTitle(GAMETITLE);
    	
    	final Menu menu = new Menu(GAMEWIDTH, GAMEHEIGHT, BACKGROUNDCOLOR);
    	
    	menu.drawMainMenu(stage);
    	
    }
    
    public static void main(String[] args) {
        launch();
    }
}
