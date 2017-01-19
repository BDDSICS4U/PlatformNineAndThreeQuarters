/* ISC4U culminating game
 * A simple platforming game
 * @author: Brendan Russell, Dalton Firth, Daniel Nucci and Stuart Detrich
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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
	int key = 0;
	public static void setup(){
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

	}

	/**
	 * The main method where our code initially executes
	 * @param args
	 */
	public static void main(String[] args) {
		//Initializing and setting the size of the JFrame
		JFrame frame = new JFrame();
		frame.setSize(width,height);
		frame.setFont(new Font("System", Font.ROMAN_BASELINE, 14));
		String space ="";
		for(int i =0; i < 85;i++){
			space += "  ";
		}
		frame.setTitle(space+ "Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(width, height));
		frame.setAutoRequestFocus(false);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		c.add(new MainGame());
		frame.pack();

	}

	/**
	 * This method starts setup and sets the background colour
	 */
	public MainGame(){
		// Start the setup
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.BLACK);
		addKeyListener(this);
		Thread gameThread = new Thread(this);
		gameThread.start();
		setup();

	}
	/**
	 * constantly repaints the screen while the game is running
	 */
	public void run() {
		while (true) {
			if(!gameOver){
				this.requestFocus();
				if(key==38){

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

		}
	}

	/**
	 * restarts the current level from the beginning
	 */
	private void resetLevel() {
		
	}
	
	public void paintComponent(Graphics g) {
		

	}



	/**
	 * boolean that determines if the player collided with an enemy
	 * @return returns true if the player has collided with the enemy
	 */
	public boolean didPlayerCollideEnemy(){
		return true;
	}
	
	/**
	 * boolean that determines if the player collided with a bonus object
	 * @return returns true if the player has collided with the bonus
	 */
	public boolean didPlayerCollideBonus(){
		return true;
	}
	
	/**
	 * boolean that determines if the player collided with a platform
	 * @return returns true if the player has collided with a platform
	 */
	public boolean didPlayerCollidePlatform(){
		return true;
	}


	/**
	 * Method that runs when the player loses the game
	 */
	public void gameOver(){
		gameOver = true;
	}

	/**
	 * method that finds what key is pressed on the keyboard
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		key = e.getKeyCode();
		repaint();
	}

	/**
	 * method that finds if the key has been released
	 */
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