package game;

public interface GameElement {
	
	public int getWidth();
	
	public int getHeight();
	
	public void move(int x, int y);
	
	public boolean checkCollision(Entity other);
}
