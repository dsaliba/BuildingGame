package Game;
import java.io.IOException;

import UI.Frame;

public class GameRunner {
	
	public static void main(String[] args) throws IOException {
		Stats stats = new Stats();
		Frame frame = new Frame(stats);
		frame.createFrame();
	}
}
