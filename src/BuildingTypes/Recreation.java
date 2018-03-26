package BuildingTypes;

/**
 * 
 * @author Dimitri Saliba
 * @author Mike Chang
 * @author Luke Souter
 *
 */
public class Recreation extends Building {

	public Recreation() {
		super();
		level = 1;
	}

	public Recreation(int level) {
		super();
		this.level = level;
	}
	
	@Override
	public String newDay() {
		String out = "r";
		switch(level) {
		case 1:
			out += 2;
			break;
		case 2:
			out += 5;
			break;
		}
		return out;
	}


	@Override
	public String toString() {
		return "r" + level;
	}
	
	@Override
	public int upgrade(double money) {
		if (level < 3) {
			switch (level){
			case 1:
				if (money >= 150) {
					level++;
					return 150;
				}
				break;
			}
		}
		return -1;
	}
}
