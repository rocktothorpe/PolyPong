package proj.polypong;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;

public class SettingsValues {
	public Image ballImage;
	public String paddleSize;
	public String ballSpeed;
	public String backgroundColor;
	private final static String COLOR1 = "color1";
	private final static String COLOR2 = "color2";
	private final static String COLOR3 = "color3";
	private final static String SMALL = "small";
	private final static String MEDIUM = "medium";
	private final static String LARGE = "large";
	private final static String SLOW = "slow";
	private final static String FAST = "fast";
	
	public SettingsValues() {
		paddleSize = SMALL;
		ballSpeed = MEDIUM;
		backgroundColor = COLOR1;
		setBallImage("falessi");
	}
	
	public void setBallImage(String head) {
		try {
			ballImage = new Image(new FileInputStream("images/" + head + "head.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void setPaddleSize(String size) {
		if (size == SMALL|| size == MEDIUM || size == LARGE) {
			paddleSize = size;
		}
	}
	
	public double getPaddleSize() {	
		switch(paddleSize)
		{
			case SMALL:
				return 50.0;
			case MEDIUM:
				return 75.0;
			case LARGE:
				return 100.0;
			default:
				return 75.0;	
		}
	}

	public void setBallSpeed(String speed) {
		if (speed == SLOW || speed == MEDIUM || speed == FAST) {
			ballSpeed = speed;
		}
	}
	
	public double getBallSpeed() {
		switch(ballSpeed)
		{
			case COLOR1:
				return -1.05; 
			case COLOR2:
				return -1.2;
			case COLOR3:
				return -1.25;
			default:
				return -1.05;	
		}
	}

	public void setBackgroundColor(String color) {
		if (color == COLOR1 || color == COLOR2 || color == COLOR3) {
			backgroundColor = color;
		}
	}
	
	public String getBackgroundColor() {
		switch(backgroundColor)
		{
			case COLOR1:
				return "#80A4ED"; 
			case COLOR2:
				return "#395C6B";
			case COLOR3:
				return "#E01A4F";
			default:
				return "#0C090D";	
		}
	}
}
