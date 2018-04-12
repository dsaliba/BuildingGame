package UI;

import java.awt.BorderLayout;

import javax.swing.*;

public class Helpmenu extends JFrame{
	private Frame parent;
	
	public Helpmenu(Frame parent) {
		this.parent = parent;
		System.out.println("Help Menu Created");
		setSize(1920,1080);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(0, 100, 1920, 1080);
		setLayout(new BorderLayout());
		setVisible(true);
		
	}
}
