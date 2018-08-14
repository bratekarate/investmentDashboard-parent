/**
 * 
 */
package org.goetheuni.investmentdashboard.client.ui;

import org.goetheuni.investmentdashboard.client.resourceBundles.Resources;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

/**
 * Objects of this class are select buttons for crypto wallets.
 * 
 * JAVADOC DONE
 */
public class SelectButtonCryptoWallet extends AbstractSelectButton<SelectableCryptoWallet> {

	/**
	 * Creates the volatility label of the select button.
	 * @param correspondingStructure The wallet
	 * @return the label expressing the wallet's volatility
	 */
	private static VolatilityLabel createLabel(SelectableCryptoWallet correspondingStructure) {

		return new VolatilityLabel(correspondingStructure.getFormattedExchangeRate(),
				correspondingStructure.getExchangeRate(), correspondingStructure.getReferenceValue());
	}

	/**
	 * Creates a select button for the given crypto wallet.
	 * @param correspondingStructure The wallet
	 */
	public SelectButtonCryptoWallet(SelectableCryptoWallet correspondingStructure) {
		// the label for the amount of crypto assets is defined here
		this(Resources.getPictogram(), correspondingStructure, createLabel(correspondingStructure),
				new ContentLabelDefault(correspondingStructure.getFormattedAmountInX()));
	}

	/**
	 * NOT A PART OF THE API
	 * @param icon please see the superclass constructor
	 * @param correspondingStructure please see the superclass constructor
	 * @param optionalVolatilityLabel please see the superclass constructor
	 * @param optionalAmountLabel please see the superclass constructor
	 */
	protected SelectButtonCryptoWallet(Image icon, SelectableCryptoWallet correspondingStructure,
			VolatilityLabel optionalVolatilityLabel, Label optionalAmountLabel) {
		super(icon, correspondingStructure, optionalVolatilityLabel, optionalAmountLabel);
	}

}
