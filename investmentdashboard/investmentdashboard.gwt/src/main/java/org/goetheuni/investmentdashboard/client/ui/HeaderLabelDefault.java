package org.goetheuni.investmentdashboard.client.ui;

import com.google.gwt.user.client.ui.Label;

/**
 * Objects of this class are labels for category headers with default font
 * color.
 */
public class HeaderLabelDefault extends Label {

	/**
	 * Creates a label for category headers with default font color.
	 * 
	 * @param text
	 *            The label's content
	 */
	public HeaderLabelDefault(String text) {
		super(text);
		this.getElement().getStyle().setColor(FontConstants.DEFAULTCOLOR);
		this.getElement().getStyle().setFontSize(FontConstants.CATEGORYHEADER, FontConstants.UNIT);
	}

}
