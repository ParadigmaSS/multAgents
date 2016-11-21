package gameOfLife;

public class Game {
	private int width = 9;
	private int height = 9;
	private char[][] board;

  public Game(int width, int height) {
    setWidth(width);
    setHeight(height);
  }

  // Print all Board.
	public void printBoard() {

    // Print index of colums.
    System.out.print("  ");
    for(int k=0;k <getWidth();k++) {
      System.out.print(k + " ");
    }
    System.out.println();

    // Print matrix.
		for(int i = 0; i < getWidth(); i++) {
			// Print index in lines.
			System.out.print(i + " ");
			for(int j = 0; j < getHeight(); j++) {
        // Get content of board matrix to print it.
        System.out.print(getCell(i,j));
        System.out.print(" ");
			}
			System.out.println(i);
		}
	}

  // Insert value to an cell, where true is an alive cell and false a dead cell.
  public void insertCell(int x, int y, boolean value) {
    char cell = 'x';
    cell = getCell(x,y);
    if (value == true) {
      cell = '*';
    } else {
      cell = '-';
    }
    setCell(x,y,cell);
  }
  // Insert an alive cell for default.
  public void insertCell(int x, int y) {
   setCell(x,y,'*');
  }

  // Verify the status of an cell.
	public boolean isAlive(int x, int y) {
		boolean alive = false;
    char cellValue = 'x';
    cellValue = getCell(x,y);

    if(cellValue == '*') {
      alive = true;
    } else if (cellValue == '-') {
      alive = false;
    } else {
      System.out.println("ERRO, CONTEÚDO DA CELULA INVÁLIDO.");
    }

		return 	alive;
	}
  
  // Initialize matrix with deadCells.
  public void initializeBoard() {
    char[][] matrix =  new char[getWidth()][getHeight()];
    for(int i=0;i<getWidth();i++) {
      for(int j=0;j<getHeight();j++) {
        // Need to create method to set a Cell, dead or alive.
        matrix[i][j] = '-';        
      }
    }
    setBoard(matrix);
  }

	// Return a char of an especif position of matrix.
  public char getCell(int x, int y) {
    return this.board[x][y];
  }
  // Insert the value of dead '-' or alive '*' to a cell.
  public void setCell(int x, int y, char cell) {
    if(cell == '-' || cell == '*') {
      this.board[x][y] = cell;
    } else {
      System.out.println("ERRO, TENTATIVA DE INSERIR VALOR INVÁLIDO.");
    }
  }

  // Return amount of all alive neighbors of an specific cell.
  public int checkNeighbors(int x, int y) {
    int neighborsAmount = 0;
    boolean verifyCell = false;

    verifyCell = isAlive(x-1,y-1);
    if(verifyCell) {
      neighborsAmount++; 
    }
    verifyCell = isAlive(x,y-1);
    if(verifyCell) {
      neighborsAmount++;
    }
    verifyCell = isAlive(x+1,y-1);
    if(verifyCell) {
      neighborsAmount++; 
    }

    verifyCell = isAlive(x-1,y);
    if(verifyCell) {
      neighborsAmount++; 
    }
    verifyCell = isAlive(x,y);
    if(verifyCell) {
      neighborsAmount++;
    }
    verifyCell = isAlive(x+1,y);
    if(verifyCell) {
      neighborsAmount++; 
    }

    verifyCell = isAlive(x-1,y+1);
    if(verifyCell) {
      neighborsAmount++; 
    }
    verifyCell = isAlive(x,y+1);
    if(verifyCell) {
      neighborsAmount++;
    }
    verifyCell = isAlive(x+1,y+1);
    if(verifyCell) {
      neighborsAmount++; 
    }

    return neighborsAmount;
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
