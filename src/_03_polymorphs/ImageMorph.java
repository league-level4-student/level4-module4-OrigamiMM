package _03_polymorphs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageMorph extends Polymorph {
BufferedImage image;
	ImageMorph(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		try {
			image = ImageIO.read(this.getClass().getResourceAsStream("icon.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.ORANGE.brighter());
		//g.fillRect(this.getX(), this.getY(), this.getwidth(), this.getheight());
		g.drawImage(image, this.getX(), this.getY(), this.getwidth(), this.getheight(), null);
	}

}
