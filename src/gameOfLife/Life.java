package gameOfLife;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class Life extends Agent {

	private static final long serialVersionUID = 1L;
	private Cell cell;
	private Board board;
	
	// Constructors.
	public Life() {
		setCell(null);
		setBoard(null);
	}
	public Life(Cell cell, Board board) {
		setCell(cell);
		setBoard(board);
	}
	
// ----------------------------------------------------------------------------
	// Agents
	public void setup() {
		final Board board = new Board(5,5);
		final Cell cell = new Cell();
		addBehaviour(new CyclicBehaviour() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {
				System.out.println("VIDA.");
				cell.setup(board, 5, 5);
				board.printBoard(board);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
// ----------------------------------------------------------------------------
	

	// Getters and Setters.
	public Cell getCell() {
		return cell;
	}
	public void setCell(Cell cell) {
		this.cell = cell;
	}
	
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
}
