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
		final Cell cell = new Cell(1,1,true);
		board.setBoard(setStatus(board, cell.getX(),cell.getY(), cell.getAlive()));
		cell.setup(board, 5, 5);
		final Cell cell2 = new Cell(2,2,true);
		board.setBoard(setStatus(board, cell2.getX(),cell2.getY(), cell2.getAlive()));
		addBehaviour(new CyclicBehaviour() {
			
			private static final long serialVersionUID = 1L;
			int i=0;
			@Override
			public void action() {
				System.out.println("----------GERAÇÃO " + i++ + "----------");
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
	
	public char[][] setStatus(Board board,int x, int y, boolean status) {
		char[][] field = board.getBoard();
		if(status) {
			field[x][y] = '*';
		} else {
			field[x][y] = '-';
		}
		return field;
	}
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
