package BuildingTypes;

/**
 * 
 * @author Dimitri Saliba
 * @author Mike Chang
 * @author Luke Souter
 *
 */
public class Defense extends Building {

	public Defense() {
		super();
		level = 1;
	}

	public Defense(int level) {
		super();
		this.level = level;
	}
	
	@Override
	public String newDay() {
		String out = "d";
		switch(level) {
		case 1:
			out += 7;
			break;
		case 2:
			out += 21;
			break;
		}
		return out;
	}


	@Override
	public String toString() {
		return "d" + level;
	}
	
	@Override
	public int upgrade(double money) {
		if (level < 3) {
			switch (level){
			case 1:
				if (money >= 200) {
					level++;
					return 200;
				}
				break;
			}
		}
		return -1;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "tower";
	}
	
	@Override
	public String getPrice() {
		switch (level) {
		case 1:
			return "200";
		case 2:
			return "Max";
		}
		return "";
	}
	
}
