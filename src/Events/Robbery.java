package Events;

import Game.Stats;

public class Robbery extends Event{

	public Robbery() {
		super();
		probability = 3;
		dayAvailable = 5;
		buffer = 10;
	}
	
	@Override
	public String execute(Stats stats) {
		int num  = (int) (Stats.coins * ((Math.random() * 50) + 1));
		stats.coins -= num;
		return "You have been robbed for " + num + " coins.";
	}

	@Override
	public boolean specialConditions(Stats stats) {
		return (Stats.defense < (Stats.population / 3));
	}

}
