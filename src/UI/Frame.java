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
	private Upgrademenu upgrade;
	private JFrame build;
	private int lastX = 0;
	private int lastY = 0;
	private EventPlanner ep;
	private SaveManager saveManager;
	private int error;
	
	
	


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
				if(Stats.buildings.get(r).get(c).toString().equals("e0")) {
					build.setVisible(true); ///buildshit
				}
				else {
					upgrade.setPrice(Stats.buildings.get(r).get(c));
					upgrade.setVisible(true);
				}
		}
		error = 0;
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
			game.updateDayButton("(" + Stats.day + ")"); // Sets text of button to match day
			
			break;
		case "exit":
			stats = new Stats();
			game = new Gamemenu(this, stats);
			game.setVisible(true);
			game.dispose();
			start.dispose();
			pause.dispose();
			saveManager.writeSave(stats);
			return;
			
		case "exitpause":
			game.dispose();
			pause.dispose();
			start.dispose();
			saveManager.writeSave(stats);
			break;

		case "exitMainMenu":
			game.setVisible(false);
			pause.setVisible(false);
			start.setVisible(true);
			saveManager.writeSave(stats);
			return;

		case "resize":
			game.setSize(1920, 1080);
			start.setSize(1920, 1080);
			break;
			
		case "resume":
			pause.setVisible(false);
			return;

		case "pause":
			pause.setVisible(true);
			return;

		case "nextDay":
			game.updateDayButton("(" + Stats.day + ")"); // Sets text of button to match day
			game.updateQueue(stats.runDay());
			game.histogram.updateData();
			game.updateQueue(ep.runEvent());
			game.updateStatus();
			game.updateImages();
			break;


		case "upgrade":
			int cost = Stats.buildings.get(lastX).get(lastY).upgrade(Stats.coins);
			
			if (cost > 0) {
				Stats.coins -= cost;
				game.grid.get(lastX).get(lastY).setIcon(new ImageIcon("Images//" + Stats.buildings.get(lastX).get(lastY).toString() + ".png"));
			}
			stats.updateRescources();
			game.updateStatus();
			upgrade.dispose();
			break;
			
		case "upgradeOff":
			break;

		case "buy land":
			stats.coins -= game.buyTiles();
			stats.updateRescources();
			game.updateStatus();
			break;
			
		case "fullLand":
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
			error = stats.setBuilding('e', lastX, lastY);
			
			
			stats.updateRescources();
			
			game.updateStatus();
			build.setVisible(false);
			upgrade.setVisible(false);
			break;

		}
		
		game.grid.get(lastX).get(lastY).setIcon(new ImageIcon("Images//" + Stats.buildings.get(lastX).get(lastY).toString() + ".png"));
//		for (int r = 0; r < Stats.width; r++) {
//			for (int c = 0; c < Stats.hieght;  c++) {
//				switch(Stats.buildings.get(r).get(c).toString().charAt(0)) {
//				
//					
//				}
//			}
//		}

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
