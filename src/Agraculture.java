
public class Agraculture extends Building {
	
	
	
	public Agraculture() {
		super();
		level = 1;
	}

	
	@Override
	public String newDay() {
		return ("f" + (level * 5));
	}


	@Override
	public double upgrade(double money) {
		if (level < 3) {
			if (money >= 300) {
				level++;
				return 300.0;
			}
		}
		return -1.0;
	}

	
	
}
