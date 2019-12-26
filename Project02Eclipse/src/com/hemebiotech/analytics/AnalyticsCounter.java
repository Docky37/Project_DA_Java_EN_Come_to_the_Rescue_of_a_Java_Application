package com.hemebiotech.analytics;

import java.io.FileWriter;
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
	private static int headacheCount = 0; // initialize to 0
	private static int rashCount = 0; // initialize to 0
	private static int pupilCount = 0; // initialize to 0

	/**
	 * The main function, entry point of the program. 
	 * Its only goal is to call the analyticsCounterSupervisor() method.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		analyticsCounterSupervisor();
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
	private static void analyticsCounterSupervisor() throws Exception {
		/** First part: an external method call to get the filePath (still needs to be done)
		 * The filepath variable is temporarily set here, until external method implementation.
		 */
		String filepath = "symptoms.txt";

		/**Second part: Caroline's ReadSymptomDataFromFile sub-program call
		 * In first we create an instance of ReadSymptomDataFromFile class with @param filepath.
		 * Then we call the 'GetSymymptoms()' method.
		 */
		ReadSymptomDataFromFile readMyFile = new ReadSymptomDataFromFile(filepath);
		List<String> result = readMyFile.GetSymptoms();

		/** Part 3: Count the occurrences of each symptom  (still needs to be done)
		 * For now it is only a small adaptation of Alex'job using 
		 * the result List<String> returned by Caroline Class & method.
		 */
		ICountOccurrences countSymptomFromArray = new CountSymptomFromArray(result);
		TreeMap<String,Integer> countResult = countSymptomFromArray.CountOccurrences();
		System.out.println(countResult);

		/** Part 4: generate output (Need to be rewrite)
		 */
		FileWriter writer = new FileWriter("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();

	}

}
