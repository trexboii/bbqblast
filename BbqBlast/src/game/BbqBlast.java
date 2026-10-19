package game;

/*
CLASS: YourGameName
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;

class BbqBlast extends Game {
	static int counter = 0;
	static int score = 0;
	static Player Ketchup = new Player(100,new Point(250,200),0.0);
	
  public BbqBlast() {
    super("Bbq Blast!",600,600);
    this.setFocusable(true);
	this.requestFocus();
	this.addKeyListener(Ketchup);
  }
  
	public void paint(Graphics brush) {
    	brush.setColor(Color.black);
    	brush.fillRect(0,0,width,height);
    	
    	// sample code for printing message for debugging
    	// counter is incremented and this message printed
    	// each time the canvas is repainted
    	counter++;
    	brush.setColor(Color.white);
    	brush.drawString("Counter is " + counter, 10, 10);
    	brush.setColor(Color.red);
    	Ketchup.move();
    	brush.fillPolygon(Ketchup.getXCoordinates(), Ketchup.getYCoordinates(), Ketchup.getNumPoints());
    	System.out.println(Ketchup.position.getX() + " " + Ketchup.position.getY());
    	
  }
  
	public static void main (String[] args) {
   		BbqBlast a = new BbqBlast();

   		a.repaint();
  }
}