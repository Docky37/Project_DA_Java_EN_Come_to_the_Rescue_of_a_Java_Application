package com.hemebiotech.analytics;

import java.util.List;
import java.util.ListIterator;
import java.util.TreeMap;

/**
 * 
 * @author docky
 *
 */
public class CountSymptomFromArray implements ICountOccurrences {

	private List<String> list;
	
	/**
	 * 
	 * @param result
	 */
	public CountSymptomFromArray(List<String> result) {
		this.list = result;
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public  TreeMap<String,Integer> CountOccurrences() {
			TreeMap<String, Integer> countResult = new TreeMap<>();
			
			ListIterator<String> iterator = list.listIterator();
			String occurrence;
			int occurrenceNb = 0;
			while (iterator.hasNext()) {
				occurrence = iterator.next();
				if (countResult.containsKey(occurrence)) {
					occurrenceNb=countResult.get(occurrence)+1;
				}else{
					occurrenceNb=1;
				}
				countResult.put(occurrence, occurrenceNb);
			}
			return countResult;
			
	}
		
	
}
