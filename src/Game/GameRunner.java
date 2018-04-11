package Game;
import java.io.IOException;

import UI.Frame;
import UI.Music;

public class GameRunner {
	
	public static void main(String[] args) throws IOException {
		Frame frame = new Frame();
	
		frame.createFrame();
		
		System.out.println("gamerunner");
		Music m = new Music();
	//	m.startBGMusic("click.mp3");
	}
}
