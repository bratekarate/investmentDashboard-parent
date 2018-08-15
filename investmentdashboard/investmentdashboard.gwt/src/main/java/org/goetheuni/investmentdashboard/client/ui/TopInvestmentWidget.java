package org.goetheuni.investmentdashboard.client.ui;

import org.goetheuni.investmentdashboard.client.structure.SecurityInvestmentStruct;

/**
 * Objects of this class visualize top-investments.
 * 
 * JAVADOC DONE
 */
public class TopInvestmentWidget extends AbstractInvestmentWidget {

	/**
	 * Creates a top-investment widget for the given investment.
	 * 
	 * @param correspondingObject
	 *            the top-investment
	 */
	public TopInvestmentWidget(SecurityInvestmentStruct correspondingObject) {
		super(correspondingObject);
	}

}
