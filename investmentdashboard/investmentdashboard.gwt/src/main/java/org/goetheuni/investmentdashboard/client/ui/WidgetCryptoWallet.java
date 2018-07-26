package org.goetheuni.investmentdashboard.client.ui;

import java.util.List;

public class WidgetCryptoWallet extends AbstractCategoryWidget<SelectableCryptoWallet> {

	
	public static WidgetCryptoWallet generate(List<? extends SelectableCryptoWallet> wallets) {
		// generate detail widget
		DetailWidgetCryptoWallet details = new DetailWidgetCryptoWallet();
		
		// generate select widget
		SelectWidgetCryptoWallets selectWidget = new SelectWidgetCryptoWallets(wallets, details);
		
		// generate header
		String header = "Krypto-Anlagen";
		
		// return result
		return new WidgetCryptoWallet(header, selectWidget, details);
	}
	
	
	protected WidgetCryptoWallet(String header, AbstractSelectWidget<SelectableCryptoWallet> selectWidget,
			AbstractDetailWidget<SelectableCryptoWallet> detailWidget) {
		super(header, selectWidget, detailWidget);
	}

	
}
