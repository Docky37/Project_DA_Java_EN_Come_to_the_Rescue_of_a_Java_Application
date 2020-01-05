package com.hemebiotech.analytics;

/**
 * <h1>Interface ISelectFileAndGetFilepath</h1>
 * <p>
 * Implementing this Interface allows user to select a file and get its absolute
 * path.
 * </p>
 * 
 * @author Thierry Schreiner (OpenClassrooms student)
 * @since 02-01-2020
 */
public interface ISelectFileAndGetFilepath {

	/**
	 * <h1>Method selectFile()</h1>
	 * <p>
	 * The method SelectFile() creates a dialogue window that allows user to select
	 * a file and get its absolute path.
	 * </p>
	 * 
	 * @return String filepath of the selected file
	 */
	String selectFile();

}