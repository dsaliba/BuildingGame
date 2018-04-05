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
	
	public Agriculture(int level) {
		super();
		this.level = level;
	}

	
	@Override
	public String newDay() {
		String out = "f";
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
		return "f" + level;
	}

	@Override
	public int upgrade(double money) {
		if (level < 3) {
			switch (level){
			case 1:
				if (money >= 300) {
					level++;
					return 300;
				}
				break;
			}
		}
		return -1;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "farm";
	}
	
}
