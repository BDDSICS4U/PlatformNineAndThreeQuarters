/* ISC4U culminating game
 * A simple platforming game
 * @author: Brendan Russell, Dalton Firth, Daniel Nucci and Stuart Detrich
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * A type of GamePiece that adds score or lives, has different images and sounds
 * @author Dalton Firth
 *
 */
public class Bonus extends GamePiece{
	private BonusType shape;
	private BufferedImage image1;
	private BufferedImage image2;
	
	/**
	 * class that holds the dimensions of bonus
	 * @param x a double value that holds the x coordinate
	 * @param y a double value that holds the x coordinate
	 * @param left
	 * @param right
	 * @param top
	 * @param bottom
	 * @param shape
	 */
	public Bonus(double x, double y, int left, int right, int top, int bottom, BonusType shape) {
		super(x, y, left, right, top, bottom);
		this.shape = shape;
		try {                
			image1 = ImageIO.read(new File("Culminating/src/resources/gem-coin.png"));
			image2 = ImageIO.read(new File("Culminating/src/resources/1UP.jpg"));

		} catch (IOException ex) {
			System.out.println("No Images");
		}
	}

	/**
	 * draws the images of the bonus
	 */
	public void draw(Graphics g) {
		switch(shape){
		case POINT:{
			g.drawImage(image2.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case LIFE:{
			g.drawImage(image1.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		}

	}

	public void animateOneStep() {
	}

	/**
	 * plays sound upon pickup
	 */
	public void playSound(){
	}


}
