
public abstract class Building {
	
	/**
	 * The stage of evolution
	 */
	protected int level;
	
	
	/**
	 * This method returns a string showing what it does each day
	 * @return String in format "(letter for building type) (Number)
	 */
	public abstract String newDay();
	
	/**
	 * This method is for updating the building type
	 * @return Whether or not the building could be successfully upgraded
	 */
	public abstract boolean upgrade(double money);
}
