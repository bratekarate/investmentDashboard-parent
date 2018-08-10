package org.goetheuni.investmentdashboard.client.ui;

import java.math.BigDecimal;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * This class provides a method that builds the top part of the UI.
 */
public class TopUIPartBuilder {

	protected static void buildUI(BigDecimal totalBalance, VerticalPanel topLayoutPanel) {

		HorizontalPanel firstRowPanel = new HorizontalPanel();
		HorizontalPanel panelLinks = new HorizontalPanel();
		HorizontalPanel panelTotalBalance = new HorizontalPanel();

		// the main widget of this site is the given VerticalPanel

		topLayoutPanel.setSpacing(7);

		// dummy label
		ContentLabelDefault linkActions = new ContentLabelDefault("Kontoaktionen");
		ContentLabelDefault linkContact = new ContentLabelDefault("Postfach");

		panelLinks.setWidth(SizeConstants.ForCatWidgets.getWidth());
		panelTotalBalance.setWidth(SizeConstants.getTotalWidth());

		// add links to their panel
		HeaderLabelBlack topLabel = new HeaderLabelBlack("Meine Konten");
		panelLinks.add(linkActions);
		panelLinks.add(linkContact);
		firstRowPanel.setWidth(SizeConstants.getTotalWidth());
		firstRowPanel.add(topLabel);
		firstRowPanel.add(panelLinks);
		firstRowPanel.setCellHorizontalAlignment(topLabel, HasHorizontalAlignment.ALIGN_LEFT);
		firstRowPanel.setCellHorizontalAlignment(panelLinks, HasHorizontalAlignment.ALIGN_RIGHT);

		// row 2
		// get total balance

		ContentLabelDefault labelTotalBalanceText = new ContentLabelDefault("Gesamtsaldo");
		// with
		// pixel

		ContentLabelBlack labelTotalBalance = new ContentLabelBlack(
				NumberFormat.getCurrencyFormat("EUR").format(totalBalance.doubleValue()));
		panelTotalBalance.add(labelTotalBalanceText);
		panelTotalBalance.add(labelTotalBalance);

		// specify alignment
		panelLinks.setCellHorizontalAlignment(linkContact, HasHorizontalAlignment.ALIGN_LOCALE_END);
		panelTotalBalance.setCellHorizontalAlignment(labelTotalBalance, HasHorizontalAlignment.ALIGN_LOCALE_END);
		panelTotalBalance.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		// set the panel's background color to white
		panelLinks.getElement().getStyle().setBackgroundColor(StyleConstants.WIDGET_BACKGROUND_COLOR);
		panelTotalBalance.getElement().getStyle().setBackgroundColor(StyleConstants.WIDGET_BACKGROUND_COLOR);

		// make the border bigger
		panelLinks.getElement().getStyle().setBorderWidth(StyleConstants.WIDEGT_BORDER_WIDTH, Unit.PX);
		panelLinks.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		panelLinks.getElement().getStyle().setBorderColor(StyleConstants.WIDGET_BACKGROUND_COLOR);

		panelTotalBalance.getElement().getStyle().setBorderWidth(StyleConstants.WIDEGT_BORDER_WIDTH, Unit.PX);
		panelTotalBalance.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		panelTotalBalance.getElement().getStyle().setBorderColor(StyleConstants.WIDGET_BACKGROUND_COLOR);

		// add to the root layout
		topLayoutPanel.add(firstRowPanel);
		topLayoutPanel.add(panelTotalBalance);

	}

}
