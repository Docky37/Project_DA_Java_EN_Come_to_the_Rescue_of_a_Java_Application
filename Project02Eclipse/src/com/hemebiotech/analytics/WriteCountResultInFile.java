package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;

/**
 * <h1>WriteCountResultInFile Class</h1>
 * <p>
 * The WriteCountResultInFile Class is able to get each key value mapping of a TreeMap passed to its constructor and write it in a file.
 * </p>
 * 
 * @author Docky37
 * @since 01-01-2020
 */
public class WriteCountResultInFile implements IWriteATreeMapInATextFile {

	TreeMap<String,Integer> countResult = new TreeMap<String,Integer>();
	
	/**
	 * <h1>Class constructor</h1>
	 * <p>The WriteCountResultInFile Class constructor set its TreeMap variable countResult with the passed TreeMap parameter.
	 * </p>
	 * 
	 * @param countResult the TreeMap created by CountSymptomFromArray Class
	 */
	public WriteCountResultInFile(TreeMap<String,Integer> countResult) {
		// Class variable countResult set with @param 
		this.countResult = countResult;
	}
	
	/**
	 * <h1>WriteInFile() method</h1>
	 * <p>
	 * In first, this method use the entrySet() method to return a Set view of the
	 * mappings contained in the TreeMap.
	 * </p>
	 * <p>
	 * The FileWriter class is use to create the file "result.out"
	 * </p>
	 * <p>
	 * Then we can iterate the set to get each key and value, an write them in the file.
	 * </p>
	 * 
	 * @return true if the file is written without trouble (false if not)
	 */
	@Override
	public boolean WriteInFile() {
		boolean fileCreated = false;
		// Create EntrySet of the MapTree
		Set<Entry<String, Integer>> set = countResult.entrySet();
		// Add an Iterator
		Iterator<Map.Entry<String, Integer>> it = set.iterator();
		try{
			FileWriter writer = new FileWriter("result.out");
		    while(it.hasNext()){
			    // Reach successively each mapping
		    	Map.Entry<String, Integer> entry = it.next();
			    System.out.println(entry);
			    /* Write the Map key (symptom) and the Map value (number of occurrences) in the file,
			     * and perform a line feed.
			     */
			    writer.write(entry.getKey() + ":   " + entry.getValue() + "\n");
		    }
			writer.close();
			fileCreated = true;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return fileCreated;
	}
	
}
