package org.goetheuni.investmentdashboard.client.ui;

import java.util.ArrayList;
import java.util.List;

/**
 * Objects of this class represent select widgets for security depots.
 */
public class SelectWidgetSecurityDepot extends AbstractSelectWidget<SelectableSecurityDepot> {

	/**
	 * @param depots
	 *            The depots represented by the widget
	 * @return The buttons of the widget (without click-handlers)
	 */
	private static List<AbstractSelectButton<SelectableSecurityDepot>> createButtons(
			List<? extends SelectableSecurityDepot> depots) {
		List<AbstractSelectButton<SelectableSecurityDepot>> result = new ArrayList<>();

		// create buttons
		for (SelectableSecurityDepot aDepot : depots) {
			result.add(new SelectButtonSecurityDepot(aDepot));
		}

		return result;
	}

	/**
	 * Creates a select widget for security depots.
	 * 
	 * @param depots
	 *            The depots shown in the widget
	 * @param detailWidget
	 *            The corresponding detail widget
	 */
	public SelectWidgetSecurityDepot(List<? extends SelectableSecurityDepot> depots,
			DetailWidgetSecurityDepot detailWidget) {
		this(createButtons(depots), detailWidget);
	}

	/**
	 * NOT A PART OF THE API
	 * 
	 * @param someSelectButtons
	 *            The widget's select buttons
	 * @param detailWidget
	 *            The corresponding detail widget
	 */
	protected SelectWidgetSecurityDepot(List<AbstractSelectButton<SelectableSecurityDepot>> someSelectButtons,
			AbstractDetailWidget<SelectableSecurityDepot> detailWidget) {
		super(someSelectButtons, detailWidget);
	}

}
