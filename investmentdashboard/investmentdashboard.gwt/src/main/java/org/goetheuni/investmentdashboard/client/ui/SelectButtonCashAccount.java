package org.goetheuni.investmentdashboard.client.ui;

import java.util.ArrayList;
import java.util.List;

import org.goetheuni.investmentdashboard.client.resourceBundles.Resources;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class SelectButtonCashAccount extends AbstractSelectButton<SelectableCashAccount> {

	public SelectButtonCashAccount(SelectableCashAccount correspondingStructure) {
		// the icon is defined here
		this(Resources.getPictogram(), correspondingStructure, new ArrayList<>(), new Label());
	}

	protected SelectButtonCashAccount(Image icon, SelectableCashAccount correspondingStructure,
			List<Label> optionalCurrencyLabel, Label optionalAmountLabel) {
		super(icon, correspondingStructure, optionalCurrencyLabel, optionalAmountLabel);
	}

}
