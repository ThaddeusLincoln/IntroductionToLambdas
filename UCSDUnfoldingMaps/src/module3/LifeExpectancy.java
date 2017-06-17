package module3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class LifeExpectancy extends PApplet{

	private static final long serialVersionUID = -3540896266859384569L;
	
	UnfoldingMap map;
	Map<String, Float> lifeExpectancyByCountry;
	
	
	public void setup(){
		
		size(950, 600, OPENGL);

		// Assume online
		map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		
		lifeExpectancyByCountry = LoadLifeExpectancyFromCSV("../data/LifeExpectancyWorldBank.csv");
	}
	
	private Map<String, Float> LoadLifeExpectancyFromCSV(String fileName) {
		
		Map<String, Float> lifeExpMap = new HashMap<String, Float>();
		
		String[] rows = loadStrings(fileName);
		
		/*for(String row : rows){
			String[] columns = row.split(",");
			float value = Float.parseFloat(columns[5]);
			lifeExpMap.put(columns[4], value);
		}*/
		
		Arrays.stream(rows).forEach(row -> {
			
			String[] columns = row.split(",");
			// float value = Float.parseFloat(columns[5]);
			// lifeExpMap.put(columns[4], value);
			System.out.println(row);
			
		});
		
		return lifeExpMap;
	}

	public void draw(){
		map.draw();
	}
	
}
