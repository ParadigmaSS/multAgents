package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Square;
import control.SquareControl;

public class SquareBoardPanel extends JPanel {

	private static final long serialVersionUID = 7332850110063699836L;

	private SquareControl squareControl;
	private ArrayList<SquarePanel> squarePanelList;

	public SquareBoardPanel() {
		setLayout(new GridBagLayout());
		this.squarePanelList = new ArrayList<SquarePanel>();

		initializeSquareControl();
		initializeGrid();
		initializeCell();
	}

	private void initializeSquareControl() {
		Color colorOne = Color.WHITE;
		Color colorHover = Color.BLUE;
		Color colorSelected = Color.GREEN;

		this.squareControl = new SquareControl(colorOne, colorHover,
				colorSelected);
	}

	private void initializeGrid() {
		GridBagConstraints gridBag = new GridBagConstraints();

		Square square;
		for (int i = 0; i < this.squareControl.getSquareList().size(); i++) {
			square = this.squareControl.getSquareList().get(i);
			gridBag.gridx = square.getPosition().y;
			gridBag.gridy = square.getPosition().x;

			SquarePanel squarePanel = new SquarePanel(square);

			add(squarePanel, gridBag);
			this.squarePanelList.add(squarePanel);
		}
	}
	private void initializeCell() {
		this.squareControl.getSquare(15, 15).setColor(Color.black);
	}
}
