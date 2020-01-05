package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * <h1>Class AnalyticsCounter</h1>
 * Main Class of the application, AnalyticsCounter contains:
 * <ul>
 * <li>the 'public static void main' function,</li>
 * <li>the 'analyticsCounterSupervisor' method.</li>
 * </ul>
 * 
 * @author Alex (Heme Biotech) and Thierry Schreiner (OpenClassrooms student)
 * @since 26-12-2019
 */
public class AnalyticsCounter {

	/**
     * <h1>main function</h1>
     * Entry point of the program, its only goal is to call the analyticsCounterSupervisor() method.
     *
     * @param args not used
     * @throws Exception any exception without specific monitoring   
     */
	public static void main(String args[]) throws Exception {
		analyticsCounterSupervisor();
	}

	/**
     * <h1>Method analyticsCounterSupervisor()</h1>
     * The 'analyticsCounterSupervisor()' monitors the application.
     * It calls sequentially each principal function of the program:
     * <ul>
     * <li>get the filepath of the file we want to read,
     * <li>read the file,
     * <li>count the occurrences of each symptom,
     * <li>generate the output file.
	 * </ul>
	 * 
	 * @throws Exception any exception without specific monitoring
	 */
	private static void analyticsCounterSupervisor() throws Exception {
		//First part: choose the file to read. 
		ISelectFileAndGetFilepath selectFileToRead = new SelectFileToRead();
		String filepath = selectFileToRead.selectFile();
		if (filepath.equals("")){
			System.out.println("End of program.");
			System.exit(0);
		}else {
			System.out.println("Part 1 'SelectFileToRead' successfully done!");
		}
		
		//Second part: Caroline's ReadSymptomDataFromFile sub-program call. 
		ISymptomReader readSelectedFile = new ReadSymptomDataFromFile(filepath);
		List<String> result = readSelectedFile.getSymptoms();
		if (result.isEmpty()){
			System.out.println("\n" + "Part 2!!!");
			System.out.println("There is no data in " + filepath);
			System.out.println("End of program.");
			System.exit(0);
		}else {
			System.out.println("\n" + "Part 2 'ReadSymptomDataFromFile' successfully done!");
		}
		
		// Part 3: Count the occurrences of each symptom. 
		ICountOccurrences countSymptomsFromArray = new CountSymptomsFromArray(result);
		TreeMap<String, Integer> countResult = countSymptomsFromArray.countOccurrences();
		if (countResult.isEmpty()) {
			System.out.println("\n" + "Part 3!!!");
			System.out.println("The MapTree is empty");
			System.out.println("End of program.");
			System.exit(0);
			
		}else {
			System.out.println("\n" + "Part 3 'CountSymptomFromArray' successfully done!");			
		}
		
		// Part 4: generate an output text file 
		IWriteATreeMapInATextFile writeCountResultInFile = new WriteCountResultInFile(countResult);
		boolean fileCreated = writeCountResultInFile.writeInFile();
		if (fileCreated) {
			System.out.println("\n" + "Part 4 successfully done! File 'result.out' was written. ");
		} else {
			System.out.println("\n" + "Part 4!!!");
			System.out.println("Unable to write 'result.out'");
			System.out.println("Program is closed.");
		}
	}

}