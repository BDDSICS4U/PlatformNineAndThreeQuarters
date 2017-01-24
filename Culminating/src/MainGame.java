import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class MainGame extends JPanel implements Runnable, KeyListener {
	HashMap<Integer,Boolean> keyMap = new HashMap<Integer,Boolean>();
	public static Level currentLevel = Level.START;
	private boolean gameOver = false;
	private static int count = 0;
	private static final int width = 1920;
	private static final int height = 990;
	private long pauseDuration = 30;
	//Player One
	Player p1 = new Player(101, 790, 0, width, 0, height, PlayerType.PLAYER1);
	Player p2 = new Player(201, 790, 0, width, 0, height, PlayerType.PLAYER2);
	public static ArrayList<Platform> platforms = new ArrayList<Platform>(0);
	public static ArrayList<Bonus> bonuses = new ArrayList<Bonus>(0);
	public static Platform end = new Platform(0, 0, 0, width, 0, height, PlatformType.END);
	public static double jumpYP1 = 0;
	public static double jumpYP2 = 0;
	public static int counter = 0;
	public static PlayerSelect playerPick = new PlayerSelect(0, 0, 0, width, 0, height, null);
	public void setup(){
		switch(currentLevel){
		case START:{
			p1.visible = false;
			p2.visible = false;
			playerPick.visible = true;
			platforms.add(new Platform(0, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(100, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(200, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(300, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(400, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(500, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(600, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(700, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(800, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(900, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1000, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1100, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1200, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1300, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1400, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1500, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1600, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1700, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1800, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1900, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 790, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 690, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 590, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 490, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 390, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 290, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 190, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 90, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(100, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(200, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(300, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(400, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(500, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(600, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(700, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(800, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(900, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1000, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1100, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1200, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1300, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1400, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1500, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1600, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1700, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1800, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1900, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1820, 790, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1820, 690, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1820, 590, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1820, 490, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1820, 390, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1820, 290, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1820, 190, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1820, 90, 0, width, 0, height, PlatformType.SOLID));
			//PlayerSelect playerPick = new PlayerSelect(0, 0, 0, width, 0, height, null);
			break;
		}
		case LEVEL1:{
			p2.visible = true;
			p1.visible = true;
			playerPick.visible = false;
			platforms.clear();
			bonuses.clear();
			p1.setX(101);
			p1.setY(790);
			p2.setX(201);
			p2.setY(790);
			platforms.add(new Platform(0, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(100, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(200, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(300, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(400, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(500, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(600, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(700, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(800, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(900, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1000, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1100, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1200, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1300, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1400, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1500, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1600, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1700, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1800, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1900, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 790, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 690, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 590, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 490, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 390, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 290, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 190, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 90, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 0, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(300, 690, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(400, 690, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(500, 690, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(600, 690, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(700, 690, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(800, 690, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(900, 690, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1000, 690, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(500, 490, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(800, 490, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(900, 490, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1000, 490, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1100, 490, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1200, 290, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1300, 290, 0, width, 0, height, PlatformType.SOLID));

			end.setX(1800);
			end.setY(290);
			
			bonuses.add(new Bonus(1000, 590, 0, width, 0, height, BonusType.POINT));
			bonuses.add(new Bonus(200, 0, 0, width, 0, height, BonusType.POINT));
			bonuses.add(new Bonus(1700, 490, 0, width, 0, height, BonusType.POINT));
			break;
		}
		case LEVEL2:{
			//c.setBackground(Color.BLACK);
			platforms.clear();
			bonuses.clear();
			p1.setX(101);
			p1.setY(790);
			p2.setX(201);
			p2.setY(790);
			platforms.add(new Platform(0, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(100, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(200, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(300, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(400, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(500, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(600, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(700, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(800, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(900, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1000, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1100, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1200, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1300, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1400, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1500, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1600, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1700, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1800, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1900, 890, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 790, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 690, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 590, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 490, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 390, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 290, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 190, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 90, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(0, 0, 0, width, 0, height, PlatformType.SOLID));
			
			platforms.add(new Platform(300, 590, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(400, 590, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(700, 390, 0, width, 0, height, PlatformType.SOLID));
			platforms.add(new Platform(1500, 590, 0, width, 0, height, PlatformType.SOLID));
			
			end.setX(1800);
			end.setY(390);
			bonuses.add(new Bonus(1000, 590, 0, width, 0, height, BonusType.POINT));
			bonuses.add(new Bonus(200, 0, 0, width, 0, height, BonusType.POINT));
			bonuses.add(new Bonus(1700, 490, 0, width, 0, height, BonusType.POINT));
			break;
		}
		case LEVEL3:{

			break;
		}
		case LEVEL4:{

			break;
		}
		}
		p1.setVisibility(true);

	}
	private static JFrame frame = new JFrame();
	private static Container c = frame.getContentPane();
	public static void main(String[] args) {
		frame.setSize(width,height);
		frame.setFont(new Font("System", Font.ROMAN_BASELINE, 14));
		String space ="";
		for(int i = 0; i < 85; i++){
			space += "  ";
		}
		frame.setTitle(space+ "Platform Nine and Three Quarters");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(width, height));
		frame.setAutoRequestFocus(false);
		frame.setVisible(true);
		//Container c = frame.getContentPane();
		c.add(new MainGame());
		frame.pack();
	}
	Color background = Color.CYAN;
	public MainGame(){
		// Start the setup
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(background);
		addKeyListener(this);
		Thread gameThread = new Thread(this);
		gameThread.start();
		setup();

	}
	public void run() {
		
		while (true) {
		setup();
		
			//	if(!gameOver){
				if(didPlayerCollideEndP1()){
					counter++;
					if (counter == 0){
						currentLevel = Level.START;
					}
					else if (counter == 1){
						currentLevel = Level.LEVEL1;
					}
					else if (counter == 2){
						currentLevel = Level.LEVEL2;
					}
					else if (counter == 3){
						currentLevel = Level.LEVEL3;
					}
					else if (counter == 4){
						currentLevel = Level.LEVEL4;
					}
					setup();
				}
				if(didPlayerCollideEndP2()){
					if (counter == 0){
						currentLevel = Level.START;
					}
					else if (counter == 1){
						currentLevel = Level.LEVEL1;
					}
					else if (counter == 2){
						currentLevel = Level.LEVEL2;
					}
					else if (counter == 3){
						currentLevel = Level.LEVEL3;
					}
					else if (counter == 4){
						currentLevel = Level.LEVEL4;
					}
					setup();
				}
				this.requestFocus();
				p1.getX();
				p1.getY();
				if(didPlayerCollideBonus()){
					p1.bonusP1++;
					System.out.println(p1.bonusP1);
				}
				if(didPlayerCollidePlatformB()){
					//System.out.println("B");
				}
				if(didPlayerCollidePlatformT()){
					//System.out.println("T");
				}
				if(didPlayerCollidePlatformL()){
					//System.out.println("L");
				}
				if(didPlayerCollidePlatformR()){
					//System.out.println("R");
				}



				if(!didPlayerCollidePlatformRP2() && !didPlayerCollidePlatformLP2()){
					//Touching Top of Platform
					if(didPlayerCollidePlatformTP2()){
						p2.setXSpeed(0);
						p2.setYSpeed(0);
					}
					//Not Touching any platform
					if(!didPlayerCollidePlatformTP2()){
						//Move left
						if(keyMap.get(65) == Boolean.TRUE){

							double tempX = p2.getX();
							double tempY = p2.getY();
							p2.setX((int) (p2.getX()-8));
							p2.setY((int) (p2.getY()));
							//If touch side of block can't move
							if(didPlayerCollidePlatformRP2() || didPlayerCollidePlatformLP2() ){
								p2.setX((int) tempX);
								p2.setY((int) tempY);
								p2.setXSpeed(0);
								p2.setYSpeed(0);
								System.out.println("yes");
							}


						}
						//Move right
						if(keyMap.get(68) == Boolean.TRUE){

							double tempX = p2.getX();
							double tempY = p2.getY();
							p2.setX((int) (p2.getX()+8));
							p2.setY((int) (p2.getY()));
							//If touch side of block can't move
							if(didPlayerCollidePlatformRP2() || didPlayerCollidePlatformLP2()){
								p2.setX((int) tempX);
								p2.setY((int) tempY);
								p2.setXSpeed(0);
								p2.setYSpeed(0);
								System.out.println("yes");
							}
						}
					}
					//Touching a platform
					if(didPlayerCollidePlatformTP2()){
						//Jump
						if(keyMap.get(87) == Boolean.TRUE){

							jumpYP2 = p2.getY();
							p2.setXSpeed(0);
							p2.setYSpeed(-10);
						}
						//Move left
						else if(keyMap.get(65) == Boolean.TRUE){
							;
							double tempX = p2.getX();
							double tempY = p2.getY();
							p2.setX((int) (p2.getX()-8));
							p2.setY((int) (p2.getY()));
							if(didPlayerCollidePlatformRP2() || didPlayerCollidePlatformLP2() ){
								p2.setX((int) tempX);
								p2.setY((int) tempY);
								p2.setXSpeed(0);
								p2.setYSpeed(0);
							}

						}
						//Move right
						else if(keyMap.get(68) == Boolean.TRUE){

							double tempX = p2.getX();
							double tempY = p2.getY();
							p2.setX((int) (p2.getX()+8));
							p2.setY((int) (p2.getY()));
							if(didPlayerCollidePlatformRP2() || didPlayerCollidePlatformLP2() ){
								p2.setX((int) tempX);
								p2.setY((int) tempY);
								p2.setXSpeed(0);
								p2.setYSpeed(0);
							}
						}
					}
					//Not touching bottom(Falling)
					if(!didPlayerCollidePlatformTP2()&& p2.getYSpeed() ==0){
						p2.setYSpeed(10);
					}
					//Not touching bottom and descending from jump
					if(!didPlayerCollidePlatformTP2() && p2.getY() == jumpYP2-250){
						p2.setXSpeed(0);
						p2.setYSpeed(10);
					}



				}


				else if(!didPlayerCollidePlatformBP2()){

					p2.setXSpeed(0);
					p2.setYSpeed(-10);
				}//



				if(!didPlayerCollidePlatformR() && !didPlayerCollidePlatformL()){
					//Touching Top of Platform
					if(didPlayerCollidePlatformT()){
						p1.setXSpeed(0);
						p1.setYSpeed(0);
					}
					//Not Touching any platform
					if(!didPlayerCollidePlatformT()){
						//Move left
						if(keyMap.get(37) == Boolean.TRUE){
							double tempX = p1.getX();
							double tempY = p1.getY();
							p1.setX((int) (p1.getX()-8));
							p1.setY((int) (p1.getY()));
							//If touch side of block can't move
							if(didPlayerCollidePlatformR() || didPlayerCollidePlatformL() ){
								p1.setX((int) tempX);
								p1.setY((int) tempY);
								p1.setXSpeed(0);
								p1.setYSpeed(0);
								System.out.println("yes");
							}


						}
						//Move right
						if(keyMap.get(39) == Boolean.TRUE){
							double tempX = p1.getX();
							double tempY = p1.getY();
							p1.setX((int) (p1.getX()+8));
							p1.setY((int) (p1.getY()));
							//If touch side of block can't move
							if(didPlayerCollidePlatformR() || didPlayerCollidePlatformL()){
								p1.setX((int) tempX);
								p1.setY((int) tempY);
								p1.setXSpeed(0);
								p1.setYSpeed(0);
								System.out.println("yes");
							}
						}
					}
					//Touching a platform
					if(didPlayerCollidePlatformT()){
						//Jump
						if(keyMap.get(38) == Boolean.TRUE){
							jumpYP1 = p1.getY();
							p1.setXSpeed(0);
							p1.setYSpeed(-10);
						}
						//Move left
						else if(keyMap.get(37) == Boolean.TRUE){
							double tempX = p1.getX();
							double tempY = p1.getY();
							p1.setX((int) (p1.getX()-8));
							p1.setY((int) (p1.getY()));
							if(didPlayerCollidePlatformR() || didPlayerCollidePlatformL() ){
								p1.setX((int) tempX);
								p1.setY((int) tempY);
								p1.setXSpeed(0);
								p1.setYSpeed(0);
							}

						}
						//Move right
						else if(keyMap.get(39) == Boolean.TRUE){
							double tempX = p1.getX();
							double tempY = p1.getY();
							p1.setX((int) (p1.getX()+8));
							p1.setY((int) (p1.getY()));
							if(didPlayerCollidePlatformR() || didPlayerCollidePlatformL() ){
								p1.setX((int) tempX);
								p1.setY((int) tempY);
								p1.setXSpeed(0);
								p1.setYSpeed(0);
							}
						}
					}
					//Not touching bottom(Falling)
					if(!didPlayerCollidePlatformT()&& p1.getYSpeed() ==0){
						p1.setYSpeed(10);
					}
					//Not touching bottom and descending from jump
					if(!didPlayerCollidePlatformT() && p1.getY() == jumpYP1-250){
						p1.setXSpeed(0);
						p1.setYSpeed(10);
					}



				}

			//}
			else if(!didPlayerCollidePlatformB()){

				p1.setXSpeed(0);
				p1.setYSpeed(-10);
			}

			repaint();
			try{
				Thread.sleep(pauseDuration);
			} catch(InterruptedException e){
			}

		}
	}

	private void resetLevel() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		playerPick.draw(g);
		p1.draw(g);
		p2.draw(g);
		end.draw(g);
		for(int i =0; i < platforms.size(); i++){
			platforms.get(i).draw(g);
		}
		for(int i =0; i < bonuses.size(); i++){
			bonuses.get(i).draw(g);
		}
	}


	public boolean didPlayerCollideEnemy(){
		return true;
	}
	public boolean didPlayerCollideEndP1(){
		if	((end.getX() >= p1.getX() - 100 && end.getX() <= p1.getX() + 100) && (end.getY() >= p1.getY() - 100 && end.getY() <= p1.getY() + 100)){
			return true;
		}
		return false;
	}
	public boolean didPlayerCollideEndP2(){
		if	((end.getX() >= p2.getX() - 100 && end.getX() <= p2.getX() + 100) && (end.getY() >= p2.getY() - 100 && end.getY() <= p2.getY() + 100)){
			return true;
		}
		return false;
	}
	public boolean didPlayerCollideBonus(){
		for(int i =0; i < bonuses.size(); i++){
			if	((bonuses.get(i).getX() >= p1.getX() - 100 && bonuses.get(i).getX() <= p1.getX() + 100) && (bonuses.get(i).getY() >= p1.getY() - 100 && bonuses.get(i).getY() <= p1.getY() + 100)){
				return true;
			}
		}
		return false;
	}
	public boolean didPlayerCollidePlatformT(){
		for(int i =0; i < platforms.size(); i++){
			if	((platforms.get(i).getX() >= p1.getX() - 100 && platforms.get(i).getX() <= p1.getX() + 100) && (platforms.get(i).getY() == p1.getY()+ 100)){
				return true;
			}
		}
		return false;
	}
	public boolean didPlayerCollidePlatformB(){
		for(int i =0; i < platforms.size(); i++){
			if	((platforms.get(i).getX() >= p1.getX() - 100 && platforms.get(i).getX() <= p1.getX() + 100) && (platforms.get(i).getY() == p1.getY() -100 )){
				return true;
			}
		}
		return false;
	}
	public boolean didPlayerCollidePlatformL(){
		for(int i =0; i < platforms.size(); i++){
			if	((platforms.get(i).getX() == p1.getX() + 100 ) && (platforms.get(i).getY() >= p1.getY() - 100 && platforms.get(i).getY() <= p1.getY() + 100)){
				return true;
			}
		}
		return false;
	}
	public boolean didPlayerCollidePlatformR(){
		for(int i =0; i < platforms.size(); i++){
			if	((platforms.get(i).getX() == p1.getX() -100) && (platforms.get(i).getY() >= p1.getY() - 100 && platforms.get(i).getY() <= p1.getY() + 100)){
				return true;
			}
		}
		return false;
	}



	public boolean didPlayerCollidePlatformTP2(){
		for(int i =0; i < platforms.size(); i++){
			if	((platforms.get(i).getX() >= p2.getX() - 100 && platforms.get(i).getX() <= p2.getX() + 100) && (platforms.get(i).getY() == p2.getY()+ 100)){
				return true;
			}
		}
		return false;
	}
	public boolean didPlayerCollidePlatformBP2(){
		for(int i =0; i < platforms.size(); i++){
			if	((platforms.get(i).getX() >= p2.getX() - 100 && platforms.get(i).getX() <= p2.getX() + 100) && (platforms.get(i).getY() == p2.getY() -100 )){
				return true;
			}
		}
		return false;
	}
	public boolean didPlayerCollidePlatformLP2(){
		for(int i =0; i < platforms.size(); i++){
			if	((platforms.get(i).getX() == p2.getX() + 100 ) && (platforms.get(i).getY() >= p2.getY() - 100 && platforms.get(i).getY() <= p2.getY() + 100)){
				return true;
			}
		}
		return false;
	}
	public boolean didPlayerCollidePlatformRP2(){
		for(int i =0; i < platforms.size(); i++){
			if	((platforms.get(i).getX() == p2.getX() -100) && (platforms.get(i).getY() >= p2.getY() - 100 && platforms.get(i).getY() <= p2.getY() + 100)){
				return true;
			}
		}
		return false;
	}




	public void gameOver(){
		gameOver = true;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keyMap.put(e.getKeyCode(), true);

		if(e.getKeyCode() == 39){
			keyMap.remove(38);
			keyMap.remove(37);
		}
		if(e.getKeyCode() == 37){
			keyMap.remove(39);
			keyMap.remove(38);
		}
		if(e.getKeyCode() == 38){
			keyMap.remove(39);
			keyMap.remove(37);
		}
		if(e.getKeyCode() == 87){
			keyMap.remove(65);
			keyMap.remove(68);
		}
		if(e.getKeyCode() == 65){
			keyMap.remove(68);
			keyMap.remove(87);
		}
		if(e.getKeyCode() == 68){
			keyMap.remove(87);
			keyMap.remove(65);
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 39){
			keyMap.remove(39);
			
		}
		if(e.getKeyCode() == 37){
			keyMap.remove(37);
			
		}
		if(e.getKeyCode() == 38){
			keyMap.remove(38);
			
		}
		if(e.getKeyCode() == 87){
			keyMap.remove(87);
		
		}
		if(e.getKeyCode() == 65){
			keyMap.remove(65);
			
		}
		if(e.getKeyCode() == 68){
			keyMap.remove(68);
			
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}