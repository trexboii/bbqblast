package game;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Entity extends Polygon{

	
	protected double height, width;
	
	public static final int boardMin = 0, boardMax = 600;
	
	public Entity(Point[] inShape, Point inPosition,double inRotation) {
		super(inShape, inPosition, inRotation);
		
	}
	
	public boolean checkCollision(Entity other) {
		return false;
	}
	public int[] getXCoordinates() {
		return Arrays.stream(super.getPoints())
				.mapToInt(p -> (int) p.getX())
				.toArray();
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
	
	
	public boolean isXOutOfBounds(double x) {
		if (x > boardMax|| x < boardMin) {
			return true;
		}
		return false;
	}
	
	public boolean isYOutOfBounds(double y) {
		if (y > boardMax|| y < boardMin) {
			return true;
		}
		return false;
	}
}
