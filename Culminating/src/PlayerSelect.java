
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
	public PlayerSelect(double x, double y, int left, int right, int top, int bottom, PlayerType shape) {
		super(x, y, left, right, top, bottom);
		this.shape = shape;
		try {
			image1 = ImageIO.read(new File("src/Pictures/Pig.jpg"));
			image2 = ImageIO.read(new File("src/Pictures/Penguin.png"));
			image3 = ImageIO.read(new File("src/Pictures/Lion.jpg"));
			image4 = ImageIO.read(new File("src/Pictures/Shark.png"));

		} catch (IOException ex) {
			System.out.println("No Images");
		}
	}

	public void draw(Graphics g) {
		if(visible){
			g.drawImage(image1, 120, 300, 300,300, null);
			g.setFont(new Font("SansSerif",Font.BOLD,25));
			g.drawString("Pig (1)", 240, 250);
			
			g.drawImage(image2, 520, 300, 300,300, null);
			g.setFont(new Font("SansSerif",Font.BOLD,25));
			g.drawString("Penguin (2)", 610, 250);
			
			g.drawImage(image3, 1100, 300, 300,300, null);
			g.setFont(new Font("SansSerif",Font.BOLD,25));
			g.drawString("Lion (3)", 1200, 250);
			
			g.drawImage(image4, 1500, 300, 300,300, null);
			g.setFont(new Font("SansSerif",Font.BOLD,25));
			g.drawString("Shark (4)", 1600, 250);
			
			g.setFont(new Font("SansSerif",Font.BOLD,25));
			g.drawString("Select two Characters", 780, 850);
		}
	}
	
	

	public void animateOneStep() {
	}
	

}
