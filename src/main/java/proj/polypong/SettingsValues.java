package proj.polypong;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;

public class SettingsValues {
	public Image ballImage;
	public String gameMode = "singlePlayer";
	public String paddleSize;
	public String ballSpeed;
	public String backgroundColor;
	public String curhead;
	public String[] headValues = {"falessi", "mammen", "gharibyan", "lupo", "staley", "clements", "eckhardt"};
	private int headPos = 1;
	private static final String COLOR1 = "color1";
	private static final String COLOR2 = "color2";
	private static final String COLOR3 = "color3";
	private static final String SMALL = "small";
	private static final String MEDIUM = "medium";
	private static final String LARGE = "large";
	private static final String SLOW = "slow";
	private static final String FAST = "fast";
    private static SettingsValues singleInstance = null; 
	
	private SettingsValues() {
		paddleSize = SMALL;
		ballSpeed = MEDIUM;
		backgroundColor = COLOR1;
		setBallImage("falessi");
	}
	
	public static SettingsValues getInstance() 
    { 
        if (singleInstance == null) 
            singleInstance = new SettingsValues(); 
  
        return singleInstance; 
    } 
	
	public void setBallImage(String head) {

		curhead = head;
		if (head == "mixed") {
			headPos = 1;
			try {
				ballImage = new Image(new FileInputStream("images/falessihead.png"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return;
		}
		
		try {
			ballImage = new Image(new FileInputStream("images/" + head + "head.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Image nextBallImage() throws FileNotFoundException {
		Image result;	
		result = new Image(new FileInputStream("images/" + headValues[headPos] + "head.png"));
		headPos++;
		
		if (headPos == headValues.length - 1) {
			headPos = 0;
		}
		return result;
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
			case SLOW:
				return -1.05; 
			case MEDIUM:
				return -1.2;
			case FAST:
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

	public String getBackgroundColorS() {
		return backgroundColor;
	}
	
	public String getBackgroundColor() {
		switch(backgroundColor)
		{
			case COLOR1:
				return "#336967"; 
			case COLOR2:
				return "#3E4F74";
			case COLOR3:
				return "#5C6B8B";
			default:
				return "#826FC4";	
		}
	}
}
