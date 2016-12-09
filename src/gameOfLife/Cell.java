package gameOfLife;

import jade.core.Agent;


public class Cell extends Agent{

	private static final long serialVersionUID = 1L;
	private int x = 0;
	private int y = 0;
	private boolean alive = false;
	private Board board;

	// Constructors.
	public Cell(int x, int y) {
		setX(x);
		setY(y);
		setAlive(false);
	}
	
	public Cell(int x, int y, boolean alive) {
		setX(x);
		setY(y);
		setAlive(alive);		
	}

	// ------------------------------------------------------------------------
	public void setup(Board board, int x, int y) {
		neighborsAlive(board, x, y);
	}
	// ------------------------------------------------------------------------
	
	// Return the amount of neighbors alive.	
	public int neighborsAlive(Board field, int x, int y) {
		
		char[][] board = field.getBoard();
		int width = field.getWidth();
		int height = field.getHeight();

		int amountOfNeighborsAlive = 0;
		char neighbor = ' ';
		// Up, left neighbor.
		if(x-1 >= 0 && y-1 >= 0) {
			neighbor = board[x-1][y-1];
			if(neighbor == '-') {
				amountOfNeighborsAlive++;
			}
		}
		// Up neighbor.
		if(y-1 >= 0) {
			neighbor = board[x][y-1];
			if(neighbor == '-') {
				amountOfNeighborsAlive++;
			}
		}
		// Up, right neighbor.
		if(x+1 < width && y-1 >= 0) {
			neighbor = board[x+1][y-1];
			if(neighbor == '-') {
				amountOfNeighborsAlive++;
			}
		}
		// Left neighbor.
		if(x-1 >= 0) {
			neighbor = board[x-1][y];
			if(neighbor == '-') {
				amountOfNeighborsAlive++;
			}
		}
		// Right neighbor.
		if(x+1 < width) {
			neighbor = board[x+1][y];
			if(neighbor == '-') {
				amountOfNeighborsAlive++;
			}
		}
		
		// Down, left neighbor.
		if(x-1 >= 0 && y+1 < height) {
			neighbor = board[x-1][y+1];
			if(neighbor == '-') {
				amountOfNeighborsAlive++;
			}
		}
		// Down neighbor.
		if(y+1 < height) {
			neighbor = board[x][y+1];
			if(neighbor == '-') {
				amountOfNeighborsAlive++;
			}
		}
		// Down, right neighbor.
		if(x+1 < width && y+1 < height) {
			neighbor = board[x+1][y+1];
			if(neighbor == '-') {
				amountOfNeighborsAlive++;
			}
		}
		
		return amountOfNeighborsAlive;
	}

	// ------------------------------------------------------------------------
		
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
	
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
}
