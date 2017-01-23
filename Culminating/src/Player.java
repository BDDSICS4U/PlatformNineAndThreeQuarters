
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends GamePiece {
	private int hp, coins;
	private boolean displayed;
	private PlayerType shape;
	private BufferedImage image1;
	private BufferedImage image2;
	

	public Player(double x, double y, int left, int right, int top, int bottom, PlayerType shape) {
		super(x, y, left, right, top, bottom);
		
		this.shape = shape;
		setHP(3);
		this.coins = 0;
		try {
			image1 = ImageIO.read(new File("src/Pictures/Pig.jpg"));
			image2 = ImageIO.read(new File("src/resources/Smiley.svg.png"));

		} catch (IOException ex) {
			System.out.println("No Images");
		}
	}

	public void draw(Graphics g) {
		switch (shape) {
		case PLAYER1: {
			
			g.drawImage(image1, (int) getX(), (int) getY(), 100,100, null);
			g.drawImage(image1, 1790, 10, 50,50,null);
			g.setFont(new Font("SansSerif",Font.BOLD,25));
			g.drawString(coins+"", 1850, 45);
			
			//g.drawImage(image1.getScaledInstance(50, 50, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			// g.drawImage(image1.getScaledInstance(20, 20,
			// Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case PLAYER2: {
			if(displayed){
				g.drawImage(image2, (int) getX(), (int) getY(), 200,200, null);
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
	
	public void setCoins(int coin){
		this.coins = coin;
	}
	public void addCoins(int coin){
		this.coins+=coin;
	}
	

}
