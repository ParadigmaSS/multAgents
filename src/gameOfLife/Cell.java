package gameOfLife;

import jade.core.Agent;

public class Cell extends Agent{
	private int x = 0;
	private int y = 0;
	private boolean alive = false;

	// Constructors.
	// Make a dead cell.
	public Cell(int x, int y) {
		setX(x);
		setY(y);
	}
	// Make a cell dead or alive.
	public Cell(int x, int y, boolean alive) {
		setX(x);
		setY(y);
		setAlive(alive);
	}
	
	// Agents
	public void setup() {
		try {
			
		} catch (Exception e) {
			System.out.println("ERRO. setup() of Cell.");
		}
	}
	
	// Return the amount of neighbors alive.	
	public int neighborsAlive(Cell cell) {
		int amountOfNeighborsAlive = 0;
		
		// Get the position of current cell.
		int cellX = cell.getX();
		int cellY = cell.getY();
		
		// Cell aux to check if the neighbor is alive.
		Cell neighbor;
		
		// Up, left neighbor.	
		neighbor = new Cell(cellX-1, cellY-1);
		if(neighbor.getAlive()) {
			amountOfNeighborsAlive++;
		}
		// Up neighbor.
		neighbor = new Cell(cellX, cellY-1);
		if(neighbor.getAlive()) {
			amountOfNeighborsAlive++;
		}
		// Up, right neighbor.
		neighbor = new Cell(cellX+1, cellY-1);
		if(neighbor.getAlive()) {
			amountOfNeighborsAlive++;
		}
		
		// Left neighbor.
		neighbor = new Cell(cellX-1, cellY);
		if(neighbor.getAlive()) {
			amountOfNeighborsAlive++;
		}
		// Right neighbor.
		neighbor = new Cell(cellX+1, cellY);
		if(neighbor.getAlive()) {
			amountOfNeighborsAlive++;
		}
		
		// Down, left neighbor.	
		neighbor = new Cell(cellX-1, cellY+1);
		if(neighbor.getAlive()) {
			amountOfNeighborsAlive++;
		}
		// Down neighbor.
		neighbor = new Cell(cellX, cellY+1);
		if(neighbor.getAlive()) {
			amountOfNeighborsAlive++;
		}
		// Down, right neighbor.
		neighbor = new Cell(cellX+1, cellY+1);
		if(neighbor.getAlive()) {
			amountOfNeighborsAlive++;
		}
		
		System.out.println("Neighbors alive of cell: " 
		+ cell.getX() + " " + getY() + " = " + amountOfNeighborsAlive);
		
		return amountOfNeighborsAlive;
	}


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
