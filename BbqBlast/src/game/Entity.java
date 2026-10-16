package game;

import java.util.ArrayList;
import java.util.Arrays;

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
	public int[] getXCoordinates() {
		int [] xCoords = Arrays.stream(super.getPoints())
				.mapToInt(p -> (int) p.getX())
				.toArray();
		return xCoords;
	}
	public int[] getYCoordinates() {
		return Arrays.stream(super.getPoints())
				.mapToInt(p -> (int) p.getY())
				.toArray();
	}
	public int getNumPoints() {
		int count = 0;
		for(Point p : super.getPoints()) {
			count++;
		}
		return count;
	}
}
