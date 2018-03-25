package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Buildmenu extends JFrame {
	private final String[] buildingLabels = {"f1", "c1", "d1", "r1", "p1"};
	private Frame parent;
	private JButton close;
	private JButton upgrade;
	private JButton remove;
	private JTextArea info;
	private JButton closeButton;
	private JButton bl;
	private JLabel test;
	
	public Buildmenu(Frame parent) {

		this.parent = parent;
		setLayout(new GridLayout(1, 6));
		setBounds(500, 400, 1000, 180);
		// setVisible(true);
		createButtons();
		createImages();
	}

	public void createButtons() {

		closeButton = new JButton("");
		closeButton.setBounds(0, 1, 200, 100);
		closeButton.setIcon(new ImageIcon("Images\\close.png"));
		closeButton.addActionListener(parent);
		closeButton.setActionCommand("close");
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
	
	public void createImages() {
		 try {
			    Image img = ImageIO.read(getClass().getResource("Images/test.gif"));
			    bl.setIcon(new ImageIcon(img));
			   
			  } catch (Exception ex) {
			    System.out.println("Build menu images are not loading.");
			  }
	}

}
