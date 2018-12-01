package proj.polypong;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;

public class SettingsValues {
	public Image ballImage;
	public String paddleSize;
	public String ballSpeed;
	public String backgroundColor;
	
	public SettingsValues() {
		paddleSize = "small";
		ballSpeed = "medium";
		backgroundColor = "color1";
		setBallImage("falessi");
	}
	
	public void setBallImage(String head) {
		try {
			switch(head)
			{
				case "mammen":
					ballImage = new Image(new FileInputStream("images/mammenhead.png"));
					break;
				case "falessi":
					ballImage = new Image(new FileInputStream("images/falessihead.png"));
					break;
				case "gharibyan":
					ballImage = new Image(new FileInputStream("images/gharibyeanhead.png"));
					break;
				case "lupo":
					ballImage = new Image(new FileInputStream("images/lupohead.png"));
					break;
				case "staley":
					ballImage = new Image(new FileInputStream("images/staleyhead.png"));
					break;
				case "clements":
					ballImage = new Image(new FileInputStream("images/clementshead.png"));
					break;
				case "eckhardt":
					ballImage = new Image(new FileInputStream("images/eckhardthead.png"));
					break;
				default:
					ballImage = new Image(new FileInputStream("images/falessihead.png"));
					break;
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
		switch(paddleSize)
		{
			case "small":
				return 50.0;
			case "medium":
				return 75.0;
			case "large":
				return 100.0;
			default:
				return 75.0;	
		}
	}

	public void setBallSpeed(String speed) {
		if (speed == "slow" || speed == "medium" || speed == "fast") {
			ballSpeed = speed;
		}
	}
	
	public double getBallSpeed() {
		switch(ballSpeed)
		{
			case "color1":
				return -1.05; 
			case "color2":
				return -1.2;
			case "color3":
				return -1.25;
			default:
				return -1.05;	
		}
	}

	public void setBackgroundColor(String color) {
		if (color == "color1" || color == "color2" || color == "color3") {
			backgroundColor = color;
		}
	}
	
	public String getBackgroundColor() {
		switch(backgroundColor)
		{
			case "color1":
				return "#80A4ED"; 
			case "color2":
				return "#395C6B";
			case "color3":
				return "#E01A4F";
			default:
				return "#0C090D";	
		}
	}
}
