
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
@SuppressWarnings("unused")
public class Player extends GamePiece {
	private int hp;
	private boolean displayed;
	private PlayerType type;
	private PlayerPicture shape;
	private BufferedImage lionImage;
	private BufferedImage penguinImage;
	private BufferedImage pigImage;
	private BufferedImage sharkImage;
	

	public Player(double x, double y, int left, int right, int top, int bottom, PlayerType type, PlayerPicture shape) {
		super(x, y, left, right, top, bottom);
		this.setXSpeed((int) (Math.random() * 8));
		this.setYSpeed((int) (Math.random() * 8)); 
		this.type = type;
		this.shape = shape;
		this.displayed = true;
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
		case LION: {
			if(displayed){
				g.drawImage(lionImage, (int) getX(), (int) getY(), 200,200, null);
			}
			
			//g.drawImage(image1.getScaledInstance(50, 50, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			// g.drawImage(image1.getScaledInstance(20, 20,
			// Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case PENGUIN: {
			if(displayed){
				g.drawImage(penguinImage, (int) getX(), (int) getY(), 200,200, null);
			}
			// g.drawImage(image2.getScaledInstance(20, 20,
			// Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case PIG:{
			if(displayed){
				g.drawImage(pigImage, (int) getX(), (int) getY(), 200,200, null);
			}
			break;
		}
		case SHARK:{
			if(displayed){
				g.drawImage(sharkImage, (int) getX(), (int) getY(), 200,200, null);
			}
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
