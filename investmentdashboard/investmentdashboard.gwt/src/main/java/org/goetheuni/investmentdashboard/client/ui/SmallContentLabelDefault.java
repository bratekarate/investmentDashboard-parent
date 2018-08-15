package org.goetheuni.investmentdashboard.client.ui;

import com.google.gwt.user.client.ui.Label;

/**
 * Objects of this class are labels for small category content. They have the
 * default font color.
 * 
 * JAVADOC DONE
 * 
 */
public class SmallContentLabelDefault extends Label {

	/**
	 * Creates an empty label for small category content with default font color.
	 */
	public SmallContentLabelDefault() {
		this("");
	}

	/**
	 * Creates a label for small category content with default font color.
	 * 
	 * @param content
	 *            the label's content
	 */
	public SmallContentLabelDefault(String content) {
		super(content);
		this.getElement().getStyle().setColor(FontConstants.DEFAULTCOLOR);
		this.getElement().getStyle().setFontSize(FontConstants.SMALLCATEGORYCONTENT, FontConstants.UNIT);
	}
}
