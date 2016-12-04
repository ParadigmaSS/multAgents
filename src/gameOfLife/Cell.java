package gameOfLife;

import jade.core.Agent;

public class Cell extends Agent{
	/**
	 * 
	 */
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
		System.out.println("Method setup started.");
		
		Cell[][] board = null;
		int width = 9;
		int height = 9;

		board = initializeBoard(board, width, height);
		printBoard(board, width, height);
		board[2][2].setAlive(true);
		board[2][3].setAlive(true);
		board[2][4].setAlive(true);
		printBoard(board, width, height);
		board = life(board,width, height);
		printBoard(board, width, height);
		board = life(board,width, height);
		printBoard(board, width, height);
		// Tests
		/*
		* neighborsAlive(board,1,1);		
		* board[2][2].setAlive(true);
		* printBoard(board, width, height);
		* neighborsAlive(board,1,1);
		*/
		try {
			
		} catch (Exception e) {
			System.out.println("ERRO. setup() of Cell.");
		}
		System.out.println("End of setup.");
	}
// ----------------------------------------------------------------------------
	// Life.
	public Cell[][] life(Cell[][] board, int width, int height) {
		Cell[][] generation = null;
		generation = initializeBoard(generation, width, height);
		
		for(int i=0;i<height;i++) {
			for(int j=0;j<height;j++) {
				//System.out.println(i + " " + j);
				// Die of loneliness.
				if(neighborsAlive(board,i,j) < 2) {
					generation[i][j].setAlive(false);
					//System.out.print("<2 ");
				// Keep be alive.
				} else if((neighborsAlive(board,i,j) == 2) && board[i][j].getAlive() == true) {
					generation[i][j].setAlive(true);
					System.out.println("alive ");
				// Back to live.
				} else if (neighborsAlive(board,i,j) == 3 && board[i][j].getAlive() == true) {
					generation[i][j].setAlive(true);
					System.out.println("alive ");
				} else if ((neighborsAlive(board,i,j) == 3) && board[i][j].getAlive() == false) {
					generation[i][j].setAlive(true);
					//System.out.println("Respaw ");
				// Die of super population.
				} else if (neighborsAlive(board,i,j) > 3) {
					generation[i][j].setAlive(false);
					//System.out.println(">3 ");
				// Erro.
				} else {
					//System.out.println(neighborsAlive(board, i, j));
					//System.out.println(i + " " + j);
					//System.out.println("ERRO. Life not working well.");
				}
			}
		}
		return generation;
	}
	// Return the amount of neighbors alive.	
	public int neighborsAlive(Cell[][] board, int x, int y) {
		int amountOfNeighborsAlive = 0;
		
		// Get the position of current cell.
		int cellX = board[x][y].getX();
		int cellY = board[x][y].getY();
		
		// Cell aux to check if the neighbor is alive.
		Cell neighbor = null;
		if((x > 0 && x < 8) && (y > 0 && y < 8)) {
			// Up, left neighbor.
			neighbor = board[cellX-1][cellY-1];
			if(neighbor.getAlive()) {
				amountOfNeighborsAlive++;
			}
			// Up neighbor.
			neighbor = board[cellX][cellY-1];
			if(neighbor.getAlive()) {
				amountOfNeighborsAlive++;
			}
			// Up, right neighbor.
			neighbor = board[cellX+1][cellY-1];
			if(neighbor.getAlive()) {
				amountOfNeighborsAlive++;
			}
			
			// Left neighbor.
			neighbor = board[cellX-1][cellY];
			if(neighbor.getAlive()) {
				amountOfNeighborsAlive++;
			}
			// Right neighbor.
			neighbor = board[cellX+1][cellY];
			if(neighbor.getAlive()) {
				amountOfNeighborsAlive++;
			}
			
			// Down, left neighbor.	
			neighbor = board[cellX-1][cellY+1];
			if(neighbor.getAlive()) {
				amountOfNeighborsAlive++;
			}
			// Down neighbor.
			neighbor = board[cellX][cellY+1];
			if(neighbor.getAlive()) {
				amountOfNeighborsAlive++;
			}
			// Down, right neighbor.
			neighbor = board[cellX+1][cellY+1];
			if(neighbor.getAlive()) {
				amountOfNeighborsAlive++;
			}
		} else {
			//System.out.println("Dont verifyng edges.");
		}
		
		// Verification.
		//System.out.println("Neighbors alive of cell: " 
		//+ board[x][y].getX() + "," + board[x][y].getX() + " = " + amountOfNeighborsAlive);
		
		return amountOfNeighborsAlive;
	}

	// Create a matrix of dead Cells. 
	public Cell[][] initializeBoard(Cell[][] board, int width, int height) {
		board = new Cell[width][height];
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				board[i][j] = new Cell(i,j);
			}
		}
		return board;
	}
	
	// Print the matrix of cells.
	public void printBoard(Cell[][] board, int width, int height) {
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				System.out.print(showStatus(board[i][j]) + " ");
			}
			System.out.println();
		}
		System.out.println("#################");
	}
	
	// If cell is alive print '*' if cell is dead print '-'.
	public char showStatus(Cell cell) {
		char status = ' ';
		
		if(cell.getAlive()) {
			status = '*';
		} else if (!cell.getAlive()) {
			status = '-';
		} else {
			System.out.println("ERRO. Status of cell wrong.");
		}
		
		return status;
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
