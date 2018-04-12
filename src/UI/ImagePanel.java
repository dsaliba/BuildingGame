package UI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private Image image = null;

	public ImagePanel(String url) {
		image = Toolkit.getDefaultToolkit().createImage(url);
		;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, this);

		}
	}
}
