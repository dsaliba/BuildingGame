package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.NEW;

import BuildingTypes.*;



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
		
		
		stats.coins = Integer.parseInt(reader.nextLine());
		stats.happiness = Integer.parseInt(reader.nextLine());
		stats.day = Integer.parseInt(reader.nextLine());
		for (int r = 0; r < x; r++) {
			for (int c = 0; c < y; c++) {
				String id = reader.nextLine();
				switch(id.charAt(0)) {
				case 'f':
					stats.buildings[r][c] = new Agriculture(id.charAt(1)-48);
					break;
				case 'c':
					stats.buildings[r][c] = new Commerce(id.charAt(1)-48);
					break;
				case 'd':
					stats.buildings[r][c] = new Defense(id.charAt(1)-48);
					break;
				case 'h':
					stats.buildings[r][c] = new Recreation(id.charAt(1)-48);
					break;
				case 'p':
					stats.buildings[r][c] = new Shelter(id.charAt(1)-48);
					break;
				default:
					stats.buildings[r][c] = new EmpteyPlot();
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
		
		writer.write(stats.coins + "\n" + stats.happiness + "\n" + stats.day + "\n");
		for (Building[] buildings : stats.buildings) {
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
