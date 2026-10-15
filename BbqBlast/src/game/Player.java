package game;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class Player extends Entity{
	private int angle;
	public static final Point[] shape = {new Point(25,0), new Point(35,40), new Point(50,40), 
            						new Point(50,100), new Point(0,100), new Point(0,40),
            						new Point(15,40)};
	
	public static Polygon sprite = new Polygon(shape, new Point(275,200), 0);
			
			
	
	public Player(int health, int height, int width){
		super(health, height, width, sprite);
		this.angle = 0;
		
	}
	
	public int getAngle() {
		return angle;
	}
	
	public void rotate(int angle) {
		sprite.rotate(angle);
		this.angle += angle;
		
	}
	
}
