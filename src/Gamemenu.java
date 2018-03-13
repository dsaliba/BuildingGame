
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
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
	private JTextArea nextDayHeader;
	

	public Gamemenu(Frame parent, Stats stats) {
		this.parent = parent;
		setLayout(new GridLayout(1, 2));
		setBounds(600, 400, 2000, 1000);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				JButton[][] grid = new JButton[gameConstants.ROW][gameConstants.COL];
				JLabel l = new JLabel(row + "|" + col);
				grid[row][col] = new JButton();
				grid[row][col].add(l);
				grid[row][col].setBackground(Color.WHITE);
				panel2.add(grid[row][col]);

				grid[row][col].setActionCommand(row + "|" + col);
				grid[row][col].addActionListener(new ActionListener() {
					// methodbuild(row, col);
					
					public void actionPerformed(ActionEvent e) {
						System.out.println("test");
						
						// TODO Auto-generated method stub
						String id = e.getActionCommand();
						int pipe = id.indexOf("|");
						int r = Integer.parseInt(id.substring(0, pipe));
						int c = Integer.parseInt(id.substring(pipe+1, id.length()));
						Stats.buildings[r][c] = new Agriculture();
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
		// temp values
		
		int gold = 100;
		int happiness = 50;
		String tax = "Medium";
		int people = 0;
		int food = 5;
		int buildings = 0;
		int defense = 0;
		int taxIncome = 0;
		int income = 5;

		// --------------------------------------------

		String text = "Gold: " + gold + " \nPeople: " + people + "\nHappiness: " + happiness + "%" + "\nTax: " + tax
				+ "\nFood: " + food + "\nBuildings: " + buildings + "\nDefense: " + defense + "\nTax Amount: "
				+ taxIncome + "\nIncome: " + income;

		// text area
		status = new JTextArea(text);
		status.setLineWrap(true);
		status.setWrapStyleWord(true);
		// status.setBounds(0, 200, 1000, 700);
		status.setFont(new Font("Monospaced", Font.PLAIN, 40));
		status.setLineWrap(true);
		status.setEditable(false);
		status.setWrapStyleWord(true);
		status.setVisible(false);

		// panel1.add(status);

		JTextArea header = new JTextArea("Tax Amount: ");
		header.setBounds(250, 10, 500, 50);
		header.setFont(new Font("Monospaced", Font.PLAIN, 40));
		header.setVisible(true);
		header.setEditable(false);
		panel1.add(header);

		
	}
	
	public void updateDayButton(String text) {
		nextDay.setText(text);
	}
}
