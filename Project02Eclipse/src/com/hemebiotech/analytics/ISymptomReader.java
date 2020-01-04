package com.hemebiotech.analytics;

import java.util.List;

/**
 * <h1>ISymptomReader</h1>
 * <p>
 * Anything that will read symptom data from a source. The important part is,
 * the return value from the operation, which is a list of strings, that may
 * contain many duplications.
 * </p>
 * <p>
 * The implementation does not need to order the list.
 * </p>
 * 
 * @author Caroline - Heme Biotech
 */
public interface ISymptomReader {
	/**
	 * <h1>GetSymptoms()</h1>
	 * <p>
	 * The method read each line of the file and store the String value of each line in a ArrayList.
	 * If no data is available, return an empty List.
	 * </p>
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 */
	List<String> getSymptoms ();
}
