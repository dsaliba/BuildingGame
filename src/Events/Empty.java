package Events;

import Game.Stats;

public class Empty extends Event{

	public Empty() {
		super();
		probability = 50;
		dayAvailable = 0;
		buffer = 0;
	}
	
	@Override
	public String execute(Stats stats) {
		return "";
	}

	@Override
	public boolean specialConditions(Stats stats) {
		return true;
	}

}
