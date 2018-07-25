/**
 * 
 */
package org.goetheuni.investmentdashboard.client.ui;

import com.google.gwt.user.client.ui.Label;

/**
 *
 */
public class ContentLabelDefault extends Label {

	public ContentLabelDefault(String text) {
		super(text);
		this.getElement().getStyle().setColor(FontConstants.DEFAULTCOLOR);
		this.getElement().getStyle().setFontSize(FontConstants.CATEGORYCONTENT, FontConstants.UNIT);
	}
}
