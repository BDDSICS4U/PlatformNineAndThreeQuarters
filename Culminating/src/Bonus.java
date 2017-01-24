

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
 
public class Bonus extends GamePiece{
	private BonusType shape;
	private Image image1;
	private int image1Height = 50;
	private int	image1Width = 50;
	private Image image2;
	private int image2Height = 50;
	private int	image2Width = 50;
	public Bonus(double x, double y, int left, int right, int top, int bottom, BonusType shape) {
		super(x, y, left, right, top, bottom);
		this.shape = shape;
		try {                
			image1 = ImageIO.read(new File("src/resources/Coin.png"));
			image2 = ImageIO.read(new File("src/resources/Life.png"));

		} catch (IOException ex) {
			System.out.println("No Images");
		}
	}

	public void draw(Graphics g) {
		switch(shape){
		case POINT:{
			g.drawImage(image1, (int) getX(), (int) getY(), 100, 100, null);
			//g.drawImage(image2.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case LIFE:{
			g.drawImage(image2, (int) getX(), (int) getY(), image2Height, image2Width, null);
			//g.drawImage(image1.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		}

	}

	public void animateOneStep() {
	}



}
