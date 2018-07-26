/**
 * 
 */
package org.goetheuni.investmentdashboard.client.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.goetheuni.investmentdashboard.client.resourceBundles.Resources;

import com.google.gwt.user.client.rpc.core.java.util.Collections;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

/**
 * 
 *
 */
public class SelectButtonCryptoWallet extends AbstractSelectButton<SelectableCryptoWallet> {

	private static List<Label> createLabels(SelectableCryptoWallet correspondingStructure) {
		List<Label> result = new ArrayList<>();

		// label for the exchange rate
		result.add(new VolatilityLabel(correspondingStructure.getFormattedExchangeRate(),
				correspondingStructure.getExchangeRate(), correspondingStructure.getReferenceValue()));

		return result;
	}

	public SelectButtonCryptoWallet(SelectableCryptoWallet correspondingStructure) {
		// the label for the amount of crypto assets is defined here
		this(Resources.getPictogram(), correspondingStructure, createLabels(correspondingStructure),
				new ContentLabelDefault(correspondingStructure.getFormattedAmountInX()));
	}

	protected SelectButtonCryptoWallet(Image icon, SelectableCryptoWallet correspondingStructure,
			List<Label> optionalCurrencyLabel, Label optionalAmountLabel) {
		super(icon, correspondingStructure, optionalCurrencyLabel, optionalAmountLabel);
	}

}
