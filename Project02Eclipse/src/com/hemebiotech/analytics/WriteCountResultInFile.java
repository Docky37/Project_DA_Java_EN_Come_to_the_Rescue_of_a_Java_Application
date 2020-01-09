package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
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
	FileWriter writer = null;
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
		try {
			writer = new FileWriter("result.out");
			fileCreated = true;
			countResult.forEach((k, v) -> {
				try {
					writer.write(k + ": " + v + "\n");
					// A line to perform an IOException test
					//IOException e = new IOException(); throw e;
				} catch (IOException e) {
					System.out.println("An IOException occurred when writting a line in the file!");
					fileCreated = false;
					return;
				}
			});
			if (!fileCreated) {
				return fileCreated;
			}
			writer.close();
		} catch (IOException e1) {
			System.out.println(
					"Part 4!!! An IOException occurred when we try to open the file! Check if it is not a read only file.");
		}

		return fileCreated;
	}

}
