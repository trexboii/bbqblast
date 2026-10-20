package game;

/*
CLASS: YourGameName
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import javax.swing.JOptionPane;
import java.util.Iterator;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import game.Player.Laser;

class BbqBlast extends Game {
	
	static int counter = 0;
	static int score = 0;
	Player Ketchup = new Player(new Point(250,200),0.0);
	private Map<String,Bun> buns = new HashMap<>();
	private int bunNumber=0;
	private ArrayList<Double> yCoorsLeft = new ArrayList<>(Arrays.asList(0.0,75.0,150.0,
			225.0,300.0,375.0,440.0,500.0));
	private ArrayList<Double> usedYCoorsLeft = new ArrayList<>();
	private ArrayList<Double> yCoorsRight = new ArrayList<>(Arrays.asList(0.0,75.0,150.0,
			225.0,300.0,375.0,440.0,500.0));
	private ArrayList<Double> usedYCoorsRight = new ArrayList<>();
	Random random = new Random();
	
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
    	brush.setColor(Color.red);
    	brush.drawString("Counter is " + counter, 10, 30);
    	Ketchup.move();
    	brush2.setStroke(new BasicStroke(3.0f));
    	if(Player.lasers.size() > 0) {
    		for (Laser l1 : Player.lasers) {
    			brush.fillPolygon(l1.getXCoordinates(), l1.getYCoordinates(), l1.getNumPoints());  
    		}
    	}
    	Ketchup.moveLasers();
    	brush.fillPolygon(Ketchup.getXCoordinates(), Ketchup.getYCoordinates(), Ketchup.getNumPoints());
    	brush.setColor(Color.black);
    	brush.setFont(myFont2);
    	brush.drawString("Ketchup", (int)Ketchup.position.getX()+2, (int)Ketchup.position.getY()+70);
    	brush.drawPolyline(Ketchup.getXCoordinates(), Ketchup.getYCoordinates(), Ketchup.getNumPoints());
    	brush.setColor(Color.YELLOW);
    	
    	if(counter%100==0){
    		double side;
    		double yCor;
    		if(random.nextDouble()>0.5 && yCoorsLeft.size()>0) {
    			side = 0.0;
    			int rand = ThreadLocalRandom.current().nextInt(0,yCoorsLeft.size());
    			yCor = yCoorsLeft.get(rand);
    			yCoorsLeft.remove(rand);
    			usedYCoorsLeft.add(yCor);
    			buns.put("bun"+bunNumber, new Bun(new Point(side,yCor),0, bunNumber));
        		bunNumber++;
    			
    		}else if(yCoorsRight.size()>0){
    			side = 460;
    			int rand = ThreadLocalRandom.current().nextInt(0,yCoorsRight.size());
    			yCor = yCoorsRight.get(rand);
    			yCoorsRight.remove(rand);
    			usedYCoorsRight.add(yCor);
    			buns.put("bun"+bunNumber, new Bun(new Point(side,yCor),180.0, bunNumber));
        		bunNumber++;
    		}
    		ArrayList<String> keys = new ArrayList<>(buns.keySet());
    		int rand = ThreadLocalRandom.current().nextInt(0,keys.size());
    		String key = keys.get(rand);
    		buns.get(key).dog.launch();
    	}
    	Iterator<Bun> bunIt = buns.values().iterator();
    	while (bunIt.hasNext()) {
    	    Bun b = bunIt.next();
    	    brush.setColor(Color.YELLOW);
    	    brush.fillPolygon(b.getXCoordinates(), b.getYCoordinates(), b.getNumPoints());
    	    brush.setColor(Color.RED);
    	    brush.fillPolygon(b.getDogXCoordinates(), b.getDogYCoordinates(), b.getDogNumPoints());
    	    b.dog.move();
    	    for(Point point : Ketchup.getPoints()) {
    	    	if(b.dog.contains(point)) {
    	    		 JOptionPane.showMessageDialog(null, "Score: " + score, "Game Over!", JOptionPane.INFORMATION_MESSAGE);
    	    		 System.exit(0);;
    	    	}
    	    	
    	    }

    	    if (b.checkCollision()) {
    	        score += 10;
    	        double y = b.getStartingY();
    	        if (b.getStartingX() == 0.0) {
    	            usedYCoorsLeft.remove(Double.valueOf(y));
    	            if (!yCoorsLeft.contains(y)) {
    	                yCoorsLeft.add(y);
    	            }
    	        } else {
    	            usedYCoorsRight.remove(Double.valueOf(y));
    	            if (!yCoorsRight.contains(y)) {
    	                yCoorsRight.add(y);
    	            }
    	        }
    	        bunIt.remove();
    	    }
    	}
    	
    	
    	
  }
  
	public static void main (String[] args) {
   		BbqBlast a = new BbqBlast();

   		a.repaint();
  }
}