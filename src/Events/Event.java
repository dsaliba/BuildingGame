package Events;

import Game.Stats;

public abstract class Event {
	public int probability;
	public int dayAvailable;
	public int buffer;
	public int count;
	
	public Event() {
		count = 0;
	}
	
	public boolean available(Stats stats) {
		return specialConditions(stats)&&(count >= buffer)&&stats.day >= dayAvailable;
	}
	
	public abstract String execute(Stats stats);
	
	public abstract boolean specialConditions(Stats stats);
}
