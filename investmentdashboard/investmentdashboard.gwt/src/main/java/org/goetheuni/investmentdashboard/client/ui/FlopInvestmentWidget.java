package org.goetheuni.investmentdashboard.client.ui;

import org.goetheuni.investmentdashboard.client.structure.SecurityInvestmentStruct;

/**
 * Objects of this class visualize a flop investment.
 */
public class FlopInvestmentWidget extends AbstractInvestmentWidget {

	/**
	 * Creates a flop investment widget from the given flop investment.
	 * @param correspondingObject The flop investment to visualize
	 */
	protected FlopInvestmentWidget(SecurityInvestmentStruct correspondingObject) {
		super(correspondingObject);
	}

}
