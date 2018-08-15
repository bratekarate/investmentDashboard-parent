package org.goetheuni.investmentdashboard.client.ui;

import java.util.List;

import org.goetheuni.investmentdashboard.client.global.DashBoardWidgets;

/**
 * Objects of this class represent category widgets for the category securities.
 * 
 * JAVADOC DONE
 */
public class WidgetSecurityDepots extends AbstractCategoryWidget<SelectableSecurityDepot> {

	/**
	 * Creates a category widget for the category securities.
	 * 
	 * @param depots
	 *            The customer's securiity depots
	 * @return a category widget for the category securities
	 */
	public static WidgetSecurityDepots generate(List<? extends SelectableSecurityDepot> depots) {
		// create detail widget
		DetailWidgetSecurityDepot details = new DetailWidgetSecurityDepot();

		// create select widget
		SelectWidgetSecurityDepot selectWidget = new SelectWidgetSecurityDepot(depots, details);

		String header = "Wertpapier-Depots";

		// create widget
		return new WidgetSecurityDepots(header, selectWidget, details);
	}

	/**
	 * NOT A PART OF THE API
	 * 
	 * @param header
	 *            please see the superclass constructor
	 * @param selectWidget
	 *            please see the superclass constructor
	 * @param detailWidget
	 *            please see the superclass constructor
	 */
	protected WidgetSecurityDepots(String header, AbstractSelectWidget<SelectableSecurityDepot> selectWidget,
			AbstractDetailWidget<SelectableSecurityDepot> detailWidget) {
		super(header, selectWidget, detailWidget);
		DashBoardWidgets.setSecurityDepots(this);
	}

}
