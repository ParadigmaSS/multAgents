package gameOfLife;

import jade.core.Agent;

public class Cell extends Agent{

	private static final long serialVersionUID = 1L;
	private int x;
	private int y;

	protected void setup() {
		
	}
	
	public void life() {
		Game g = new Game();
		int amount = g.checkNeighbors(getX(), getY());
		if(amount < 2) {
			//Dead
		}
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
