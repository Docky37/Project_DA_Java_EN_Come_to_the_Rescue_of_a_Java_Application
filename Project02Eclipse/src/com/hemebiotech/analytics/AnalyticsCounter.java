package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * Main Class of the application, AnalyticsCounter contains: 
 * 	- the 'public static void main' function (entry point of any java program),
 *  - the 'analyticsCounterSupervisor' method.
 * 
 * @author docky
 *
 */
public class AnalyticsCounter {

	/**
	 * The main function, entry point of the program. 
	 * Its only goal is to call the analyticsCounterSupervisor() method.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		AnalyticsCounterSupervisor();
	}

	/**
	 * The 'analyticsCounterSupervisor()' monitors the application. 
	 * It calls sequentially each principal function of the program:
	 * 	- get the filepath of the file we want to read,
	 * 	- read the file,
	 * 	- count the occurrences of each symptom,
	 * 	- generate the file output.
	 * 
	 * @throws Exception
	 */
	private static void AnalyticsCounterSupervisor() throws Exception {
		/** First part: an external method call to get the filePath (still needs to be done)
		 * The filepath variable is temporarily set here, until external method implementation.
		 */
		String filepath = "symptoms.txt";

		/**Second part: Caroline's ReadSymptomDataFromFile sub-program call
		 * In first we create an instance of ReadSymptomDataFromFile class with @param filepath.
		 * Then we call the 'GetSymymptoms()' method.
		 */
		ISymptomReader readMyFile = new ReadSymptomDataFromFile(filepath);
		List<String> result = readMyFile.GetSymptoms();

		/** Part 3: Count the occurrences of each symptom  (still needs to be done)
		 * For now it is only a small adaptation of Alex'job using 
		 * the result List<String> returned by Caroline Class & method.
		 */
		ICountOccurrences countSymptomFromArray = new CountSymptomFromArray(result);
		TreeMap<String,Integer> countResult = countSymptomFromArray.CountOccurrences();

		/** Part 4: generate an output text file
		 */
		IWriteATreeMapInATextFile writeFile = new WriteCountResultInFile(countResult);
		boolean fileCreated = writeFile.WriteInFile();
		if (fileCreated) {
			System.out.println("\n" + "File 'result.out' written.");
		}else {
			System.out.println("\n" + "Unable to write 'result.out'");			
		}
	}
	
}