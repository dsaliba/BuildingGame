package Game;

import java.util.ArrayList;

import javax.naming.InsufficientResourcesException;

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
			if (e.available(stats)) {
				count += e.probability;
			}
			
		}
		
		if (count == 0) return "";
		
		int rng = (int) ((Math.random()*count) + 1);
		
		int newCount = 0;
		int last = 0;
		for (int i = 0; i < events.size(); i++) {
			if (events.get(i).available(stats)) {
				last = newCount;
				newCount += events.get(i).probability;
			}
			if (rng > last && rng <= newCount) {
				for (Event e: events) {
					e.count ++;
				}
				events.get(i).count = 0;
				String message = events.get(i).execute(stats);
				if(events.get(i).buffer == -1)events.remove(i);
				return message;
			}
		}
		return null;
	}
	
}
