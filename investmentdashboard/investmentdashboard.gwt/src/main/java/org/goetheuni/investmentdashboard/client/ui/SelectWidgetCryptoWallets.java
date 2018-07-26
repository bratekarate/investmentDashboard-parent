package org.goetheuni.investmentdashboard.client.ui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SelectWidgetCryptoWallets extends AbstractSelectWidget<SelectableCryptoWallet> {

	
	private static List<AbstractSelectButton<SelectableCryptoWallet>> createButtons(List<? extends SelectableCryptoWallet> wallets){
		List<AbstractSelectButton<SelectableCryptoWallet>> result = new LinkedList<>();
		
		// create buttons
		for(SelectableCryptoWallet aWallet : wallets) {
			result.add(new SelectButtonCryptoWallet(aWallet));
		}
		
		return result;
	}
	
	public SelectWidgetCryptoWallets(List<? extends SelectableCryptoWallet> wallets, DetailWidgetCryptoWallet detailWidget) {
		this(createButtons(wallets), detailWidget);
	}
	
	protected SelectWidgetCryptoWallets(List<AbstractSelectButton<SelectableCryptoWallet>> someSelectButtons,
			AbstractDetailWidget<SelectableCryptoWallet> detailWidget) {
		super(someSelectButtons, detailWidget);
		
	}

	
}
