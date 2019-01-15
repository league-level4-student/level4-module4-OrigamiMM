package _03_polymorphs;

import java.awt.Graphics;

public abstract class Polymorph {
    private int x;
    private int y;
    private int width = 50;
	private int height = 50;
	
    Polymorph(int x, int y){
   	 this.x = x;
   	 this.y = y;
    }
    
    public void update(){
   	 
    }
    //x
    public int getX() {
    	return x;
    }
    public void setX(int newX) {
    	this.x = newX;
    }
    //y
    public int getY() {
    	return y;
    }
    public void setY(int newY) {
    	this.y = newY;
    }
  //width
  	public int getwidth() {
  		return width;
  	}
  	public void setwidth(int nWidth) {
  		this.width = nWidth;
  	}
  	//height
  	public int getheight() {
  		return height;
  	}	
  	public void setheight(int nHeight) {
		this.height = nHeight;
	}
	
    
    public abstract void draw(Graphics g);
}
