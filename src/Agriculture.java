

public abstract class Agriculture extends Building {
	private double bonus;
	
	
	public Agriculture() {
		super();
		bonus = 1;
	}

	
	@Override
	abstract public int update();

}
