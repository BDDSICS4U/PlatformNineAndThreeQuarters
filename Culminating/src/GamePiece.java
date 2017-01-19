import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

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
		setXSpeed(0);
		setXSpeed(0);
		setColor(Color.black);
		setX(x);
		setY(y);
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
			if (x >= right | x <= left)
				xSpeed *= -1;
			if (y >= bottom | y <= top)
				ySpeed *= -1;
			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
			}
		}
	}

	abstract public void draw(BufferedImage image);

	abstract public void animateOneStep();

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setXSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	public void setYSpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double getYSpeed(){
		return this.ySpeed;
	}
	
	public double getXSpeed(){
		return this.xSpeed;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
