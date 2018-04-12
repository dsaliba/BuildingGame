package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Helpmenu extends JFrame implements ActionListener {

	private JLabel tent;
	private JLabel merchant;
	private JLabel tree;
	private JLabel farm;
	private JLabel tower;
	
	private JPanel back;
	private JButton resize;
	private Frame parent;
	
	public Helpmenu(Frame parent) {
		this.parent = parent;
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		System.out.println("Start Menu Created");
		setSize(1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setLayout(new BorderLayout());
		//setVisible(true);
		createPanel();
		createButtons();
		createImages();
		
		
		
	}
	
	public void createButtons() {
		
		resize = new JButton("");
		resize.setBounds(12, 280, 462, 100);
		resize.setIcon(new ImageIcon("Images\\resize.png"));
		resize.setFont(new Font("Monospaced", Font.BOLD, 40));
		resize.setVisible(true);
		resize.addActionListener(parent);
		resize.setActionCommand("resize");
		resize.setPressedIcon(new ImageIcon("Images\\resizepressed.png"));
		resize.setOpaque(false);
		resize.setContentAreaFilled(false);
		resize.setBorderPainted(false);
		back.add(resize);
	}
	
	public void createPanel() {
		back = new JPanel();
		add(back);
		
	}
	
	public void createImages() {
		tent = new JLabel("");
		tent.setIcon(new ImageIcon("Images\\tent.png"));
		tent.setVisible(true);
		tent.setBounds(0, 0, 180, 180);
		back.add(tent);
	}
	
	public void createTextArea() {
		JTextArea info = new JTextArea("text text text");
		info.setEditable(false);
		//info.setBorder(Color.BLACK));
		info.setVisible(true);
		back.add(info);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
