package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * <h1>Class CountSymptomsFromArray:</h1>
 * <p>
 * This class, with the implementation of the interface ICountOccurrences,
 * creates a TreeMap (with a String key and an Integer value) from the list
 * previously created by the ReadSymptomDataFromFile class. Each different
 * symptom becomes a key of the Map and the associated value of each key is the
 * number of occurrences of this symptom in the list.
 * </p>
 * 
 * @author Thierry Schreiner (OpenClassrooms student)
 * @since 26-12-2019
 */
public class CountSymptomsFromArray implements ICountOccurrences {

	private List<String> list;

	/**
	 * <h1>Constructor CountSymptomsFromArray:</h1>
	 * <p>
	 * When the new instance of the CountSymptomFromArray class is created, the
	 * constructor set the List&lt;String&gt; list private variable with the @param
	 * result value.
	 * </p>
	 * 
	 * @param result a list of symptoms previously created by the
	 *               ReadSymptomDataFromFile class.
	 */
	public CountSymptomsFromArray(List<String> result) {
		this.list = result;
	}

	/**
	 * <h1>Method countOccurrences:</h1>
	 * <p>
	 * This method read each symptom of the list.
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
	public TreeMap<String, Integer> countOccurrences() {
		TreeMap<String, Integer> countResult = new TreeMap<>();
		list.forEach(item->{
			if (countResult.containsKey(item)) {
				countResult.put(item, countResult.get(item) + 1);
			} else {
				countResult.put(item, 1);
			}
			System.out.println(item +"= "+countResult.get(item));
		});
		return countResult;
	}

}
