
public abstract class Building {
	private String name;
	private double cost;
	
	public Building() {
		name = "unDif";
		cost = 0;
	}
	
	public Building(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}
	
	public String getName() {
		return name;
	}
	
	public double getCost() {
		return cost;
	}
	
	//This will be called each turn
	abstract public void update();
	
}
