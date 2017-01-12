
 
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy extends GamePiece{
	private EnemyType shape;
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;

	public Enemy(double x, double y, int left, int right, int top, int bottom, EnemyType shape) {
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

	public void draw(Graphics g) {
		switch(shape){
		case WEAK:{
			g.drawImage(image2.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case MEDIUM:{
			g.drawImage(image1.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case STRONG:{
			g.drawImage(image3.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		}

	}

	public void animateOneStep() {
	}



}
