package gameOfLife;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class Life extends Agent {

	private static final long serialVersionUID = 1L;
	private Cell cells;
	
	// Constructors.
	
// ----------------------------------------------------------------------------
	// Agents
	public void setup() {
		Cell cells = new Cell();
		setCells(cells);
		try {
			System.out.println("Begining Life Agent.");
			addBehaviour(new CyclicBehaviour(this) {
				private static final long serialVersionUID = 1L;
				Integer i=0;
				@Override
				public void action() {
					// Apply life to cells.
					getCells().setBoard(life(getCells().getBoard(), getCells().getWidth(), getCells().getHeight()));
					// Print the result.
					getCells().printBoard(getCells().getBoard(), getCells().getWidth(), getCells().getHeight());
					// Sleep for a time
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("                     ##### Gneration: " + i++ + " #####");
					// Life ends.
					if(i == 78) {
						System.out.println("Vida acabou.");
						doDelete();
					}
				}
			});
		} catch (Exception e) {
			System.out.println("ERRO. setup() of Cell.");
		}
		System.out.println("End Life.");
	}
// ----------------------------------------------------------------------------
	
	// Logic of life.
	public Cell[][] life(Cell[][] board, int width, int height) {
		Cell[][] generation = null;
		generation = getCells().initializeBoard(generation, width, height);

		// Verify all Cells.
		for(int i=0;i<height;i++) {
			for(int j=0;j<height;j++) {
				// Die of loneliness.
				if(getCells().neighborsAlive(board,i,j) < 2) {
					generation[i][j].setAlive(false);
				// Keep be alive.
				} else if((getCells().neighborsAlive(board,i,j) == 2) && board[i][j].getAlive() == true) {
					generation[i][j].setAlive(true);
				// Back to live.
				} else if (getCells().neighborsAlive(board,i,j) == 3 && board[i][j].getAlive() == true) {
					generation[i][j].setAlive(true);
				} else if ((getCells().neighborsAlive(board,i,j) == 3) && board[i][j].getAlive() == false) {
					generation[i][j].setAlive(true);
				// Die of super population.
				} else if (getCells().neighborsAlive(board,i,j) > 3) {
					generation[i][j].setAlive(false);
				}
			}
		}
		
		return generation;
	}

	// Getters and Setters.
	public Cell getCells() {
		return cells;
	}
	public void setCells(Cell cells) {
		this.cells = cells;
	}
}
