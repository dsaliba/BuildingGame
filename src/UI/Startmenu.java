package UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Startmenu extends JFrame implements ActionListener{

	private Frame parent;
	private JButton exitButton;
	private JButton startButton;
	private JButton continueButton;
	private JLabel background;
	private BufferedImage titleScreen = null;
	private JLabel title;

	public Startmenu(Frame parent) {
		this.parent = parent;
		System.out.println("isrunning");
		setSize(1920,1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setLayout(new BorderLayout());
		createBackground();
		createButtons();
		background.add(startButton);
		background.add(continueButton);
		background.add(exitButton);
		background.add(title);
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
		
		title = new JLabel("");
		title.setIcon(new ImageIcon("Images\\title.png"));
		title.setVisible(true);
		title.setBounds(575, 250, 750, 500);
		
		
	}

	public void createButtons() {
		startButton = new JButton(""); // play button
		startButton.setIcon(new ImageIcon("Images\\start.png"));
		startButton.setBounds(800, 600, 300, 100);
		startButton.setFont(new Font("Monospaced", Font.BOLD, 40));
		startButton.setVisible(true);
		startButton.addActionListener(parent);
		startButton.setActionCommand("new game");
		startButton.setPressedIcon(new ImageIcon("Images\\startpressed.png"));
		startButton.setOpaque(false);
		startButton.setContentAreaFilled(false);
		startButton.setBorderPainted(false);
		
		continueButton = new JButton(""); // play button
		continueButton.setIcon(new ImageIcon("Images\\continue.png"));
		continueButton.setBounds(800, 700, 300, 100);
		continueButton.setFont(new Font("Monospaced", Font.BOLD, 40));
		continueButton.setVisible(true);
		continueButton.addActionListener(parent);
		continueButton.setActionCommand("continue");
		continueButton.setPressedIcon(new ImageIcon("Images\\continuepressed.png"));
		continueButton.setOpaque(false);
		continueButton.setContentAreaFilled(false);
		continueButton.setBorderPainted(false);

		exitButton = new JButton(""); // exit button on pause screen
		exitButton.setIcon(new ImageIcon("Images\\exit.png"));
		exitButton.setBounds(800, 800, 300, 100);
		exitButton.setFont(new Font("Monospaced", Font.BOLD, 40));
		exitButton.setVisible(true);
		exitButton.addActionListener(parent); //----------------------------------------action listener stuff (v)
		exitButton.setActionCommand("exit");
		exitButton.setPressedIcon(new ImageIcon("Images\\exitpressed.png"));
		exitButton.setOpaque(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setBorderPainted(false);

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
