import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class MainGame extends JPanel implements Runnable, KeyListener {
	public static Level currentLevel = Level.START;
	private boolean gameOver = false;
	//private static int count = 0;
	private static final int width = 1920;
	private static final int height = 990;
	private int key = 0;
	private long pauseDuration = 30;
	private int coins;
	//Player One
	Player p1 = new Player(500, 500, 0, width, 0, height, PlayerType.PLAYER1);
	Player p2 = new Player(500, 500, 0, width, 0, height, PlayerType.PLAYER2);
	
	BufferedImage coinImage;

	public void setup(){
		switch(currentLevel){
		case START:{
			p2.setVisibility(true);
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
		try{
			coinImage = ImageIO.read(new File("src/Pictures/Life.png"));
		}catch(IOException ex){
		}
		Thread gameThread = new Thread(this);
		gameThread.start();
		setup();

	}
	public void run() {
		while (true) {
			if(!gameOver){
				this.requestFocus();
				p1.getX();
				p1.getY();
				
				if(key==38){
					this.coins++;
				}
				else if(key==40){
					
				}
				else if(key==37){

				}
				else if(key==39){

				}
				//Make for loop to check collision
				//Also if statement for when player hits something


			}
			repaint();
			try{
				Thread.sleep(pauseDuration);
			} catch(InterruptedException e){
			}

		}
	}

	@SuppressWarnings("unused")
	private void resetLevel() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		p1.draw(g);
		p2.draw(g);
		g.drawImage(coinImage, 1790, 10, 50,50,null);
		g.setFont(new Font("SansSerif",Font.BOLD,25));
		g.drawString(coins+"", 1850, 45);

	}


	public boolean didPlayerCollideEnemy(){
		return true;
	}
	public boolean didPlayerCollideBonus(){
		return true;
	}
	public boolean didPlayerCollidePlatform(){
		return true;
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