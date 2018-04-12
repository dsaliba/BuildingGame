package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import BuildingTypes.Building;
import Game.Stats;


public class Upgrademenu extends JFrame{
	
	private Frame parent;
	private JButton close;
	private JButton upgrade;
	private JButton remove;
	private JTextArea info;
	private JButton closeButton;
	private JLabel closeLabel; 
	private JLabel upgradeLabel;
	private JLabel removeLabel;
	
	private String closeText ="Close";
	private String removeText = "Remove";
	private String upgradeText = "Upgrade";
	
	
	
	public Upgrademenu(Frame parent) {
		setResizable(false);
		setUndecorated(false);
		this.parent = parent;
		setLayout(new GridLayout(2, 3));
		setBounds(850, 400, 545, 360);
		createButtons();
		createTextLabels();
	}



	public void createButtons() {
		
		closeButton = new JButton("");
		closeButton.setIcon(new ImageIcon("Images\\closeup.png"));
		closeButton.addActionListener(parent);
		closeButton.setActionCommand("close");
		closeButton.setVisible(true);
	//	closeButton.setBackground(Color.WHITE);
		closeButton.setPressedIcon(new ImageIcon("Images\\closedown.png"));
		closeButton.setOpaque(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setBorderPainted(false);
		add(closeButton);
		
		remove = new JButton("");
		remove.setIcon(new ImageIcon("Images\\destroyup.png"));
		remove.addActionListener(parent);
		remove.setActionCommand("remove");
		remove.setVisible(true);
		remove.setBackground(Color.WHITE);
		remove.setPressedIcon(new ImageIcon("Images\\destroydown.png"));
		remove.setOpaque(false);
		remove.setContentAreaFilled(false);
		remove.setBorderPainted(false);
		add(remove);
		
		
	
		upgrade = new JButton("");
		upgrade.setIcon(new ImageIcon("Images\\upgradeup.png"));
		upgrade.addActionListener(parent);
		upgrade.setActionCommand("upgrade");
		upgrade.setVisible(true);
		upgrade.setBackground(Color.WHITE);
		upgrade.setPressedIcon(new ImageIcon("Images\\upgradedown.png"));
		upgrade.setOpaque(false);
		upgrade.setContentAreaFilled(false);
		upgrade.setBorderPainted(false);
		add(upgrade);
		
													
		
		
		}
	
	public void createTextLabels() {
		
		
		closeLabel = new JLabel(closeText);
		closeLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
		closeLabel.setVisible(true);
		closeLabel.setBackground(Color.WHITE);
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		closeLabel.setVerticalAlignment(SwingConstants.TOP);
		closeLabel.setSize(180, 90);
		add(closeLabel);
		
		removeLabel = new JLabel(removeText);
		removeLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
		removeLabel.setVisible(true);
		removeLabel.setBackground(Color.WHITE);
		removeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		removeLabel.setVerticalAlignment(SwingConstants.TOP);
		removeLabel.setSize(180, 90);
		add(removeLabel);
		
		upgradeLabel = new JLabel(upgradeText);
		upgradeLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
		upgradeLabel.setVisible(true);
		upgradeLabel.setBackground(Color.WHITE);
		upgradeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		upgradeLabel.setVerticalAlignment(SwingConstants.TOP);
		upgradeLabel.setSize(180, 90);
		add(upgradeLabel);
		
	}
	
	public void setPrice(Building building) {
		
		upgradeLabel.setText("<HTML>Upgrade<br/><center>[" + building.getPrice() + "]</center></HTML>");
		if(building.getPrice().equals("Max")) {
			toggleUpgrade(true);
		}else if (Integer.parseInt(building.getPrice()) > Stats.coins){
			toggleUpgrade(true);
		}else {
			toggleUpgrade(false);
		}
	}
	
	public void toggleUpgrade(boolean showUpgrade) {
		if(showUpgrade) {
			upgrade.setActionCommand("upgradeOff");
			upgrade.setIcon(new ImageIcon("Images\\upgradeOff.png"));
		} else {
			upgrade.setActionCommand("upgrade");
			upgrade.setIcon(new ImageIcon("Images\\upgradeup.png"));
		}
	}
	
	
}
