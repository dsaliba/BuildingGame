package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;


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
		setBounds(500, 400, 1000, 500);
		//setVisible(true);
		createButtons();
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
		
		remove = new JButton("Remove");
		remove.setBackground(Color.WHITE);
		remove.setFont(new Font("Monospaced", Font.BOLD, 40));
		remove.addActionListener(parent);
		remove.setActionCommand("remove");
		remove.setVisible(true);
		add(remove);
		
		
		upgrade = new JButton("Upgrade/Build");
		upgrade.setBackground(Color.WHITE);
		upgrade.setFont(new Font("Monospaced", Font.BOLD, 40));
		upgrade.addActionListener(parent);
		upgrade.setActionCommand("buildUpgrade");
		upgrade.setVisible(true);
		add(upgrade);
		
		
		}
	
	
}
