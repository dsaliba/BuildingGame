package Events;

import BuildingTypes.EmpteyPlot;
import Game.Stats;

public class Ransack extends Event{

	public Ransack() {
		super();
		probability = 1;
		dayAvailable = 25;
		buffer = 25;
	}
	
	@Override
	public String execute(Stats stats) {
		int r = (int) (Math.random() * stats.width);
		int c = (int) (Math.random() * stats.height);
		String name = Stats.buildings.get(r).get(c).getName();
		Stats.buildings.get(r).set(c, new EmpteyPlot());
		if (name == null) {
			return " The town was ransacked but nothing was destroyed";
		}
		return " The town was ransakced, a " + name + " was destroyed";
	}

	@Override
	public boolean specialConditions(Stats stats) {
		return (stats.defense <= (stats.numBuildings / 2));
	}

}
