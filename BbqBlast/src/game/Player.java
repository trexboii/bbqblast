package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

public class Player extends Entity implements KeyListener, Moving{

	public static final Point[] SHAPE = {new Point(25,0), new Point(35,40), new Point(50,40),
									new Point(50,70), new Point(50,100),
									new Point(25,100), new Point(0,100), 
									new Point(0, 70), new Point(0,40), 
									new Point(15,40), new Point(25,0)};
	
	public static final double STEP_SIZE = 2;
	
	public boolean moveForward = false, moveBack = false, turnRight = false, turnLeft = false;
	
	public static ArrayList<Laser> lasers;

	public Player(Point inPosition, double inRotation) {
		super(SHAPE,inPosition,inRotation);
		height = 140;
		width = 65;
		lasers = new ArrayList<>();
	}
	
	public void returnToScreen() {
		if(position.getY() >= 560) {
			position.setY(-100);
		}
		else if(position.getY() <= -100) {
			position.setY(560);
		}
		if(position.getX() >= 595) {
			position.setX(-90);
		}
		else if(position.getX() <= -90) {
			position.setX(595);
		}
	}
	
	public void move() {
		if(turnRight) {
			rotate(4);
		}
		if(turnLeft) {
			rotate(-4);
		}
		if(moveForward ) {
			position.setX(position.getX()+5*(Math.sin(Math.toRadians(rotation))));
			position.setY(position.getY()-5*(Math.cos(Math.toRadians(rotation))));
		}
		if(moveBack) {
			position.setX(position.getX()-5*(Math.sin(Math.toRadians(rotation))));
			position.setY(position.getY()+5*(Math.cos(Math.toRadians(rotation))));
		}
		
		returnToScreen();
	}
	

	public void moveLasers() {
		Iterator<Laser> it = lasers.iterator();
		while (it.hasNext()) {
			Laser l1 = it.next();
        	l1.move();
        	if (l1.isOutOfBounds()) {
            it.remove();
        	}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			moveForward = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			moveBack = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			turnLeft = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			turnRight = true;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			moveForward = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			moveBack = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			turnLeft = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			turnRight = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			Laser l1 = new Laser(position, rotation);
			lasers.add(l1);
		}
	}
	
	public class Laser extends Entity implements Moving {
		public static final Point[] SHAPE = {new Point(0,0), new Point(5,25), new Point(-5,25)};
		private int speed;
		
		public Laser(Point position, double rotation) {
			super(SHAPE, position.clone(), rotation);
			speed = 10;
			height = 25;
			width = 3;
			super.position.setX(super.position.getX()+20);
			super.position.setY(super.position.getY()+50);
		}
		public void move() {
			this.position.setX(this.position.getX()+speed*(Math.sin(Math.toRadians(rotation))));
			this.position.setY(this.position.getY()-speed*(Math.cos(Math.toRadians(rotation))));
		}
		
		public boolean isOutOfBounds() {
		    return Entity.isXOutOfBounds(position.getX())
		        || Entity.isYOutOfBounds(position.getY());
		}
	}
}