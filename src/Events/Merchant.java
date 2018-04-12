package Events;

import Game.Stats;

public class Merchant extends Event{

	public Merchant() {
		super();
		probability = 5;
		dayAvailable = 5;
		buffer = 10;
	}
	
	@Override
	public String execute(Stats stats) {
		int num  = (int) (Stats.population * ((Math.random() * 6) + 1));
		stats.coins += num;
		return " A traveling merchant has arived, you gained " + num + " coins";
	}

	@Override
	public boolean specialConditions(Stats stats) {
		return (Stats.population >= 1 && Stats.happiness >= 50);
	}

}
