package org.goetheuni.investmentdashboard.client.ui;

import com.google.gwt.user.client.ui.Label;

/**
 * Objects of this class are Labels in a category. Their font color is black.
 */
public class ContentLabelBlack extends Label {

	public ContentLabelBlack(String text) {
		super(text);
		this.getElement().getStyle().setColor("black");
		this.getElement().getStyle().setFontSize(FontConstants.CATEGORYCONTENT, FontConstants.UNIT);
	}
}
