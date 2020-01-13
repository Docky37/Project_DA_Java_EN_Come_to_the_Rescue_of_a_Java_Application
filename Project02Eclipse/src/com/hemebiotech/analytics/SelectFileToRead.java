package com.hemebiotech.analytics;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

/**
 * <h1>Class SelectFileToRead:</h1>
 * <p>
 * This class with its implementation of the Interface ISelectFileAndGetFilepath
 * allows user to select a file and get its absolute path.
 * </p>
 * 
 * @author Thierry Schreiner (OpenClassrooms student)
 * @since 02-01-2020
 */
public class SelectFileToRead implements ISelectFileAndGetFilepath {

	/**
	 * <h1>Method selectFile:</h1>
	 * <p>
	 * This method creates a dialogue window in the current directory (in user's
	 * default directory if IOException.)
	 * </p>
	 * <p>
	 * This window allows user to select a file and get its absolute path.
	 * </p>
	 * 
	 * @return String - the path of the selected file
	 */
	@Override
	public String selectFile() {
		String filePath = "";
		File localDirectory = null;
		try {
			localDirectory = new File(".").getCanonicalFile();
		} catch (IOException e) {
			AnalyticsCounter.sendMessage(12);
		}

		try {
			JFileChooser dialogue = new JFileChooser(localDirectory);
			dialogue.showOpenDialog(null);

			filePath = dialogue.getSelectedFile().getAbsolutePath();
		} catch (Exception e) {
			System.out.println("You don't choose any file!");
		}
		return filePath;

	}
}
