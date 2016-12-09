package gameOfLife;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;


public class Cell extends Agent{

	private static final long serialVersionUID = 1L;
	private int x = 0;
	private int y = 0;
	private boolean alive = false;
	private Board board;

	// Constructors.
	public Cell() {
		setX(0);
		setY(0);
		setAlive(false);
		setBoard(null);
	}
	
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
	public void setup(final Board board, final int x, final int y) {
		System.out.println("CÉLULA");
		
		addBehaviour(new CyclicBehaviour(this) {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {
				// TODO Auto-generated method stub
				System.out.println(isAlive(board, x, y));
			}
		});	
		
	}
	// ------------------------------------------------------------------------

	// Logic of life.
		public boolean isAlive(Board board, int x, int y) {
			boolean generation = false;
			
			// Verify all Cells.
			for(int i=0;i<board.getHeight();i++) {
				for(int j=0;j<board.getWidth();j++) {
					// Die of loneliness.
					if(neighborsAlive(board,i,j) < 2) {
						generation = false;
					// Keep be alive.
					} else if((neighborsAlive(board,i,j) == 2) && getAlive() == true) {
						generation = true;
					// Back to live.
					} else if (neighborsAlive(board,i,j) == 3 && getAlive() == true) {
						generation = true;
					} else if ((neighborsAlive(board,i,j) == 3) && getAlive() == false) {
						generation = true;
					// Die of super population.
					} else if (neighborsAlive(board,i,j) > 3) {
						generation = false;
					}
				}
			}
			
			return generation;
		}
		
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
