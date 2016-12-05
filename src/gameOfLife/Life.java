package gameOfLife;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class Life extends Agent {

	private static final long serialVersionUID = 1L;
	private Cell[][] board = null;
	private int width = 20;
	private int height = 20;
	
	// Constructors.
	// Empty.
	public Life() {
		setBoard(null);
	}
	
	public Life(Cell[][] board, int width, int height) {
		setBoard(board);
		setWidth(width);
		setHeight(height);
	}
	
	public Life(int width, int height) {
		setBoard(null);
		setWidth(width);
		setHeight(height);
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
		
//		getBoard()[5][5].setAlive(true);
//		getBoard()[6][5].setAlive(true);
//		getBoard()[7][6].setAlive(true);
//		getBoard()[6][7].setAlive(true);
//		getBoard()[5][7].setAlive(true);
//		getBoard()[4][6].setAlive(true);
//		getBoard()[4][5].setAlive(true);
//		printBoard(getBoard(), getWidth(), getHeight());
//		setBoard(life(getBoard(), getWidth(), getHeight()));
//		printBoard(getBoard(), getWidth(), getHeight());
//		setBoard(life(getBoard(), getWidth(), getHeight()));
//		printBoard(getBoard(), getWidth(), getHeight());
//		// Tests
//		
//		neighborsAlive(board,1,1);		
//		getBoard()[2][2].setAlive(true);
//		printBoard(board, width, height);
//		neighborsAlive(board,1,1);
		
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
					System.out.println("Gneration: " + i++);
					
					for(int k=0;k<getWidth();k++) {
						System.out.print("#");
					} System.out.println();
				}
			});
		} catch (Exception e) {
			System.out.println("ERRO. setup() of Cell.");
		}
		System.out.println("End Life.");
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
					//System.out.println("alive ");
				// Back to live.
				} else if (neighborsAlive(board,i,j) == 3 && board[i][j].getAlive() == true) {
					generation[i][j].setAlive(true);
					//System.out.println("alive ");
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
				System.out.print(showStatus(getBoard()[i][j]) + " ");
			}
			System.out.println();
		}
		// Print any '#'.
		for(int k=0;k<getWidth();k++) {
			System.out.print("#");
		} System.out.println();
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
