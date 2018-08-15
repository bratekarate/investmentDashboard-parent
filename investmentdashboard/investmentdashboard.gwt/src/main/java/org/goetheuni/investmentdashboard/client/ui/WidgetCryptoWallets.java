package org.goetheuni.investmentdashboard.client.ui;

import java.util.List;

import org.goetheuni.investmentdashboard.client.global.DashBoardWidgets;

/**
 * Objects of this class represent category widgets for the category crypto
 * assets.
 * 
 * JAVADOC DONE
 */
public class WidgetCryptoWallets extends AbstractCategoryWidget<SelectableCryptoWallet> {

	/**
	 * Creates a category widget for crypto assets
	 * 
	 * @param wallets
	 *            The customer's crypto wallets
	 * @return a category widget for crypto assets
	 */
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

	/**
	 * NOT A PART OF THE API
	 * 
	 * @param header
	 *            please see the superclass constructor
	 * @param selectWidget
	 *            please see the superclass constructor
	 * @param detailWidget
	 *            please see the superclass constructor
	 */
	protected WidgetCryptoWallets(String header, AbstractSelectWidget<SelectableCryptoWallet> selectWidget,
			AbstractDetailWidget<SelectableCryptoWallet> detailWidget) {
		super(header, selectWidget, detailWidget);
		DashBoardWidgets.setCryptoWallets(this);
	}

}
