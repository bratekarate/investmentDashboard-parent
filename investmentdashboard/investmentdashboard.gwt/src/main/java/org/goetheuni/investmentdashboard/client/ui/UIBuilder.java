package org.goetheuni.investmentdashboard.client.ui;

import java.math.BigDecimal;

import org.goetheuni.investmentdashboard.client.structure.RootStructure;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class UIBuilder {

	public static void buildUI(RootPanel rootPanel, RootStructure rootStruct) {

		// set default color (of the text)
		rootPanel.getElement().getStyle().setColor(FontConstants.DEFAULTCOLOR);

		// create a own rootpanel
		VerticalPanel myRoot = new VerticalPanel();
		myRoot.setWidth("100%");
		myRoot.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		rootPanel.add(myRoot);

		// create the fundamental layout
		VerticalPanel fundamentalLayout = new VerticalPanel();
		myRoot.add(fundamentalLayout);

		fundamentalLayout.setWidth(SizeConstants.getTotalWidth());
		fundamentalLayout.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		// create panels
		VerticalPanel topPanel = new VerticalPanel();
		HorizontalPanel panelForWidgets = new HorizontalPanel();
		VerticalPanel leftPanel = new VerticalPanel();
		VerticalPanel rightPanel = new VerticalPanel();

		// configure the panel's size
		topPanel.setWidth(SizeConstants.getTotalWidth());
		panelForWidgets.setWidth("100%");

		// add panels according to their position
		fundamentalLayout.add(topPanel);
		fundamentalLayout.add(panelForWidgets);
		panelForWidgets.add(leftPanel);
		panelForWidgets.add(rightPanel);

		// specify alignment

		panelForWidgets.setCellHorizontalAlignment(leftPanel, HasHorizontalAlignment.ALIGN_LEFT);
		panelForWidgets.setCellHorizontalAlignment(rightPanel, HasHorizontalAlignment.ALIGN_RIGHT);
		leftPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		rightPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		topPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		// build the top part
		// compute the balance
		BigDecimal totalBalance = RootStructure.get().getCachedTotalBalance();

		TopUIPartBuilder.buildUI(totalBalance, topPanel);

		LeftUIPartBuilder.buildUI(leftPanel, rootStruct);

		RightUIPartBuilder.build(rightPanel, rootStruct);

	}

}
