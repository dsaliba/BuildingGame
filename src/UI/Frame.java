package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Game.Stats;

public class Frame implements ActionListener {

	private Stats stats;
	public static int dayCount; // temp int

	private Gamemenu game;
	private JFrame start; // start screen
	private JFrame pause;
	private JFrame upgrade;
	private JFrame build;
	private int lastX = -1;
	private int lastY = -1;

	public Frame() {
		game = new Gamemenu(this, stats);
	}

	public Frame(Stats stats) {
		this.stats = stats;
		dayCount = 0;
	}

	public void createFrame() {
		// --------------Frame Setup-----------------
		game = new Gamemenu(this, stats); // JFrame
		start = new Startmenu(this); // start screen
		pause = new Pausemenu(this); // pause screen
		upgrade = new Upgrademenu(this);
		build = new Buildmenu(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton source;
		String coordinate;
		int x;
		int y;
		
		// build.setVisible(true);

		switch (e.getActionCommand()) {
		case "start":
			start.setVisible(false);
			game.setVisible(true);

			break;
		case "exit":
			game.dispose();
			start.dispose();
			pause.dispose();
			break;

		case "exitMainMenu":
			game.setVisible(false);
			pause.setVisible(false);
			start.setVisible(true);
			break;

		case "resume":
			pause.setVisible(false);
			break;

		case "pause":
			pause.setVisible(true);
			break;

		case "nextDay":
			// GUI:
			dayCount++; // increases day (temp)
			game.updateDayButton("Next Day (" + dayCount + ")"); // Sets text of button to match day

			// Other method calling:

			stats.updateRescources();
			break;

		case "buttonPressed":

			build.setVisible(true);
			break;

		case "upgrade":

			break;

		case "build":
			source = (JButton) e.getSource();
			coordinate = source.getText();
			x = coordinate.charAt(0);
			lastX = x - '0';
			y = coordinate.charAt(2);
			lastY = y - '0';
			build.setVisible(true);
			
			break;

		case "remove":

			break;
		case "close":
			upgrade.dispose();
			build.dispose();
			break;

		case "0": // A
			stats.setBuilding('a', lastX, lastY);
			game.updatePlotButton(lastX, lastY);

			break;
		case "1": // C
			
			stats.setBuilding('c', lastX, lastY);
			game.updatePlotButton(lastX, lastY);
			System.out.println("1");

			break;
		case "2": // D
			
			stats.setBuilding('d', lastX, lastY);
			game.updatePlotButton(lastX, lastY);
			System.out.println("2");

			break;
		case "3": // R
		
			stats.setBuilding('r', lastX, lastY);
			game.updatePlotButton(lastX, lastY);

			System.out.println("3");
			break;
		case "4": // S
			stats.setBuilding('s', lastX, lastY);
			game.updatePlotButton(lastX, lastY);
			System.out.println("4");

			break;
		case "5": // E
			stats.setBuilding('a', lastX, lastY);
			game.updatePlotButton(lastX, lastY);

			System.out.println("5");
			break;

		}

	}

	// method that changes icon of row/col button
	public void changeIcon(int row, int col, String image) {
		switch (image) {
		case "tent":
			// JLabel(new ImageIcon(titleScreen)); gamemenu.setlabel(this);
			break;
		}
	}
}
