package gameOfLife;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class Life extends Agent {

	private static final long serialVersionUID = 1L;
	private Cell cell;
	private Board board;
	
	// Constructors.
	
// ----------------------------------------------------------------------------
	// Agents
	public void setup() {
		addBehaviour(new CyclicBehaviour() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {	
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
