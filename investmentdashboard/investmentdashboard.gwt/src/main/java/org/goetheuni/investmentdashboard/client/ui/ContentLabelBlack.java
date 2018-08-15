package org.goetheuni.investmentdashboard.client.ui;

import com.google.gwt.user.client.ui.Label;

/**
 * Objects of this class represent labels for content within a category. Their
 * font color is black.
 * 
 * JAVADOC DONE
 */
public class ContentLabelBlack extends Label {

	/**
	 * Creates a label for content within a category. Its font color is black.
	 * 
	 * @param text
	 */
	public ContentLabelBlack(String text) {
		super(text);
		this.getElement().getStyle().setColor("black");
		this.getElement().getStyle().setFontSize(FontConstants.CATEGORYCONTENT, FontConstants.UNIT);
	}
}
