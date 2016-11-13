package model;

import java.awt.Color;

public class Cell {
	private Color color;
	
	public Cell() {
		setColor(Color.CYAN);
	}
	public Cell (Color color) {
		setColor(color);
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
