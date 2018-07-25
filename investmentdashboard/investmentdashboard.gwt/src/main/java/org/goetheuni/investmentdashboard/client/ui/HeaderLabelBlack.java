package org.goetheuni.investmentdashboard.client.ui;

import com.google.gwt.user.client.ui.Label;

public class HeaderLabelBlack extends Label {

	public HeaderLabelBlack(String text) {
		super(text);
		this.getElement().getStyle().setColor("black");
		this.getElement().getStyle().setFontSize(FontConstants.CATEGORYHEADER, FontConstants.UNIT);
	}
}
