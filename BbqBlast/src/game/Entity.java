package game;

import java.util.ArrayList;

public class Entity implements GameElement{

	protected int health, width, height;
	protected ArrayList<Polygon> sprite;
	
	public static final int topBound = 0, bottomBound = 600, leftBound = 0, rightBound = 600;
	
	public Entity(int health, int height, int width, ArrayList<Polygon> sprite) {
		this.health = health;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
	}
	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkCollision(Entity other) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
