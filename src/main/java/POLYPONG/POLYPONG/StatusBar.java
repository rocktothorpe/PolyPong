package POLYPONG.POLYPONG;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class StatusBar extends HBox {
	
	Rectangle bar;
	
	public StatusBar(double gameWidth, double statusBarHeight, Color color) {
		super ();
		bar = new Rectangle(0, 0, gameWidth, statusBarHeight);
		bar.setFill(color);
		
//		final ImageView imv = new ImageView();
//        final Image image2 = new Image("file:pause.png");
//        imv.setImage(image2);
		
		
		this.getChildren().add(bar);
	}
	
}
