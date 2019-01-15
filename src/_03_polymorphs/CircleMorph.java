package _03_polymorphs;

import java.awt.Color;
import java.awt.Graphics;

public class CircleMorph extends Polymorph{
	int angle = 0;
	CircleMorph(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.DARK_GRAY);
		g.fillRect(this.getX(), this.getY(), this.getwidth(), this.getheight());
	}
	public void update() {
		this.setX((int) (getX() + Math.cos(angle) * 10));
		this.setY((int) (getY() + Math.sin(angle) * 10));
		angle++;
	}

}
