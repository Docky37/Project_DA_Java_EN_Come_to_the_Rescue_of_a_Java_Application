package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * Main Class of the application, AnalyticsCounter contains: - the 'public
 * static void main' function (entry point of any java program), - the
 * 'analyticsCounterSupervisor' method.
 * 
 * @author docky
 *
 */
public class AnalyticsCounter {

	/**
	 * The main function, entry point of the program. Its only goal is to call the
	 * analyticsCounterSupervisor() method.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		AnalyticsCounterSupervisor();
	}

	/**
	 * The 'analyticsCounterSupervisor()' monitors the application. It calls
	 * sequentially each principal function of the program: - get the filepath of
	 * the file we want to read, - read the file, - count the occurrences of each
	 * symptom, - generate the file output.
	 * 
	 * @throws Exception
	 */
	private static void AnalyticsCounterSupervisor() throws Exception {
		/*
		 * First part: an external method call to get the filePath. 
		 * Create an instance of SelectFileToRead. 
		 * Then call the 'SelectFile' method that returns the filePath
		 * of the selected file.
		 */
		ISelectFileAndGetFilepath selectFile = new SelectFileToRead();
		String filepath = selectFile.SelectFile();
		 // If no selected file, the program is closed. 
		if (filepath.equals("")){
			System.out.println("End of program.");
			System.exit(0);
		}else {
			System.out.println("Part 1 'SelectFileToRead' successfully done!");
		}
		/*
		 * Second part: Caroline's ReadSymptomDataFromFile sub-program call. 
		 * Create an instance of ReadSymptomDataFromFile class with @param filepath. 
		 * Then call its 'GetSymptoms()' method that returns an ArrayList.
		 */
		ISymptomReader readMyFile = new ReadSymptomDataFromFile(filepath);
		List<String> result = readMyFile.GetSymptoms();
		 // If the returned ArrayList is empty, the program is closed. 
		if (result.isEmpty()){
			System.out.println("\n" + "Part 2!!!");
			System.out.println("There is no data in " + filepath);
			System.out.println("End of program.");
			System.exit(0);
		}else {
			System.out.println("\n" + "Part 2 'ReadSymptomDataFromFile' successfully done!");
		}
		
		/*
		 * Part 3: Count the occurrences of each symptom. 
		 * Create an instance of CountSymptomFromArray class with @param result (the List<String> returned by
		 * Caroline Class & method) 
		 * Then call its 'CountOccurrences()' method that returns a TreeMap.
		 */
		ICountOccurrences countSymptomFromArray = new CountSymptomFromArray(result);
		TreeMap<String, Integer> countResult = countSymptomFromArray.CountOccurrences();
		if (countResult.isEmpty()) {
			System.out.println("\n" + "Part 3!!!");
			System.out.println("The MapTree is empty");
			System.out.println("End of program.");
			System.exit(0);
			
		}else {
			System.out.println("\n" + "Part 3 'CountSymptomFromArray' successfully done!");			
		}
		/*
		 * Part 4: generate an output text file 
		 * Create an instance of WriteCountResultInFile class with @param countResult
		 * (the TreeMap returned previously). 
		 * Then call its 'WriteInFile()' method that write the countResult in a textFile 
		 * and return a boolean used to confirm that job is well done.
		 */
		IWriteATreeMapInATextFile writeFile = new WriteCountResultInFile(countResult);
		boolean fileCreated = writeFile.WriteInFile();
		if (fileCreated) {
			System.out.println("\n" + "Part 4 successfully done! File 'result.out' was written.");
		} else {
			System.out.println("\n" + "Part 4!!!");
			System.out.println("Unable to write 'result.out'");
			System.out.println("Program is closed.");
		}
	}

}