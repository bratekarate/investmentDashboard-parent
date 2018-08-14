/**
 * 
 */
package org.goetheuni.investmentdashboard.client.ui;

import org.goetheuni.investmentdashboard.client.structure.RootStructure;

import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Builds the left part of the dash boards' UI in the center. 
 * 
 * JAVADOC DONE
 */
public class LeftUIPartBuilder {

	/**
	 * Builds the left part of the dash boards' UI in the center. 
	 */
	protected static void buildUI(VerticalPanel leftLayoutPanel, RootStructure rootStruct) {

		leftLayoutPanel.setSpacing(7);

		leftLayoutPanel.add(WidgetCashAccounts.generate(rootStruct.getCashAccounts()));

		leftLayoutPanel.add(WidgetCryptoWallets.generate(rootStruct.getWallets()));

	}
}
