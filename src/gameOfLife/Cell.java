package gameOfLife;

import jade.core.Agent;

public class Cell extends Agent{

	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private char value;

	protected void setup() {

	}

	public Cell(int x,int y, char value) {
		setX(x);
		setY(y);
		setValue(value);
	}

	public void life() {
		Game g = new Game();
		int amount = g.checkNeighbors(getX(), getY());
		if(amount < 2) {
			g.insertCell(getX(), getY(), false);
		} else if(amount == 2 || amount == 3) {
			g.insertCell(getX(), getY(), true);
		} else if(amount > 3) {
			g.insertCell(getX(), getY(), false);
		} else {
			System.out.println("ERRO. Condição de vida inválida.");
		}
	}

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
}
