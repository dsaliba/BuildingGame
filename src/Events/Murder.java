package Events;

import Game.Stats;

public class Murder extends Event{

	public Murder() {
		super();
		probability = 1;
		dayAvailable = 5;
	}
	
	@Override
	public String execute(Stats stats) {
		stats.population --;
		return "A town member has been killed";
	}

	@Override
	public boolean specialConditions(Stats stats) {
		return (stats.population > 1);
	}

}
