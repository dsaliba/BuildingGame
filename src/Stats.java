import java.util.ArrayList;



public class Stats {
	public static double coins;
	public static int food;
	public static int happiness;
	public static int defense;
	public static double coinsIncome;
	public static int foodIncome;
	public static int population;
	public static int maxPopuulation;
	
	public static Building[][] buildings;
	
	public Stats() {
		buildings = new Building[gameConstants.ROW][gameConstants.COL];
		for (int r = 0; r < buildings.length; r++) {
			for (int c = 0; c < buildings[r].length; c++) {
				buildings[r][c] = new EmpteyPlot();
			}
		}
		coins = 200;
		food = 0;
		happiness = 0;
		defense = 0;
		coinsIncome = 0;
		foodIncome = 0;
		population = 0;
		maxPopuulation = 0;
	}
	
	public void runDay() {
		updateRescources();
		
	}
	
	public void updateRescources() {
		defense = 0;
		happiness = 50;
		maxPopuulation = 0;
		foodIncome = 0;
		coinsIncome = 0;
		for (Building[] buildingList: buildings) {
			for (Building building: buildingList) {
				String id = building.toString();
				switch (id.charAt(0)) {
				case 'c':
					coinsIncome += Double.parseDouble(id.substring(1));
					break;
				case 'd':
					defense += Integer.parseInt(id.substring(1));
					break;
				case 'f':
					foodIncome += Integer.parseInt(id.substring(1));
					break;
				case 'p':
					population += Integer.parseInt(id.substring(1));
					break;
				case 'h':
					happiness += Integer.parseInt(id.substring(1));
					break;
				}
			}
		}
		coins += coinsIncome;
		food += foodIncome;
	}

}
