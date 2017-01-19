/* ISC4U culminating game
 * A simple platforming game
 * @author: Brendan Russell, Dalton Firth, Daniel Nucci and Stuart Detrich
 */
 
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A type of GamePiece that the player stands on
 * @author Daniel Nucci
 *
 */
public class Platform extends GamePiece{
	private PlatformType shape;
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param left
	 * @param right
	 * @param top
	 * @param bottom
	 * @param shape
	 */
	public Platform(double x, double y, int left, int right, int top, int bottom, PlatformType shape) {
		super(x, y, left, right, top, bottom);
		this.shape = shape;
		try {                
			image1 = ImageIO.read(new File(""));
			image2 = ImageIO.read(new File(""));
			image3 = ImageIO.read(new File(""));


		} catch (IOException ex) {
			System.out.println("No Images");
		}
	}

	/**
	 * draws the image of the platform
	 */
	public void draw(Graphics g) {
		switch(shape){
		case SOLID:{
			g.drawImage(image2.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case MOVING:{
			g.drawImage(image1.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case BREAK:{
			g.drawImage(image3.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		}

	}

	public void animateOneStep() {
	}



}
