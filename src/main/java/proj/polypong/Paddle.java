package proj.polypong;
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
			this.setY(this.getY() + 2);
		}
	}
	public void slideUp(double statusBarHeight) {
		if (this.getY() > statusBarHeight) {
			this.setY(this.getY() - 2);
		}
	}
	public boolean ballCollides(Ball ball) {
		
		double ballMin = ball.localToScreen(ball.getBoundsInLocal()).getMinY();
		double ballMax = ball.localToScreen(ball.getBoundsInLocal()).getMaxY();
		
		double paddleMin = this.localToScreen(this.getBoundsInLocal()).getMinY();
		double paddleMax = this.localToScreen(this.getBoundsInLocal()).getMaxY();
		
		return !(ballMin > paddleMax || ballMax < paddleMin);
	}
}
