package gameOfLife;

public class Main {

	public static void main(String[] args) {
		Game g = new Game(10,10);
		g.initializeBoard();
		g.printBoard();
		Cell cell = new Cell();
		cell.setup();
		System.out.println("Saiu do Ciclo.");
	}
}
