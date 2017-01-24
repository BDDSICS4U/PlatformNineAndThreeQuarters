
 
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Platform extends GamePiece{
	private PlatformType shape;
	private Image image1;
	private Image image2;
	private Image image3;
public boolean visible = true;
	public Platform(double x, double y, int left, int right, int top, int bottom, PlatformType shape) {
		super(x, y, left, right, top, bottom);
		this.shape = shape;
		try {                
			image1 = ImageIO.read(new File("src/resources/Permanent.png"));
			image2 = ImageIO.read(new File("src/resources/Moving.png"));
			


		} catch (IOException ex) {
			System.out.println("No Images");
		}
	}

	public void draw(Graphics g) {
		switch(shape){
		case SOLID:{
			g.drawImage(image1, (int) getX(), (int) getY(), 100, 100, null);
			//g.drawImage(image2.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case END:{
			if(visible){
			g.drawImage(image2, (int) getX(), (int) getY(), 100, 100, null);
			//g.drawImage(image1.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			}
			break;
			
		}
		
		}

	}

	public void animateOneStep() {
	}



}
