package BuildingTypes;

import java.io.Serializable;

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
			out += 2;
			break;
		case 2:
			out += 5;
			break;
		case 3:
			out += 10;
			break;
		}
		return out;
	}


	@Override
	public double upgrade(double money) {
		if (level < 4) {
			switch (level){
			case 1:
				if (money >= 100.0) {
					level++;
					return 100.0;
				}
				break;
			case 2: 
				if (money >= 500.0) {
					level++;
					return 500.0;
				}
				break;
			}
		}
		return -1.0;
	}
	
	@Override
	public String toString() {
		return "p" + level;
	}
	
}
