package org.goetheuni.investmentdashboard.client.ui;

import org.goetheuni.investmentdashboard.client.structure.RootStructure;

import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Builds the right part of the dash boards' UI in the center.
 * 
 * JAVADOC DONE
 */
public class RightUIPartBuilder {

	/**
	 * Builds the left part of the dash boards' UI in the center.
	 */
	protected static void build(VerticalPanel rightLayoutPanel, RootStructure rootStructure) {

		rightLayoutPanel.setSpacing(7);

		rightLayoutPanel.add(WidgetSecurityDepots.generate(rootStructure.getDepots()));
	}

}
