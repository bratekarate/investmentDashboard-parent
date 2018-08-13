package org.goetheuni.investmentdashboard.client.ui;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * An objec twith this interface is a widget that shows details for a Selectable object of the a category.
 * It will be updated, if a select button of the corresponding select widget is pressed.
 * 
 * @param <S> The category (cash, crypto or depots)
 * 
 * JAVADOC DONE
 */
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

	/**
	 * Sets the detail widget's appearance back to its original state after
	 * initialization.
	 */
	void resetAppearance();
}
