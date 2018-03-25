package UI;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Game.EventPlanner;
import Game.SaveManager;
import Game.Stats;

public class Frame implements ActionListener, ChangeListener{

	public Stats stats;

	private Gamemenu game;
	private JFrame start; // start screen
	private JFrame pause;
	private JFrame upgrade;
	private JFrame build;
	private int lastX = 0;
	private int lastY = 0;
	private EventPlanner ep;
	private SaveManager saveManager;
	
	
	


	public Frame() throws IOException {
		saveManager = new SaveManager();
        
	}

	public Frame(Stats stats) throws IOException {
		this.stats = stats;
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
				if(Stats.buildings[r][c].toString().equals("e0")) {
					build.setVisible(true);
				}
				else {
					upgrade.setVisible(true);
				}
		}
		int error = 0;
		switch (e.getActionCommand()) {
		case "new game":
			start.setVisible(false);
			stats = new Stats();
			game = new Gamemenu(this, stats);
			game.setVisible(true);
			break;
		case "continue":
			start.setVisible(false);
			stats = saveManager.readSave();
			game = new Gamemenu(this, stats);
			game.setVisible(true);
			game.updateDayButton("Next Day (" + Stats.day + ")"); // Sets text of button to match day
			
			break;
		case "exit":
			game.dispose();
			start.dispose();
			pause.dispose();
			saveManager.writeSave(stats);
			return;

		case "exitMainMenu":
			game.setVisible(false);
			pause.setVisible(false);
			start.setVisible(true);
			saveManager.writeSave(stats);
			return;

		case "resume":
			pause.setVisible(false);
			return;

		case "pause":
			pause.setVisible(true);
			return;

		case "nextDay":
			game.updateDayButton("Next Day (" + Stats.day + ")"); // Sets text of button to match day
			// Other method calling:

			stats.runDay();
			game.histogram.updateData();
			game.updateQueue(ep.runEvent());
			game.updateStatus();
			break;


		case "upgrade":
			int cost = Stats.buildings[lastX][lastY].upgrade(Stats.coins);
			if (cost == -1) {
				game.updateQueue("You dont have enough money to upgrade that building");
			}
			if (cost > 0) {
				Stats.coins -= cost;
				game.grid[lastX][lastY].setIcon(new ImageIcon("Images//" + Stats.buildings[lastX][lastY].toString() + ".png"));
			}
			stats.updateRescources();
			game.updateStatus();
			upgrade.dispose();
			break;


		case "close":
			upgrade.dispose();
			build.dispose();
			return;

		case "0": // A
			error = stats.setBuilding('a', lastX, lastY);
			


			stats.updateRescources();
			game.updateStatus();
			build.setVisible(false);

			break;
		case "1": // C
			
			error = stats.setBuilding('c', lastX, lastY);
			
			stats.updateRescources();
			game.updateStatus();
			build.setVisible(false);

			break;
		case "2": // D
			
			error = stats.setBuilding('d', lastX, lastY);
			
			stats.updateRescources();
			game.updateStatus();
			build.setVisible(false);

			break;
		case "3": // R
		
			error = stats.setBuilding('r', lastX, lastY);
			
			stats.updateRescources();

			game.updateStatus();
			build.setVisible(false);
			break;
		case "4": // S
			error = stats.setBuilding('s', lastX, lastY);
			
			stats.updateRescources();
			game.updateStatus();
			build.setVisible(false);

			break;
		case "5": // E
		case "remove":
			System.out.println("rem");
			error = stats.setBuilding('e', lastX, lastY);
			
			
			stats.updateRescources();
			
			game.updateStatus();
			build.setVisible(false);
			upgrade.setVisible(false);
			break;

		}
		switch (error) {
		case -1:
			game.updateQueue("You dont have enough money to build that");
			break;
		case -2:
			game.updateQueue("You already have a building there, you need to remove it to do this");
			break;
		}
		game.grid[lastX][lastY].setIcon(new ImageIcon("Images//" + Stats.buildings[lastX][lastY].toString() + ".png"));
		for (int r = 0; r < Stats.buildings.length; r++) {
			for (int c = 0; c < Stats.buildings[r].length;  c++) {
				switch(Stats.buildings[r][c].toString().charAt(0)) {
				
					
				}
			}
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
	
	public void createFrame() {
		// --------------Frame Setup-----------------
		//game = new Gamemenu(this, stats); // JFrame
		start = new Startmenu(this); // start screen
		pause = new Pausemenu(this); // pause screen
		upgrade = new Upgrademenu(this);
		build = new Buildmenu(this);
		ep = new EventPlanner(stats);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider slider = (JSlider)e.getSource();
		switch (slider.getValue()) {
		case 0:
			Stats.tax = "Low";
			break;
		case 1:
			Stats.tax = "Medium";
			break;
		case 2:
			Stats.tax = "High";
			break;
		}
		stats.updateRescources();
		game.updateStatus();
	}
}
