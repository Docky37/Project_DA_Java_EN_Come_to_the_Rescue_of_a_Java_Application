package com.hemebiotech.analytics;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

/**
 * <h1>Class SelectFileToRead</h1>
 * <p>
 * The Class SelectFileToRead with its implementation of the Interface
 * ISelectFileAndGetFilepath allows user to select a file and get its absolute
 * path.
 * </p>
 * 
 * @author Thierry Schreiner (OpenClassrooms student)
 * @since 02-01-2020
 */
public class SelectFileToRead implements ISelectFileAndGetFilepath {

	/**
	 * <h1>Method selectFile()</h1>
	 * <p>
	 * The method SelectFile() creates a dialogue window in the current directory (
	 * in user's default directory if IOException.)
	 * </p>
	 * <p>
	 * This window allows user to select a file and get its absolute path.
	 * </p>
	 * 
	 * @return String filepath the absolute path of the selected file
	 */
	@Override
	public String selectFile() {
		String filePath = "";
		File localDirectory = null;
		try {
			localDirectory = new File(".").getCanonicalFile();
			System.out.println("Current directory: " + localDirectory);
		} catch (IOException e) {
			// if IOException, localDirectory remains undefined
		}

		try {
			JFileChooser dialogue = new JFileChooser(localDirectory);
			dialogue.showOpenDialog(null);

			filePath = dialogue.getSelectedFile().getAbsolutePath();
			System.out.println("Selected file: " + filePath + "\n");
		} catch (Exception e) {
			System.out.println("\n" + "You don't choose any file!");
		}
		return filePath;

	}
}
