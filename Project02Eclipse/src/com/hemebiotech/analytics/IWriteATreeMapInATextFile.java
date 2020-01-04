package com.hemebiotech.analytics;

/**
 * <h1>IWriteATreeMapInATextFile</h1>
 * <p>
 * Interface class that has the following method.
 * </p>
 * 
 * @author Docky37
 * @since 01-01-2020
 */
public interface IWriteATreeMapInATextFile {

	/**
	 * <h1>WriteInFile() method</h1>
	 * <p>
	 * The method iterate a Set view of a Map to get each key and value, an write them into a text file. 
	 * </p>
	 * 
	 * @return true if the file is written without trouble (false if not)
	 */
	boolean writeInFile();

}