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

	BufferedImage background = null;
	BufferedImage red = null;
	private Stats stats;
	 static int dayCount = 0; //temp int

	Gamemenu game;
	JFrame start; // start screen
	JFrame pause;
	JPanel p2; // Section 2
	JPanel p;
	
<<<<<<< HEAD
	Gamemenu gamemenu;
	
	public Frame() {
		gamemenu = new Gamemenu(this);
	}

	public void createFrame() {
		// --------------Frame Setup-----------------
		game = gamemenu; // JFrame
=======
	public Frame(Stats stats) {
		this.stats = stats;
	}
	
	public void createFrame() {
		// --------------Frame Setup-----------------
		game = new Gamemenu(this, stats); // JFrame
>>>>>>> 2a6e30358c43690867fe90746f31f41ae8ad3d24
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
			gamemenu.updateDayButton("Next Day (" + dayCount + ")"); //Sets text of button to match day
			
<<<<<<< HEAD
			//Other method calling:
			
=======
			//callsmethods
			dayCount++; //temp int for testing gui
			game.updateDayButton("Next Day (" + dayCount + ")");
			stats.updateRescources();
>>>>>>> 2a6e30358c43690867fe90746f31f41ae8ad3d24
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
