package model;

import java.awt.Color;
import java.awt.Point;

import javax.swing.text.Position;

public class Cell {
	private Position position;
	private Color color;
	
	public Cell() {
		setPosition(0,0);
		setColor(Color.CYAN);
	}
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public void setPosition(int x, int y) {
		this.position = (Position) new Point(x,y);
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
