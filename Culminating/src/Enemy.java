
 
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy extends GamePiece{
	private EnemyType shape;
	private Image image1;
	private Image image2;
	private Image image3;
	private Image image4;

	public Enemy(double x, double y, int left, int right, int top, int bottom, EnemyType shape) {
		super(x, y, left, right, top, bottom);
		this.shape = shape;
		try {                
			image1 = ImageIO.read(new File("src/resources/EnemyPig.png"));
			image2 = ImageIO.read(new File("src/resources/EnemyLion.png"));
			image3 = ImageIO.read(new File("src/resources/EnemyShark.png"));
			image4 = ImageIO.read(new File("src/resources/EnemyPenguin.png"));


		} catch (IOException ex) {
			System.out.println("No Images");
		}
	}

	public void draw(Graphics g) {
		switch(shape){
		case WEAK:{
			g.drawImage(image1, (int) getX(), (int) getY(), 100, 100, null);
			//g.drawImage(image2.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case MEDIUM:{
			g.drawImage(image2, (int) getX(), (int) getY(), 100, 100, null);
			//g.drawImage(image1.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case STRONG:{
			g.drawImage(image3, (int) getX(), (int) getY(), 100, 100, null);
			//g.drawImage(image3.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case BOSS:{
			g.drawImage(image4, (int) getX(), (int) getY(), 100, 100, null);
		}
		}

	}

	public void animateOneStep() {
	}



}
