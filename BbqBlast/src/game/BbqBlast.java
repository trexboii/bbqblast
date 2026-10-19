package game;

/*
CLASS: YourGameName
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class BbqBlast extends Game {
	static int counter = 0;
	static int score = 0;
	static Player Ketchup = new Player(100,new Point(250,200),0.0);
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
    	brush.setColor(Color.YELLOW);
    	if(counter%200==0){
    		double side;
    		double yCor;
    		if(random.nextDouble()>0.5 && yCoorsLeft.size()>0) {
    			side = 0.0;
    			int rand = ThreadLocalRandom.current().nextInt(0,yCoorsLeft.size());
    			yCor = yCoorsLeft.get(rand);
    			yCoorsLeft.remove(rand);
    			usedYCoorsLeft.add(yCor);
    			buns.put("bun"+bunNumber, new Bun(100,new Point(side,yCor),0));
        		bunNumber++;
    			
    		}else if(yCoorsRight.size()>0){
    			side = 460;
    			int rand = ThreadLocalRandom.current().nextInt(0,yCoorsRight.size());
    			yCor = yCoorsRight.get(rand);
    			yCoorsRight.remove(rand);
    			usedYCoorsRight.add(yCor);
    			buns.put("bun"+bunNumber, new Bun(100,new Point(side,yCor),180.0));
        		bunNumber++;
    		}
    		ArrayList<String> keys = new ArrayList<>(buns.keySet());
    		int rand = ThreadLocalRandom.current().nextInt(0,keys.size());
    		String key = keys.get(rand);
    		System.out.println(key);
    		buns.get(key).dog.launch();
    	}
    	for (Bun b : buns.values()) {
    		brush.setColor(Color.YELLOW);
    		brush.fillPolygon(b.getXCoordinates(),b.getYCoordinates(),b.getNumPoints());
    		brush.setColor(Color.RED);
    		brush.fillPolygon(b.getDogXCoordinates(),
    				b.getDogYCoordinates(),b.getDogNumPoints());
    		b.dog.move();
    	}
    	
    	
  }
  
	public static void main (String[] args) {
   		BbqBlast a = new BbqBlast();

   		a.repaint();
  }
}