package gameOfLife;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;


public class Cell extends Agent{

	private static final long serialVersionUID = 1L;
	private int x = 0;
	private int y = 0;
	private boolean alive = false;
	private Cell[][] board = null;
	private int width = 21;
	private int height = 21;

	// Constructors.
	// Empty.
	public Cell() {
		setup();
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
	// ------------------------------------------------------------------------
	public void setup() {
		System.out.println("Begining Cell Agent.");
		Cell[][] board = null;
		setBoard(initializeBoard(board,getWidth(), getHeight()));
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
		addBehaviour(new CyclicBehaviour(this) {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {
				// Sleep for a time
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int neighborsValue;
				neighborsValue =  neighborsAlive(getBoard(), 1, 1);
				//JOptionPane.showMessageDialog(null, neighborsValue);
				System.out.println(neighborsValue);
				
			}
		});
	}
	
	// ------------------------------------------------------------------------	
	// Return the amount of neighbors alive.	
		public int neighborsAlive(Cell[][] board, int x, int y) {
			int amountOfNeighborsAlive = 0;
			
			// Get the position of current cell.
			int cellX = getBoard()[x][y].getX();
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
