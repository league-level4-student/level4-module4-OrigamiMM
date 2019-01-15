package _03_polymorphs;

import java.awt.Color;
import java.awt.Graphics;

public class MessageMorph extends Polymorph MouseListener{

	MessageMorph(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.MAGENTA);
		g.fillRect(this.getX(), this.getY(), this.getwidth(), this.getheight());
	}
	
}
