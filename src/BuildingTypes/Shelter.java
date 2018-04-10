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
			out += 5;
			break;
		case 3:
			out += 15;
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
				if (money >= 100) {
					level++;
					return 100;
				}
				break;
			case 2: 
				if (money >= 250) {
					level++;
					return 250;
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
			return "250";
		case 3:
			return "Max";
		}
		return "";
	}
}
