package org.goetheuni.investmentdashboard.client.ui;

import org.goetheuni.investmentdashboard.client.resourceBundles.Resources;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class SelectButtonCashAccount extends AbstractSelectButton<SelectableCashAccount> {

	public SelectButtonCashAccount(SelectableCashAccount correspondingStructure) {
		// the icon is defined here
		this(Resources.getPictogram(), correspondingStructure, new ContentLabelBlack(""));
	}

	protected SelectButtonCashAccount(Image icon, SelectableCashAccount correspondingStructure,
			Label optionalCurrencyLabel) {
		super(icon, correspondingStructure, optionalCurrencyLabel);
	}

}
