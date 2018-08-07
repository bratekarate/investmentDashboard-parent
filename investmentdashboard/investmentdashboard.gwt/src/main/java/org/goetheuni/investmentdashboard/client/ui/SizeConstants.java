package org.goetheuni.investmentdashboard.client.ui;

/**
 * This class provides constants and methods for the sizing of widgets;
 */
public class SizeConstants {

	private static int totalWidth = 90;

	public static String getTotalWidth() {
		return SizeConstants.totalWidth + "vw";
	}

	static class ForCatWidgets {

		private static int categoryWidgetWidth = 41;

		public static String getWidth() {
			return SizeConstants.ForCatWidgets.categoryWidgetWidth + "vw";
		}
	}
}
