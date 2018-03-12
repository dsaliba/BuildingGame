
public class Commerce extends Building{

	public Commerce() {
		super();
		level = 1;
	}

	
	@Override
	public String newDay() {
		String out = "c";
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
				if (money >= 250.0) {
					level++;
					return 250.0;
				}
				break;
			}
		}
		return -1.0;
	}
	
	@Override
	public String toString() {
		return "c" + level;
	}
}
