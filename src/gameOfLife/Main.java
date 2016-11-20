package gameOfLife;

public class Main {

	public static void main(String[] args) {
		Game g = new Game();
		//b.printBoard();
    //System.out.println();
    g.initializeBoard();
		g.printBoard();
    System.out.println(g.isAlive(0,0));
    g.insertCell(0,0,true);
    g.printBoard();
    System.out.println(g.isAlive(0,0));
	}
}
