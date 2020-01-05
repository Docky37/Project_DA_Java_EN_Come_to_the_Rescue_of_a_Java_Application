package com.hemebiotech.analytics;

import java.util.TreeMap;

/**
 * <h1>Interface ICountOccurrences</h1>
 * <p>
 * Implementing this Interface allows user to create a TreeMap (with a String
 * key and an Integer value) from a list (with duplicates) for counting the
 * occurrences of each key.
 * </p>
 * 
 * @author Thierry Schreiner (OpenClassrooms student)
 * @since 26-12-2019
 */
public interface ICountOccurrences {

	/**
	 * <h1>Method countOccurrences()</h1>
	 * <p>
	 * Each different element of the list becomes a String key of a TreeMap
	 * </p>
	 * <p>
	 * and the associated value of each key is the number of occurrences of the
	 * element in the list.
	 * </p>
	 * 
	 * @return a TreeMap&lt;String, Integer&gt;
	 */
	TreeMap<String, Integer> countOccurrences();

}