import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public abstract class GamePiece implements Runnable {
 
	private double x;
	private double y;
	private double xSpeed;
	private double ySpeed;
	private int left;
	private int right;
	private int top;
	private int bottom;
	private int pauseDuration;
	protected Color color;
	private boolean moving;

	public GamePiece(double x, double y, int left, int right, int top, int bottom) {
		this.pauseDuration = 40;
		this.xSpeed = 0;
		this.ySpeed = 0;
		this.color = Color.black;
		this.x = x;
		this.y = y;
		this.left = left;
		this.right = right;
		this.top = top;
		this.bottom = bottom;
		startThread();
	}

	public void startThread() {
		moving = true;
		Thread t = new Thread(this);
		t.start();
	}

	public void stopThread() {
		moving = false;
	}

	public void run() {
		while (moving) {
			animateOneStep();
			x += xSpeed;
			y += ySpeed;
			if (x > right || x < left){
				if (x > right){
					x = right - 101;
				}
				else if (x < left){
					x = left + 101;
				}
				xSpeed *= -1;
			}
			if (y >= bottom || y <= top){
				ySpeed *= -1;
			}
			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
			}
		}
	}

	abstract public void draw(Graphics g);

	abstract public void animateOneStep();

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getXSpeed(){
		return xSpeed;
	}
	public double getYSpeed(){
		return ySpeed;
	}
	public void setXSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	public void setYSpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
