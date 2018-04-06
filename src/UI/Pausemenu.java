package UI;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Pausemenu extends JFrame{

	private Frame parent;
	private JButton pauseResume;
	private JButton pauseExitMainMenu;
	private JButton pauseExitGame;
	
	
	public Pausemenu(Frame parent) {
		this.parent = parent;
		System.out.println("isrunning");
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(850, 250, 500, 750);
		setLayout(null);
		setResizable(false);
		setUndecorated(false);
		getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
		createButtons();
		createText();
		add(pauseExitGame);
		add(pauseResume);
		add(pauseExitMainMenu);
		setVisible(false);
	}
	

	public void createButtons() {

		pauseExitMainMenu = new JButton("Main Menu");
		pauseExitMainMenu.setBounds(12, 490, 462, 75);
		pauseExitMainMenu.setFont(new Font("Monospaced", Font.BOLD, 40));
		pauseExitMainMenu.setVisible(true);
		pauseExitMainMenu.addActionListener(parent);
		pauseExitMainMenu.setActionCommand("exitMainMenu");
		pauseExitMainMenu.setBackground(Color.WHITE);
		
		pauseExitGame = new JButton("Save and Exit");
		pauseExitGame.setBounds(12, 600, 462, 75);
		pauseExitGame.setFont(new Font("Monospaced", Font.BOLD, 40));
		pauseExitGame.addActionListener(parent);
		pauseExitGame.setActionCommand("exit");
		pauseExitGame.setBackground(Color.WHITE);
		
		pauseResume = new JButton("Resume");
		pauseResume.setBounds(12, 380, 462, 75);
		pauseResume.setFont(new Font("Monospaced", Font.BOLD, 40));
		pauseResume.addActionListener(parent);
		pauseResume.setActionCommand("resume");
		pauseResume.setBackground(Color.WHITE);
		
	}
	
	public void createText() {

		String textPaused = "Game is Paused"; // <------ Text
		JLabel pauseText = new JLabel(textPaused);
		pauseText.setHorizontalAlignment(SwingConstants.CENTER);
		pauseText.setVerticalAlignment(SwingConstants.CENTER);
		pauseText.setFont(new Font("Monospaced", Font.BOLD, 40));
		pauseText.setBounds(0, 0, 500, 100);
		add(pauseText);

	}
}
