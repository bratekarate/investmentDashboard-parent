package org.goetheuni.investmentdashboard.client.ui;

import java.util.Objects;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Objects of this class represent widgets for a whole category.
 * The three categories are cash, crypto assets and security depots.
 * It consists of a select widget and detail widget.
 * 
 * @param <S> The category that the widget represents.
 * 
 * JAVADOC DONE
 */
public abstract class AbstractCategoryWidget<S extends Selectable> extends VerticalPanel {

	/**
	 * The select widget (a child-widget)
	 */
	protected AbstractSelectWidget<S> selectWidget;

	/**
	 * The detail widget (a child-widget)
	 */
	protected AbstractDetailWidget<S> detailWidget;

	/**
	 * Creates a category widget.
	 * @param header The header of the category
	 * @param selectWidget The select widget of the new widget
	 * @param detailWidget the detail widget of the new widget
	 */
	protected AbstractCategoryWidget(String header, AbstractSelectWidget<S> selectWidget,
			AbstractDetailWidget<S> detailWidget) {
		// validate input
		Objects.requireNonNull(header, "The given header must not be null");
		this.selectWidget = Objects.requireNonNull(selectWidget, "The given selectWidget must not be null");
		this.detailWidget = Objects.requireNonNull(detailWidget, "The given detailWidget must not be null");

		// set the background color and widget border properties
		Style style = this.getElement().getStyle();
		style.setBackgroundColor(StyleConstants.WIDGET_BACKGROUND_COLOR);
		style.setBorderColor(StyleConstants.WIDGET_BACKGROUND_COLOR);
		style.setBorderStyle(Style.BorderStyle.SOLID);
		style.setBorderWidth(StyleConstants.WIDEGT_BORDER_WIDTH, Unit.PX);

		// create the header
		this.add(new HeaderLabelDefault(header));

		// set distance between header and SelectWidget
		this.setSpacing(5);

		// add widgets
		this.add(selectWidget);
		this.add(detailWidget);
	}
}
