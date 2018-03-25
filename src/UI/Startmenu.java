package UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Startmenu extends JFrame {

	private Frame parent;
	private JButton exitButton;
	private JButton startButton;
	private JButton continueButton;
	private JLabel background;
	private BufferedImage titleScreen = null;

	public Startmenu(Frame parent) {
		this.parent = parent;
		System.out.println("isrunning");
		setSize(2000,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 400, 2000, 1000);
		setLayout(new BorderLayout());
		createBackground();
		createButtons();
		background.add(startButton);
		background.add(continueButton);
		background.add(exitButton);
		setVisible(true);
	}

	
	
	
	public void createBackground() {

		//BufferedImage titleScreen = null; // Images
		try {
			titleScreen = ImageIO.read(
					new File("Images\\TitleScreen2.png"));
			System.out.println("Get Image: " + titleScreen);
			System.out.println("Load image into frame");

			background = new JLabel(new ImageIcon(titleScreen));
			getContentPane().add(background);
			//pack();

		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	public void createButtons() {
		startButton = new JButton("New Game"); // play button
		startButton.setBounds(850, 400, 300, 100);
		startButton.setFont(new Font("Monospaced", Font.BOLD, 40));
		startButton.setVisible(true);
		startButton.addActionListener(parent);
		startButton.setActionCommand("new game");
		startButton.setBackground(Color.WHITE);
		
		continueButton = new JButton("Continue"); // play button
		continueButton.setBounds(850, 550, 300, 100);
		continueButton.setFont(new Font("Monospaced", Font.BOLD, 40));
		continueButton.setVisible(true);
		continueButton.addActionListener(parent);
		continueButton.setActionCommand("continue");
		continueButton.setBackground(Color.WHITE);

		exitButton = new JButton("Exit"); // exit button on pause screen
		exitButton.setBounds(850, 700, 300, 100);
		exitButton.setFont(new Font("Monospaced", Font.BOLD, 40));
		exitButton.setVisible(true);
		exitButton.addActionListener(parent); //----------------------------------------action listener stuff (v)
		exitButton.setActionCommand("exit");
		exitButton.setBackground(Color.WHITE);

	}
}
