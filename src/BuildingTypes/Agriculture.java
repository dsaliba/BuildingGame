package BuildingTypes;

/**
 * 
 * @author Dimitri Saliba
 * @author Mike Chang
 * @author Luke Souter
 *
 */
public class Agriculture extends Building {
	
	public Agriculture() {
		super();
		level = 1;
	}

	
	@Override
	public String newDay() {
		String out = "f";
		switch(level) {
		case 1:
			out += 5;
			break;
		case 2:
			out += 10;
			break;
		}
		return out;
	}
	
	

	@Override
	public double upgrade(double money) {
		if (level < 3) {
			switch (level){
			case 1:
				if (money >= 300.0) {
					level++;
					return 300.0;
				}
				break;
			}
		}
		return -1.0;
	}

	@Override
	public String toString() {
		return "f" + level;
	}
	
}
