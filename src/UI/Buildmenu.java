package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Buildmenu extends JFrame {
	private final String[] buildingLabels = { "f1", "c1", "d1", "r1", "p1" };
	private Frame parent;
	private JButton close;
	private JButton upgrade;
	private JButton remove;
	private JTextArea info;
	private JButton closeButton;
	private JButton bl;
	private JLabel test;

	private final String[] buildingLabelsNames = { "Close", "Farm", "Merchant", "Tower", "Tree", "Tent" };

	public Buildmenu(Frame parent) {

		this.parent = parent;
		setLayout(new GridLayout(2, 6));
		setResizable(true);
		setBounds(500, 400, 1000, 360);

		// setVisible(true);
		createButtons();
		createImages();
		createTextLabels();
	}

	public void createButtons() {

		closeButton = new JButton("");
		closeButton.setBounds(0, 1, 200, 100);
		closeButton.setIcon(new ImageIcon("Images\\close.png"));
		closeButton.addActionListener(parent);
		closeButton.setActionCommand("close");
		closeButton.setBackground(Color.WHITE);
		closeButton.setVisible(true);
		add(closeButton);

		for (int i = 0; i < buildingLabels.length; i++) {
			
			bl = new JButton("");
			bl.setIcon(new ImageIcon("Images\\" + buildingLabels[i] + ".png"));
			bl.addActionListener(parent);
			bl.setActionCommand("" + i);
			bl.setFont(new Font("Monospaced", Font.BOLD, 40));
			bl.setBackground(Color.WHITE);
			add(bl);
		}

	}

	public void createTextLabels() {

		JLabel closeLabel = new JLabel("Close");
		closeLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
		closeLabel.setVisible(true);
		closeLabel.setBackground(Color.WHITE);
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		closeLabel.setVerticalAlignment(SwingConstants.TOP);
		add(closeLabel);
		
		JLabel farmLabel = new JLabel("Farm");
		farmLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
		farmLabel.setVisible(true);
		farmLabel.setBackground(Color.WHITE);
		farmLabel.setHorizontalAlignment(SwingConstants.CENTER);
		farmLabel.setVerticalAlignment(SwingConstants.TOP);
		add(farmLabel);
		
		JLabel merchantLabel = new JLabel("Shop");
		merchantLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
		merchantLabel.setVisible(true);
		merchantLabel.setBackground(Color.WHITE);
		merchantLabel.setHorizontalAlignment(SwingConstants.CENTER);
		merchantLabel.setVerticalAlignment(SwingConstants.TOP);
		add(merchantLabel);
		
		JLabel defenseLabel = new JLabel("Tower");
		defenseLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
		defenseLabel.setVisible(true);
		defenseLabel.setBackground(Color.WHITE);
		defenseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		defenseLabel.setVerticalAlignment(SwingConstants.TOP);
		add(defenseLabel);
		
		JLabel recreationLabel = new JLabel("Tree");
		recreationLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
		recreationLabel.setVisible(true);
		recreationLabel.setBackground(Color.WHITE);
		recreationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		recreationLabel.setVerticalAlignment(SwingConstants.TOP);
		add(recreationLabel);
		
		JLabel housingLabel = new JLabel("Tent");
		housingLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
		housingLabel.setVisible(true);
		housingLabel.setBackground(Color.WHITE);
		housingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		housingLabel.setVerticalAlignment(SwingConstants.TOP);
		add(housingLabel);
		
	}

	public void createImages() {
		try {
			Image img = ImageIO.read(getClass().getResource("Images/test.gif"));
			bl.setIcon(new ImageIcon(img));

		} catch (Exception ex) {
			System.out.println("Build menu images are not loading.");
		}
	}

}
