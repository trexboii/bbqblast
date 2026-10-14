package game;

import java.util.ArrayList;

import java.util.List;

public class Player extends Entity{
	private int angle;
	private static Point[] shape = {new Point(25,0), new Point(35,40), new Point(50,40), 
            						new Point(50,100), new Point(0,100), new Point(0,40),
            						new Point(15,40)};
	
	private static ArrayList<Polygon> sprite = new ArrayList<>(List.of(
			new Polygon(shape, new Point(25,50), 90)));
	
	public Player(int health, int height, int width) {
		super(health, height, width, sprite);
		this.angle = 90;
	}
	
	public int getAngle() {
		return angle;
	}
	
	public void rotate(int angle) {
		for(Polygon shape : sprite) {
			shape.rotate(angle);
		}
		this.angle += angle;
		
	}
}
