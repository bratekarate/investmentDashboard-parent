package org.goetheuni.investmentdashboard.client.ui;

import com.google.gwt.user.client.ui.IsWidget;

public interface AbstractDetailWidget<S extends Selectable> extends IsWidget {

	/**
	 * @return the currently displayed structure object
	 */
	S getCurrentCorrespondingObject();

	/**
	 * This method updates the detail widget, such that the details for the given
	 * Selectable are shown.
	 * 
	 * @param correspondingObjects
	 *            The Selectable to shown
	 */
	void update(S correspondingObject);
}
