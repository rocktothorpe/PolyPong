package proj.polypong;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Ball extends Circle {
	double xVelocity = 2.0;
	double yVelocity = 0.5;
	
	public Ball(double centerX, double centerY, double radius) {
		super (centerX, centerY, radius);
	}
	
	public Ball(double radius, Paint fill) {
		super (radius, fill);
		Image image;
		// set image
		try {
			image = new Image(new FileInputStream("images/mammenhead.png"));
			this.setFill(new ImagePattern(image));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("file was not found - oh no");
		} 
	}
	
	public boolean hitLeftWall() {
		return this.getLayoutX() <= this.getRadius() * 2;
	}
	
	public boolean hitRightWall(double gameWidth) {
		return this.getLayoutX() >= gameWidth - this.getRadius() * 2;
	}
}
