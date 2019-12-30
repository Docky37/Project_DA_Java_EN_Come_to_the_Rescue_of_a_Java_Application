package com.hemebiotech.analytics;

import java.util.List;
import java.util.ListIterator;
import java.util.TreeMap;

/**
 * The CountSymptomFromArray class creates a TreeMap (with a String key and an
 * Integer value) from the list previously created by the
 * ReadSymptomDataFromFile class. Each different symptom becomes a key of
 * the Map and the associated value of each key is the number of occurrences of
 * this symptom in the list.
 * 
 * @author docky
 *
 */
public class CountSymptomFromArray implements ICountOccurrences {

	private List<String> list;
	
	/**
	 * <h1>CountSymptomFromArray(List&lt;String&gt; result)</h1>
	 * <p>
	 * When the new instance of the CountSymptomFromArray class is created, the
	 * constructor set the List&lt;String&gt; list private variable with the @param result
	 * value.
	 * </p>
	 * 
	 * @param result a list of symptoms previously created by the
	 *               ReadSymptomDataFromFile class.
	 */
	public CountSymptomFromArray(List<String> result) {
		this.list = result;
	}
	
	/**
	 * <h1>CountOccurrences()</h1>
	 * <p>
	 * The CountOccurrences method read each symptom of the list.
	 * </p>
	 * <p>
	 * If the map previously contained a mapping for the 'symptom', the old value is
	 * incremented by 1.
	 * </p>
	 * <p>
	 * Else a new mapping is created with the key 'symptom' and the value of 1.
	 * </p>
	 * 
	 * @return the TreeMap
	 */
	@Override
	public TreeMap<String, Integer> CountOccurrences() {
		TreeMap<String, Integer> countResult = new TreeMap<>();

		ListIterator<String> iterator = list.listIterator();
		String occurrence;
		int occurrenceNb = 0;
		while (iterator.hasNext()) {
			occurrence = iterator.next();
			if (countResult.containsKey(occurrence)) {
				occurrenceNb = countResult.get(occurrence) + 1;
			} else {
				occurrenceNb = 1;
			}
			countResult.put(occurrence, occurrenceNb);
		}
		return countResult;

	}
		
	
}
