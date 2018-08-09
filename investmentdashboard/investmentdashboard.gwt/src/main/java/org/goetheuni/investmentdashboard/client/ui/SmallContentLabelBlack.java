package org.goetheuni.investmentdashboard.client.ui;

import com.google.gwt.user.client.ui.Label;

public class SmallContentLabelBlack extends Label {

	public SmallContentLabelBlack() {
		this("");
	}
	
	public SmallContentLabelBlack(String content) {
		super(content);
		this.getElement().getStyle().setColor("black");
		this.getElement().getStyle().setFontSize(FontConstants.SMALLCATEGORYCONTENT, FontConstants.UNIT);
	}
}
