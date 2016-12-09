package gameOfLife;

public class Board {
	// Attributes.
	private char[][] board = null;
	private int width = 5;
	private int height = 5;
	
	// Constructors.
	public Board() {
		setWidth(5);
		setHeight(5);
	}
	
	public Board(char[][] board, int width, int height) {
		setBoard(board);
		setWidth(width);
		setHeight(height);
	}

	public Board(int width, int height) {
		setBoard(initializeBoard(5, 5));
		setWidth(width);
		setHeight(height);
	}
	
	public char[][] initializeBoard(int width, int height) {
		char[][] board = new char[width][height];
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				board[i][j] = '-';
			}
		}
		return board;
	}
	
	// Print the matrix of cells.
	public void printBoard(Board board) {
		System.out.print("   ");
		for(int k=0;k<board.getWidth();k++) {
			if(k<10) {
				System.out.print(k + "  ");
			} else {
				System.out.print(k + " ");
			}
		}
		System.out.println();
		for(int i=0;i<board.getWidth();i++) {
			if(i<10) {
				System.out.print(i + "  ");
			} else {
				System.out.print(i + " ");
			}
			for(int j=0;j<board.getHeight();j++) {
				System.out.print(board.getBoard()[i][j] + "  ");
			}
			System.out.print(" " + i);
			System.out.println();
		}
	}
	

	// Getters and Setters.
	public char[][] getBoard() {
		return board;
	}
	public void setBoard(char[][] board) {
		this.board = board;
	}
	
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
}
