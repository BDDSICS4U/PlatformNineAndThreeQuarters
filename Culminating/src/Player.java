
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends GamePiece {
	private int hp, coins;
	private boolean displayed;
	private PlayerType shape;
	private BufferedImage image1;
	private BufferedImage image2;
	private int jumpTime, jumpTimeLeft;

	public Player(double x, double y, int left, int right, int top, int bottom, PlayerType shape) {
		super(x, y, left, right, top, bottom);
		setPlayerType(shape);
		setHP(3);
		setCoins(0);
		setVisability(true);
		try {
			image1 = ImageIO.read(new File("src/resources/Smiley.svg.png"));
			image2 = ImageIO.read(new File("src/resources/Smiley.svg.png"));

		} catch (IOException ex) {
			System.out.println("No Images");
		}
	}

	public void draw(Graphics g) {
		switch (shape) {
		case PLAYER1: {
			System.out.println("asdf");
			// image.getGraphics().drawImage(image1, (int) getX(), (int) getY(),
			// 30, 30, (ImageObserver) this);
			//g.drawImage(image1, this.getX(), this.getY(), (ImageObserver) this);
			break;
		}
		case PLAYER2: {
			// image.getGraphics().drawImage(image2, (int) getX(), (int) getY(),
			// 30, 30, null);
			// g.drawImage(image2.getScaledInstance(20, 20,
			// Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		}

	}

	public void animateOneStep() {
		// this.draw(image1);
	}

	private void setPlayerType(PlayerType shape) {
		this.shape = shape;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}

	public int getHP() {
		return this.hp;
	}

	public void setCoins(int coin) {
		this.coins = coin;
	}

	public int getCoins() {
		return this.coins;
	}

	public void setVisability(boolean state) {
		this.displayed = state;
	}

	public boolean getVisability() {
		return this.displayed;
	}

	public void jump() {
		if (jumpTime == 0) {
			this.setYSpeed(0.2);
		} else if (jumpTimeLeft <= 0.5){
			this.setYSpeed(this.getYSpeed() + 0.1);
		}
		else if (jumpTimeLeft <= 0.7){
			this.setYSpeed(this.getYSpeed() - 0.2);
		}
		else{
			this.setYSpeed(-0.5);
		}
	}

	@Override
	public void draw(BufferedImage image) {
		// TODO Auto-generated method stub

	}

}
