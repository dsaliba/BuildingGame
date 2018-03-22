package Events;

import Game.Stats;

public abstract class Event {
	public int probability;
	public int dayAvailable;
	
	public abstract String execute(Stats stats);
	
	public abstract boolean specialConditions(Stats stats);
}
