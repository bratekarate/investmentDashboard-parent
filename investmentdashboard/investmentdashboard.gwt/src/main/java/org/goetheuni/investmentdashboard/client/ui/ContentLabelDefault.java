/**
 * 
 */
package org.goetheuni.investmentdashboard.client.ui;

import com.google.gwt.user.client.ui.Label;

/**
 * Objects of this class represent labels for content within a category. Their font color is the default color.
 */
public class ContentLabelDefault extends Label {

	/**
	 *  Creates a label for content within a category. Its font color is the default color.
	 * @param text
	 */
	public ContentLabelDefault(String text) {
		super(text);
		this.getElement().getStyle().setColor(FontConstants.DEFAULTCOLOR);
		this.getElement().getStyle().setFontSize(FontConstants.CATEGORYCONTENT, FontConstants.UNIT);
	}
}
