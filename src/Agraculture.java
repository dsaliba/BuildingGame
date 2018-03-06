
public class Agraculture extends Building {
	
	/**
	 * Food per turn
	 */
	private int food;
	
	public Agraculture() {
		super();
		level = 1;
	}

	
	@Override
	public String newDay() {
		// TODO Auto-generated method stub
		return ("f" + (level * 5));
	}


	@Override
	public boolean upgrade(double money) {
		if (level < 2) {
			if (money > 300) {
				level++;
				return true;
			}
		}
		return false;
	}

	
	
}
