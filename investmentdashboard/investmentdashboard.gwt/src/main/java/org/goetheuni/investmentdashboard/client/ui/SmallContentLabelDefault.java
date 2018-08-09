package org.goetheuni.investmentdashboard.client.ui;

import com.google.gwt.user.client.ui.Label;

public class SmallContentLabelDefault extends Label {

	public SmallContentLabelDefault() {
		this("");
	}
	
	public SmallContentLabelDefault(String content) {
		super(content);
		this.getElement().getStyle().setColor(FontConstants.DEFAULTCOLOR);
		this.getElement().getStyle().setFontSize(FontConstants.SMALLCATEGORYCONTENT, FontConstants.UNIT);
	}
}
