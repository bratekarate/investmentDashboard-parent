package org.goetheuni.investmentdashboard.client.ui;

import com.google.gwt.user.client.ui.Label;

/**
 * Objects of this class are labels for category headers with black font color.
 * 
 * JAVADOC DONE
 */
public class HeaderLabelBlack extends Label {

	/**
	 * Creates a header label with black font color.
	 *  
	 * @param text The label's content
	 */
	public HeaderLabelBlack(String text) {
		super(text);
		this.getElement().getStyle().setColor("black");
		this.getElement().getStyle().setFontSize(FontConstants.CATEGORYHEADER, FontConstants.UNIT);
	}
}
