/**
 * 
 */
package org.goetheuni.investmentdashboard.client.ui;

import org.goetheuni.investmentdashboard.client.resourceBundles.Resources;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

/**
 * 
 *
 */
public class SelectButtonCryptoWallet extends AbstractSelectButton<SelectableCryptoWallet> {

	private static VolatilityLabel createLabel(SelectableCryptoWallet correspondingStructure) {

		return new VolatilityLabel(correspondingStructure.getFormattedExchangeRate(),
				correspondingStructure.getExchangeRate(), correspondingStructure.getReferenceValue());
	}

	public SelectButtonCryptoWallet(SelectableCryptoWallet correspondingStructure) {
		// the label for the amount of crypto assets is defined here
		this(Resources.getPictogram(), correspondingStructure, createLabel(correspondingStructure),
				new ContentLabelDefault(correspondingStructure.getFormattedAmountInX()));
	}

	protected SelectButtonCryptoWallet(Image icon, SelectableCryptoWallet correspondingStructure,
			VolatilityLabel optionalVolatilityLabel, Label optionalAmountLabel) {
		super(icon, correspondingStructure, optionalVolatilityLabel, optionalAmountLabel);
	}

}
