package game;

import java.util.ArrayList;

import java.util.List;

public class Player extends Entity{
	private int angle;
	private static Point[] shape = {new Point(25,0), new Point(35,40), new Point(50,40), 
            						new Point(50,100), new Point(0,100), new Point(0,40),
            						new Point(15,40)};
	private static Point inPosition;
	private static double inRotation;
	private static final double STEP_SIZE = 5;
	
	public Player(int health, int height, int width, Point inPosition, double inRotation) {
		super(health, height, width,shape,inPosition,inRotation);
		this.inPosition = inPosition;
		this.inRotation = inRotation;
		this.angle = 90;
	}
	
	public int getAngle() {
		return angle;
	}
	
	public void rotate(int angle) {
		//TODO unimplemented. take input angle 
	}
	public void moveRight() {
		for (Point p : shape) {
			p.setX(p.getX()+STEP_SIZE);
		}
	}
	public void moveLeft() {
		for (Point p : shape) {
			p.setX(p.getX()-STEP_SIZE);
		}
		
	}
	public void moveUp() {
		for (Point p : shape) {
			p.setY(p.getY()+STEP_SIZE);
		}
		
	}
	public void moveDown() {
		for (Point p : shape) {
			p.setY(p.getY()-STEP_SIZE);
		}
	}
}
