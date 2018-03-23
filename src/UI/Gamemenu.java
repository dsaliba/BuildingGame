package UI;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.sun.xml.internal.ws.spi.db.RepeatedElementBridge;

import BuildingTypes.Agriculture;
import Game.Stats;
import Game.gameConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class Gamemenu extends JFrame implements ComponentListener {

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
		queue = new String[] { "", "", "" };
		grid = new JButton[gameConstants.ROW][gameConstants.COL];
		this.parent = parent;
		setLayout(new GridLayout(1, 2));
		setBounds(600, 400, 2000, 1000);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.stats = stats;
		createPanels();
		createButtons();
		createSlider();
		createText();

		add(panel1);
		add(panel2);
		addComponentListener(this);

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

		pauseButton = new JButton("Pause");// pause button
		
		pauseButton.setFont(new Font("Monospaced", Font.BOLD, 40));
		pauseButton.setBackground(Color.WHITE);
		pauseButton.addActionListener(parent);
		pauseButton.setActionCommand("pause");
		pauseButton.setVisible(true);

		String nextDayText = "Next Day (" + day + ")";
		nextDay = new JButton(nextDayText); // next day button (Not implemented yet)
		
		nextDay.setFont(new Font("Monospaced", Font.BOLD, 20));
		nextDay.addActionListener(parent);
		nextDay.setActionCommand("nextDay");
		nextDay.setBackground(Color.WHITE);
		nextDay.setVisible(true);

<<<<<<< HEAD
		panel1.add(pauseButton, c);
		panel1.add(nextDay, d);

=======
		panel1.add(pauseButton);
		panel1.add(nextDay);
		
		
>>>>>>> 182fa1e1d06cbdf2c4685e35e4ce1101854b4130
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
				grid[row][col].addComponentListener(new ComponentAdapter() {
				
			      @Override
                  public void componentResized(ComponentEvent e) {
                      JButton btn = (JButton) e.getComponent();
                      Dimension size = btn.getSize();
                      Insets insets = btn.getInsets();
                      size.width -= insets.left + insets.right;
                      size.height -= insets.top + insets.bottom;
                      if (size.width > size.height) {
                          size.width = -1;
                      } else {
                          size.height = -1;
                      }
                   //   Image scaled = .getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
                 //     btn.setIcon(new ImageIcon(scaled));
                  }

              });

			}
		}

	}

	public void createPanels() {
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(gameConstants.ROW, gameConstants.COL));
		panel1 = new JPanel(); // Section 1

		panel1.setLayout(new GridBagLayout());

	}

	public void createSlider() {

		GridBagConstraints s = new GridBagConstraints();
		s.fill = GridBagConstraints.NONE;
		s.gridx = 1;
		s.gridy = 1;
		s.gridheight = 1;

		taxSlider = new JSlider(JSlider.HORIZONTAL, 0, 2, 1);
		
		
		taxSlider.addChangeListener(parent);

		Hashtable<Integer, JLabel> labelTable = new Hashtable();
		labelTable.put(new Integer(0), new JLabel("Low"));
		labelTable.put(new Integer(1), new JLabel("Medium"));
		labelTable.put(new Integer(2), new JLabel("High"));
		taxSlider.setLabelTable(labelTable);
		taxSlider.setPaintLabels(true);

		panel1.add(taxSlider, s);
	}

	public void createText() {
		// --------------------------------------------
		GridBagConstraints a = new GridBagConstraints();
		a.fill = GridBagConstraints.BOTH;
		a.gridx = 0;
		a.gridy = 3;
		a.gridwidth = 3;
		a.weightx = 1;
		
		
		String text = stats.toString();

		// text area
		status = new JTextArea(text);
		status.setLineWrap(true);
		status.setWrapStyleWord(true);
		status.setFont(new Font("Monospaced", Font.PLAIN, 40));
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
		b.gridy = 4;
		b.gridwidth = 3;
		b.weightx = 1;
		
		console = new JTextArea(queue[2] + "\n" + queue[1] + "\n" + queue[0]);
		console.setLineWrap(true);
		console.setWrapStyleWord(true);
		
		console.setFont(new Font("Monospaced", Font.PLAIN, 35));
		console.setEditable(false);
		console.setVisible(true);
		panel1.add(console, b);
	}

	public void updateQueue(String phrase) {
		if (phrase.equals(""))
			return;
		queue[2] = queue[1];
		queue[1] = queue[0];
		queue[0] = phrase;
		console.setText(queue[2] + "\n" + queue[1] + "\n" + queue[0]);
	}

	public void updateStatus() {
		status.setText(stats.toString());
	}

	public void updateDayButton(String text) {
		nextDay.setText(text);
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
//		int W = 2;
//		int H = 1;
//		Rectangle b = arg0.getComponent().getBounds();
//		arg0.getComponent().setBounds(b.x, b.y, b.width, b.width * H / W);
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
