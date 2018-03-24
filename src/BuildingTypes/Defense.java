package BuildingTypes;

import java.io.Serializable;

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
			out += 1;
			break;
		case 2:
			out += 5;
			break;
		}
		return out;
	}


	@Override
	public double upgrade(double money) {
		if (level < 3) {
			switch (level){
			case 1:
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
		return "d" + level;
	}
	
}
