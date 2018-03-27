package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
	
	public SaveManager(){
		save = new File("Save.txt");
		
	}
	
	public Stats readSave(){
		Stats stats = new Stats();
		try {
			reader = new Scanner(save);
		
		
		stats.coins = Integer.parseInt(reader.nextLine());
		stats.happiness = Integer.parseInt(reader.nextLine());
		stats.day = Integer.parseInt(reader.nextLine());
		stats.population = Integer.parseInt(reader.nextLine());
		stats.width = Integer.parseInt(reader.nextLine());
		stats.height = Integer.parseInt(reader.nextLine());
		for (int r = 0; r < stats.width; r++) {
			for (int c = 0; c < stats.height; c++) {
				String id = reader.nextLine();
				switch(id.charAt(0)) {
				case 'f':
					Stats.buildings.get(r).set(c, new Agriculture(id.charAt(1)-48));
					break;
				case 'c':
					Stats.buildings.get(r).set(c, new Commerce(id.charAt(1)-48));
					break;
				case 'd':
					Stats.buildings.get(r).set(c, new Defense(id.charAt(1)-48));
					break;
				case 'h':
					Stats.buildings.get(r).set(c, new Recreation(id.charAt(1)-48));
					break;
				case 'p':
					Stats.buildings.get(r).set(c, new Shelter(id.charAt(1)-48));
					break;
				default:
					Stats.buildings.get(r).set(c, new EmpteyPlot());
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
		
		writer.write(Stats.coins + "\n" + Stats.happiness + "\n" + Stats.day + "\n" + Stats.population + "\n" + stats.width + "\n" + stats.height + "\n");
		for (ArrayList<Building> buildings : Stats.buildings) {
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
