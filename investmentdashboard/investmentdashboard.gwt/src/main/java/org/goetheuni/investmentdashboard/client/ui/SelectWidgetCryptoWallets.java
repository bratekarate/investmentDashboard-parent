package org.goetheuni.investmentdashboard.client.ui;

import java.util.LinkedList;
import java.util.List;

/**
 * Objects of this class are select widgets for crypto wallets.
 * 
 * JAVADOC DONE
 */
public class SelectWidgetCryptoWallets extends AbstractSelectWidget<SelectableCryptoWallet> {

	/**
	 * @param wallets The wallets to represent
	 * @return Creates the buttons for the select widget (without click-handlers)
	 */
	private static List<AbstractSelectButton<SelectableCryptoWallet>> createButtons(
			List<? extends SelectableCryptoWallet> wallets) {
		List<AbstractSelectButton<SelectableCryptoWallet>> result = new LinkedList<>();

		// create buttons
		for (SelectableCryptoWallet aWallet : wallets) {
			result.add(new SelectButtonCryptoWallet(aWallet));
		}

		return result;
	}

	public SelectWidgetCryptoWallets(List<? extends SelectableCryptoWallet> wallets,
			DetailWidgetCryptoWallet detailWidget) {
		this(createButtons(wallets), detailWidget);
	}

	/**
	 * NOT A PART OF THE API
	 * @param someSelectButtons the widget's select buttons
	 * @param detailWidget the corresponding detail widget
	 */
	protected SelectWidgetCryptoWallets(List<AbstractSelectButton<SelectableCryptoWallet>> someSelectButtons,
			AbstractDetailWidget<SelectableCryptoWallet> detailWidget) {
		super(someSelectButtons, detailWidget);

	}

}
