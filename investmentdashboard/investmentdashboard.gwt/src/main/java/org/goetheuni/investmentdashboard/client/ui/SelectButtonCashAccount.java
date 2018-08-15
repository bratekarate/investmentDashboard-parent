package org.goetheuni.investmentdashboard.client.ui;

import org.goetheuni.investmentdashboard.client.resourceBundles.Resources;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

/**
 * Objects of this class represent select buttons for cash accounts.
 * 
 * JAVADOC DONE
 */
public class SelectButtonCashAccount extends AbstractSelectButton<SelectableCashAccount> {

	/**
	 * Creates a select button for the given cash account.
	 * 
	 * @param correspondingStructure
	 *            The cash account
	 */
	public SelectButtonCashAccount(SelectableCashAccount correspondingStructure) {
		// the icon is defined here
		this(Resources.getPictogram(), correspondingStructure, new VolatilityLabel(), new Label());
	}

	/**
	 * NOT A PART OF THE API
	 * 
	 * @param icon
	 *            please see the superclass constructor
	 * @param correspondingStructure
	 *            please see the superclass constructor
	 * @param optionalVolatilityLabel
	 *            please see the superclass constructor
	 * @param optionalAmountLabel
	 *            please see the superclass constructor
	 */
	protected SelectButtonCashAccount(Image icon, SelectableCashAccount correspondingStructure,
			VolatilityLabel optionalVolatilityLabel, Label optionalAmountLabel) {
		super(icon, correspondingStructure, optionalVolatilityLabel, optionalAmountLabel);
	}

}
