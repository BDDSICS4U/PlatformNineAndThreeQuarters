/**
 * MainGame.java
 * @version 2017/01/24
 * @author Daniel Nucci
 * @author Stuart Dietrich
 * @author Brendan Russell
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class MainGame extends JPanel implements Runnable, KeyListener, MouseListener {
	//stores all the key codes for multiple key functionality
	HashMap<Integer, Boolean> keyMap = new HashMap<Integer, Boolean>();
	
	//sets the current level to the starting level
	public static Level currentLevel = Level.START;
	private boolean gameOver = false;
	private static int count = 0;
	
	//sets the size of the JFrame
	private static final int width = 1920;
	private static final int height = 990;
	private long pauseDuration = 30;
	public static int winsP1 = 0;
	public static int winsP2 = 0;
	
	//sets the default player characters
	public static Character p1Char = Character.PENGUIN;
	public static Character p2Char = Character.PIG;
	
	//make 2 new characters
	Player p1 = new Player(101, 790, 0, width, 0, height, PlayerType.PLAYER1);
	Player p2 = new Player(201, 790, 0, width, 0, height, PlayerType.PLAYER2);
	
	//make the arrays of assorted things
	public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public static ArrayList<Platform> platforms = new ArrayList<Platform>(0);
	public static ArrayList<Bonus> bonuses = new ArrayList<Bonus>(0);
	public static Platform end = new Platform(0, 0, 0, width, 0, height, PlatformType.END);
	public static PlayerSelect playerPick = new PlayerSelect(0, 0, 0, width, 0, height, null);
	public static double jumpYP1 = 0;
	public static double jumpYP2 = 0;
	public static int counter = 0;
	
	/**
	 * called at the startup of the game
	 * @throws InterruptedException 
	 */
	public void setup(){
		switch(currentLevel){
		case START:{
			counter++;
			platforms.clear();
			bonuses.clear();
			playerPick.visible = true;
			end.visible = false;

			//a square around the border of the frame
			for (int i = 0; i < 1900; i+= 100){
				makePlatform(i, 890);
				makePlatform(i, 0);
			}
			for (int i = 90; i < 800; i+= 100){
				makePlatform(0, i);
				makePlatform(1800, i);
			}

			//PlayerSelect playerPick = new PlayerSelect(0, 0, 0, width, 0, height, null);
			//set the player character
			repaint();
			while(true){
				//System.out.println("in");
				//System.out.println(mouseX);
				//System.out.println(mouseY);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				if(mouseX >= 120 && mouseX <= 420 && mouseY >= 300 && mouseY <= 600){
					p1Char = Character.PIG;
					//System.out.println("Click");
					break;
				}
				else if(mouseX >= 520 && mouseX <= 820 && mouseY >= 300 && mouseY <= 600){
					p1Char = Character.PENGUIN;
					//System.out.println("Click");
					break;
				}
				else if(mouseX >= 1100 && mouseX <= 1400 && mouseY >= 300 && mouseY <= 600){
					p1Char = Character.LION;
					//System.out.println("Click");
					break;
				}
				else if(mouseX >= 1500 && mouseX <= 1800 && mouseY >= 300 && mouseY <= 600){
					p1Char = Character.SHARK;
					//System.out.println("Click");
					break;
				}
			}
			while(true){
				//System.out.println("in");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				if(mouseX >= 120 && mouseX <= 420 && mouseY >= 300 && mouseY <= 600){
					if(p1Char != Character.PIG){
						p2Char = Character.PIG;
						//System.out.println("Click");
						break;}
				}
				else if(mouseX >= 520 && mouseX <= 820 && mouseY >= 300 && mouseY <= 600){
					if(p1Char != Character.PENGUIN){
						p2Char = Character.PENGUIN;
						//System.out.println("Click");
						break;}
				}
				else if(mouseX >= 1100 && mouseX <= 1400 && mouseY >= 300 && mouseY <= 600){
					if(p1Char != Character.LION){
						p2Char = Character.LION;
						//System.out.println("Click");
						break;}
				}
				else if(mouseX >= 1500 && mouseX <= 1800 && mouseY >= 300 && mouseY <= 600){
					if(p1Char != Character.SHARK){
						p2Char = Character.SHARK;
						//System.out.println("Click");
						break;}
				}
			}
			currentLevel = Level.LEVEL1;
			//System.out.println("Out");
			break;
		}
		case LEVEL1:{
			p1.setVisibility(true);
			p2.setVisibility(true);
			p2.visible = true;
			p1.visible = true;
			end.visible = true;
			playerPick.visible = false;
			p1.spawnPlayer(101, 790);
			p2.spawnPlayer(201, 790);
			platforms.clear();
			bonuses.clear();

			makeBasicStartingPosition();

			for(int i = 300; i <= 1000; i+=100){
				makePlatform(i, 690);
			}
			makePlatform(500, 490);
			for(int i = 800; i <= 1100; i+=100){
				makePlatform(i, 490);
			}
			makePlatform(1200, 290);
			makePlatform(1300, 290);

			for(int i=0; i<3; i++){
				Platform temp = platforms.get((int) (Math.random() * platforms.size()));
				while(temp.getX()<=100){
					temp = platforms.get((int) (Math.random() * platforms.size()));
				}
				enemies.add(new Enemy(temp.getX(), temp.getY() - 100, 0, width, 0, height, EnemyType.WEAK));
				if(didPlayerCollideEnemy(p1)||didPlayerCollideEnemy(p2)||(!isPlatformNextLeft(enemies.get(enemies.size()-1))||!isPlatformNextRight(enemies.get(enemies.size()-1)))){
					enemies.remove(enemies.size()-1);
					i--;
				}

			}


			end.setX(1800);
			end.setY(290);

			bonuses.add(new Bonus(1000, 590, 0, width, 0, height, BonusType.POINT));
			bonuses.add(new Bonus(200, 0, 0, width, 0, height, BonusType.POINT));
			bonuses.add(new Bonus(1700, 490, 0, width, 0, height, BonusType.POINT));

			break;
		}
		case LEVEL2:{
			//c.setBackground(Color.BLACK);
			p1.spawnPlayer(101, 790);
			p2.spawnPlayer(201, 790);
			platforms.clear();
			bonuses.clear();
			enemies.clear();

			makeBasicStartingPosition();

			makePlatform(300, 590);
			makePlatform(400, 590);
			makePlatform(700, 390);
			makePlatform(1500, 590);

			for(int i=0; i<3; i++){
				Platform temp = platforms.get((int) (Math.random() * platforms.size()));
				while(temp.getX()<=100){
					temp = platforms.get((int) (Math.random() * platforms.size()));
				}
				enemies.add(new Enemy(temp.getX(), temp.getY() - 100, 0, width, 0, height, EnemyType.WEAK));
				if(didPlayerCollideEnemy(p1)||didPlayerCollideEnemy(p2)||(!isPlatformNextLeft(enemies.get(enemies.size()-1))||!isPlatformNextRight(enemies.get(enemies.size()-1)))){
					enemies.remove(enemies.size()-1);
					i--;
				}	
			}

			end.setX(1800);
			end.setY(390);
			bonuses.add(new Bonus(1000, 590, 0, width, 0, height, BonusType.POINT));
			bonuses.add(new Bonus(200, 0, 0, width, 0, height, BonusType.POINT));
			bonuses.add(new Bonus(1700, 490, 0, width, 0, height, BonusType.POINT));
			break;
		}
		case LEVEL3:{
			p1.spawnPlayer(101, 790);
			p2.spawnPlayer(201, 790);
			platforms.clear();
			bonuses.clear();
			enemies.clear();

			makeBasicStartingPosition();

			platforms.add(new Platform(300, 590, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(600, 590, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(800, 390, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1600, 590, 0, width, 0, height, PlatformType.SOLID));

			for(int i=0; i<3; i++){
				Platform temp = platforms.get((int) (Math.random() * platforms.size()));
				while(temp.getX()<=100){
					temp = platforms.get((int) (Math.random() * platforms.size()));
				}
				enemies.add(new Enemy(temp.getX(), temp.getY() - 100, 0, width, 0, height, EnemyType.WEAK));
				if(didPlayerCollideEnemy(p1)||didPlayerCollideEnemy(p2)||(!isPlatformNextLeft(enemies.get(enemies.size()-1))||!isPlatformNextRight(enemies.get(enemies.size()-1)))){
					enemies.remove(enemies.size()-1);
					i--;
				}	
			}

			end.setX(1800);
			end.setY(390);
			bonuses.add(new Bonus(1000, 590, 0, width, 0, height, BonusType.POINT));
			bonuses.add(new Bonus(200, 0, 0, width, 0, height, BonusType.POINT));
			bonuses.add(new Bonus(1700, 490, 0, width, 0, height, BonusType.POINT));
			break;
		}
		case LEVEL4:{
			platforms.clear();
			bonuses.clear();
			enemies.clear();
			
			p1.visible = false;
			p2.visible = false;
			playerPick.visible = false;
			end.visible = false;

			if(p1.scoreP1 > p2.scoreP2){
				//Player p1End = new Player(alignmentX, alignmentX, flags, flags, flags, flags, null)
				p1.visible = true;
				p1.spawnPlayer(101, 790);
			}
			else if(p2.scoreP2 > p1.scoreP1){
				p2.visible = true;
				p2.spawnPlayer(101, 790);
			}
			else{
				p2.visible = true;
				p1.visible = true;
				p2.spawnPlayer(101, 790);
				p1.spawnPlayer(101, 790);
			}
			for (int i = 0; i <= 1900; i+= 100){
				makePlatform(i, 890);
				makePlatform(i, 0);
			}
			for (int i = 90; i < 800; i+= 100){
				makePlatform(0, i);
				makePlatform(1800, i);
			}
			end.setX(Integer.MAX_VALUE);
			end.setY(Integer.MAX_VALUE);
			break;
		}
		}


	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(width, height);
		frame.setFont(new Font("System", Font.ROMAN_BASELINE, 14));
		String space = "";
		for (int i = 0; i < 85; i++) {
			space += "  ";
		}
		frame.setTitle(space + "Platform Nine and Three Quarters");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(width, height));
		frame.setAutoRequestFocus(true);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		// Container c = frame.getContentPane();
		c.add(new MainGame());
		frame.pack();
	}

	Color background = Color.CYAN;

	public MainGame() {
		// Start the setup
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(background);
		addKeyListener(this);
		addMouseListener(this);
		Thread gameThread = new Thread(this);
		gameThread.start();

	}

	public void run() {
		setup();
		setup();

		while (true) {
			if (currentLevel != Level.START) {
				// if(!gameOver){
				if (didPlayerCollideEnd(p1)) {
					counter++;
					winsP1++;
					currentLevel = makeNewCurrentLevel(counter);
					setup();
				}
				else if (didPlayerCollideEnd(p2)) {
					counter++;
					winsP2++;
					currentLevel = makeNewCurrentLevel(counter);
					setup();
				}
				this.requestFocus();
				p1.getX();
				p1.getY();
				if (didPlayerCollideBonus(p1)) {
					p1.bonusP1++;
					//System.out.println(p1.bonusP1);
				}
				if (didPlayerCollideBonus(p2)) {
					p1.bonusP2++;
					//System.out.println(p2.bonusP2);
				}
				

				if (!didPlayerCollidePlatformRight(p2) && !didPlayerCollidePlatformLeft(p2)) {
					// Touching Top of Platform
					if (didPlayerCollidePlatformTop(p2)) {
						p2.setXSpeed(0);
						p2.setYSpeed(0);
					}
					// Not Touching any platform
					if (!didPlayerCollidePlatformTop(p2)) {
						// Move left
						if (keyMap.get(65) == Boolean.TRUE) {

							double tempX = p2.getX();
							double tempY = p2.getY();
							p2.setX((int) (p2.getX() - 8));
							p2.setY((int) (p2.getY()));
							// If touch side of block can't move
							if (didPlayerCollidePlatformRight(p2) || didPlayerCollidePlatformLeft(p2)) {
								p2.setX((int) tempX);
								p2.setY((int) tempY);
								p2.setXSpeed(0);
								p2.setYSpeed(0);
								System.out.println("yes");
							}

						}
						// Move right
						if (keyMap.get(68) == Boolean.TRUE) {

							double tempX = p2.getX();
							double tempY = p2.getY();
							p2.setX((int) (p2.getX() + 8));
							p2.setY((int) (p2.getY()));
							// If touch side of block can't move
							if (didPlayerCollidePlatformRight(p2) || didPlayerCollidePlatformLeft(p2)) {
								p2.setX((int) tempX);
								p2.setY((int) tempY);
								p2.setXSpeed(0);
								p2.setYSpeed(0);
								System.out.println("yes");
							}
						}
					}
					// Touching a platform
					if (didPlayerCollidePlatformTop(p2)) {
						// Jump
						if (keyMap.get(87) == Boolean.TRUE) {

							jumpYP2 = p2.getY();
							p2.setXSpeed(0);
							p2.setYSpeed(-10);
						}
						// Move left
						else if (keyMap.get(65) == Boolean.TRUE) {
							;
							double tempX = p2.getX();
							double tempY = p2.getY();
							p2.setX((int) (p2.getX() - 8));
							p2.setY((int) (p2.getY()));
							if (didPlayerCollidePlatformRight(p2) || didPlayerCollidePlatformLeft(p2)) {
								p2.setX((int) tempX);
								p2.setY((int) tempY);
								p2.setXSpeed(0);
								p2.setYSpeed(0);
							}

						}
						// Move right
						else if (keyMap.get(68) == Boolean.TRUE) {

							double tempX = p2.getX();
							double tempY = p2.getY();
							p2.setX((int) (p2.getX() + 8));
							p2.setY((int) (p2.getY()));
							if (didPlayerCollidePlatformRight(p2) || didPlayerCollidePlatformLeft(p2)) {
								p2.setX((int) tempX);
								p2.setY((int) tempY);
								p2.setXSpeed(0);
								p2.setYSpeed(0);
							}
						}
					}
					// Not touching bottom(Falling)
					if (!didPlayerCollidePlatformTop(p2) && p2.getYSpeed() == 0) {
						p2.setYSpeed(10);
					}
					// Not touching bottom and descending from jump
					if (!didPlayerCollidePlatformTop(p2) && p2.getY() == jumpYP2 - 250) {
						p2.setXSpeed(0);
						p2.setYSpeed(10);
					}

				}

				else if (!didPlayerCollidePlatformBot(p2)) {
					p2.setXSpeed(0);
					p2.setYSpeed(-10);
				} //

				if (!didPlayerCollidePlatformRight(p1) && !didPlayerCollidePlatformLeft(p1)) {
					// Touching Top of Platform
					if (didPlayerCollidePlatformTop(p1)) {
						p1.setXSpeed(0);
						p1.setYSpeed(0);
					}
					// Not Touching any platform
					if (!didPlayerCollidePlatformTop(p1)) {
						// Move left
						if (keyMap.get(37) == Boolean.TRUE) {
							double tempX = p1.getX();
							double tempY = p1.getY();
							p1.setX((int) (p1.getX() - 8));
							p1.setY((int) (p1.getY()));
							// If touch side of block can't move
							if (didPlayerCollidePlatformRight(p1) || didPlayerCollidePlatformLeft(p1)) {
								p1.setX((int) tempX);
								p1.setY((int) tempY);
								p1.setXSpeed(0);
								p1.setYSpeed(0);
								System.out.println("yes");
							}

						}
						// Move right
						if (keyMap.get(39) == Boolean.TRUE) {
							double tempX = p1.getX();
							double tempY = p1.getY();
							p1.setX((int) (p1.getX() + 8));
							p1.setY((int) (p1.getY()));
							// If touch side of block can't move
							if (didPlayerCollidePlatformRight(p1) || didPlayerCollidePlatformLeft(p1)) {
								p1.setX((int) tempX);
								p1.setY((int) tempY);
								p1.setXSpeed(0);
								p1.setYSpeed(0);
								System.out.println("yes");
							}
						}
					}
					// Touching a platform
					if (didPlayerCollidePlatformTop(p1)) {
						// Jump
						if (keyMap.get(38) == Boolean.TRUE) {
							jumpYP1 = p1.getY();
							p1.setXSpeed(0);
							p1.setYSpeed(-10);
						}
						// Move left
						else if (keyMap.get(37) == Boolean.TRUE) {
							double tempX = p1.getX();
							double tempY = p1.getY();
							p1.setX((int) (p1.getX() - 8));
							p1.setY((int) (p1.getY()));
							if (didPlayerCollidePlatformRight(p1) || didPlayerCollidePlatformLeft(p1)) {
								p1.setX((int) tempX);
								p1.setY((int) tempY);
								p1.setXSpeed(0);
								p1.setYSpeed(0);
							}

						}
						// Move right
						else if (keyMap.get(39) == Boolean.TRUE) {
							double tempX = p1.getX();
							double tempY = p1.getY();
							p1.setX((int) (p1.getX() + 8));
							p1.setY((int) (p1.getY()));
							if (didPlayerCollidePlatformRight(p1) || didPlayerCollidePlatformLeft(p1)) {
								p1.setX((int) tempX);
								p1.setY((int) tempY);
								p1.setXSpeed(0);
								p1.setYSpeed(0);
							}
						}
					}
					// Not touching bottom(Falling)
					if (!didPlayerCollidePlatformTop(p1) && p1.getYSpeed() == 0) {
						p1.setYSpeed(10);
					}
					// Not touching bottom and descending from jump
					if (!didPlayerCollidePlatformTop(p1) && p1.getY() == jumpYP1 - 250) {
						p1.setXSpeed(0);
						p1.setYSpeed(10);
					}

				}

				// }
				else if (!didPlayerCollidePlatformBot(p1)) {

					p1.setXSpeed(0);
					p1.setYSpeed(-10);
				}

				if (didPlayerCollideEnemy(p1)) {
					p1.spawnPlayer(101, 790);
				}
				if (didPlayerCollideEnemy(p2)) {
					p2.spawnPlayer(101, 790);
				}
			}
			repaint();
			// Working on
			for (int i = 0; i < enemies.size(); i++) {
				if (!didEnemyCollidePlatformBot(enemies.get(i))) {
					if (enemies.get(i).getXSpeed() < 0) {
						enemies.get(i).setX((int) (enemies.get(i).getX() + 10));
					} else if (enemies.get(i).getXSpeed() > 0) {
						enemies.get(i).setX((int) (enemies.get(i).getX() - 10));
					}
					enemies.get(i).setXSpeed(-1 * enemies.get(i).getXSpeed());
				}

				if ((enemies.get(i).getXSpeed() == 0)) {
					enemies.get(i).setXSpeed(4);
				}
			}
			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
			}

		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		playerPick.draw(g);
		p1.draw(g);
		p2.draw(g);
		end.draw(g);
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
		}
		for (int i = 0; i < platforms.size(); i++) {
			platforms.get(i).draw(g);
		}
		for (int i = 0; i < bonuses.size(); i++) {
			bonuses.get(i).draw(g);
		}
	}

	//used when making the array of enemies
	public boolean isPlatformNextLeft(Enemy e) {
		for (int i = 0; i < platforms.size(); i++) {
			if ((platforms.get(i).getX() == e.getX() - 100) && (platforms.get(i).getY() == e.getY() + 100)) {
				return true;
			}
		}
		return false;
	}

	//used when making the array of enemies
	public boolean isPlatformNextRight(Enemy e) {
		for (int i = 0; i < platforms.size(); i++) {
			if (platforms.get(i).getX() == e.getX() + 100 && platforms.get(i).getY() == e.getY() + 100) {
				return true;
			}
		}
		return false;
	}

	public boolean didEnemyCollidePlatformBot(Enemy e) {
		for (int i = 0; i < platforms.size(); i++) {
			if ((platforms.get(i).getX() >= e.getX() - 50 && platforms.get(i).getX() <= e.getX() + 50) && (platforms.get(i).getY() == e.getY() + 100)) {
				return true;
			}
		}
		return false;
	}

	public boolean didPlayerCollideEnemy(Player p) {
		for (int i = 0; i < enemies.size(); i++) {
			if ((enemies.get(i).getX() >= p.getX() - 100 && enemies.get(i).getX() <= p.getX() + 100)
					&& (enemies.get(i).getY() >= p.getY() - 100 && enemies.get(i).getY() <= p.getY() + 100)) {
				return true;
			}
		}
		return false;
	}

	public boolean didPlayerCollideEnd(Player p) {
		if ((end.getX() >= p.getX() - 100 && end.getX() <= p.getX() + 100)
				&& (end.getY() >= p.getY() - 100 && end.getY() <= p.getY() + 100)) {
			return true;
		}
		return false;
	}

	public boolean didPlayerCollideBonus(Player p) {
		for (int i = 0; i < bonuses.size(); i++) {
			if ((bonuses.get(i).getX() >= p.getX() - 100 && bonuses.get(i).getX() <= p.getX() + 100)
					&& (bonuses.get(i).getY() >= p.getY() - 100 && bonuses.get(i).getY() <= p.getY() + 100)) {
				return true;
			}
		}
		return false;
	}

	public boolean didPlayerCollidePlatformTop(Player p) {
		for (int i = 0; i < platforms.size(); i++) {
			if ((platforms.get(i).getX() >= p.getX() - 100 && platforms.get(i).getX() <= p.getX() + 100)
					&& (platforms.get(i).getY() == p.getY() + 100)) {
				return true;
			}
		}
		return false;
	}

	public boolean didPlayerCollidePlatformBot(Player p) {
		for (int i = 0; i < platforms.size(); i++) {
			if ((platforms.get(i).getX() >= p.getX() - 100 && platforms.get(i).getX() <= p.getX() + 100)
					&& (platforms.get(i).getY() == p.getY() - 100)) {
				return true;
			}
		}
		return false;
	}

	public boolean didPlayerCollidePlatformLeft(Player p) {
		for (int i = 0; i < platforms.size(); i++) {
			if ((platforms.get(i).getX() == p.getX() + 100)
					&& (platforms.get(i).getY() >= p.getY() - 100 && platforms.get(i).getY() <= p.getY() + 100)) {
				return true;
			}
		}
		return false;
	}

	public boolean didPlayerCollidePlatformRight(Player p) {
		for (int i = 0; i < platforms.size(); i++) {
			if ((platforms.get(i).getX() == p.getX() - 100)
					&& (platforms.get(i).getY() >= p.getY() - 100 && platforms.get(i).getY() <= p.getY() + 100)) {
				return true;
			}
		}
		return false;
	}

	public void gameOver() {
		gameOver = true;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// System.out.println(e.getKeyCode());
		keyMap.put(e.getKeyCode(), true);

		if (e.getKeyCode() == 39) {
			keyMap.remove(38);
			keyMap.remove(37);
		}
		if (e.getKeyCode() == 37) {
			keyMap.remove(39);
			keyMap.remove(38);
		}
		if (e.getKeyCode() == 38) {
			keyMap.remove(39);
			keyMap.remove(37);
		}
		if (e.getKeyCode() == 87) {
			keyMap.remove(65);
			keyMap.remove(68);
		}
		if (e.getKeyCode() == 65) {
			keyMap.remove(68);
			keyMap.remove(87);
		}
		if (e.getKeyCode() == 68) {
			keyMap.remove(87);
			keyMap.remove(65);
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyMap.remove(e.getKeyCode());
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public static int mouseY = 0;
	public static int mouseX = 0;

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	public static void makePlatform(double x, double y) {
		platforms.add(new Platform(x, y, 0, width, 0, height, PlatformType.SOLID));
	}

	public static void makeBasicStartingPosition() {
		makePlatform(0, -10);
		for (int i = 0; i <= 1900; i += 100) {
			makePlatform(i, 890);
		}
		for (int i = 90; i < 900; i += 100) {
			makePlatform(0, i);
		}
	}
	
	public static Level makeNewCurrentLevel(int counter){
		if (counter == 0) {
			return(Level.START);
		} else if (counter == 1) {
			return(Level.LEVEL1);
		} else if (counter == 2) {
			return(Level.LEVEL2);
		} else if (counter == 3) {
			return(Level.LEVEL3);
		} else if (counter == 4) {
			return(Level.LEVEL4);
		}
		return currentLevel;
	}
}