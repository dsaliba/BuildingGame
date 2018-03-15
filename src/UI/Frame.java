package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Game.Stats;


public class Frame implements ActionListener {


	private Stats stats;
	public static int dayCount; //temp int

	private Gamemenu game;
	private JFrame start; // start screen
	private JFrame pause;
	private JFrame upgrade;
	

	
	
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
			//GUI: 
			dayCount++; //increases day (temp)
			game.updateDayButton("Next Day (" + dayCount + ")"); //Sets text of button to match day
			
			//Other method calling:
			

			stats.updateRescources();
 			break;
 			
		case "buttonPressed":
			upgrade.setVisible(true);
			break;
			
		case "buildUpgrade":
			
			break;
		
		case "remove":
			
			break;
		case "close":
			upgrade.dispose();
			break;
		}

	}
	
	//method that changes icon of row/col button
	public void changeIcon(int row, int col, String image) {
		switch(image) {
		case "tent":
			//JLabel(new ImageIcon(titleScreen)); gamemenu.setlabel(this);
			break;
		}
	}
}
