package com.hemebiotech.analytics;

/**
 * <h1>IWriteATreeMapInATextFile</h1>
 * <p>
 * Implementing this Interface allows user to write a TreeMap content in a text file.
 * </p>
 * 
 * @author Thierry Schreiner (OpenClassrooms student)
 * @since 01-01-2020
 */
public interface IWriteATreeMapInATextFile {

	/**
	 * <h1>Method writeInFile() </h1>
	 * <p>
	 * The method iterate a Set view of a Map to get each key and value, an write them as a line into a text file. 
	 * </p>
	 * 
	 * @return true if the file is written without trouble
	 */
	boolean writeInFile();

}