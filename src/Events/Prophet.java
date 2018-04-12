package Events;

import Game.Stats;

public class Prophet extends Event{

	public Prophet() {
		super();
		probability = 2;
		dayAvailable = 20;
		buffer = -1;
	}
	
	@Override
	public String execute(Stats stats) {
		Stats.happiness = 100;
		Stats.coins += Stats.population * 100;
		return "Jesus Christ has arrived! Great fortune will come!";
	}

	@Override
	public boolean specialConditions(Stats stats) {
		return true;
	}

}