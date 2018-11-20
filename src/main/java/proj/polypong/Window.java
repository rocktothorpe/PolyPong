package proj.polypong;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Window extends StackPane{
	public Label windowTitle;
	public double height = 500.0;
	public double width = 900.0;
	public static final Color backgroundcolor = Color.rgb(0, 0, 0);

	public Scene drawWindow() {
		Scene scene = new Scene(this, width, height);
		return scene;
	}
	
	public static String toRGBCode( Color color )
    {
        return String.format( "#%02X%02X%02X",
            (int)( color.getRed() * 255 ),
            (int)( color.getGreen() * 255 ),
            (int)( color.getBlue() * 255 ) );
    }
}
