package gameOfLife;

import jade.core.Agent;

public class Cell extends Agent{

	private static final long serialVersionUID = 1L;
	private int x = 0;
	private int y = 0;
	private boolean alive = false;

	// Constructors.
	// Empty.
	public Cell() {
		setX(0);
		setY(0);
		setAlive(false);
	}
	// Make a dead cell.
	public Cell(int x, int y) {
		setX(x);
		setY(y);
		setAlive(false);
	}
	// Make a cell dead or alive.
	public Cell(int x, int y, boolean alive) {
		setX(x);
		setY(y);
		setAlive(alive);
	}
	
// ----------------------------------------------------------------------------
	// Agents
	public void setup() {
	}
// ----------------------------------------------------------------------------
	// Getters and Setters.
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x  = x; 
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean getAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
