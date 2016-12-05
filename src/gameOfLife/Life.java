package gameOfLife;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class Life extends Agent {

	private static final long serialVersionUID = 1L;
	private Cell[][] board = null;
	private int width = 21;
	private int height = 21;
	
	// Constructors.
	// Empty.
	public Life() {
		setBoard(null);
	}
	
// ----------------------------------------------------------------------------
	// Agents
	public void setup() {
		System.out.println("Begining Life Agent.");
				
		setBoard(initializeBoard(getBoard(),getWidth(), getHeight()));
		printBoard(getBoard(), getWidth(), getHeight());
		getBoard()[2][2].setAlive(true);
		getBoard()[2][3].setAlive(true);
		getBoard()[2][4].setAlive(true);
		
		getBoard()[5][5].setAlive(true);
		getBoard()[5][6].setAlive(true);
		getBoard()[6][7].setAlive(true);
		getBoard()[7][6].setAlive(true);
		getBoard()[7][5].setAlive(true);
		getBoard()[6][4].setAlive(true);
		
		getBoard()[7][7].setAlive(true);
		
		try {
			
			addBehaviour(new CyclicBehaviour(this) {
				Integer i=0;
				@Override
				public void action() {
					// Apply life to cells.
					setBoard(life(getBoard(), getWidth(), getHeight()));
					// Print the result.
					printBoard(getBoard(), getWidth(), getHeight());
					// Sleep for 1 second.
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("                     ##### Gneration: " + i++ + " #####");
				}
			});
		} catch (Exception e) {
			System.out.println("ERRO. setup() of Cell.");
		}
		System.out.println("End Life.");
	}
// ----------------------------------------------------------------------------
	
	// Logic of life.
	public Cell[][] life(Cell[][] board, int width, int height) {
		Cell[][] generation = null;
		generation = initializeBoard(generation, width, height);

		// Verify all Cells.
		for(int i=0;i<height;i++) {
			for(int j=0;j<height;j++) {
				// Die of loneliness.
				if(neighborsAlive(board,i,j) < 2) {
					generation[i][j].setAlive(false);
				// Keep be alive.
				} else if((neighborsAlive(board,i,j) == 2) && board[i][j].getAlive() == true) {
					generation[i][j].setAlive(true);
				// Back to live.
				} else if (neighborsAlive(board,i,j) == 3 && board[i][j].getAlive() == true) {
					generation[i][j].setAlive(true);
				} else if ((neighborsAlive(board,i,j) == 3) && board[i][j].getAlive() == false) {
					generation[i][j].setAlive(true);
				// Die of super population.
				} else if (neighborsAlive(board,i,j) > 3) {
					generation[i][j].setAlive(false);
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
		//if((x > 0 && x < getWidth()) && (y > 0 && y < getHeight())) {
			// Up, left neighbor.
			if(cellX-1 >= 0 && cellY-1 >= 0) {
				neighbor = board[cellX-1][cellY-1];
				if(neighbor.getAlive()) {
					amountOfNeighborsAlive++;
				}
			}
			// Up neighbor.
			if(cellY-1 >= 0) {
				neighbor = board[cellX][cellY-1];
				if(neighbor.getAlive()) {
					amountOfNeighborsAlive++;
				}
			}
			// Up, right neighbor.
			if(cellX+1 < getWidth() && cellY-1 >= 0) {
				neighbor = board[cellX+1][cellY-1];
				if(neighbor.getAlive()) {
					amountOfNeighborsAlive++;
				}
			}
			// Left neighbor.
			if(cellX-1 >= 0) {
				neighbor = board[cellX-1][cellY];
				if(neighbor.getAlive()) {
					amountOfNeighborsAlive++;
				}
			}
			// Right neighbor.
			if(cellX+1 < getWidth()) {
				neighbor = board[cellX+1][cellY];
				if(neighbor.getAlive()) {
					amountOfNeighborsAlive++;
				}
			}
			
			// Down, left neighbor.
			if(cellX-1 >= 0 && cellY+1 < getHeight()) {
				neighbor = board[cellX-1][cellY+1];
				if(neighbor.getAlive()) {
					amountOfNeighborsAlive++;
				}
			}
			// Down neighbor.
			if(cellY+1 < getHeight()) {
				neighbor = board[cellX][cellY+1];
				if(neighbor.getAlive()) {
					amountOfNeighborsAlive++;
				}
			}
			// Down, right neighbor.
			if(cellX+1 < getWidth() && cellY+1 < getHeight()) {
				neighbor = board[cellX+1][cellY+1];
				if(neighbor.getAlive()) {
					amountOfNeighborsAlive++;
				}
			}
		
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
		System.out.print("   ");
		for(int k=0;k<getWidth();k++) {
			if(k<10) {
				System.out.print(k + "  ");
			} else {
				System.out.print(k + " ");
			}
		}
		System.out.println();
		for(int i=0;i<width;i++) {
			if(i<10) {
				System.out.print(i + "  ");
			} else {
				System.out.print(i + " ");
			}
			for(int j=0;j<height;j++) {
				System.out.print(showStatus(getBoard()[i][j]) + "  ");
			}
			System.out.print(" " + i);
			System.out.println();
		}
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
	public Cell[][] getBoard() {
		return board;
	}
	public void setBoard(Cell[][] board) {
		this.board = board;
	}
	
	public int getWidth(){
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
