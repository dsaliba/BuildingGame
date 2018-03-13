package Game;
import UI.Frame;

public class GameRunner {
	
	public static void main(String[] args) {
		Stats stats = new Stats();
		Frame frame = new Frame(stats);
		frame.createFrame();
	}
}
