package game;

public class Bun extends Entity{
	
	private double startingY;
	private double startingX;
	public static final Point[] SHAPE = {
		    new Point(25, 0),    new Point(0, 12),    new Point(0, 37), 
		    new Point(0, 37),    new Point(25, 50),   new Point(100, 50),
		    new Point(125, 37),  new Point(125, 37), 
		    new Point(125, 12),  new Point(100, 0)
		};
	public HotDog dog;
	private final double SPEED = 8;
	public Bun(Point inPosition, double inRotation) {
		super(SHAPE,inPosition,inRotation);
		Point dogPos = new Point(inPosition.getX()+10,inPosition.getY()+12);
		dog = new HotDog(dogPos,inRotation);
		height = 140;
		width = 65;
		startingY = inPosition.getY();
		startingX = inPosition.getX();
	}
	public double getStartingY() {
		return startingY;
	}
	
	public void rotate(int angle) {
		super.rotate(angle);
	}
	
	public int[] getDogXCoordinates() {
		return dog.getXCoordinates();
	}
	public int[] getDogYCoordinates() {
		return dog.getYCoordinates();
	}
	public int getDogNumPoints() {
		return dog.getNumPoints();
	}
	class HotDog extends Entity implements Projectile{
		private boolean launch;
		public static final Point[] SHAPE = {
				new Point(12, 12), new Point(112, 12),
			    new Point(112, 37), new Point(12, 37)
			};
		public HotDog(Point inPosition, double inRotation) {
			super(SHAPE,inPosition,inRotation);
			height = 140;
			width = 65;
		}
		public void reset() {
			this.position.setX(startingX+10);
		}
		public void launch() {
			launch = true;
		}
		private boolean isOnScreen() {
			if(this.position.getX()>-200 && this.position.getX()<800) {
				return true;
			}
			return false;
		}
		public void move() {
			if(launch && isOnScreen()) {
				double currX = this.position.getX();
				if(startingX==0.0) {
					this.position.setX(currX+SPEED);
					currX+=SPEED;
				}else {
					this.position.setX(currX-SPEED);
					currX-=SPEED;
				}
			}
			else {
				launch = false;
				reset();
			}
		}
		
		public void delete() {
			
			
		}
		
	}
}
