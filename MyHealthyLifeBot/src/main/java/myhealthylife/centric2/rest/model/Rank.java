package myhealthylife.centric2.rest.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rank")
public class Rank {
	
	private final Integer NUM_ELEMENTS_FILTERED_LIST = 10;

	private ArrayList<String> compactRanking;
	
	public ArrayList<String> getCompactRanking() {
		return compactRanking;
	}

	public void setCompactRanking(ArrayList<String> compactRanking) {
		this.compactRanking = compactRanking;
	}
	
	
	/**
	 * Formats the input ranking list containing all the users in the system
	 * @param sortedRanking The ranking list in an hashmap object
	 * @return The same ranking formatted as a list of strings containing also the position for each entry
	 */
	public ArrayList<String> getFinalRanking(Map<String, Double> sortedRanking) {

		Iterator<String> iKeys = sortedRanking.keySet().iterator();
		this.compactRanking = new ArrayList<>();
		
		for(int i=0;i<sortedRanking.size();i++) {
			
			String currentKey = iKeys.next();
			Double currentValue = sortedRanking.get(currentKey);
			
			String recordToInsert = "[" + i + 1 + "] " + currentKey + ": " + currentValue;
			
			this.compactRanking.add(recordToInsert);
			
		}
		
		return this.compactRanking;
	}
	
	
	/**
	 * Formats the input ranking list containing all the users in the system in a list of results strictly close to the current user
	 * @param username The user around which the list will be built in order to filter the results
	 * @param sortedRanking The ranking list in an hashmap object
	 * @return A subset of the ranking formatted as a list of strings containing also the position for each entry
	 */
	public ArrayList<String> getFinalRankingFiltered(String username, Map<String, Double> sortedRanking) {

		this.compactRanking = new ArrayList<>();
		
		Iterator<String> iKeys = sortedRanking.keySet().iterator();
		
		boolean elementFound = false;
		int elementCounter = 0;
		int upperBound = sortedRanking.size();
		
		for(int i=0;i<upperBound;i++) {
			
			String currentKey = iKeys.next();
			Double currentValue = sortedRanking.get(currentKey);
			
			String recordToInsert = "[" + (i + 1) + "] " + currentKey + ": " + currentValue;

			this.compactRanking.add(recordToInsert);
			
			if(!elementFound && currentKey.equals(username)) {
				elementFound = true;
				elementCounter = i;
			}
			
		}
		
		Integer lowerElement = elementCounter - this.NUM_ELEMENTS_FILTERED_LIST/2;
		Integer upperElement = elementCounter + this.NUM_ELEMENTS_FILTERED_LIST/2;
		
		// Check the bounds
		if(lowerElement < 0) {
			lowerElement = 0;
		}
		if(upperElement >= upperBound) {
			upperElement = upperBound;
		}
		else {
			upperElement +=1;
		}
		
		return new ArrayList<>(compactRanking.subList(lowerElement, upperElement));
	}
	
	
	
	
	
	public Map<String,Double> getFinalRankingMapFiltered(String username, Map<String, Double> sortedRanking) {

		Map<String,Double> compactMap = new LinkedHashMap<String,Double>();
		
		ArrayList<String> usernames = new ArrayList<>();
		ArrayList<Double> points = new ArrayList<>();
		
		Iterator<String> iKeys = sortedRanking.keySet().iterator();
		
		boolean elementFound = false;
		int elementCounter = 0;
		int upperBound = sortedRanking.size();
		
		for(int i=0;i<upperBound;i++) {
			
			String currentKey = iKeys.next();
			Double currentValue = sortedRanking.get(currentKey);
			
			usernames.add(currentKey);
			points.add(currentValue);
			
			if(!elementFound && currentKey.equals(username)) {
				elementFound = true;
				elementCounter = i;
			}
			
		}
		
		Integer lowerElement = elementCounter - this.NUM_ELEMENTS_FILTERED_LIST/2;
		Integer upperElement = elementCounter + this.NUM_ELEMENTS_FILTERED_LIST/2;
		
		// Check the bounds
		if(lowerElement < 0) {
			lowerElement = 0;
		}
		if(upperElement >= upperBound) {
			upperElement = upperBound;
		}
		else {
			upperElement +=1;
		}
		
		usernames = new ArrayList<>(usernames.subList(lowerElement, upperElement));
		points = new ArrayList<>(points.subList(lowerElement, upperElement));
		
		
		for(int i=0;i<usernames.size();i++) {
			compactMap.put(usernames.get(i), points.get(i));
		}
		
		return compactMap;
	}
	
}
