package org.goetheuni.investmentdashboard.client.ui;

import java.util.List;

public class WidgetSecurityDepots extends AbstractCategoryWidget<SelectableSecurityDepot> {

	public static WidgetSecurityDepots generate(List<? extends SelectableSecurityDepot> depots) {
		// create detail widget
		DetailWidgetSecurityDepot details = new DetailWidgetSecurityDepot();

		// create select widget
		SelectWidgetSecurityDepot selectWidget = new SelectWidgetSecurityDepot(depots, details);

		String header = "Wertpapier-Depots";

		// create widget
		return new WidgetSecurityDepots(header, selectWidget, details);
	}

	protected WidgetSecurityDepots(String header, AbstractSelectWidget<SelectableSecurityDepot> selectWidget,
			AbstractDetailWidget<SelectableSecurityDepot> detailWidget) {
		super(header, selectWidget, detailWidget);
	}

}
