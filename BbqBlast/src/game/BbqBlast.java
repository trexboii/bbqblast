package game;

/*
CLASS: YourGameName
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;

import game.Player.Laser;

class BbqBlast extends Game {
	static int counter = 0;
	static int score = 0;
	Player Ketchup = new Player(new Point(250,200),0.0);
	
  public BbqBlast() {
    super("Bbq Blast!",600,600);
    this.setFocusable(true);
	this.requestFocus();
	this.addKeyListener(Ketchup);
  }
  
	public void paint(Graphics brush) {
		Graphics2D brush2 = (Graphics2D) brush;
		Font myFont = new Font("Arial", Font.BOLD, 24);
		Font myFont2 = new Font("Arial", Font.BOLD, 12);
		brush.setFont(myFont);
    	brush.setColor(Color.white);
    	brush.fillRect(0,0,width,height);
    	brush.setColor(Color.black);
    	for (int i = 0 ; i <= 600 ; i += 100) {
    		for (int j = 0 ; j <= 600 ; j += 100) {
    			brush.fillRect(i, j, 50, 50);
    		}
    	}
    	
    	for (int i = 50 ; i <= 600 ; i += 100) {
    		for (int j = 50 ; j <= 600 ; j += 100) {
    			brush.fillRect(i, j, 50, 50);
    		}
    	}
    	
    	// sample code for printing message for debugging
    	// counter is incremented and this message printed
    	// each time the canvas is repainted
    	counter++;
    	brush.setColor(Color.black);
    	brush.drawString("Counter is " + counter, 10, 30);
    	brush.setColor(Color.red);
    	Ketchup.move();
    	brush2.setStroke(new BasicStroke(3.0f));
    	if(Ketchup.lasers.size() > 0) {
    		for (Laser l1 : Ketchup.lasers) {
    			brush.fillPolygon(l1.getXCoordinates(), l1.getYCoordinates(), l1.getNumPoints());
    			System.out.println(l1.position.getX());
    			System.out.println(l1.position.getY());
    		}
    	}
    	Ketchup.moveLasers();
    	brush.fillPolygon(Ketchup.getXCoordinates(), Ketchup.getYCoordinates(), Ketchup.getNumPoints());
    	brush.setColor(Color.black);
    	brush.setFont(myFont2);
    	brush.drawString("Ketchup", (int)Ketchup.position.getX()+2, (int)Ketchup.position.getY()+70);
    	brush.drawPolyline(Ketchup.getXCoordinates(), Ketchup.getYCoordinates(), Ketchup.getNumPoints());
  }
  
	public static void main (String[] args) {
   		BbqBlast a = new BbqBlast();

   		a.repaint();
  }
}