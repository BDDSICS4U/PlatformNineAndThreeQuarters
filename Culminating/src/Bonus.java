

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
 
public class Bonus extends GamePiece{
	private BonusType shape;
	private BufferedImage image1;
	private BufferedImage image2;
	public Bonus(double x, double y, int left, int right, int top, int bottom, BonusType shape) {
		super(x, y, left, right, top, bottom);
		this.shape = shape;
		try {                
			image1 = ImageIO.read(new File(""));
			image2 = ImageIO.read(new File(""));

		} catch (IOException ex) {
			System.out.println("No Images");
		}
	}

	public void draw(Graphics g) {
		switch(shape){
		case POINT:{
			g.drawImage(image2.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case LIFE:{
			g.drawImage(image1.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		}

	}

	public void animateOneStep() {
	}

	public void playSound(){
		 // *****************************
	    // THESE LINES PLAY THE MUSIC. 
	    // Cut and paste them into your program, and change "theme.wav"
	    // to the sound you want to play. You also have to change ExampleCode
	    // to your package name.
	    AudioStream sound1;
	    sound1 = new AudioStream (new FileInputStream ("ExampleCode/theme.wav"));
	    AudioPlayer.player.start (sound1);
	    // *****************************
	}


}
