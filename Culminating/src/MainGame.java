import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class MainGame extends JPanel implements Runnable, KeyListener {
	public static Level currentLevel = Level.START;
	private boolean gameOver = false;
	private static int count = 0;
	private static final int width = 1920;
	private static final int height = 990;
	private int key = 0;
	private long pauseDuration = 30;
	//Player One
	Player p1 = new Player(101, 790, 0, width, 0, height, PlayerType.PLAYER1);
	public static ArrayList<Platform> platforms = new ArrayList<Platform>(0);
	public static ArrayList<Bonus> bonuses = new ArrayList<Bonus>(0);
	public static double jumpY = 0;
	public static double jumpX = 0;

	public void setup(){
		switch(currentLevel){
		case START:{
			break;
		}
		case LEVEL1:{

			break;
		}
		case LEVEL2:{

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

	public static void main(String[] args) {
		JFrame frame = new JFrame();
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
		Container c = frame.getContentPane();
		c.add(new MainGame());
		frame.pack();
		frame.setBackground(Color.CYAN);
	}

	public MainGame(){
		// Start the setup
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.CYAN);
		addKeyListener(this);
		Thread gameThread = new Thread(this);
		gameThread.start();
		setup();

	}
	public void run() {
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
		platforms.add(new Platform(1400, 290, 0, width, 0, height, PlatformType.SOLID));
		

		platforms.add(new Platform(1800, 190, 0, width, 0, height, PlatformType.MOVING));
		platforms.add(new Platform(1800, 290, 0, width, 0, height, PlatformType.SOLID));
		

		bonuses.add(new Bonus(1000, 590, 0, width, 0, height, BonusType.POINT));

		while (true) {
			if(!gameOver){
				this.requestFocus();
				p1.getX();
				p1.getY();

				if(didPlayerCollidePlatformB()){
					System.out.println("B");
				}
				if(didPlayerCollidePlatformT()){
					System.out.println("T");
				}
				if(didPlayerCollidePlatformL()){
					System.out.println("L");
				}
				if(didPlayerCollidePlatformR()){
					System.out.println("R");
				}


				if(!didPlayerCollidePlatformR() && !didPlayerCollidePlatformL()){
					//Touching Top of Platform
					if(didPlayerCollidePlatformT()){
						p1.setXSpeed(0);
						p1.setYSpeed(0);
					}
					//Not Touching any platform
					if(!didPlayerCollidePlatformT()){
						//Move left
						if(key==37){
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
						if(key==39){
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
						if(key==38){
							jumpY = p1.getY();
							p1.setXSpeed(0);
							p1.setYSpeed(-10);
						}
						//Move left
						else if(key==37){
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
						else if(key==39){
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
					if(!didPlayerCollidePlatformT() && p1.getY() == jumpY-250){
						p1.setXSpeed(0);
						p1.setYSpeed(10);
					}


					
				}

			}
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
		p1.draw(g);
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
	public boolean didPlayerCollideBonus(){
		return true;
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

	public void gameOver(){
		gameOver = true;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		key = e.getKeyCode();
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		key = 0;
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}