package _03_polymorphs;

import java.awt.Color;
import java.awt.Graphics;

public class MovingMorph extends Polymorph{
	private int xSpeed = 3;
	private int ySpeed = 3;
	
	MovingMorph(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void update() {
		this.setX(this.getX()+xSpeed);
		this.setY(this.getY()+ySpeed);
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green);
		g.fillRect(this.getX(), this.getY(), this.getwidth(), this.getheight());
	}

}
