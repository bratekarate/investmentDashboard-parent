package org.goetheuni.investmentdashboard.client.ui;

import java.util.ArrayList;
import java.util.List;

public class SelectWidgetSecurityDepot extends AbstractSelectWidget<SelectableSecurityDepot> {

	private static List<AbstractSelectButton<SelectableSecurityDepot>> createButtons(
			List<? extends SelectableSecurityDepot> depots) {
		List<AbstractSelectButton<SelectableSecurityDepot>> result = new ArrayList<>();

		// create buttons
		for (SelectableSecurityDepot aDepot : depots) {
			result.add(new SelectButtonSecurityDepot(aDepot));
		}

		return result;
	}

	public SelectWidgetSecurityDepot(List<? extends SelectableSecurityDepot> depots,
			DetailWidgetSecurityDepot detailWidget) {
		this(createButtons(depots), detailWidget);
	}

	protected SelectWidgetSecurityDepot(List<AbstractSelectButton<SelectableSecurityDepot>> someSelectButtons,
			AbstractDetailWidget<SelectableSecurityDepot> detailWidget) {
		super(someSelectButtons, detailWidget);
	}

}
