package com.hemebiotech.analytics;

import java.util.TreeMap;

/**
 * <h1>ICountOccurrences</h1>
 * <p>
 * The ICountOccurrences interface contain one method that creates a TreeMap
 * (with a String Key and an Integer value) from a list (with duplicates).
 * </p>
 * 
 * @author docky
 */
public interface ICountOccurrences {

	/**
	 * <h1>CountOccurrences()</h1>
	 * <p>
	 * Each different element of the list becomes a String key of a TreeMap</p>
	 * <p>and the associated value of each key is the number of occurrences of the
	 * element in the list.
	 * </p>
	 * 
	 * @return a TreeMap&lt;String, Integer&gt;
	 */
	TreeMap<String, Integer> countOccurrences();

}