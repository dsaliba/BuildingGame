package Game;

import java.util.ArrayList;

import javax.naming.InsufficientResourcesException;

import Events.*;

public class EventPlanner {
	Stats stats;
	ArrayList<Event> events;
	
	public EventPlanner(Stats s) {
		events = new ArrayList<Event>();
		events.add(new Murder());
		events.add(new Ransack());
		events.add(new Empty());
		events.add(new Robbery());
		events.add(new Merchant());
		stats = s;
	}
	
	public String runEvent() {
		
		int count = 0;
		for (Event e: events) {
			if (e.available(stats)) {
				//system.out.println(e.getClass().getName());
				count += e.probability;
			}
			
		}
		for (Event e: events) {
			e.count ++;
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
				events.get(i).count = 0;
				String message = events.get(i).execute(stats);
				if(events.get(i).buffer == -1)events.remove(i);
				//system.out.println(message);
				return message;
			}
		}
		return null;
	}
	
}
