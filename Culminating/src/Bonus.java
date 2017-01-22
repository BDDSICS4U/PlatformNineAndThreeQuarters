

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
 
public class Bonus extends GamePiece{
	private BonusType shape;
	private BufferedImage coinImage;
	private BufferedImage lifeImage;
	public Bonus(double x, double y, int left, int right, int top, int bottom, BonusType shape) {
		super(x, y, left, right, top, bottom);
		this.shape = shape;
		try {                
			coinImage = ImageIO.read(new File("src/Pictures/Life.png"));
			lifeImage = ImageIO.read(new File("src/Pictures/Life.jpg"));

		} catch (IOException ex) {
			System.out.println("No Images");
		}
	}

	public void draw(Graphics g) {
		switch(shape){
		case POINT:{
			g.drawImage(coinImage, (int) getX(), (int) getY(), 50, 50, null);
			//g.drawImage(image2.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case LIFE:{
			g.drawImage(lifeImage, (int) getX(), (int) getY(), 50, 50, null);
			//g.drawImage(image1.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		}

	}

	public void animateOneStep() {
	}



}
