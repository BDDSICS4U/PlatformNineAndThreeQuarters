
 
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
@SuppressWarnings("unused")
public class Enemy extends GamePiece{
	private EnemyType type;
	private EnemyPicture shape;
	private Image enemyLion;
	private Image enemyPig;
	private Image enemyPenguin;
	private Image enemyShark;

	public Enemy(double x, double y, int left, int right, int top, int bottom, EnemyType type, EnemyPicture shape) {
		super(x, y, left, right, top, bottom);
		this.type = type;
		this.shape = shape;
		try {                
			enemyLion = ImageIO.read(new File("src/Pictures/EnemyLion.jpg"));
			enemyPig = ImageIO.read(new File("src/Pictures/EnemyPig.jpg"));
			enemyPenguin = ImageIO.read(new File("src/Pictures/EnemyPenguin.jpg"));
			enemyShark = ImageIO.read(new File("src/Pictures/EnemyShark.jpg"));


		} catch (IOException ex) {
			System.out.println("No Images");
		}
	}

	public void draw(Graphics g) {
		switch(shape){
		case LION:{
			g.drawImage(enemyLion, (int) getX(), (int) getY(), 30, 30, null);
			//g.drawImage(enemyPig.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case PIG:{
			g.drawImage(enemyPig, (int) getX(), (int) getY(), 100, 100, null);
			//g.drawImage(enemyLion.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case PENGUIN:{
			g.drawImage(enemyPenguin, (int) getX(), (int) getY(), 30, 30, null);
			//g.drawImage(enemyPenguin.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case SHARK:{
			g.drawImage(enemyShark, (int) getX(), (int) getY(), 30, 30, null);
			break;
		}
		}

	}

	public void animateOneStep() {
	}



}
