package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;

/**
 * <h1>Class WriteCountResultInFile:</h1>
 * <p>
 * This class, with the implementation of the interface
 * IWriteATreeMapInATextFile, is able to get each key value mapping of a TreeMap
 * passed to its constructor and write it in a file.
 * </p>
 * 
 * @author Thierry Schreiner (OpenClassrooms student)
 * @since 01-01-2020
 */
public class WriteCountResultInFile implements IWriteATreeMapInATextFile {

	TreeMap<String, Integer> countResult = new TreeMap<String, Integer>();

	/**
	 * <h1>Class constructor:</h1>
	 * <p>
	 * This class constructor set its TreeMap variable countResult with the passed
	 * TreeMap parameter.
	 * </p>
	 * 
	 * @param countResult - the TreeMap created by CountSymptomFromArray Class
	 */
	public WriteCountResultInFile(TreeMap<String, Integer> countResult) {
		// Class variable countResult set with @param
		this.countResult = countResult;
	}

	/**
	 * <h1>Method WriteInFile:</h1>
	 * <p>
	 * This method use The FileWriter class to create or modify the file
	 * "result.out".
	 * </p>
	 * <p>
	 * It loops the TreeMap to get each key and value, an write them in the file.
	 * </p>
	 * 
	 * @return true if the file is written without trouble (false if not)
	 */
	@Override
	public boolean writeInFile() {
		boolean fileCreated = false;
		Set<Entry<String, Integer>> set = countResult.entrySet();
		Iterator<Map.Entry<String, Integer>> it = set.iterator();
		try {
			FileWriter writer = new FileWriter("result.out");
			while (it.hasNext()) {
				Map.Entry<String, Integer> entry = it.next();
				System.out.println(entry);
				writer.write(entry.getKey() + ":   " + entry.getValue() + "\n");
			}
			writer.close();
			fileCreated = true;
		} catch (IOException e) {
			fileCreated = false;
		}
		return fileCreated;
	}

}
