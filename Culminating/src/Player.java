/**
 * Player.java
 * @version 2017/01/24
 * @author Daniel Nucci
 * @author Stuart Dietrich
 * @author Brendan Russell
 */

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends GamePiece {
	public static int scoreP1 = 0;
	public static int scoreP2 = 0;
	public boolean visible = true;
	private int hp, coins;
	private boolean displayed;
	private PlayerType shape;
	private BufferedImage image1;
	private BufferedImage image2;
	public static int bonusP1 = 0;
	public static int bonusP2 = 0;
	
	/**
	 * Player constructor
	 * 
	 * @param x
	 * 			double - the x value
	 * @param y
	 * 			double - the y value
	 * @param left
	 * 			int - the left side x parameter of the screen 
	 * @param right
	 * 			int - the right side x parameter of the screen
	 * @param top
	 * 			int - the top side y parameter of the screen
	 * @param bottom
	 * 			int - the top side y parameter of the screen
	 * @param shape
	 * 			PlayerType - the enum for what player number it is
	 */
	public Player(double x, double y, int left, int right, int top, int bottom, PlayerType shape) {
		super(x, y, left, right, top, bottom);
		try {
			P1Character choice = MainGame.p1Char;
			switch(choice){
			case PIG:{
				image1 = ImageIO.read(new File("src/Pictures/Pig.jpg"));
				break;
			}
			case LION:{
				image1 = ImageIO.read(new File("src/Pictures/Lion.jpg"));
				break;
			}
			case SHARK:{
				System.out.println("shark");
				image1 = ImageIO.read(new File("src/Pictures/Shark.png"));
				break;
			}
			case PENGUIN:{
				image1 = ImageIO.read(new File("src/Pictures/Penguin.png"));
				break;
			}
			}}
		catch (IOException ex) {
			System.out.println("No Images");
		}

		try {
			P2Character choice = MainGame.p2Char;
			switch(choice){
			case PIG:{
				System.out.println("pig");
				image2 = ImageIO.read(new File("src/Pictures/Pig.jpg"));
				break;
			}
			case LION:{
				image2 = ImageIO.read(new File("src/Pictures/Lion.jpg"));
				break;
			}
			case SHARK:{
				image2 = ImageIO.read(new File("src/Pictures/Shark.png"));
				break;
			}
			case PENGUIN:{
				image2 = ImageIO.read(new File("src/Pictures/Penguin.png"));
				break;
			}

			} 
		}catch (IOException ex) {
			System.out.println("No Images");
		}

		this.shape = shape;
		setHP(3);
		this.coins = 0;
	}

	/**
	 * This method draws the current player
	 * 
	 * @param g 
	 * 				Graphics - The graphics object that needs to be passed through
	 */
	public void draw(Graphics g) {
		switch (shape) {
		case PLAYER1: {
			if(visible){
				if(MainGame.currentLevel != Level.LEVEL4){
					try {
						P1Character choice = MainGame.p1Char;
						switch(choice){
						case PIG:{
							image1 = ImageIO.read(new File("src/resources/Pig.png"));
							break;
						}
						case LION:{
							image1 = ImageIO.read(new File("src/resources/Lion.png"));
							break;
						}
						case SHARK:{
							System.out.println("shark");
							image1 = ImageIO.read(new File("src/resources/Shark.png"));
							break;
						}
						case PENGUIN:{
							image1 = ImageIO.read(new File("src/resources/Penguin.png"));
							break;
						}
						}}
					catch (IOException ex) {
						System.out.println("No Images");
					}
					scoreP1 = (MainGame.winsP1 * 500) + (bonusP1);
					g.drawImage(image1, (int) getX(), (int) getY(), 100,100, null);
					g.drawImage(image1, 1790, 10, 50,50,null);
					g.setFont(new Font("SansSerif",Font.BOLD,25));
					g.drawString(scoreP1+"", 1850, 45);

				}
			
			if(MainGame.currentLevel == Level.LEVEL4){
				try {
					P1Character choice = MainGame.p1Char;
					switch(choice){
					case PIG:{
						image1 = ImageIO.read(new File("src/resources/Pig.png"));
						break;
					}
					case LION:{
						image1 = ImageIO.read(new File("src/resources/Lion.png"));
						break;
					}
					case SHARK:{
						System.out.println("shark");
						image1 = ImageIO.read(new File("src/resources/Shark.png"));
						break;
					}
					case PENGUIN:{
						image1 = ImageIO.read(new File("src/resources/Penguin.png"));
						break;
					}
					}}
				catch (IOException ex) {
					System.out.println("No Images");
				}
				scoreP1 = (MainGame.winsP1 * 500) + (bonusP1);
				g.drawImage(image1, (int) getX(), (int) getY(), 100,100, null);
				g.setFont(new Font("SansSerif",Font.BOLD,100));
				g.drawString("Winner ", 700, 300);
			}
			}
			break;
		}
		case PLAYER2: {
			if(visible){
				if(MainGame.currentLevel != Level.LEVEL4){
					try {
						P2Character choice = MainGame.p2Char;
						switch(choice){
						case PIG:{
							System.out.println("pig");
							image2 = ImageIO.read(new File("src/resources/Pig.png"));
							break;
						}
						case LION:{
							image2 = ImageIO.read(new File("src/resources/Lion.png"));
							break;
						}
						case SHARK:{
							image2 = ImageIO.read(new File("src/resources/Shark.png"));
							break;
						}
						case PENGUIN:{
							image2 = ImageIO.read(new File("src/resources/Penguin.png"));
							break;
						}


						} 
					}catch (IOException ex) {
						System.out.println("No Images");
					}
					scoreP2 = (MainGame.winsP2 * 500) + (bonusP2);
					g.drawImage(image2, (int) getX(), (int) getY(), 100,100, null);
					g.drawImage(image2, 1790, 70, 50,50,null);
					g.setFont(new Font("SansSerif",Font.BOLD,25));
					g.drawString(scoreP2+"", 1850, 100);

				}
			
			if(MainGame.currentLevel == Level.LEVEL4){
				try {
					P2Character choice = MainGame.p2Char;
					switch(choice){
					case PIG:{
						System.out.println("pig");
						image2 = ImageIO.read(new File("src/resources/Pig.png"));
						break;
					}
					case LION:{
						image2 = ImageIO.read(new File("src/resources/Lion.png"));
						break;
					}
					case SHARK:{
						image2 = ImageIO.read(new File("src/resources/Shark.png"));
						break;
					}
					case PENGUIN:{
						image2 = ImageIO.read(new File("src/resources/Penguin.png"));
						break;
					}


					} 
				}catch (IOException ex) {
					System.out.println("No Images");
				}
				scoreP2 = (MainGame.winsP2 * 500) + (bonusP2);
				g.drawImage(image2, (int) getX(), (int) getY(), 100,100, null);
				g.setFont(new Font("SansSerif",Font.BOLD,100));
				g.drawString("Winner ", 700, 300);
			}
			}
			break;
		}
		}

	}

	/**
	 * This method sets visibility
	 * 
	 * @param visible
	 * 					boolean - the visibility
	 */
	public void setVisibility(boolean visible){
		this.displayed = visible;
	}

	/**
	 * Blank Method
	 */
	public void animateOneStep() {
	}

	/**
	 * Sets the player HP
	 * 
	 * @param hp
	 * 			int - the HP to set
	 */
	public void setHP(int hp) {
		this.hp = hp;
	}

	/**
	 * Gets the player HP
	 * 
	 * @return hp
	 * 			int - the HP
	 */
	public int getHP() {
		return this.hp;
	}

	/**
	 * Sets the coins to a value
	 * 
	 * @param coin
	 * 			int - the number of coins 	
	 */
	public void setCoins(int coin){
		this.coins = coin;
	}
	
	/**
	 * Adds a number of coins to the current number of coins
	 * 
	 * @param coin
	 * 			int - the number of coins you want to add
	 */
	public void addCoins(int coin){
		this.coins+=coin;
	}

	/**
	 * Spawn a player in a location on the JFrame
	 * 
	 * @param x	
	 * 			int - the x value
	 * @param y
	 * 			int - the y vallue
	 */
	public void spawnPlayer(int x, int y) {
		setXSpeed(0);
		setYSpeed(0);
		setX(x);
		setY(y);
	}


}
