package proj.polypong;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;

public class SettingsValues {
	public Image ballImage;
	public String paddleSize;
	
	public SettingsValues() {
		paddleSize = "small";
		setBallImage("falessi");
	}
	
	public void setBallImage(String head) {
		try {
			if (head == "mammen") {
				ballImage = new Image(new FileInputStream("images/mammenhead.png"));
			}
			else if (head == "falessi") {
				ballImage = new Image(new FileInputStream("images/falessihead.png"));
			}
			else if (head == "gharibyan") {
				ballImage = new Image(new FileInputStream("images/gharibyeanhead.png"));
			}
			else if (head == "lupo") {
				ballImage = new Image(new FileInputStream("images/lupohead.png"));
			}
			else if (head == "staley") {
				ballImage = new Image(new FileInputStream("images/staleyhead.png"));
			}
			else if (head == "clements") {
				ballImage = new Image(new FileInputStream("images/clementshead.png"));
			}
			else if (head == "eckhardt") {
				ballImage = new Image(new FileInputStream("images/eckhardthead.png"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void setPaddleSize(String size) {
		if (size == "small" || size == "medium" || size == "large") {
			paddleSize = size;
		}
	}
	
	public double getPaddleSize() {
		
		if (paddleSize == "small") {
			return 50.0; 
		}
		
		if (paddleSize == "medium") {
			return 75.0;
		}
		
		return 100.0;
	}
}
