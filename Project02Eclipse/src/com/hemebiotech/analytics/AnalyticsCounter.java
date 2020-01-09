package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;
import java.util.Scanner;

/**
 * <h1>Class AnalyticsCounter:</h1> Main Class of the application,
 * AnalyticsCounter contains:
 * <ul>
 * <li>the 'public static void main' function,</li>
 * <li>the 'analyticsCounterSupervisor' method.</li>
 * </ul>
 * 
 * @author Alex (Heme Biotech) and Thierry Schreiner (OpenClassrooms student)
 * @since 26-12-2019
 * @version v1.3
 * 
 */
public class AnalyticsCounter {

	/**
	 * Scanner instance used to get keyboard entries.
	 */
	private Scanner sc = new Scanner(System.in);
	private String externalMessage="";
	
	String getExternalMessage() {
		return externalMessage;
	}

	void setExternalMessage(String externalMessage) {
		this.externalMessage = externalMessage;
	}

	/**
	 * <h1>Function main:</h1>
	 * <p>
	 * Entry point of the program, its only goal is to instance the class and call
	 * the analyticsCounterSupervisor() method.
	 * </p>
	 * 
	 * @param args not used
	 * @throws Exception any exception without specific monitoring
	 */
	public static void main(String args[]) throws Exception {
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		analyticsCounter.analyticsCounterSupervisor();
		System.out.println("See you soon.");
	}

	/**
	 * <h1>Method analyticsCounterSupervisor:</h1>
	 * <p>
	 * This method monitors the application. It calls sequentially each principal
	 * function of the program:
	 * </p>
	 * <ul>
	 * <li>get the filepath of the file we want to read,
	 * <li>read the file,
	 * <li>count the occurrences of each symptom,
	 * <li>generate the output file.
	 * </ul>
	 * 
	 * @throws Exception any exception without specific monitoring
	 */
	public void analyticsCounterSupervisor() throws Exception {
		boolean answer;
		// First part: choose the file to read.
		String filepath = chooseAFile();
		if (filepath.equals("")) {
			answer = questionYesOrNo("Do you want to choose a file (Y or N)?");
			if (answer) {
				analyticsCounterSupervisor();
			} else {
				sendMessage(1);
			}
			return;
		} else {
			sendMessage(3);
		}

		// Second part: Caroline's ReadSymptomDataFromFile sub-program call.
		List<String> result;
		do {
			result = readTheFile(filepath);
			if (result == null) {
				answer = questionYesOrNo("Retry to read the file (Y or N)?");
				if (!answer) {
					sendMessage(1);
					return;
				}
			}
		} while (result == null);
		if (result.isEmpty()) {
			sendMessage(2);
			sc.close();
			return;
		}
		// Part 3: Count the occurrences of each symptom.
		TreeMap<String, Integer> countResult = countOccurencesFromArray(result);

		// Part 4: Generate an output text file
		boolean fileCreated=false;
		do {
			fileCreated = writeATreeMapInATextFile(countResult);
			if (!fileCreated) {
				sendMessage(5);
				answer = questionYesOrNo("Retry to write result (Y or N)?");
				if (!answer) {
					sendMessage(1);
					return;
				}
			}
		} while (!fileCreated);
		sendMessage(4);
		sc.close();
	}

	/**
	 * <h1>Method chooseAFile:</h1>
	 * <p>
	 * This method created an instance of the class SelectFileToRead and call its
	 * method selectFile() to select a file and get its path.
	 * </p>
	 * 
	 * @return a String - the path of the selected file
	 */
	public String chooseAFile() {
		ISelectFileAndGetFilepath selectFileToRead = new SelectFileToRead();
		String filepath = selectFileToRead.selectFile();
		return filepath;
	}

	/**
	 * <h1>Method readTheFile:</h1>
	 * <p>
	 * This method created an instance of the class ReadSymptomDataFromFile and call
	 * its method getSymptoms() to make a List&lt;String&gt; of its content..
	 * </p>
	 * *
	 * 
	 * @param filepath the path of the file to read
	 * @return a List&lt;String&gt; - the ArrayList of symptoms read in the file
	 */
	public List<String> readTheFile(String filepath) {
		ISymptomReader readSelectedFile = new ReadSymptomDataFromFile(filepath);
		List<String> result = readSelectedFile.getSymptoms();
		if (result == null) {
			sendMessage(6);
		} else if (result.isEmpty()) {
			sendMessage(7);
		} else {
			sendMessage(8);
		}
		return result;
	}

	/**
	 * <h1>Method countOccurencesFromArray:</h1>
	 * <p>
	 * This method created an instance of the class CountSymptomsFromArray and call
	 * its method countOccurrences() to make a TreeMap&lt;String, Integer&gt; that
	 * stores each key with an associated value equal to the number of occurrences
	 * of the key in the @param list.
	 * </p>
	 * 
	 * @param result a List of string with duplicates
	 * @return a TreeMap&lt;String, Integer&gt; - the TreeMap that contains the
	 *         count of symptoms
	 */
	public TreeMap<String, Integer> countOccurencesFromArray(List<String> result) {
		ICountOccurrences countSymptomsFromArray = new CountSymptomsFromArray(result);
		TreeMap<String, Integer> countResult = countSymptomsFromArray.countOccurrences();
		sendMessage(9);
		return countResult;
	}

	/**
	 * <h1>Method writeATreeMapInATextFile:</h1>
	 * <p>
	 * This method created an instance of the class WriteCountResultInFile and call
	 * its method writeInFile() to record the given parameter TreeMap&lt;String,
	 * Integer&gt; in a text file.
	 * </p>
	 * 
	 * @param countResult a TreeMap&lt;String, Integer&gt; -
	 * @return a boolean - true if the file is written.
	 */
	public boolean writeATreeMapInATextFile(TreeMap<String, Integer> countResult) {
		IWriteATreeMapInATextFile writeCountResultInFile = new WriteCountResultInFile(countResult);
		boolean fileCreated = writeCountResultInFile.writeInFile();
		return fileCreated;
	}

	/**
	 * <h1>Method questionYesOrNo:</h1>
	 * <p>
	 * This method use java.util.Scanner to ask a yes or no question and wait for a
	 * keyboard answer.
	 * </p>
	 * 
	 * @param question String - the text of the asked question
	 * @return boolean - the yes or no answer
	 */
	public boolean questionYesOrNo(String question) {
		char keybordAnswer = '?';
		boolean answer = false;
		do {
			System.out.println(question);
			String str = sc.nextLine();
			str = str.toUpperCase();
			keybordAnswer = str.charAt(0);
		} while (keybordAnswer != 'Y' && keybordAnswer != 'N');
		if (keybordAnswer == 'Y')
			answer = true;
		return answer;
	}

	/**
	 * <h1>Method sendMessage:</h1>
	 * <p>
	 * This method centralize console message edition and sending.
	 * </p>
	 * 
	 * @param mes int - an id associated with a message to print
	 */
	public void sendMessage(int mes) {
		String message = "";
		switch (mes) {
		case 1:
			message = "Ok, you have chosen to interrupt this function.";
			break;
		case 2:
			message = "Without data at this step, this function stop.";
			break;
		case 3:
			message = "Part 1 'SelectFileToRead' successfully done!";
			break;
		case 4:
			message = "\n" + "Part 4 successfully done! File 'result.out' was written." + "\n"
					+ "The program normally ends.";
			break;
		case 5:
			message = "Unable to write in result.out!" + "\n";
			break;
		case 6:
			message = "\n" + "Part 2!!!  Caution! An IOException occurred! We deleted unreliable datas!";
			break;
		case 7:
			message = "\n" + "Part 2!!!" + "There is no data in this file !";
			break;
		case 8:
			message = "\n" + "Part 2 'ReadSymptomDataFromFile' successfully done!" + "\n";
			break;
		case 9:
			message = "\n" + "Part 3 'CountSymptomFromArray' successfully done!" + "\n";
			break;
		default:
			message = "Message id error !";
		}
		System.out.println(message);
	}
}