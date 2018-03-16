package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.sun.xml.internal.ws.spi.db.RepeatedElementBridge;

import BuildingTypes.Agriculture;
import Game.Stats;
import Game.gameConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

public class Gamemenu extends JFrame {

	int day = Frame.dayCount;
	private Frame parent;
	private JButton nextDay;
	private JButton pauseButton;
	private JPanel panel1;
	private JPanel panel2;
	private JTextArea status;
	private JSlider taxSlider;
	private JButton[][] grid;
	private JLabel farmImage;
	private BufferedImage picture = null;

	private String buildingImages[] = { "Images\\AdvancedFarm.png", "Images\\Cottage.png", "Images\\Farm.png",
			"Images\\Grass.png", "Images\\Keep.png", "Images\\MerchantTent.png", "Images\\Shop.png",
			"Images\\StoneHouse.png", "Images\\Tent.png", "Images\\Tower.png" };
	Stats stats;

	public Gamemenu(Frame parent, Stats stats) {
		grid = new JButton[gameConstants.ROW][gameConstants.COL];
		this.parent = parent;
		setLayout(new GridLayout(1, 2));
		setBounds(600, 400, 2000, 1000);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.stats = stats;
		createPanels();
		createButtons();
		createSlider();
		createText();

		add(panel1);
		add(panel2);

	}

	public void createButtons() {

		pauseButton = new JButton("Pause");// pause button
		pauseButton.setBounds(0, 1, 200, 100);
		pauseButton.setFont(new Font("Monospaced", Font.BOLD, 40));
		pauseButton.setBackground(Color.WHITE);
		pauseButton.addActionListener(parent);
		pauseButton.setActionCommand("pause");
		pauseButton.setVisible(true);

		String nextDayText = "Next Day (" + day + ")";
		nextDay = new JButton(nextDayText); // next day button (Not implemented yet)
		nextDay.setBounds(800, 1, 200, 100);
		nextDay.setFont(new Font("Monospaced", Font.BOLD, 20));
		nextDay.addActionListener(parent);
		nextDay.setActionCommand("nextDay");
		nextDay.setBackground(Color.WHITE);
		nextDay.setVisible(true);

		panel1.add(pauseButton);
		panel1.add(nextDay);

		for (int row = 0; row < gameConstants.ROW; row++) {
			for (int col = 0; col < gameConstants.COL; col++) {

				JLabel l = new JLabel(row + "|" + col);
				grid[row][col] = new JButton("e0");
				grid[row][col].add(l);
				grid[row][col].setBackground(Color.WHITE);
				panel2.add(grid[row][col]);
				grid[row][col].addActionListener(parent);
				grid[row][col].setActionCommand("tile" + row + "|" + col);
				updatePlotButton(row, col, null, 3);
				// grid[row][col].setActionCommand(row + "|" + col);
				grid[row][col].addActionListener(new ActionListener() {

					// methodbuild(row, col);

					public void actionPerformed(ActionEvent e) {

						// TODO Auto-generated method stub
						// String id = e.getActionCommand();
						// int pipe = id.indexOf("|");
						// int r = Integer.parseInt(id.substring(0, pipe));
						// int c = Integer.parseInt(id.substring(pipe+1, id.length()));

					}
				});
			}
		}

	}

	public void createPanels() {
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(gameConstants.ROW, gameConstants.COL));
		panel1 = new JPanel(); // Section 1
		panel1.setLayout(null);

	}

	public void createSlider() {
		taxSlider = new JSlider(JSlider.HORIZONTAL, 0, 2, 1);
		taxSlider.setBounds(535, 1, 150, 100);
		panel1.add(taxSlider);
	}

	public void createText() {
		// --------------------------------------------

		String text = stats.toString();

		// text area
		status = new JTextArea(text);
		status.setLineWrap(true);
		status.setWrapStyleWord(true);
		status.setBounds(0, 200, 1000, 700);
		status.setFont(new Font("Monospaced", Font.PLAIN, 40));
		status.setLineWrap(true);
		status.setEditable(false);
		status.setWrapStyleWord(true);
		status.setVisible(true);
		panel1.add(status);

		JTextArea header = new JTextArea("Tax Amount: ");
		header.setBounds(250, 10, 500, 50);
		header.setFont(new Font("Monospaced", Font.PLAIN, 40));
		header.setVisible(true);
		header.setEditable(false);
		panel1.add(header);

	}

	public void createImages(int x, int y, int i) {
		try {
			picture = ImageIO.read(new File(buildingImages[i]));
			System.out.println("Get Image: " + picture);
			System.out.println("Load image into frame");

			farmImage = new JLabel(new ImageIcon(picture));
			grid[x][y].setIcon(new ImageIcon(picture));

		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	public void updateStatus() {
		status.setText(stats.toString());
	}

	public void updatePlotButton(int x, int y, String name, int i) {
		grid[x][y].setText(name);
		createImages(x, y, i);
	}

	public void updateDayButton(String text) {
		nextDay.setText(text);
	}
}
