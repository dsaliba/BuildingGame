package BuildingTypes;

/**
 * 
 * @author Dimitri Saliba
 * @author Mike Chang
 * @author Luke Souter
 *
 */
public abstract class Building {
	
	
	/**
	 * The stage of evolution
	 */
	public int level;
	
	
	/**
	 * This method returns a string showing what it does each day
	 * @return String in format "(letter for building type) (Number)
	 */
	public abstract String newDay();
	
	/**
	 * This method is for updating the building type
	 * @return Whether or not the building could be successfully upgraded
	 */
	public abstract int upgrade(double money);
	
	public abstract String getName();
}
