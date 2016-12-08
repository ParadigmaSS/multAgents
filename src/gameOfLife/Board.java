package gameOfLife;

public class Board {
	// Attributes.
	private char[][] board = null;
	private char status = ' ';
	private int width = 5;
	private int height = 5;
	
	// Constructors.
	public Board() {
		setStatus('x');
		setWidth(5);
		setHeight(5);
	}
	
	// Getters and Setters.
	public char[][] getBoard() {
		return board;
	}
	public void setBoard(char[][] board) {
		this.board = board;
	}
	
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
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
