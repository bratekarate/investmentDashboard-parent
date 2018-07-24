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
		rootPanel.getElement().getStyle().setColor(FontConstants.DEFAULTCOLOR);;
		
		// create the fundamental layout
		VerticalPanel fundamentalLayout = new VerticalPanel();
		rootPanel.add(fundamentalLayout);
		
		// create panels
		VerticalPanel topPanel = new VerticalPanel();
		HorizontalPanel panelForWidgets = new HorizontalPanel();
		VerticalPanel leftPanel = new VerticalPanel();
		VerticalPanel rightPanel= new VerticalPanel();
		
		// add panels according to their position
		fundamentalLayout.add(topPanel);
		fundamentalLayout.add(panelForWidgets);
		panelForWidgets.add(leftPanel);
		panelForWidgets.add(rightPanel);
		
		// specify alignment
		fundamentalLayout.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		// build the top part
		// compute the balance
		BigDecimal totalBalance = RootStructure.get().computeTotalBalanceInEUR(SecurityMarketDataStorage.get(),
				CryptoMarketDataStorage.get());
		
		TopUIPartBuilder.buildUI(totalBalance, topPanel);
		
		
	}

	
}
