package Game;

import java.util.ArrayList;

import Events.Event;
import Events.Murder;

public class EventPlanner {
	Stats stats;
	ArrayList<Event> events;
	
	public EventPlanner(Stats s) {
		events = new ArrayList<Event>();
		events.add(new Murder());
		stats = s;
	}
	
	public String runEvent() {
		
		int count = 0;
		for (Event e: events) {
			if (Stats.day >= e.dayAvailable && e.specialConditions(stats)) {
				count += e.probability;
			}
			
		}
		
		if (count == 0) return "";
		
		int rng = (int) ((Math.random()*count) + 1);
		
		int newCount = 0;
		int last = 0;
		for (Event e: events) {
			if (Stats.day >= e.dayAvailable && e.specialConditions(stats)) {
				last = newCount;
				newCount += e.probability;
			}
			if (rng > last && rng <= newCount) {
				return e.execute(stats);
			}
		}
		return null;
	}
	
}
