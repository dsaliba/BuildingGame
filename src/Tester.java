import Game.Stats;
import UI.Frame;

public class Tester {

	public static void main(String[] args) {
		Stats stats = new Stats();
		Frame f = new Frame(stats);
		f.createFrame();
	}
}
