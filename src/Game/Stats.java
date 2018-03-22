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
	public static int taxHap;
	public static int day;
	
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
		taxHap = 0;
		day = 0;
		
	}
	
	public void runDay() {
		day++;
		updateRescources();
		if (tax.equals("Low")) {
			taxHap += 5;
		}else if(tax.equals("High")) {
			taxHap -= 5;
		}
		coins += coinsIncome;
		food += foodIncome;
		if(happiness > 30) {
			int people = (int) ((Math.random() * 5) * ((double)population + 0.5));
		if (population < 70) {
			if (people > 1) people = 1;
		}
		population += people;
		if (population > maxPopuulation) {
			population = maxPopuulation;
		}
		}else {
			population--;
			if (population < 0) population = 0;
		}
		
		coins += coinTax;
		
		updateRescources();
	}
	
	public double setBuilding(char building, int x, int y) {
		if (!buildings[x][y].toString().equals("e0")) {
			if(building == 'e') {
				buildings[x][y] = new EmpteyPlot();
				updateRescources();
				numBuildings --;
				return 0;
			}
			return -2.0;
		}
		numBuildings ++;
		switch (building) {
		case 'a':
			if (coins >= 20) {
				buildings[x][y] = new Agriculture();
				coins -= 20;
				updateRescources();
				return 20;
			}
			break;
		case 'c':
			if (coins >= 50) {
				buildings[x][y] = new Commerce();
				coins -= 50;
				updateRescources();
				return 50;
			}
			break;
		case 'd':
			if (coins >= 100) {
				buildings[x][y] = new Defense();
				coins -= 100;
				updateRescources();
				return 100;
			}
			break;
		case 's':
			if (coins >= 25) {
				buildings[x][y] = new Shelter();
				coins -= 25;
				updateRescources();
				return 25;
			}
			break;
		case 'r':
			if (coins >= 10) {
				buildings[x][y] = new Recreation();
				coins -= 10;
				updateRescources();
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
					maxPopuulation += Integer.parseInt(id.substring(1));
					break;
				case 'r':
					happiness += Integer.parseInt(id.substring(1));
					break;
					
				}
			}
		}
		double taxNum = 0;
		switch(tax) {
		case "Low":
			taxNum = 2.3;
			break;
		case "Medium":
			taxNum = 2.5;
			break;
		case "High":
			taxNum = 2.7;
			break;
		}
		coinTax = population*taxNum;
		happiness += taxHap;
		if(happiness >= 100) {
			happiness = 100;
		}
		if (happiness <= 0) {
			happiness = 0;
		}
	}

	
	public String toString() {
		updateRescources();
		return "Gold: " + coins + " \nPeople: " + population + "\nHappiness: " + happiness + "%" + "\nTax: " + tax
				+ "\nFood: " + food + "\nBuildings: " + numBuildings + "\nDefense: " + defense + "\nTax Income: "
				+ coinTax + "\nIncome: " + coinsIncome + "\nFood Yield: " + foodIncome;
	}
}
