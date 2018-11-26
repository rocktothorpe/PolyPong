package proj.polypong;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Ball extends Circle {
	double xVelocity = 2.0;
	double yVelocity = 0.5;
	
	public Ball(double radius, Paint fill, Image image) {
		super (radius, fill);
		this.setFill(new ImagePattern(image)); 
	}
	
	public boolean hitLeftWall() {
		return this.getLayoutX() <= this.getRadius();
	}
	
	public boolean hitRightWall(double gameWidth) {
		return this.getLayoutX() >= gameWidth - this.getRadius();
	}
}
