package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.sun.org.apache.bcel.internal.generic.LASTORE;

import BuildingTypes.Building;
import BuildingTypes.EmpteyPlot;
import Game.Stats;
import javafx.scene.layout.Border;
import jdk.internal.org.objectweb.asm.tree.FrameNode;

public class Gamemenu extends JFrame implements ComponentListener {

	private Frame parent; // Frames, Buttons, Slider, Labels, Textareas, Histograms, Images, Ect
	private JButton nextDay;
	private JButton pauseButton;
	private ImagePanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JTextArea status;
	private JTextArea console;
	private JSlider taxSlider;
	private JButton addGrid;
	public Histogram histogram;
	private String[] queue;
	private JTextArea[] queueLabel;
	private GridBagConstraints button;
	public ArrayList<ArrayList<JButton>> grid;
	private JLabel farmImage;
	private BufferedImage picture = null;
	private Color textColor;

	Stats stats;

	public Gamemenu(Frame parent, Stats stats) { // Constructor
		queue = new String[] { "", "", "", "", "", "", "", "", "", ""};
		queueLabel = new JTextArea[10];
		textColor = Color.WHITE;
		grid = new ArrayList<ArrayList<JButton>>();
		this.parent = parent;
		setLayout(new GridLayout(1, 2));
		setBounds(0, 0, 1920, 1080);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.stats = stats;
		//getContentPane().setForeground(new Color(239, 211, 135, 255));
		createPanels();
		createButtons();
		createSlider();
		createText();
		creatHistogram();
		addComponentListener(this);
		histogram.updateData();
		if (stats.width > 22) {
			panel1.remove(addGrid);
			remove(panel1);
			remove(panel2);
			add(panel1);
			add(panel2);
		}
		
	}

	/*
	 * This Method creates the GridBagConstraints for all of the buttons on the Game
	 * Frame. The Buttons this method creates are: Pause, Nextday, BuyLand, and the
	 * 6x6 grid.
	 */

	public void createButtons() {

		GridBagConstraints p = new GridBagConstraints();
		p.fill = GridBagConstraints.BOTH;
		p.gridx = 0;
		p.gridy = 0;
		p.gridheight = 2;
		p.gridwidth = 1;

		GridBagConstraints d = new GridBagConstraints();
		d.fill = GridBagConstraints.BOTH;
		d.gridx = 4;
		d.gridy = 0;
		d.gridheight = 2;
		d.gridwidth = 2;

		GridBagConstraints g = new GridBagConstraints();
		g.fill = GridBagConstraints.HORIZONTAL;
		g.gridx = 0;
		g.gridy = 3;
		g.gridheight = 1;
		g.gridwidth = 6;

		pauseButton = new JButton("");// pause button
		pauseButton.setIcon(new ImageIcon("Images\\pause.png"));
		pauseButton.setFont(new Font("Monospaced", Font.BOLD, 40));
		pauseButton.setForeground(Color.WHITE);
		pauseButton.addActionListener(parent);
		pauseButton.setActionCommand("pause");
		pauseButton.setVisible(true);
		pauseButton.setPressedIcon(new ImageIcon("Images\\pausepressed.png"));
		pauseButton.setOpaque(false);
		pauseButton.setContentAreaFilled(false);
		pauseButton.setBorderPainted(false);

		String nextDayText = "(" + stats.day + ")";
		nextDay = new JButton(nextDayText); // next day button (Not implemented yet)
		nextDay.setIcon(new ImageIcon("Images\\nextday.png"));
		nextDay.setFont(new Font("Monospaced", Font.BOLD, 40));
		nextDay.addActionListener(parent);
		nextDay.setActionCommand("nextDay");
		nextDay.setForeground(textColor);
		nextDay.setVisible(true);
		nextDay.setPressedIcon(new ImageIcon("Images\\nextdaypressed.png"));
		nextDay.setOpaque(false);
		nextDay.setContentAreaFilled(false);
		nextDay.setBorderPainted(false);

		addGrid = new JButton("[" + 500 * stats.width + "]"); // Add Grid Button
		addGrid.setIcon(new ImageIcon("Images\\buyland.png"));
		addGrid.setOpaque(false);
		addGrid.setFont(new Font("Monospaced", Font.BOLD, 40));
		addGrid.setForeground(textColor);
		addGrid.addActionListener(parent);
		addGrid.setActionCommand("buy land");
		addGrid.setVisible(true);
		addGrid.setPressedIcon(new ImageIcon("Images\\buylandpressed.png"));
		addGrid.setOpaque(false);
		addGrid.setContentAreaFilled(false);
		addGrid.setBorderPainted(false);

		panel1.add(addGrid, g); // Panel Button Adding
		panel1.add(pauseButton, p);
		panel1.add(nextDay, d);

		for (int row = 0; row < stats.width; row++) { // This loop creates the initial 6 x 6 Grid of Buttons

			grid.add(new ArrayList<JButton>());
			for (int col = 0; col < stats.height; col++) {
				grid.get(row).add(new JButton(""));
				grid.get(row).get(col).setBorder(new LineBorder(Color.BLACK));
				panel2.add(grid.get(row).get(col));
				grid.get(row).get(col).addActionListener(parent);
				grid.get(row).get(col).setActionCommand("tile" + row + "|" + col);
				grid.get(row).get(col)
						.setIcon(new ImageIcon("Images//" + stats.buildings.get(row).get(col).toString() + ".png"));
			}
		}

	}

	/*
	 * This method handles buying more land tiles for expansion.
	 */
	public int buyTiles() {

		if (stats.coins >= stats.width * 500) {
			remove(panel2);
			stats.width++;
			stats.height++;

			for (ArrayList<Building> list : stats.buildings) { // This forloop adds the new buttons to the arraylist
				list.add(new EmpteyPlot());
			}

			int count = 0;
			for (ArrayList<JButton> list : grid) { // This forloop creates the buttons on the forloop
				list.add(new JButton("e0"));
				list.get(count).setBorder(new LineBorder(Color.BLACK));
				list.get(stats.height - 1).setForeground(textColor);
				// panel2.add(grid.get(stats.width-1).get(i));
				list.get(stats.height - 1).addActionListener(parent);
				list.get(stats.height - 1).setActionCommand("tile" + count + "|" + (stats.height - 1));
				list.get(stats.height - 1).setIcon(new ImageIcon(
						"Images//" + stats.buildings.get(count).get(stats.height - 1).toString() + ".png"));
				count++;
			}

			grid.add(new ArrayList<JButton>());
			stats.buildings.add(new ArrayList<Building>());
			for (int i = 0; i < stats.height; i++) {
				
				stats.buildings.get(stats.width - 1).add(new EmpteyPlot());
				grid.get(stats.width - 1).add(new JButton("e0"));
				grid.get(stats.width - 1).get(i).setForeground(Color.WHITE);
				grid.get(stats.width - 1).get(i).setBorder(new LineBorder(Color.BLACK));
				// panel2.add(grid.get(stats.width-1).get(i));
				grid.get(stats.width - 1).get(i).addActionListener(parent);
				grid.get(stats.width - 1).get(i).setActionCommand("tile" + (stats.width - 1) + "|" + i);
				grid.get(stats.width - 1).get(i).setIcon(
					
						new ImageIcon("Images//" + stats.buildings.get(stats.width - 1).get(i).toString() + ".png"));

			}

			// These for loops add the newly created buttons
			panel2 = new JPanel();
			panel2.setLayout(new GridLayout(stats.width, stats.height));
			for (int row = 0; row < stats.width; row++) {
				for (int col = 0; col < stats.height; col++) {
					panel2.add(grid.get(row).get(col));
					grid.get(row).get(col).setVisible(true);
				}
			}

			add(panel2);
			addGrid.setText("[" + 500 * stats.width + "]");
			if (stats.width > 22) {
				addGrid.addActionListener(parent);
				addGrid.setActionCommand("fullLand");
				addGrid.setForeground(Color.RED);
				addGrid.setText("Max Size Reached");
				remove(panel1);
				remove(panel2);
				add(panel1);
				add(panel2);
			}
			return (stats.width-1) * 500;

		} else

		{
			return 0;
		}
	}
	/*
	 * This method divides the Game Frame into 3 sections. One section will contain
	 * the game's grid The other section will contain the game's stats, Histogram,
	 * Console, Slider, and Buttons
	 */

	public void createPanels() {

		panel2 = new JPanel(); // Grid Section
		panel2.setLayout(new GridLayout(stats.width, stats.height));
		panel1 = new ImagePanel("Images//gameback.png"); // Stats Section
		panel1.setLayout(new GridBagLayout());
		panel1.setForeground(new Color(239, 211, 135, 255));
		add(panel1);
		add(panel2);

	}

	/*
	 * This method creates the slider and the respective Grid Bag Constraints.
	 */
	public void createSlider() {
		GridBagConstraints t = new GridBagConstraints(); // Grid Bag Constraints
		t.fill = GridBagConstraints.HORIZONTAL;
		t.gridx = 2;
		t.gridy = 1;
		t.gridheight = 2;
		t.gridwidth = 2;
		t.weightx = 0.5;

		taxSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 2, 1); // Tax Slider
		taxSlider.addChangeListener(parent);
		taxSlider.setOpaque(false);
		Hashtable<Integer, JLabel> labelTable = new Hashtable(); // Tax Slider Labels and Ticks
		labelTable.put(new Integer(0), new JLabel("L"));
		labelTable.put(new Integer(1), new JLabel("M"));
		labelTable.put(new Integer(2), new JLabel("H"));
		for (int i = 0; i < 3; i++) {
			labelTable.get(new Integer(i)).setForeground(textColor);
		}

		taxSlider.setLabelTable(labelTable);
		taxSlider.setPaintLabels(true);
		panel1.add(taxSlider, t);

	}

	public void updateImages() {
		for (int row = 0; row < grid.size(); row++) {
			for (int col = 0; col < grid.get(row).size(); col++) {
				grid.get(row).get(col)
						.setIcon(new ImageIcon("Images//" + stats.buildings.get(row).get(col).toString() + ".png"));
			}
		}
	}

	// This method handles the Text Area for the Status, Console, and the Header for
	// Tax Slider
	public void createText() {
		// --------------------------------------------
		GridBagConstraints g = new GridBagConstraints();
		g.fill = GridBagConstraints.BOTH;
		g.gridx = 0;
		g.gridy = 4;
		g.gridheight = 1;
		g.gridwidth = 3;
		g.weightx = 0.25;

		String text = stats.toString();
		// text area
		status = new JTextArea(text); // Status Text Area
		status.setLineWrap(true);
		status.setWrapStyleWord(true);
		status.setFont(new Font("Monospaced", Font.BOLD, 30));
		status.setEditable(false);
		status.setVisible(true);
		status.setForeground(textColor);
		status.setOpaque(false);
		panel1.add(status, g);

		GridBagConstraints t = new GridBagConstraints(); // Tax Slider Grid Bag Constraint
		// t.fill = GridBagConstraints.BOTH;
		t.gridx = 2;
		t.gridy = 0;
		t.gridheight = 1;
		t.gridwidth = 2;

		JTextArea header = new JTextArea("Tax"); // Tax Slider Header
		header.setFont(new Font("Monospaced", Font.BOLD, 30));
		header.setForeground(textColor);
		header.setOpaque(false);
		header.setVisible(true);
		header.setEditable(false);
		panel1.add(header, t);

		GridBagConstraints b = new GridBagConstraints(); // Console Grid Bag Constraint
		b.fill = GridBagConstraints.BOTH;
		b.gridx = 0;
		b.gridy = 5;
		b.gridwidth = 6;
		b.gridheight = 1;
		b.weighty = 1;
		b.ipady = 0;
		for (int i = 0; i<queueLabel.length; i ++) {
			b.gridy++;
			queueLabel[i] = new JTextArea("");
			queueLabel[i].setLineWrap(true);
			queueLabel[i].setWrapStyleWord(true);
			queueLabel[i].setFont(new Font("Monospaced", Font.BOLD, 30));
			queueLabel[i].setEditable(false);
			queueLabel[i].setVisible(true);
			queueLabel[i].setOpaque(false);
			queueLabel[i].setForeground(new Color(255, 255, 255, ((27*i)+12)));
			panel1.add(queueLabel[i], b);
		}
	}

	/*
	 * This Method Creates the Histogram. It also contains the Hisogram's gridbag
	 * Constraints
	 */
	public void creatHistogram() {
		histogram = new Histogram(stats); // Hisogram
		histogram.updateData();
		// --------------------------------------------
		GridBagConstraints g = new GridBagConstraints();
		g.fill = GridBagConstraints.BOTH;
		g.gridx = 3;
		g.gridy = 4;
		g.gridheight = 1;
		g.gridwidth = 3;
		g.weightx = 0.25;
		panel1.add(histogram.chart, g);

	}

	/*
	 * This method updates the nextday button's text
	 */
	public void updateDayButton(String text) {
		nextDay.setText(text);
	}

	/*
	 * This method updates the text on the status text area.
	 */
	public void updateStatus() {
		status.setText(stats.toString());

	}

	/*
	 * What does this method do? <----------------------------- EDIT EDIT EDIT EDIT
	 * EDIT
	 */
	public void updateQueue(String phrase) {
		if (phrase.equals("")) return;
		String next = "";
		if (phrase.length() >= 50) {
			int lastSpace = phrase.substring(0, 51).lastIndexOf(" ");
			next = phrase.substring(lastSpace-1);
			phrase = phrase.substring(0, lastSpace-1);
		}
		queue[9] = queue[8];
		queue[8] = queue[7];
		queue[7] = queue[6];
		queue[6] = queue[5];
		queue[5] = queue[4];
		queue[4] = queue[3];
		queue[3] = queue[2];
		queue[2] = queue[1];
		queue[1] = queue[0];
		queue[0] = phrase;
		for (int i = 0; i < queueLabel.length; i++) {
			queueLabel[i].setText(queue[9-i]);
		}
		if (!next.equals("")) {
			updateQueue(next);
		}
	}

	// Unused Implemented Methods
	// --------------------------------------------------------------------

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

}
