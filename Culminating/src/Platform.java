
 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Platform extends GamePiece{
	private PlatformType shape;
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;

	public Platform(double x, double y, int left, int right, int top, int bottom, PlatformType shape) {
		super(x, y, left, right, top, bottom);
		this.shape = shape;
		try {                
			image1 = ImageIO.read(new File(""));
			image2 = ImageIO.read(new File(""));
			image3 = ImageIO.read(new File(""));


		} catch (IOException ex) {
			System.out.println("No Images");
		}
	}

	public void draw(BufferedImage image) {
		switch(shape){
		case SOLID:{
			image.getGraphics().drawImage(image1, (int) getX(), (int) getY(), 30, 30, null);
			//g.drawImage(image2.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case MOVING:{
			image.getGraphics().drawImage(image2, (int) getX(), (int) getY(), 30, 30, null);
			//g.drawImage(image1.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		case BREAK:{
			image.getGraphics().drawImage(image3, (int) getX(), (int) getY(), 30, 30, null);
			//g.drawImage(image3.getScaledInstance(20, 20, Image.SCALE_DEFAULT), (int) getX(), (int) getY(), null);
			break;
		}
		}

	}

	public void animateOneStep() {
	}



}
