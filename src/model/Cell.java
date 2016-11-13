package model;

import java.awt.Color;
import java.awt.Point;

import javax.swing.text.Position;

public class Cell {
	private Point position;
	private Color color;
	
	public Cell() {
		setPosition(0,0);
		setColor(Color.CYAN);
	}
	
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	public void setPosition(int x, int y) {
		this.position = new Point(x,y);
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
