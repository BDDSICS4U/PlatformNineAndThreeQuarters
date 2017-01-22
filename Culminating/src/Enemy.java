
 
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy extends GamePiece{
	private EnemyType shape;
	private Image enemyLion;
	private Image enemyPig;
	private Image enemyPenguin;

	public Enemy(double x, double y, int left, int right, int top, int bottom, EnemyType shape) {
		super(x, y, left, right, top, bottom);
		this.shape = shape;
		try {                
			enemyLion = ImageIO.read(new File(""));
			enemyPig = ImageIO.read(new File(""));
			enemyPenguin = ImageIO.read(new File(""));


		} catch (IOException ex) {
			System.out.println("No Images");
		}
	}

	public void draw(Graphics g) {
		switch(shape){
		case WEAK:{
			g.drawImage(enemyLion, (int) getX(), (int) getY(), 30, 30, null);
			//g.drawImage(enemyPig.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case MEDIUM:{
			g.drawImage(enemyPig, (int) getX(), (int) getY(), 30, 30, null);
			//g.drawImage(enemyLion.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case STRONG:{
			g.drawImage(enemyPenguin, (int) getX(), (int) getY(), 30, 30, null);
			//g.drawImage(enemyPenguin.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		}

	}

	public void animateOneStep() {
	}



}
