package _03_polymorphs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PolymorphWindow extends JPanel implements ActionListener, MouseListener{
    public static final int WIDTH = 900;
    public static final int HEIGHT = 600;
    
    private JFrame window;
    private Timer timer;
    
    static ArrayList<Polymorph> polies = new ArrayList<Polymorph>();
    static MessageMorph m = new MessageMorph(300,30);
   
    public static void main(String[] args) {
  
   	new PolymorphWindow().buildWindow();
   	polies.add(new RedMorph(10,10));
   	polies.add(new MovingMorph(300,250));
	polies.add(new BluePolymorph(245,75));
   	polies.add(new RedMorph(175,174));
   	polies.add(new CircleMorph(200,200));
   	polies.add(new MouseMorph(20,20));
   	polies.add(new ImageMorph(300,300));
	polies.add(m);
   	
    }
    
    public void buildWindow(){
   	 window = new JFrame("IT'S MORPHIN' TIME!");
   	 window.add(this);
   	 window.getContentPane().setPreferredSize(new Dimension(500, 500));
   	 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	 window.pack();
   	 window.setVisible(true);
   	 window.addMouseListener(m);
  
   	 
   	 timer = new Timer(1000 / 30, this);
   	 timer.start();
    }
    
    public void paintComponent(Graphics g){
    //draw background
   	 g.setColor(Color.LIGHT_GRAY);
   	 g.fillRect(0, 0, 500, 500);
   	
   	 //draw polymorph
   	
   	 for (Polymorph polymorph : polies) {
		polymorph.draw(g);
	}
   	 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   	 repaint();
   	for (Polymorph polymorph : polies) {
		polymorph.update();
	}
   	 
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
