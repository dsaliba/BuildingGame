package Game;

import java.util.ArrayList;

import Events.Event;

public class EventPlanner {
	Stats stats;
	ArrayList<Event> events;
	
	public EventPlanner(Stats s) {
		stats = s;
	}
	
	public String runEvent() {
		if (events.size() == 0) return "";
		int count = 0;
		for (Event e: events) {
			if (stats.day >= e.dayAvailable && e.specialConditions(stats)) {
				count += e.probability;
			}
			
		}
		
		int rng = (int) ((Math.random()*count) + 1);
		
		int newCount = 0;
		for (Event e: events) {
			if (stats.day >= e.dayAvailable && e.specialConditions(stats)) {
				count += e.probability;
			}
			if (newCount == rng) {
				return e.execute(stats);
			}
		}
		return null;
	}
	
}
