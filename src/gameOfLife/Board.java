package gameOfLife;

public class Board {
	private int width = 9;
	private int height = 9;
	
	public void printBoard() {
		for(int i = 0; i < getWidth(); i++) {
			// Print index in lines
			System.out.print(i + " ");
			for(int j = 0; j < getHeight(); j++) {
				//sprintDeadCell();
				printAliveCell();
			}
			System.out.println();
		}
	}
	//Print "-" that means DEAD.	
	public void printDeadCell() {
		System.out.print("-" + " ");
	}
	
	//Print "*" that means ALIVE.
	public void printAliveCell() {
		System.out.print("*" + " ");
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
