package gameOfLife;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.ThreadedBehaviourFactory;

public class Cell extends Agent{

	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private char value;
	private Game game;

	protected void setup() {
		System.out.println("Agente iniciado.");
		ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();
		Behaviour cell = new MyCyclicBehaviour(this);
		cell.action();
		addBehaviour(tbf.wrap(cell));
	}

	//Comportamento CyclicBehaviour
	class MyCyclicBehaviour extends CyclicBehaviour{
		
		private static final long serialVersionUID = 1L;
		
		public MyCyclicBehaviour(Agent a) {
	        super(a);
	    }
	 
	    public void action() {
			int amount = getGame().checkNeighbors(getX(), getY());
			makeChange(amount);
	    }
	}	
	
	// This method is call only when all cells verify his neighbors. 
	public synchronized void makeChange( int amount) {
		getGame().insertCell(getX(), getY(), life(amount));
	}
	
	public boolean life(int amount) {
		boolean status = false;
		if(getValue() == '-') {
			if(amount == 3) {
				status = true;
			} else {
				status = false;
			}
		} else if (getValue() == '*') { 
			if(amount < 2) {
				status = false;
			} else if(amount == 2 || amount == 3) {
				status = true;
			} else if(amount > 3) {
				status = false;
			} else {
				System.out.println("ERRO. Condição de vida inválida.");
			}
		} else {
			System.out.println("ERRO. Valor da celula em vida inválido.");
		}
		return status;
	}
	
	// Constructor
	public Cell(int x,int y, char value) {
		setX(x);
		setY(y);
		setValue(value);
	}
	public Cell() {
		setX(0);
		setY(0);
		setValue('-');
	}
	
	public Cell(Game game) {
		setGame(game);
	}
	
	public Cell(int x, int y, char value, Game game) {
		setX(x);
		setY(y);
		setValue(value);
		setGame(game);
	}

	// Getters and Setters
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public char getValue() {
		return value;
	}
	public void setValue(char value) {
		if(value == '-' || value == '*') {
			this.value = value;
		} else {
			System.out.println("ERRO, TENTATIVA DE INSERIR VALOR INVÁLIDO.");
		}
	}
	
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
}
