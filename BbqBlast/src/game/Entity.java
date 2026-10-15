package game;

import java.util.ArrayList;

public abstract class Entity extends Polygon{

	protected int health, width, height;
	
	
	public static final int topBound = 0, bottomBound = 600, leftBound = 0, rightBound = 600;
	
	public Entity(int health, int height, int width, 
			Point[] inShape, Point inPosition,double inRotation) {
		super(inShape,inPosition, inRotation);
		this.health = health;
		this.width = width;
		this.height = height;
	}
	public int getWidth() {
		return width;
	}

	
	public int getHeight() {
		return height;
	}

	public void move(Point p) {}
	
	public boolean checkCollision(Entity other) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
