package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import BuildingTypes.Agriculture;
import BuildingTypes.Building;
import BuildingTypes.Commerce;
import BuildingTypes.Defense;
import BuildingTypes.EmpteyPlot;
import BuildingTypes.Recreation;
import BuildingTypes.Shelter;



public class SaveManager {
	public File save;
	private FileWriter writer;
	private Scanner reader;
	private int x = gameConstants.ROW;
	private int y = gameConstants.COL;
	
	public SaveManager(){
		save = new File("Save.txt");
		
	}
	
	public Stats readSave(){
		Stats stats = new Stats();
		try {
			reader = new Scanner(save);
		
		
		Stats.coins = Integer.parseInt(reader.nextLine());
		Stats.happiness = Integer.parseInt(reader.nextLine());
		Stats.day = Integer.parseInt(reader.nextLine());
		for (int r = 0; r < x; r++) {
			for (int c = 0; c < y; c++) {
				String id = reader.nextLine();
				switch(id.charAt(0)) {
				case 'f':
					Stats.buildings[r][c] = new Agriculture(id.charAt(1)-48);
					break;
				case 'c':
					Stats.buildings[r][c] = new Commerce(id.charAt(1)-48);
					break;
				case 'd':
					Stats.buildings[r][c] = new Defense(id.charAt(1)-48);
					break;
				case 'h':
					Stats.buildings[r][c] = new Recreation(id.charAt(1)-48);
					break;
				case 'p':
					Stats.buildings[r][c] = new Shelter(id.charAt(1)-48);
					break;
				default:
					Stats.buildings[r][c] = new EmpteyPlot();
				}
			}
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stats.updateRescources();
		
		return stats;
	}
	
	public void writeSave(Stats stats){
		
		try {
			writer = new FileWriter(save);
		
		writer.write(Stats.coins + "\n" + Stats.happiness + "\n" + Stats.day + "\n");
		for (Building[] buildings : Stats.buildings) {
			for(Building building : buildings) {
				writer.write(building.toString() + "\n");
			}
		}
		writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
