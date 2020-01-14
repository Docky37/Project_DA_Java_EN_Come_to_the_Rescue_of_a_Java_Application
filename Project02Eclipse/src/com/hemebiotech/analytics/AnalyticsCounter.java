package com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <h1>Class AnalyticsCounter:</h1> Main Class of the application,
 * AnalyticsCounter contains:
 * <ul>
 * <li>the 'public static void main' function,</li>
 * <li>the 'analyticsCounterSupervisor' method.</li>
 * </ul>
 * 
 * @author Alex (Heme Biotech) and Thierry Schreiner (OpenClassrooms student)
 * @since 14-01-2020
 * @version v1.6
 * 
 */
public class AnalyticsCounter {
	/**
	 * Scanner instance used to get keyboard entries.
	 */
	private Scanner sc = new Scanner(System.in);

	/**
	 * Used to store all messages that the program can send to the console.
	 */
	private static String[] messages = { "See you soon.", "Ok, you have chosen to interrupt this function.",
			"Without data at this step, this function stop.", "Part 1 'SelectFileToRead' successfully done!",
			"\n" + "Part 3 successfully done! File 'result.out' was written." + "\n" + "The program normally ends.",
			"Unable to write in result.out!" + "\n",
			"\n" + "Part 2!!!  Caution! An Exception occurred!",
			"But, there is no data in this file! ",
			"\n" + "Part 2 'readAndCountWithStream' successfully done!" + "\n",
			"\n" + "Part 2 'CountSymptomFromArray' successfully done!" + "\n",
			"\n" + "Part 3!!! An IOException occurred when writing in the file!",
			"\n" + "Part 3!!! An IOException occurred when we try to open the file! Check if it is not a read only file.",
			"Unable to find current directory, dialogue window opens in user's directory." };

	/**
	 * The Map &lt;String,Long&gt; used to collect the count of each symptom.
	 */
	TreeMap<String, Long> countResult;

	/**
	 * This final char value is used to recognize a YES answer in the
	 * questionYesOrNo(String question)method.
	 */
	private final char YES = 'Y';

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
	public static void main(String[] args) throws Exception {
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		analyticsCounter.analyticsCounterSupervisor();
		sendMessage(0);
	}

	/**
	 * <h1>Method analyticsCounterSupervisor:</h1>
	 * <p>
	 * This method monitors the application. It calls sequentially each principal
	 * function of the program:
	 * </p>
	 * <ul>
	 * <li>get the filepath of the file we want to read,
	 * <li>read and count the occurrences of each symptom,
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

		/* Part 2:
		 * This new Second part replaces old Part 2 and 3, ReadSymptomDataFromFile and
		 * CountSymptomsFromArray are no longer useful.
		 */
		readAndCountWithStream(filepath);
		if (countResult.isEmpty()) {
			sendMessage(7);
			return;
		}
		
		// Part 3: Generate an output text file
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
	 * Method readAndCountWithStream
	 * This method use the method lines() in Files class to read a file, line by line as Stream of String
	 * and then use a groupingBy collector to create the TreeMap we need from the Stream.  
	 * @param filepath String - the path of the selected file
	 */
	public void readAndCountWithStream(String filepath) {
		try (Stream<String> symptomsStream = Files.lines(Paths.get(filepath))) {
			countResult = symptomsStream
				.collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
			sendMessage(8);
			for (Map.Entry<String, Long> kV : countResult.entrySet()) {
				System.out.println(kV.getKey() + "= " + kV.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
			sendMessage(8);
		}
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
	public boolean writeATreeMapInATextFile(TreeMap<String, Long> countResult) {
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
		if (keybordAnswer == YES)
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
	public static void sendMessage(int mes) {
		System.out.println(messages[mes]);	
	}
}
