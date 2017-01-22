
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends GamePiece {
	private int hp;
	private boolean displayed;
	private PlayerType shape;
	private BufferedImage lionImage;
	private BufferedImage penguinImage;
	private BufferedImage pigImage;
	private BufferedImage sharkImage;
	

	public Player(double x, double y, int left, int right, int top, int bottom, PlayerType shape) {
		super(x, y, left, right, top, bottom);
		this.setXSpeed((int) (Math.random() * 8));
		this.setYSpeed((int) (Math.random() * 8)); 
		this.shape = shape;
		setHP(3);
		try {
			lionImage = ImageIO.read(new File("src/Pictures/Lion.jpg"));
			penguinImage = ImageIO.read(new File("src/Pictures/Penguin.png"));
			pigImage = ImageIO.read(new File("src/Pictures/Pig.jpg"));
			sharkImage = ImageIO.read(new File("src/Pictures/Shark.png"));

		} catch (IOException ex) {
			System.out.println("No Images");
		}
	}

	public void draw(Graphics g) {
		switch (shape) {
		case PLAYER1: {
			
			g.drawImage(lionImage, (int) getX(), (int) getY(), 200,200, null);
			
			//g.drawImage(image1.getScaledInstance(50, 50, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			// g.drawImage(image1.getScaledInstance(20, 20,
			// Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case PLAYER2: {
			if(displayed){
				g.drawImage(penguinImage, (int) getX(), (int) getY(), 200,200, null);
			}
			// g.drawImage(image2.getScaledInstance(20, 20,
			// Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		}

	}
	
	public void setVisibility(boolean visible){
		this.displayed = visible;
	}

	public void animateOneStep() {
	}

	public void setHP(int hp) {
		this.hp = hp;
	}

	public int getHP() {
		return this.hp;
	}

	

}
