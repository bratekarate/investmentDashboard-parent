package org.goetheuni.investmentdashboard.client.ui;

import java.util.Objects;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.VerticalPanel;

public abstract class AbstractCategoryWidget<S extends Selectable> extends VerticalPanel {

	protected AbstractSelectWidget<S> selectWidget;

	protected AbstractDetailWidget<S> detailWidget;

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
		this.setSpacing(6);

		// add widgets
		this.add(selectWidget);
		this.add(detailWidget);
	}
}
