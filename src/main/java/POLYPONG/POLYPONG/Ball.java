package POLYPONG.POLYPONG;
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
	}
	
	public boolean hitLeftWall() {
		return this.getLayoutX() <= this.getRadius() * 2;
	}
	
	public boolean hitRightWall(double gameWidth) {
		return this.getLayoutX() >= gameWidth - this.getRadius() * 2;
	}
}
