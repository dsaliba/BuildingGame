package UI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private Image image = null;
	private int iWidth2;
	private int iHeight2;

	public ImagePanel(String url)
	{
	    image = Toolkit.getDefaultToolkit().createImage(url);;
	    //this.iWidth2 = image.getWidth(this)/2;
	    //this.iHeight2 = image.getHeight(this)/2;
	}


	public void paintComponent(Graphics g){
	    super.paintComponent(g);
	    if (image != null){
	        //int x = this.getParent().getWidth()/2 - iWidth2;
	        //int y = this.getParent().getHeight()/2 - iHeight2;
	        g.drawImage(image,0,0,this);
	    }
	}
}
