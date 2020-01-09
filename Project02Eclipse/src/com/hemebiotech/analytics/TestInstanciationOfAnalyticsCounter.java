package com.hemebiotech.analytics;

/**
 * This class allows user to test if AnalyticsCount can be used from another class.
 * 
 * @author docky
 * @since 09/01/2020 
 */
public class TestInstanciationOfAnalyticsCounter {

	/**
	 * Method main used to create a instance of AnalyticsCounter and call its method
	 * analyticsCounterSupervisor.
	 * 
	 * @param args - not used
	 * @throws Exception -
	 */
	public static void main(String[] args) throws Exception {
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		analyticsCounter.analyticsCounterSupervisor();
		System.out.println("\n" + "AnalyticsCount program has successfully run after an external class method call.");
	}

}
