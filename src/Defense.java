
public class Defense extends Building{

	public Defense() {
		super();
		level = 1;
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
	
}
