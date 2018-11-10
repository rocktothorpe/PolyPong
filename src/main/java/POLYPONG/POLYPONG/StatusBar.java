package POLYPONG.POLYPONG;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.EventHandler;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class StatusBar extends HBox {
	
	public StatusBar(double gameWidth, double statusBarHeight) {
		super ();
		this.setStyle("-fx-background-color: rgb(166, 161, 159);");
		this.setPrefWidth(gameWidth);
		
		final ImageView imv = new ImageView();
		imv.setX(50); 
		imv.setY(25); 
		imv.setFitHeight(50); 
		imv.setFitWidth(50); 
        Image image2 = null;
		try {
			image2 = new Image(new FileInputStream("pause.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		ColorAdjust colorAdjust = new ColorAdjust();
		colorAdjust.setBrightness(1.0);
		imv.setEffect(colorAdjust);
        imv.setImage(image2);
        
        imv.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Tile pressed ");
                event.consume();
            }
       });
		
		
		this.getChildren().addAll(imv);
	}
	
}
