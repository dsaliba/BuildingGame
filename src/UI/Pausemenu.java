package UI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Pausemenu extends JFrame {

	private Frame parent;
	private JButton pauseResume;
	private JButton pauseExitMainMenu;
	private JButton pauseExitGame;
	private JButton resize;

	public Pausemenu(Frame parent) {
		this.parent = parent;
		System.out.println("pause menu ready");
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
		add(resize);
		setAlwaysOnTop (true);
		setVisible(false);
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

		pauseExitMainMenu = new JButton("");
		pauseExitMainMenu.setBounds(12, 380, 462, 100);
		pauseExitMainMenu.setIcon(new ImageIcon("Images\\exitmain.png"));
		pauseExitMainMenu.setFont(new Font("Monospaced", Font.BOLD, 40));
		pauseExitMainMenu.setVisible(true);
		pauseExitMainMenu.addActionListener(parent);
		pauseExitMainMenu.setActionCommand("exitMainMenu");
		pauseExitMainMenu.setPressedIcon(new ImageIcon("Images\\exitmainpressed.png"));
		pauseExitMainMenu.setOpaque(false);
		pauseExitMainMenu.setContentAreaFilled(false);
		pauseExitMainMenu.setBorderPainted(false);

		pauseExitGame = new JButton("");
		pauseExitGame.setBounds(12, 480, 462, 100);
		pauseExitGame.setIcon(new ImageIcon("Images\\exitpause.png"));
		pauseExitGame.setFont(new Font("Monospaced", Font.BOLD, 40));
		pauseExitGame.addActionListener(parent);
		pauseExitGame.setActionCommand("exitpause");
		pauseExitGame.setPressedIcon(new ImageIcon("Images\\exitpausepressed.png"));
		pauseExitGame.setOpaque(false);
		pauseExitGame.setContentAreaFilled(false);
		pauseExitGame.setBorderPainted(false);

		pauseResume = new JButton("");
		pauseResume.setBounds(12, 180, 462, 100);
		pauseResume.setIcon(new ImageIcon("Images\\resume.png"));
		pauseResume.setFont(new Font("Monospaced", Font.BOLD, 40));
		pauseResume.addActionListener(parent);
		pauseResume.setActionCommand("resume");
		pauseResume.setPressedIcon(new ImageIcon("Images\\resumepressed.png"));
		pauseResume.setOpaque(false);
		pauseResume.setContentAreaFilled(false);
		pauseResume.setBorderPainted(false);

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
