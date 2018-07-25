package org.goetheuni.investmentdashboard.client.ui;

import com.google.gwt.user.client.ui.Label;

public class HeaderLabelDefault extends Label {

	public HeaderLabelDefault(String text) {
		super(text);
		this.getElement().getStyle().setColor(FontConstants.DEFAULTCOLOR);
		this.getElement().getStyle().setFontSize(FontConstants.CATEGORYHEADER, FontConstants.UNIT);
	}

}
