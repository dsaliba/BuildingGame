package Game;

import java.io.Serializable;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import BuildingTypes.Agriculture;
import BuildingTypes.Building;
import BuildingTypes.Commerce;
import BuildingTypes.Defense;
import BuildingTypes.EmpteyPlot;
import BuildingTypes.Recreation;
import BuildingTypes.Shelter;



@SuppressWarnings("javadoc")
public class Stats implements Serializable{
	public static int coins;
	public static int food;
	public static int happiness;
	public static int defense;
	public static int coinsIncome;
	public static int foodIncome;
	public static int population;
	public static int maxPopuulation;
		public static String tax;
		public static int coinTax;
		public static int numBuildings;
		public static int taxHap;
		public static int day;
		public static int width;
		public static int height;
	public static int happinessIncome;
	
	public static ArrayList<ArrayList<Building>> buildings;
	
	public Stats() {
		height = 6;
		width = 6;
		buildings = new ArrayList<ArrayList<Building>>();
		for (int r = 0; r < width; r++) {
			buildings.add(new ArrayList<Building>());
			for (int c = 0; c < height; c++) {
				buildings.get(r).add(new EmpteyPlot());
			}
		}
		coins = 200;
		food = 0;
		happiness = 50;
		defense = 0;
		coinsIncome = 5;
		foodIncome = 0;
		population = 0;
		maxPopuulation = 0;
		tax = "Medium";
		coinTax = 0;
		numBuildings = 0;
		taxHap = 0;
		day = 0;
		happinessIncome = 0;
	}
	
	
	
	public String runDay() {
		day++;
		updateRescources();
		happiness += happinessIncome;
		coins += coinsIncome;
		food += foodIncome;
		if(happiness > 30) {
			int people = (int) ((Math.random() * 5) * (population + 0.5));
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
		
		int leftover = food - population;
		if (leftover >= 0) {
			food = leftover;
		}else {
			food = 0;
			leftover = (-leftover);
			population -= leftover;
			happiness -= 5;
			updateRescources();
			if (leftover > 1) {
				return leftover + " people died of starvation";
			}
			return leftover + " person died of starvation";
		}
		updateRescources();
		return "";
	}
	
	public int setBuilding(char building, int x, int y) {
		if (!buildings.get(x).get(y).toString().equals("e0")) {
			if(building == 'e') {
				buildings.get(x).set(y, new EmpteyPlot());
				updateRescources();
				numBuildings --;
				return 0;
			}
			return -2;
		}
		numBuildings ++;
		switch (building) {
		case 'a':
			if (coins >= 30) {
				buildings.get(x).set(y, new Agriculture());
				coins -= 30;
				updateRescources();
				return 30;
			}
			break;
		case 'c':
			if (coins >= 50) {
				buildings.get(x).set(y, new Commerce());
				coins -= 50;
				updateRescources();
				return 50;
			}
			break;
		case 'd':
			if (coins >= 100) {
				buildings.get(x).set(y, new Defense());
				coins -= 100;
				updateRescources();
				return 100;
			}
			break;
		case 's':
			if (coins >= 25) {
				buildings.get(x).set(y, new Shelter());
				coins -= 25;
				updateRescources();
				return 25;
			}
			break;
		case 'r':
			if (coins >= 10) {
				buildings.get(x).set(y, new Recreation());
				coins -= 10;
				updateRescources();
				return 10;
			}
			break;

			
		}
		return -1;
	}
	
	@Override
	public String toString() {
		updateRescources();
		return "Gold: " + coins + "\nPopulation: " + population + "/" + maxPopuulation  + "\nHappiness: " + happiness + "%" + "\nTax: " + tax
				+ "\nFood: " + food + "\nBuildings: " + numBuildings + "\nDefense: " + defense + "\nTax Income: "
				+ coinTax + "\nIncome: " + (coinsIncome + coinTax) + "\nFood Yield: " + foodIncome + "\nMood: " + happinessIncome;
	}

	
	public void updateRescources() {
		defense = 0;
		maxPopuulation = 0;
		foodIncome = 0;
		coinsIncome = 0;
		happinessIncome = 0;
		int rCount = 0;
		
		for (ArrayList<Building> buildingList: buildings) {
			int cCount = 0;
			for (Building building: buildingList) {
				String id = building.newDay();
				switch (id.charAt(0)) {
				case 'c':
					int tempPop2 = population;
					if (tempPop2 > 0) {
						for (int r = -1; r < 3; r++) {
							if(!(rCount + r < 0 || rCount + r > width-1)) {
							for (int c = -1; c < 3; c++) {
								if(!(cCount + c < 0 || cCount + c > height-1)) { 
								String next = buildings.get(r+rCount).get(c+cCount).toString();
								if (next.charAt(0) == 'p') {
									for (int i = 0; i < Integer.parseInt(next.substring(1)); i++) {
										if (tempPop2 < 1) break;
										coinsIncome += Integer.parseInt(id.substring(1));
										tempPop2 --;
									}
								}
								}
							}
							}
						}
					}
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
					int tempPop = population;
					if (tempPop > 0) {
						for (int r = -1; r < 3; r++) {
							if(!(rCount + r < 0 || rCount + r > width-1)) {
							for (int c = -1; c < 3; c++) {
								if(!(cCount + c < 0 || cCount + c > height-1)) { 
								String next = buildings.get(r+rCount).get(c+cCount).toString();
								if (next.charAt(0) == 'p') {
									for (int i = 0; i < Integer.parseInt(next.substring(1)); i++) {
										if (tempPop < 1) break;
										happinessIncome += Integer.parseInt(id.substring(1));
										tempPop --;
									}
								}
								}
							}
							}
						}
					}
					
					
					
					
					//happinessIncome += Integer.parseInt(id.substring(1));
					break;
					
				}
				cCount++;
			}
			rCount++;
		}
		double taxNum = 0;
		switch(tax) {
		case "Low":
			taxNum = 2.3;
			taxHap = 1;
			break;
		case "Medium":
			taxNum = 2.5;
			taxHap = 0;
			break;
		case "High":
			taxNum = 2.7;
			taxHap = -3;
			break;
		}
		coinTax = (int) (population*taxNum);
		happinessIncome += taxHap*population;
		
		
		
		if(happiness >= 100) {
			happiness = 100;
		}
		if (happiness <= 0) {
			happiness = 0;
		}
	}
}
