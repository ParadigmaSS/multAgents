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
	
	public char[][] initializeBoard(char[][] board, int width, int height) {
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				board[i][j] = '-';
			}
		}
		return board;
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
