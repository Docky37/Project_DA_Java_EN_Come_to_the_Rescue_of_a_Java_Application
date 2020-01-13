package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

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
	boolean fileCreated = false;
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
		try (FileWriter writer = new FileWriter("result.out")){
			fileCreated = true;
			for (Map.Entry<String, Integer> kV : countResult.entrySet()) {
				try {
					writer.write(kV.getKey() + ": " + kV.getValue() + "\n");
				} catch (IOException e) {
					AnalyticsCounter.sendMessage(10);
					fileCreated = false;
					return fileCreated;
				}
			}
			if (!fileCreated) {
				return fileCreated;
			}
		} catch (IOException e1) {
			AnalyticsCounter.sendMessage(11);
		}
		return fileCreated;
	}

}
