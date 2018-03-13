import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

public class Frame implements ActionListener {

	BufferedImage background = null;
	BufferedImage red = null;

	 static int dayCount = 0; //temp int

	Stats stats;
	JFrame game;
	JFrame start; // start screen
	JFrame pause;
	JPanel p2; // Section 2
	JPanel p;
	
	Gamemenu gamemenu;
	
	public Frame() {
		gamemenu = new Gamemenu(this);
		stats = new Stats();
	}

	public void createFrame() {
		// --------------Frame Setup-----------------
		game = gamemenu; // JFrame
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
			
			stats.updateRescources();
			//Other method calling:
			
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
