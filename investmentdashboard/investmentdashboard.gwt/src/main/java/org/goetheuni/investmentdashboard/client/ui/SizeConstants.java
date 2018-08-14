package org.goetheuni.investmentdashboard.client.ui;

/**
 * This class provides constants and methods for the sizing of widgets
 * 
 * JAVADOC DONE
 */
public class SizeConstants {

	/**
	 * The total width of the UI in the CSS unit vw
	 */
	private static int totalWidth = 90;
	
	/**
	 * The width of a category widget in the CSS unit vw
	 */
	private static int categoryWidgetWidth = 41;

	/**
	 * @return The total width of the UI as a string with vw
	 */
	public static String getTotalWidth() {
		return SizeConstants.totalWidth + "vw";
	}

	/**
	 * @return The width of the category widgets as a string with vw
	 */
	public static String getCategoryWidgetWidth() {
		return categoryWidgetWidth + "vw";
	}
}
