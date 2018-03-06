import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class pausemenu extends JFrame{

	private frame parent;
	private JButton pauseResume;
	private JButton pauseExitMainMenu;
	private JButton pauseExitGame;
	
	
	public pausemenu(frame parent) {
		this.parent = parent;
		System.out.println("isrunning");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(1350, 500, 500, 700);
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
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
		
		pauseExitGame = new JButton("Exit Game");
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

		String gameIsPaused = "Game is Paused"; // <------ Text
		JTextArea pauseText = new JTextArea(gameIsPaused);

		pauseText.setFont(new Font("Monospaced", Font.BOLD, 40));
		pauseText.setBounds(0, 0, 500, 100);
		pauseText.setEditable(false);
		add(pauseText);

	}
}
