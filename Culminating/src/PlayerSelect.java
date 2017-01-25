/**
 * PlayerSelect.java
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

public class PlayerSelect extends GamePiece {
	private PlayerType shape;
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	public static boolean visible = true;
	
	/**
	 * PlayerSelect constructor
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
	public PlayerSelect(double x, double y, int left, int right, int top, int bottom, PlayerType shape) {
		super(x, y, left, right, top, bottom);
		this.shape = shape;
		try {
			image1 = ImageIO.read(new File("src/resources/Pig.png"));
			image2 = ImageIO.read(new File("src/resources/Penguin.png"));
			image3 = ImageIO.read(new File("src/resources/Lion.png"));
			image4 = ImageIO.read(new File("src/resources/Shark.png"));

		} catch (IOException ex) {
			System.out.println("No Images");
		}
	}

	/**
	 * This method draws the current player select screen
	 * 
	 * @param g 
	 * 				Graphics - The graphics object that needs to be passed through
	 */
	public void draw(Graphics g) {
		if(visible){
			g.drawImage(image1, 120, 300, 300,300, null);
			g.setFont(new Font("SansSerif",Font.BOLD,25));
			g.drawString("Pig", 240, 250);
			
			g.drawImage(image2, 520, 300, 300,300, null);
			g.setFont(new Font("SansSerif",Font.BOLD,25));
			g.drawString("Penguin", 610, 250);
			
			g.drawImage(image3, 1100, 300, 300,300, null);
			g.setFont(new Font("SansSerif",Font.BOLD,25));
			g.drawString("Lion", 1200, 250);
			
			g.drawImage(image4, 1500, 300, 300,300, null);
			g.setFont(new Font("SansSerif",Font.BOLD,25));
			g.drawString("Shark", 1600, 250);
			
			g.setFont(new Font("SansSerif",Font.BOLD,25));
			g.drawString("Select two Characters", 850, 150);
			
			g.setFont(new Font("SansSerif",Font.BOLD,25));
			g.drawString("Rules: Play with two characters. Use", 200, 720);
			g.drawString("arrows and wad to move. The blocks have ladders", 200, 750);
			g.drawString("on the back, allowing the animals to climb. To get down,", 200, 780);
			g.drawString("jump. Touch the yellow circles to gain points or reach the", 200, 810);
			g.drawString("end block to get 500 points. Avoid enemies.", 200, 840);
		}
	}
	
	
	/**
	 * Blank Method
	 */
	public void animateOneStep() {
	}
	

}
