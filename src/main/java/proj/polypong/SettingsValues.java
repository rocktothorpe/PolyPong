package proj.polypong;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;

public class SettingsValues {
	public Image ballImage;
	
	public SettingsValues() {
		// set image
		try {
			ballImage = new Image(new FileInputStream("images/mammenhead.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("file was not found - oh no");
		}
	}
}
