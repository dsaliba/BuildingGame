package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.sun.xml.internal.ws.policy.spi.AbstractQNameValidator;

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

		if(e.getActionCommand().contains("tile")) {
			String id = e.getActionCommand().substring(4);
				int pipe = id.indexOf("|");
				int r = Integer.parseInt(id.substring(0, pipe));
				int c = Integer.parseInt(id.substring(pipe+1, id.length()));
				lastX = r;
				lastY = c;
				if(stats.buildings[r][c].toString().equals("e0")) {
					build.setVisible(true);
				}
				else {
					upgrade.setVisible(true);
				}
		}
		
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

			stats.runDay();
			game.updateStatus();
			break;


		case "upgrade":
			double cost = stats.buildings[lastX][lastY].upgrade(stats.coins);
			System.out.println(cost);
			if (cost > 0) {
				stats.coins -= cost;
				game.updatePlotButton(lastX, lastY, stats.buildings[lastX][lastY].toString(), 0);
			}
			stats.updateRescources();
			game.updateStatus();
			break;


		case "close":
			upgrade.dispose();
			build.dispose();
			break;

		case "0": // A
			stats.setBuilding('a', lastX, lastY);
			game.updatePlotButton(lastX, lastY, stats.buildings[lastX][lastY].toString(), 0);
			stats.updateRescources();
			game.updateStatus();
			build.setVisible(false);

			break;
		case "1": // C
			
			stats.setBuilding('c', lastX, lastY);
			game.updatePlotButton(lastX, lastY, stats.buildings[lastX][lastY].toString(), 0);
			stats.updateRescources();
			game.updateStatus();
			build.setVisible(false);

			break;
		case "2": // D
			
			stats.setBuilding('d', lastX, lastY);
			game.updatePlotButton(lastX, lastY, stats.buildings[lastX][lastY].toString(), 0);
			stats.updateRescources();
			game.updateStatus();
			build.setVisible(false);

			break;
		case "3": // R
		
			stats.setBuilding('r', lastX, lastY);
			game.updatePlotButton(lastX, lastY, stats.buildings[lastX][lastY].toString(), 2);
			stats.updateRescources();

			game.updateStatus();
			build.setVisible(false);
			break;
		case "4": // S
			stats.setBuilding('s', lastX, lastY);
			game.updatePlotButton(lastX, lastY, stats.buildings[lastX][lastY].toString(), 1);
			stats.updateRescources();
			game.updateStatus();
			build.setVisible(false);

			break;
		case "5": // E
		case "remove":
			System.out.println("rem");
			stats.setBuilding('e', lastX, lastY);
			
			game.updatePlotButton(lastX, lastY, stats.buildings[lastX][lastY].toString(), 3);
			stats.updateRescources();
			
			game.updateStatus();
			build.setVisible(false);
			upgrade.setVisible(false);
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
