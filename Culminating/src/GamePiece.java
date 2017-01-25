/**
 * GamePiece.java
 * @version 2017/01/24
 * @author Daniel Nucci
 * @author Stuart Dietrich
 * @author Brendan Russell
 */

import java.awt.Color;
import java.awt.Graphics;

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

	/**
	 * GamePiece constructor
	 * 
	 * @param x
	 * 			double - the x value
	 * @param y
	 * 			double - the y value
	 * @param left
	 * 			int - the left side x parameter of the screen 
	 * @param right
	 * 			int - the right side x parameter of the screen
	 * @param top
	 * 			int - the top side y parameter of the screen
	 * @param bottom
	 * 			int - the top side y parameter of the screen
	 * @param shape
	 * 			PlayerType - the enum for what player number it is
	 */
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

	/**
	 * Start the thread
	 */
	public void startThread() {
		moving = true;
		Thread t = new Thread(this);
		t.start();
	}

	/**
	 * Stop the thread
	 */
	public void stopThread() {
		moving = false;
	}

	/**
	 * run one frame of the gamepiece
	 */
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

	/**
	 * used to draw a game piece
	 */
	abstract public void draw(Graphics g);

	/**
	 * used to animate one step
	 */
	abstract public void animateOneStep();

	/**
	 * Get the x coordinate of the current game piece
	 * 
	 * @return x
	 * 			int - the x value
	 */
	public double getX() {
		return x;
	}

	/**
	 * Get the y coordinate of the current game piece
	 * 
	 * @return y
	 * 			int - the y value
	 */
	public double getY() {
		return y;
	}

	/**
	 * Get the current x speed
	 * 	
	 * @return xSpeed
	 * 			double - the x speed
	 */
	public double getXSpeed(){
		return xSpeed;
	}
	
	/**
	 * Get the current y speed
	 * 	
	 * @return ySpeed
	 * 			double - the y speed
	 */
	public double getYSpeed(){
		return ySpeed;
	}
	
	/**
	 * Set the current x speed
	 * 
	 * @param xSpeed
	 * 			double - the x speed you want to change to
	 */
	public void setXSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	/**
	 * Set the current y speed
	 * 
	 * @param ySpeed
	 * 			double - the y speed you want to change to
	 */
	public void setYSpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}

	/**
	 * set the current x value
	 * 	
	 * @param x
	 * 			int - the x value you want to change to
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * set the current x value
	 * 	
	 * @param x
	 * 			int - the x value you want to change to
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * set the current colour 
	 * 
	 * @param color
	 * 			Color - the colour you want to change to
	 */
	public void setColor(Color color) {
		this.color = color;
	}
}
