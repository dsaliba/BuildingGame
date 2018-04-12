package Events;

import Game.Stats;

public class Murder extends Event{

	public Murder() {
		super();
		probability = 3;
		dayAvailable = 5;
		buffer = 3;
	}
	
	@Override
	public String execute(Stats stats) {
		Stats.population --;
		return " A town member has been murdered";
	}

	@Override
	public boolean specialConditions(Stats stats) {
		return (Stats.population > 1 && Stats.defense <= Stats.population/3);
	}

}
