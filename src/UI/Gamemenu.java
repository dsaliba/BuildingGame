package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.sun.xml.internal.ws.spi.db.RepeatedElementBridge;

import BuildingTypes.Agriculture;
import Game.Stats;
import Game.gameConstants;
import javafx.scene.layout.Border;

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
	private JTextArea console;
	private JSlider taxSlider;
	
	private String[] queue;

	public JButton[][] grid;
	private JLabel farmImage;
	private BufferedImage picture = null;

	private String buildingImages[] = { "Images\\AdvancedFarm.png", "Images\\Cottage.png", "Images\\Farm.png",
			"Images\\Grass.png", "Images\\Keep.png", "Images\\MerchantTent.png", "Images\\Shop.png",
			"Images\\StoneHouse.png", "Images\\Tent.png", "Images\\Tower.png" };


	Stats stats;

	public Gamemenu(Frame parent, Stats stats) {
		queue = new String[]{"", "", ""};
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
		pauseButton.setBounds(0, 1, 250, 100);
		pauseButton.setFont(new Font("Monospaced", Font.BOLD, 40));
		pauseButton.setBackground(Color.WHITE);
		pauseButton.addActionListener(parent);
		pauseButton.setActionCommand("pause");
		pauseButton.setVisible(true);

		String nextDayText = "Next Day (" + day + ")";
		nextDay = new JButton(nextDayText); // next day button (Not implemented yet)
		nextDay.setBounds(750, 1, 250, 100);
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
				grid[row][col].setIcon(new ImageIcon("Images//" + stats.buildings[row][col].toString() + ".png"));
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
		taxSlider.setBounds(420, 65, 150, 45);
		taxSlider.addChangeListener(parent);
		
		Hashtable<Integer, JLabel> labelTable = new Hashtable();
		labelTable.put( new Integer(0), new JLabel("Low") );
		labelTable.put( new Integer(1), new JLabel("Medium") );
		labelTable.put( new Integer(2), new JLabel("High") );
		taxSlider.setLabelTable(labelTable);
		taxSlider.setPaintLabels(true);
		
		panel1.add(taxSlider);
	}

	public void createText() {
		// --------------------------------------------

		String text = stats.toString();

		// text area
		status = new JTextArea(text);
		status.setLineWrap(true);
		status.setWrapStyleWord(true);
		status.setBounds(0, 200, 1000, 550);
		status.setFont(new Font("Monospaced", Font.PLAIN, 40));
		//status.setLineWrap(true);
		status.setEditable(false);
		//status.setWrapStyleWord(true);
		status.setVisible(true);
		panel1.add(status);

		JTextArea header = new JTextArea("Tax Amount");
		header.setBounds(410, 5, 175, 50);
		header.setFont(new Font("Monospaced", Font.PLAIN, 30));
		header.setVisible(true);
		header.setEditable(false);
		panel1.add(header);
		
		console = new JTextArea(queue[2]+"\n"+queue[1]+"\n"+queue[0]);
		console.setLineWrap(true);
		console.setWrapStyleWord(true);
		console.setBounds(0, 750, 1000, 200);
		console.setFont(new Font("Monospaced", Font.PLAIN, 35));
		console.setEditable(false);
		console.setVisible(true);
		panel1.add(console);
	}
	
	public void updateQueue(String phrase) {
		if (phrase.equals("")) return;
		queue[2] = queue[1];
		queue[1] = queue[0];
		queue[0] = phrase;
		console.setText(queue[2]+"\n"+queue[1]+"\n"+queue[0]);
	}


	public void updateStatus() {
		status.setText(stats.toString());
	}


	public void updateDayButton(String text) {
		nextDay.setText(text);
	}
}
