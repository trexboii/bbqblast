package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import game.Player.Laser;

public class Player extends Entity implements KeyListener{

	public static final Point[] SHAPE = {new Point(25,0), new Point(35,40), new Point(50,40), 
            						new Point(50,100), new Point(0,100), new Point(0,40),
            						new Point(15,40), new Point(25,0)};
	
	public static final double STEP_SIZE = 2;
	
	public boolean moveForward = false, moveBack = false, turnRight = false, turnLeft = false;
	
	public ArrayList<Player.Laser> lasers;

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

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			this.lasers.add(this.new Laser());
		}
		
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
	}
	
	public class Laser extends Entity implements Projectile {
		public static final Point[] SHAPE = {new Point(0,0), new Point(0,25)};
		private int speed;
		
		public Laser() {
			super(SHAPE, Player.this.position, Player.this.rotation);
			speed = 10;
		}
		public void move() {
			position.setX(position.getX()+speed*(Math.sin(Math.toRadians(rotation))));
			position.setY(position.getY()-speed*(Math.cos(Math.toRadians(rotation))));
			position.setX(position.getX()-speed*(Math.sin(Math.toRadians(rotation))));
			position.setY(position.getY()+speed*(Math.cos(Math.toRadians(rotation))));
		}

		@Override
		public void delete() {
			
		}
		
	}

}
