package _03_polymorphs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;

public class MouseMorph extends Polymorph{

	MouseMorph(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.ORANGE);
		g.fillRect(this.getX(), this.getY(), this.getwidth(), this.getheight());
	}
	
	public void update() {
		this.setX(MouseInfo.getPointerInfo().getLocation().x);
		this.setY(MouseInfo.getPointerInfo().getLocation().y);
	}

}
