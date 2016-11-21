package gameOfLife;

public class Main {

	public static void main(String[] args) {
		Game g = new Game(10,10);
		g.initializeBoard();
		g.printBoard();
		System.out.println(g.isAlive(0,0));
		g.insertCell(0,0,true);
		g.insertCell(0,1,true);
		g.insertCell(1,0,true);
		g.insertCell(1,1,true);
		g.printBoard();
		System.out.println(g.isAlive(0,0));
		System.out.println(g.checkNeighbors(1,1));
		System.out.println(g.checkNeighbors(3,3));
		System.out.println(g.checkNeighbors(0,0));
	}
}
