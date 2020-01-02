package com.hemebiotech.analytics;

	import java.io.File;
	import java.io.IOException;
	 
	import javax.swing.JFileChooser;
	 
/**
 * <h1>Class SelectFileToRead</h1>
 * @author docky
 *
 */
public class SelectFileToRead implements ISelectFileAndGetFilepath {

	/**
	 * Class constructor 
	 * 
	 */
	public SelectFileToRead() {
		
	}
	
	/**
	 * 
	 */
	@Override
	public String SelectFile() {
		String filePath = "";
		File localDirectory = null;
		try {
			// get the local directory
			localDirectory = new File(".").getCanonicalFile();
			System.out.println("Current directory: " + localDirectory);
		} catch (IOException e) {

		}

		/*
		 * create a dialogue window in the current directory or user's default directory if IOException (in
		 * this case localDirectory = null). This default depends on the operating system. 
		 * "My Documents" folder on Windows, and the user's home directory on Unix.
		 */
		try {
			JFileChooser dialogue = new JFileChooser(localDirectory);
			dialogue.showOpenDialog(null);
	
			// get the filepath of the selected file and return it
			filePath = dialogue.getSelectedFile().getAbsolutePath();
			System.out.println("Selected file: " + filePath + "\n");
		}
		catch (Exception e){
			System.out.println("\n" + "You don't choose any file!");
		}
		return filePath;
			
	}
}
