package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Upgrademenu extends JFrame{
	
	private Frame parent;
	private JButton close;
	private JButton upgrade;
	private JButton remove;
	private JTextArea info;
	private JButton closeButton;
	
	public Upgrademenu(Frame parent) {
		
		this.parent = parent;
		setLayout(new GridLayout(1, 3));
		setBounds(500, 400, 540, 180);
		//setVisible(true);
		createButtons();
	}

	
	public void createButtons() {
		
		closeButton = new JButton("");
		closeButton.setIcon(new ImageIcon("Images\\close.png"));
		closeButton.addActionListener(parent);
		closeButton.setActionCommand("close");
		closeButton.setVisible(true);
		closeButton.setBackground(Color.WHITE);
		add(closeButton);
		
		remove = new JButton("");
		remove.setIcon(new ImageIcon("Images\\remove.png"));
		remove.addActionListener(parent);
		remove.setActionCommand("remove");
		remove.setVisible(true);
		remove.setBackground(Color.WHITE);
		add(remove);
		
		
		upgrade = new JButton("Upgrade");
		upgrade.setBackground(Color.WHITE);
		upgrade.setFont(new Font("Monospaced", Font.BOLD, 40));
		upgrade = new JButton("");
		upgrade.setIcon(new ImageIcon("Images\\upgrade.png"));
		upgrade.addActionListener(parent);
		upgrade.setActionCommand("upgrade");
		upgrade.setVisible(true);
		upgrade.setBackground(Color.WHITE);
		add(upgrade);
		
													
		
		
		}
	
	
}
