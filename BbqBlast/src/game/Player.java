package game;

import java.util.ArrayList;

import java.util.List;

public class Player extends Entity{

	public static final Point[] SHAPE = {new Point(25,0), new Point(35,40), new Point(50,40), 
            						new Point(50,100), new Point(0,100), new Point(0,40),
            						new Point(15,40)};

	public Player(int health, Point inPosition, double inRotation) {
		super(health,SHAPE,inPosition,inRotation);
		height = 140;
		width = 65;
	}
	
	public void rotate(int angle) {
		super.rotate(angle);
	}
	
	public void moveHorizontal(double x) {
		double setX = position.getX()+x;
		if (!isXOutOfBounds(setX)) {
			position.setX(position.getX()+x);
		}
	}
	
	public void moveVertical(double y) {
		double setY = position.getY()+y;
		if (!isYOutOfBounds(setY)) {
			position.setY(setY);
		}
	}
}
