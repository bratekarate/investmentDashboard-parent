package org.goetheuni.investmentdashboard.client.ui;

import org.goetheuni.investmentdashboard.client.resourceBundles.Resources;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class SelectButtonCashAccount extends AbstractSelectButton<SelectableCashAccount> {

	public SelectButtonCashAccount(SelectableCashAccount correspondingStructure) {
		// the icon is defined here
		this(Resources.getPictogram(), correspondingStructure, new VolatilityLabel(), new Label());
	}

	protected SelectButtonCashAccount(Image icon, SelectableCashAccount correspondingStructure,
			VolatilityLabel optionalVolatilityLabel, Label optionalAmountLabel) {
		super(icon, correspondingStructure, optionalVolatilityLabel, optionalAmountLabel);
	}

}
