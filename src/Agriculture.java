
public class Agriculture extends Building {
	private int foodYeild;
	
	
	public Agriculture() {
		super();
		foodYeild = 0;
	}
	
	public Agriculture(String name, double cost, int foodYield) {
		super(name, cost);
		this.foodYeild = foodYield;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
