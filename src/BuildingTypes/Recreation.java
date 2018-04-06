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
			out += 1;
			break;
		case 2:
			out += 3;
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

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "tree";
	}
	
	@Override
	public String getPrice() {
		switch (level) {
		case 1:
			return "150";
		case 2:
			return "Max";
		}
		return "";
	}
}
