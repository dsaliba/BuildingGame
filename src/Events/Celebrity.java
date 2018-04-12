package Events;

import BuildingTypes.EmpteyPlot;
import BuildingTypes.Shelter;
import Game.Stats;

public class Celebrity extends Event{

	public Celebrity() {
		super();
		probability = 2;
		dayAvailable = 10;
		buffer = 10;
	}
	
	@Override
	public String execute(Stats stats) {
		Stats.population = Stats.maxPopuulation;
		Stats.coins =+ Stats.population * 7;
		Stats.happiness =+ 20;
		int celebrityIndex = (int) (Math.random() * 10);
		String celebrity;
		switch(celebrityIndex) {
			case 0:
				celebrity = "Johnny Depp";
				Stats.coins -= 250;
				return celebrity + " might be a bad pirate, but at least you've heard of him! He steals some of your money!";
				
		break;
		case 1:
			celebrity = "Jennifer Lawrence";
			Stats.defense += 10;
			Stats.coins += 100;
			return celebrity + " shoots a movie in your town, and her security guards increase your defense!";
		break;
		case 2:
			celebrity = "Keanu "
					+ "Reeves";
			Stats.happiness =+ 100;
			int r = (int) (Math.random() * stats.width);
			int c = (int) (Math.random() * stats.height);
			String name = Stats.buildings.get(r).get(c).getName();
			Stats.buildings.get(r).set(c, new Shelter());
			if (name == null) {
				return "Keanu Reeves builds a homeless shelter in your town!";
			}
			return "Keanu Reeves destroys a " + name + " and replaces it with a homeless shelter!";
			break;
		case 3:
			celebrity = "Ewan McGregor";
			Stats.defense += 10;
			Stats.population =- 5;
			return celebrity + " takes some of your children and trains Jedi, increasing your defense!";
			break;
		case 4:
			celebrity = "Danil \"Dendi\" Ishutin";
			Stats.coins += 250;
			return celebrity + " wins a TI and gives you his prize money!";
			break;
		case 5:
			celebrity = "Tom Cruise";
			int rr = (int) (Math.random() * stats.width);
			int rc = (int) (Math.random() * stats.height);
			String bName = Stats.buildings.get(rr).get(rc).getName();
			Stats.buildings.get(rr).set(rc, new EmpteyPlot());
			if (bName == null) {
				return celebrity + " sets off explosions in an abandoned part of town.";
			}
			return celebrity + " blows up a " + bName + " and runs away!";
		case 6:
			celebrity = "Artour \"Arteezy\" Babaev";
			Stats.population =- 3;
			Stats.happiness += 20;
			return celebrity + " rages really hard and murders multiple people, but makes people laugh!";
		case 7:
			celebrity = "Dimitri Saliba";
			Stats.coins += 500;
			return celebrity + " codes a program to cheat your money supply!";
		case 8:
			celebrity = "Michael Chang";
			Stats.happiness += 20;
			Stats.coins += 100;
			return celebrity + " makes your town look super pretty!";
		case 9:
			celebrity = "Luke Souter";
			Stats.population = 1;
			return celebrity + " kills everyone in your village and settles in one of your tents!";
		
		case 10:
			return "A celebrity was supposed to arrive in your village, but was brutally murdered!";
		}
		return "";
	}

	@Override
	public boolean specialConditions(Stats stats) {
		return (Stats.population > 1 && Stats.defense <= Stats.population/3);
	}

}
