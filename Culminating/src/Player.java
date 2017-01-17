
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
			image1 = ImageIO.read(new File("src/resources/Smiley.svg.png"));
			image2 = ImageIO.read(new File("src/resources/Smiley.svg.png"));

		} catch (IOException ex) {
			System.out.println("No Images");
		}
	}

	public void draw(BufferedImage image) {
		switch (shape) {
		case PLAYER1: {
			System.out.println("asdf");
			image.getGraphics().drawImage(image1, (int) getX(), (int) getY(), 30, 30, null);
			// g.drawImage(image1.getScaledInstance(20, 20,
			// Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case PLAYER2: {
			image.getGraphics().drawImage(image2, (int) getX(), (int) getY(), 30, 30, null);
			// g.drawImage(image2.getScaledInstance(20, 20,
			// Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		}

	}

	public void animateOneStep() {
		this.draw(image1);
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

}
