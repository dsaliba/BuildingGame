package BuildingTypes;

/**
 * 
 * @author Dimitri Saliba
 * @author Mike Chang
 * @author Luke Souter
 *
 */
public class Shelter extends Building {

	public Shelter() {
		super();
		level = 1;
	}
	
	public Shelter(int level) {
		super();
		this.level = level;
	}

	
	@Override
	public String newDay() {
		String out = "p";
		switch(level) {
		case 1:
			out += 1;
			break;
		case 2:
			out += 3;
			break;
		case 3:
			out += 6;
			break;
		}
		return out;
	}


	@Override
	public String toString() {
		return "p" + level;
	}
	
	@Override
	public int upgrade(double money) {
		if (level < 4) {
			switch (level){
			case 1:
				if (money >= 100.0) {
					level++;
					return 100;
				}
				break;
			case 2: 
				if (money >= 500.0) {
					level++;
					return 500;
				}
				break;
			}
		}
		return -1;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "shelter";
	}
	
	@Override
	public String getPrice() {
		switch (level) {
		case 1:
			return "100";
		case 2:
			return "500";
		case 3:
			return "Max";
		}
		return "";
	}
}
