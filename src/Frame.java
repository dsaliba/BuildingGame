import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

public class Frame implements ActionListener {

	private BufferedImage background = null;
	private BufferedImage red = null;
	private Stats stats;
	public static int dayCount; //temp int

	private Gamemenu game;
	private JFrame start; // start screen
	private JFrame pause;
	private JPanel p2; // Section 2
	private JPanel p;
	
	
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
