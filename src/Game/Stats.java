package Game;
import java.util.ArrayList;

import BuildingTypes.Agriculture;
import BuildingTypes.Building;
import BuildingTypes.Commerce;
import BuildingTypes.Defense;
import BuildingTypes.EmpteyPlot;
import BuildingTypes.Recreation;
import BuildingTypes.Shelter;



public class Stats {
	public static double coins;
	public static int food;
	public static int happiness;
	public static int defense;
	public static double coinsIncome;
	public static int foodIncome;
	public static int population;
	public static int maxPopuulation;
	public static String tax;
	public static double coinTax;
	public static int numBuildings;
	
	public static Building[][] buildings;
	
	public Stats() {
		buildings = new Building[gameConstants.ROW][gameConstants.COL];
		for (int r = 0; r < buildings.length; r++) {
			for (int c = 0; c < buildings[r].length; c++) {
				buildings[r][c] = new BuildingTypes.EmpteyPlot();
			}
		}
		coins = 200;
		food = 0;
		happiness = 0;
		defense = 0;
		coinsIncome = 5;
		foodIncome = 0;
		population = 0;
		maxPopuulation = 0;
		tax = "Medium";
		coinTax = 0.0;
		numBuildings = 0;
	}
	
	public void runDay() {
		updateRescources();
		
	}
	
	public double setBuilding(char building, int x, int y) {
		if (!buildings[x][y].toString().equals("e0")) {
			return -2.0;
		}
		switch (building) {
		case 'a':
			if (coins >= 20) {
				buildings[x][y] = new Agriculture();
				coins -= 20;
				return 20;
			}
			break;
		case 'c':
			if (coins >= 50) {
				buildings[x][y] = new Commerce();
				coins -= 50;
				return 50;
			}
			break;
		case 'd':
			if (coins >= 100) {
				buildings[x][y] = new Defense();
				coins -= 100;
				return 100;
			}
			break;
		case 's':
			if (coins >= 25) {
				buildings[x][y] = new Shelter();
				coins -= 25;
				return 25;
			}
			break;
		case 'r':
			if (coins >= 10) {
				buildings[x][y] = new Recreation();
				coins -= 10;
				return 10;
			}
			break;
		}
		return -1.0;
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
