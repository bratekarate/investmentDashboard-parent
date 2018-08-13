package org.goetheuni.investmentdashboard.client.ui;

import java.util.List;

import org.goetheuni.investmentdashboard.client.global.DashBoardWidgets;

public class WidgetCryptoWallets extends AbstractCategoryWidget<SelectableCryptoWallet> {

	public static WidgetCryptoWallets generate(List<? extends SelectableCryptoWallet> wallets) {
		// generate detail widget
		DetailWidgetCryptoWallet details = new DetailWidgetCryptoWallet();

		// generate select widget
		SelectWidgetCryptoWallets selectWidget = new SelectWidgetCryptoWallets(wallets, details);

		// generate header
		String header = "Krypto-Anlagen";

		// return result
		return new WidgetCryptoWallets(header, selectWidget, details);
	}

	protected WidgetCryptoWallets(String header, AbstractSelectWidget<SelectableCryptoWallet> selectWidget,
			AbstractDetailWidget<SelectableCryptoWallet> detailWidget) {
		super(header, selectWidget, detailWidget);
		DashBoardWidgets.setCryptoWallets(this);
	}

}
