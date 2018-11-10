package POLYPONG.POLYPONG;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Paddle extends Rectangle {
	
	public boolean isLowering = false;
	public boolean isRaising = false;
	
	public Paddle(double x, double y, double width, double height, Color color) {
		super (x, y, width, height);
		this.setArcWidth(width); 
	    this.setArcHeight(width);  
	    this.setFill(color);
	}
	public void slideDown(double gameHeight) {
		if (this.getY() < gameHeight-this.getHeight()) {
			this.setY(this.getY() + 5);
		}
	}
	public void slideUp(double statusBarHeight) {
		if (this.getY() > statusBarHeight) {
			this.setY(this.getY() - 5);
		}
	}
	public boolean ballCollides(Ball ball) {
		return ball.getLayoutY() > this.getY() && ball.getLayoutY() < this.getY() + this.getHeight();
	}
}
