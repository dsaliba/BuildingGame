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
	private final String[] buildingLabels = { "a.png", "c.png", "d.png", "r.png", "s.png", "e.png" };
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
		setBounds(500, 400, 1000, 500);
		// setVisible(true);
		createButtons();
		createImages();
	}

	public void createButtons() {

		closeButton = new JButton("Close");
		closeButton.setBounds(0, 1, 200, 100);
		closeButton.setFont(new Font("Monospaced", Font.BOLD, 40));
		closeButton.setBackground(Color.WHITE);
		closeButton.addActionListener(parent);
		closeButton.setActionCommand("close");
		closeButton.setVisible(true);
		add(closeButton);

		for (int i = 0; i < buildingLabels.length - 1; i++) {
			bl = new JButton("" + buildingLabels[i]);
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
