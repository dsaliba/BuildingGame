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
		break;
		case 1:
			celebrity = "Jennifer Lawrence";
		break;
		case 2:
			celebrity = "Keanu Reeves";
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
			break;
		case 5:
			celebrity = "Tom Cruise";
			int r = (int) (Math.random() * stats.width);
			int c = (int) (Math.random() * stats.height);
			String name = Stats.buildings.get(r).get(c).getName();
			Stats.buildings.get(r).set(c, new EmpteyPlot());
			if (name == null) {
				return celebrity + " sets off explosions in an abandoned part of town.";
			}
			return celebrity + " blows up a " + name + " and runs away!";
		case 6:
			celebrity = "Artour \"Arteezy\" Babaev";
			Stats.population =- 3;
			Stats.happiness += 20;
			return celebrity + " rages really hard and kills multiple people, but makes people laugh!";
		case 7:
			celebrity = "Dimitri Saliba";
			//DIMITRI PUT YOUR STUFF HERE
			//MAKE SURE YOU RETURN
			break;
		case 8:
			celebrity = "Michael Chang";
			//MICHAEL PUT YOUR STUFF HERE
			//MAKE SURE YOU RETURN
			break;
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
