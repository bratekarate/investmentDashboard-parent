package org.goetheuni.investmentdashboard.client.ui;

/**
 * This class provides constants und methods for the sizing of widgets;
 */
public class SizeConstants {

	private static int totalWidth = 94;

	public static String getTotalWidth() {
		return SizeConstants.totalWidth + "vw";
	}

	static class ForCatWidgets {

		private static int categoryWidgetWidth = 44;

		public static String getWidth() {
			return SizeConstants.ForCatWidgets.categoryWidgetWidth + "vw";
		}
	}
}
