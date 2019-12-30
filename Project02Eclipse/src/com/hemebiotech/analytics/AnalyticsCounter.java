package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * <h1>AnalyticsCounter</h1>
<<<<<<< HEAD
 * Main Class of the application, AnalyticsCounter contains:
=======
 * Main Class of the application, AnalyticsCounter contains: 
>>>>>>> cf7b344... doc: create class and interface javadoc
 * <ul>
 * <li>the 'public static void main' function (entry point of any java program),</li>
 * <li>the 'analyticsCounterSupervisor' method.</li>
 * </ul>
 * 
<<<<<<< HEAD
 * @author Alex and Docky37
=======
 * @author Alex and Docky
>>>>>>> cf7b344... doc: create class and interface javadoc
 *
 */
public class AnalyticsCounter {

	/**
<<<<<<< HEAD
     * <h1>Main function</h1>
     * The main function, entry point of the program.
     * Its only goal is to call the analyticsCounterSupervisor() method.
     *
     * @param args not used
     * @throws Exception
     */
=======
	 * <h1>Main function</h1>
	 * The main function, entry point of the program. 
	 * Its only goal is to call the analyticsCounterSupervisor() method.
	 * 
	 * @param args not used  
	 * @throws Exception
	 */
>>>>>>> cf7b344... doc: create class and interface javadoc
	public static void main(String args[]) throws Exception {
		AnalyticsCounterSupervisor();
	}

	/**
<<<<<<< HEAD
     * <h1>analyticsCounterSupervisor()</h1>
     * The 'analyticsCounterSupervisor()' monitors the application.
     * It calls sequentially each principal function of the program:
     * <ul>
     * <li>get the filepath of the file we want to read,
     * <li>read the file,
     * <li>count the occurrences of each symptom,
     * <li>generate the file output.
=======
	 * <h1>analyticsCounterSupervisor()</h1>
	 * The 'analyticsCounterSupervisor()' monitors the application. 
	 * It calls sequentially each principal function of the program:
	 * <ul>
	 * <li>get the filepath of the file we want to read,
	 * <li>read the file,
	 * <li>count the occurrences of each symptom,
	 * <li>generate the file output.
>>>>>>> cf7b344... doc: create class and interface javadoc
	 * 
	 * @throws Exception
	 */
	private static void AnalyticsCounterSupervisor() throws Exception {
<<<<<<< HEAD
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
=======
		/* First part: an external method call to get the filePath (still needs to be done)
		 * The filepath variable is temporarily set here, until external method implementation.
		 */
		String filepath = "symptoms.txt";

		/*Second part: Caroline's ReadSymptomDataFromFile sub-program call
		 * In first we create an instance of ReadSymptomDataFromFile class with @param filepath.
		 * Then we call the 'GetSymptoms()' method.
		 */
		ISymptomReader readMyFile = new ReadSymptomDataFromFile(filepath);
		List<String> result = readMyFile.GetSymptoms();

		/* Part 3: Count the occurrences of each symptom  (still needs to be done)
		 * For now it is only a small adaptation of Alex'job using 
		 * the result List<String> returned by Caroline Class & method.
		 */
		ICountOccurrences countSymptomFromArray = new CountSymptomFromArray(result);
		TreeMap<String,Integer> countResult = countSymptomFromArray.CountOccurrences();
		System.out.println(countResult);

		/* Part 4: generate output (Need to be rewrite)
>>>>>>> cf7b344... doc: create class and interface javadoc
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