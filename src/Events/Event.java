package Events;

import com.sun.org.glassfish.external.statistics.Stats;

public abstract class Event {
	public double probability;
	
	public abstract String execute(Stats stats) {
		
	}
	
}
