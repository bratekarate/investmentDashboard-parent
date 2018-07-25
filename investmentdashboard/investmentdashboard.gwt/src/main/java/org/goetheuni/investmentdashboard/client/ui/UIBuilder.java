package org.goetheuni.investmentdashboard.client.ui;

import java.math.BigDecimal;

import org.goetheuni.investmentdashboard.client.global.CryptoMarketDataStorage;
import org.goetheuni.investmentdashboard.client.global.SecurityMarketDataStorage;
import org.goetheuni.investmentdashboard.client.structure.RootStructure;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class UIBuilder {

	public static void buildUI(RootPanel rootPanel, RootStructure rootStruct) {

		// set default color (of the text)
		rootPanel.getElement().getStyle().setColor(FontConstants.DEFAULTCOLOR);
		;

		// create the fundamental layout
		VerticalPanel fundamentalLayout = new VerticalPanel();
		rootPanel.add(fundamentalLayout);

		// create panels
		VerticalPanel topPanel = new VerticalPanel();
		HorizontalPanel panelForWidgets = new HorizontalPanel();
		VerticalPanel leftPanel = new VerticalPanel();
		VerticalPanel rightPanel = new VerticalPanel();

		// configure the panel's size
		topPanel.setWidth(SizeConstants.getTotalWidth());
		panelForWidgets.setWidth(SizeConstants.getTotalWidth());
		leftPanel.setWidth(SizeConstants.ForCatWidgets.getWidth());
		rightPanel.setWidth(SizeConstants.ForCatWidgets.getWidth());

		// add panels according to their position
		fundamentalLayout.add(topPanel);
		fundamentalLayout.add(panelForWidgets);
		panelForWidgets.add(leftPanel);
		panelForWidgets.add(rightPanel);

		// specify alignment
		fundamentalLayout.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		panelForWidgets.setCellHorizontalAlignment(leftPanel, HasHorizontalAlignment.ALIGN_LEFT);
		panelForWidgets.setCellHorizontalAlignment(rightPanel, HasHorizontalAlignment.ALIGN_RIGHT);

		// build the top part
		// compute the balance
		BigDecimal totalBalance = RootStructure.get().computeTotalBalanceInEUR(SecurityMarketDataStorage.get(),
				CryptoMarketDataStorage.get());

		TopUIPartBuilder.buildUI(totalBalance, topPanel);

		LeftUIPartBuilder.buildUI(leftPanel, rootStruct);

	}

}
