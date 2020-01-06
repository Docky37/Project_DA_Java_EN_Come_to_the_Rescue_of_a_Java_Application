package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Class ReadSymptomDataFromFile:</h1>
 * <p>
 * This class can read a file that contains a listing of symptoms (one per line)
 * and store it in an ArrayList.
 * </p>
 * 
 * @author Caroline Hédot (Heme Biotech)
 * @since 25-12-2019
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * <h1>Constructor ReadSymptomDataFromFile:</h1>
	 * <p>
	 * When the new instance of the ReadSymptomDataFromFile class is created, the
	 * constructor set the String filepath private variable with the @param filepath
	 * value.
	 * </p>
	 * 
	 * @param filepath - an absolute path giving the base location of the file with
	 *                 symptom strings in it, one per line.
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * <h1>Method getSymptoms:</h1>
	 * <p>
	 * This method read each line of the file (using BufferedReader and FileReader
	 * classes) and store the String value of each line into an ArrayList.
	 * </p>
	 * 
	 * @return the list of Strings
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
				// A line to perform an IOException test
				// IOException e = new IOException(); throw e;
			} catch (IOException e) {
				result = null;
			}
		}

		return result;
	}

}
