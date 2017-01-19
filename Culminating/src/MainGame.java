import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainGame extends JPanel implements Runnable, KeyListener {
	public static Level currentLevel = Level.START;
	private boolean gameOver = false;
	private static int count = 0;
	private static final int width = 500;
	private static final int height = 500;
	ArrayList<Integer> listOfKeys = new ArrayList<Integer>();
	int key = 0;
	
	Player p1 = new Player(500, 500, 0, width, 0, height, PlayerType.PLAYER1);

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

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(width, height);
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
		this.setBackground(Color.BLACK);
		addKeyListener(this);
		Thread gameThread = new Thread(this);
		gameThread.start();
		setup();

	}
	public void run() {
		while (true) {
			if(!gameOver){
				this.requestFocus();
				for(int i =0; i < listOfKeys.size(); i++){
					System.out.print(listOfKeys.get(i) + ", ");
				}
				System.out.println();
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

	private void resetLevel() {
		
	}
	
	public void paintComponent(Graphics g) {
		

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
		listOfKeys = bubble(listOfKeys);
		if(binary(listOfKeys, e.getKeyCode()) == -1){
			listOfKeys.add(e.getKeyCode());
		}
		//key = e.getKeyCode();
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		listOfKeys = bubble(listOfKeys);
		if (binary(listOfKeys, e.getKeyCode()) != -1){
			listOfKeys.remove(binary(listOfKeys, e.getKeyCode()));
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * this method sorts a int array using bubble sort
	 * 
	 * @param a
	 *           a int array that will be sorted
	 */
	public static ArrayList<Integer> bubble(ArrayList<Integer> a) {
		int counter = 0;

		for (int i = 0; i < a.size() - 1; i++) {
			for (int j = 0; j < a.size() - 1 - i; j++) {
				if (a.get(j) > a.get(j + 1)) {
					Collections.swap(a, j, j + 1);
					counter++;
				}
			}
			if (counter == 0) {
				break;
			}
			counter = 0;
		}
		return a;
	}
	
	
	/**
	 * Feeder method for binary search through an array of ints
	 * 
	 * @param array
	 *           ArrayList<Integer> - the array you want to get a value from
	 * @param target
	 *           int - the value of your target
	 * @return the loader method
	 */
	public static int binary(ArrayList<Integer> array, int target) {
		return binary(array, target, 0, array.size() - 1);
	}
	
	/**
	 * The loader method for binary search through an array of ints
	 * 
	 * @param array
	 *           ArrayList<Integer> - the array you want to get a value from
	 * @param target
	 *           int - the value of your target
	 * @param startIndex
	 *           int - the starting index of the current instance of the array
	 * @param endIndex
	 *           int - the ending index of the current instance of the array
	 * @return the index at which the target occurs
	 */
	private static int binary(ArrayList<Integer> array, int target, int startIndex, int endIndex) {
		int midpoint = (startIndex + endIndex) / 2;

		if (startIndex > endIndex) {
			return -1;
		}

		if (target == array.get(midpoint)) {
			return midpoint;
		}
		else if (target > array.get(midpoint)) {
			return binary(array, target, midpoint + 1, endIndex);
		}
		else if (target < array.get(midpoint)) {
			return binary(array, target, startIndex, midpoint - 1);
		}

		return -1;
	}
	
}