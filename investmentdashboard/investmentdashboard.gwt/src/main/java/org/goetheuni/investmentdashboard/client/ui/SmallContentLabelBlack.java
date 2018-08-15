package org.goetheuni.investmentdashboard.client.ui;

import com.google.gwt.user.client.ui.Label;

/**
 * Objects of this class are labels for small category content with black font
 * color.
 * 
 * JAVADOC DONE
 * 
 */
public class SmallContentLabelBlack extends Label {

	/**
	 * Creates an empty label for small category content with black font color.
	 */
	public SmallContentLabelBlack() {
		this("");
	}

	/**
	 * Creates a label for small category content with black font color.
	 * 
	 * @param content
	 *            The label's content
	 */
	public SmallContentLabelBlack(String content) {
		super(content);
		this.getElement().getStyle().setColor("black");
		this.getElement().getStyle().setFontSize(FontConstants.SMALLCATEGORYCONTENT, FontConstants.UNIT);
	}
}
