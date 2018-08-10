package org.goetheuni.investmentdashboard.client.ui;

import org.goetheuni.investmentdashboard.client.structure.RootStructure;

import com.google.gwt.user.client.ui.VerticalPanel;

public class RightUIPartBuilder {

	protected static void build(VerticalPanel rightLayoutPanel, RootStructure rootStructure) {

		rightLayoutPanel.setSpacing(7);

		rightLayoutPanel.add(WidgetSecurityDepots.generate(rootStructure.getDepots()));
	}

}
