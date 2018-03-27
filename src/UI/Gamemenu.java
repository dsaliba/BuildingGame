package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
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

import org.jfree.ui.RefineryUtilities;

import com.sun.rowset.internal.Row;

import BuildingTypes.Building;
import BuildingTypes.EmpteyPlot;
import Game.Stats;

public class Gamemenu extends JFrame implements ComponentListener {

	private Frame parent;
	private JButton nextDay;
	private JButton pauseButton;
	private JPanel panel1;
	private JPanel panel2;
	private JTextArea status;
	private JTextArea console;
	private JSlider taxSlider;
	private JButton addGrid;
	public Histogram histogram;
	private int expasionCount;
	private String[] queue;

	public ArrayList<ArrayList<JButton>> grid;
	private JLabel farmImage;
	private BufferedImage picture = null;

	Stats stats;

	public Gamemenu(Frame parent, Stats stats) {
		expasionCount = 6;
		queue = new String[] { "\n", "\n", "\n", "\n", "\n", "\n" };
		grid = new ArrayList<ArrayList<JButton>>();
		this.parent = parent;
		setLayout(new GridLayout(1, 2));
		setBounds(0, 0, 1920, 1080);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.stats = stats;
		createPanels();
		createButtons();
		createSlider();
		createText();
		creatHistogram();
		add(panel1);
		add(panel2);
		addComponentListener(this);
		histogram.updateData();

	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// int W = 2;
		// int H = 1;
		// Rectangle b = arg0.getComponent().getBounds();
		// arg0.getComponent().setBounds(b.x, b.y, b.width, b.width * H / W);
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	public void createButtons() {

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		c.weightx = 0.5;

		GridBagConstraints d = new GridBagConstraints();
		d.fill = GridBagConstraints.BOTH;
		d.gridx = 2;
		d.gridy = 0;
		d.gridheight = 2;
		d.weightx = 0.5;

		GridBagConstraints g = new GridBagConstraints();
		g.fill = GridBagConstraints.BOTH;
		g.gridx = 0;
		g.gridy = 2;
		g.gridwidth = 3;

		pauseButton = new JButton("Pause");// pause button
		pauseButton.setFont(new Font("Monospaced", Font.BOLD, 40));
		pauseButton.setBackground(Color.WHITE);
		pauseButton.addActionListener(parent);
		pauseButton.setActionCommand("pause");
		pauseButton.setVisible(true);

		String nextDayText = "Next Day (" + stats.day + ")";
		nextDay = new JButton(nextDayText); // next day button (Not implemented yet)

		nextDay.setFont(new Font("Monospaced", Font.BOLD, 20));
		nextDay.addActionListener(parent);
		nextDay.setActionCommand("nextDay");
		nextDay.setBackground(Color.WHITE);
		nextDay.setVisible(true);

		addGrid = new JButton("Buy Land: [" + 200 * stats.width + "]");
		addGrid.setFont(new Font("Monospaced", Font.BOLD, 40));
		addGrid.setBackground(Color.WHITE);
		addGrid.addActionListener(parent);
		addGrid.setActionCommand("buy land");
		addGrid.setVisible(true);

		panel1.add(addGrid, g);
		panel1.add(pauseButton, c);
		panel1.add(nextDay, d);

		for (int row = 0; row < stats.width; row++) {
			grid.add(new ArrayList<JButton>());
			for (int col = 0; col < stats.height; col++) {
				grid.get(row).add(new JButton("e0"));
				grid.get(row).get(col).setBackground(Color.WHITE);
				panel2.add(grid.get(row).get(col));
				grid.get(row).get(col).addActionListener(parent);
				grid.get(row).get(col).setActionCommand("tile" + row + "|" + col);
				grid.get(row).get(col)
						.setIcon(new ImageIcon("Images//" + stats.buildings.get(row).get(col).toString() + ".png"));

				// grid.get(row).get(col).addComponentListener(new ComponentAdapter() {
				//
				// @Override
				// public void componentResized(ComponentEvent e) {
				// JButton btn = (JButton) e.getComponent();
				// Dimension size = btn.getSize();
				// Insets insets = btn.getInsets();
				// size.width -= insets.left + insets.right;
				// size.height -= insets.top + insets.bottom;
				// if (size.width > size.height) {
				// size.width = -1;
				// } else {
				// size.height = -1;
				// }
				// // Image scaled = .getScaledInstance(size.width, size.height,
				// java.awt.Image.SCALE_SMOOTH);
				// // btn.setIcon(new ImageIcon(scaled));
				// }
				//
				// });

			}
		}

	}

	public int buyTiles() {
		if (stats.coins > stats.width * 200) {
			stats.width++;
			stats.height++;
			expasionCount++;
			grid.add(new ArrayList<JButton>());
			stats.buildings.add(new ArrayList<Building>());
			for (int i = 0; i < stats.height; i++) {
				stats.buildings.get(stats.width - 1).add(new EmpteyPlot());
				grid.get(stats.width - 1).add(new JButton("e0"));
				grid.get(stats.width - 1).get(i).setBackground(Color.WHITE);
				// panel2.add(grid.get(stats.width-1).get(i));
				grid.get(stats.width - 1).get(i).addActionListener(parent);
				System.out.println("tile" + stats.width + "|" + i);
				grid.get(stats.width - 1).get(i).setActionCommand("tile" + stats.width + "|" + i);
				grid.get(stats.width - 1).get(i).setIcon(
						new ImageIcon("Images//" + stats.buildings.get(stats.width - 1).get(i).toString() + ".png"));

				// grid.get(stats.width-1).get(i).addComponentListener(new ComponentAdapter() {
				//
				// @Override
				// public void componentResized(ComponentEvent e) {
				// JButton btn = (JButton) e.getComponent();
				// Dimension size = btn.getSize();
				// Insets insets = btn.getInsets();
				// size.width -= insets.left + insets.right;
				// size.height -= insets.top + insets.bottom;
				// if (size.width > size.height) {
				// size.width = -1;
				// } else {
				// size.height = -1;
				// }
				// }
				//
				// });
			}
			for (int row = 0; row < stats.width -1 + expasionCount; row++) {
				for (int col = 0; col < stats.height - 1 + expasionCount; col++) {
					System.out.println(row + " | " + col);
					if (col == row) {
						panel2.add(grid.get(row).get(col));
					}
					if (col == expasionCount + col) {
						panel2.add(grid.get(row).get(col));
					}
					if (row == expasionCount + row) {
						panel2.add(grid.get(row).get(col));
					}
				}
			}
			// add(panel2);
			addGrid.setText("Buy Land: [" + 200 * stats.width + "]");
			createGrid();
			return stats.width * 200;

		} else

		{
			return -3;
		}
	}

	public void createPanels() {

		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(stats.width, stats.height));

		panel1 = new JPanel(); // Section 1

		panel1.setLayout(new GridBagLayout());

	}

	public void createGrid() {
		panel2 = new JPanel();
		panel2.setLayout(new GridBagLayout());
		for (int row = 0; row < stats.width - 1; row++) {
			for (int col = 0; col < stats.height - 1; col++) {
				GridBagConstraints t = new GridBagConstraints();
				t.fill = GridBagConstraints.BOTH;
				t.gridx = row;
				t.gridy = col;
				panel2.add(grid.get(row).get(col), t);
			}
		}
	}

	public void createSlider() {

		GridBagConstraints t = new GridBagConstraints();
		t.fill = GridBagConstraints.BOTH;
		t.gridx = 1;
		t.gridy = 1;
		t.gridheight = 1;

		taxSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 2, 1);

		taxSlider.addChangeListener(parent);

		Hashtable<Integer, JLabel> labelTable = new Hashtable();
		labelTable.put(new Integer(0), new JLabel("Low"));
		labelTable.put(new Integer(1), new JLabel("Medium"));
		labelTable.put(new Integer(2), new JLabel("High"));
		taxSlider.setLabelTable(labelTable);
		taxSlider.setPaintLabels(true);

		panel1.add(taxSlider, t);
	}

	public void createText() {
		// --------------------------------------------
		GridBagConstraints a = new GridBagConstraints();
		a.fill = GridBagConstraints.BOTH;
		a.gridx = 0;
		a.gridy = 4;
		a.weightx = 0;

		String text = stats.toString();

		// text area
		status = new JTextArea(text);
		status.setLineWrap(true);
		status.setWrapStyleWord(true);
		status.setFont(new Font("Monospaced", Font.PLAIN, 30));
		// status.setLineWrap(true);
		status.setEditable(false);
		status.setVisible(true);
		panel1.add(status, a);

		GridBagConstraints t = new GridBagConstraints();
		t.fill = GridBagConstraints.BOTH;
		t.gridx = 1;
		t.gridy = 0;
		t.gridheight = 1;

		JTextArea header = new JTextArea("Tax Amount");

		header.setFont(new Font("Monospaced", Font.PLAIN, 30));
		header.setVisible(true);
		header.setEditable(false);
		panel1.add(header, t);

		GridBagConstraints b = new GridBagConstraints();
		b.fill = GridBagConstraints.BOTH;
		b.gridx = 0;
		b.gridy = 6;
		b.gridwidth = 3;
		b.gridheight = 0;
		b.weighty = 0;
		b.weightx = 0;

		console = new JTextArea(
				queue[5] + "\n" + queue[4] + "\n" + queue[3] + "\n" + queue[2] + "\n" + queue[1] + "\n" + queue[0]);
		console.setLineWrap(true);
		console.setWrapStyleWord(true);

		console.setFont(new Font("Monospaced", Font.PLAIN, 30));
		console.setEditable(false);
		console.setVisible(true);
		panel1.add(console, b);
	}

	public void creatHistogram() {
		histogram = new Histogram(stats);
		histogram.updateData();
		GridBagConstraints a = new GridBagConstraints();
		a.fill = GridBagConstraints.BOTH;
		a.gridx = 1;
		a.gridy = 4;
		a.weightx = 0;
		a.gridwidth = 2;
		panel1.add(histogram.chart, a);
	}

	public void updateDayButton(String text) {
		nextDay.setText(text);
	}

	public void updateQueue(String phrase) {
		if (phrase.equals(""))
			return;
		queue[5] = queue[4];
		queue[4] = queue[3];
		queue[3] = queue[2];
		queue[2] = queue[1];
		queue[1] = queue[0];
		queue[0] = phrase;
		console.setText(
				queue[5] + "\n" + queue[4] + "\n" + queue[3] + "\n" + queue[2] + "\n" + queue[1] + "\n" + queue[0]);
	}

	public void updateStatus() {
		status.setText(stats.toString());

	}

}
