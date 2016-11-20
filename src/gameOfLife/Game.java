package gameOfLife;

public class Game {
	private int width = 9;
	private int height = 9;
	private char[][] board;
	
	public void printBoard() {
    char aux;
		for(int i = 0; i < getWidth(); i++) {
			// Print index in lines.
			System.out.print(i + " ");
			for(int j = 0; j < getHeight(); j++) {
        // Get content of board matrix to print it.
        aux = getSingleSquare(i,j);
        System.out.print(aux);
			}
			System.out.println(" " + i);
		}
	}
	
	public boolean isAlive(int x, int y) {
		boolean alive = false;
    // Content of matrix == * then true.
		return 	alive;
	}
	
  // Return amount of all alive neighbors of an specific cell.
	public int checkNeighbors(int x, int y) {
		int neighborsAmount = 0;
		//if(x-1 ==)
		return neighborsAmount;
	}
  
  // Initialize matrix with deadCells.
  public void initializeBoard() {
    char[][] matrix =  new char[getWidth()][getHeight()];
    for(int i=0;i<getWidth();i++) {
      for(int j=0;j<getHeight();j++) {
        matrix[i][j] = '-';        
      }
    }
    setBoard(matrix);
  }
	// Return a char of an especif position of matrix.
  public char getSingleSquare(int x, int y) {
    return this.board[x][y];
  }

  // Getters and Setters.
	public int getWidth() {
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
  
  public char[][] getBoard() {
    return board;
  }
  public void setBoard(char[][] board) {
    this.board = board;
  }
}
