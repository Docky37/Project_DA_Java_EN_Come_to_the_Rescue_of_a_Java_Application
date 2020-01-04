package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>ReadSymptomDataFromFile class</h1>
 * <p>
 * The ReadSymptomDataFromFile class can read a file that contains a listing of
 * symptoms (one per line) and store it in an ArrayList.
 * </p>
 * 
 * @author Caroline - Heme Biotech
 * 
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * <h1>Class constructor</h1>
	 * When the new instance of the ReadSymptomDataFromFile class is created,
	 * the constructor set the String filepath private variable with the @param
	 * filepath value.
	 * 
	 * @param filepath an absolute or relative path giving the base location of the
	 *                 file with symptom strings in it, one per line.
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * <h1>GetSymptoms()</h1>
	 * The GetSymptoms() method read each line of the file (using BufferedReader and
	 * FileReader classes) and store the String value of each line in a ArrayList.
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
