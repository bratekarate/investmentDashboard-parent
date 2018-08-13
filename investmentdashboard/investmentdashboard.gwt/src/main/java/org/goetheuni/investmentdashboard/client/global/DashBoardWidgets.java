package org.goetheuni.investmentdashboard.client.global;

import org.goetheuni.investmentdashboard.client.ui.WidgetCashAccounts;
import org.goetheuni.investmentdashboard.client.ui.WidgetCryptoWallets;
import org.goetheuni.investmentdashboard.client.ui.WidgetSecurityDepots;

import com.google.gwt.user.client.ui.Label;

/**
 * This class provides access to the dashboard's widgets
 */
public class DashBoardWidgets {

	/**
	 * Stores the label for the total balance. It is null if it has not been
	 * initialized yet.
	 */
	protected static Label totalBalanceLabel;

	/**
	 * Stores the widget for cash accounts. It is null if it has not been
	 * initialized yet.
	 */
	protected static WidgetCashAccounts cashAccounts;

	/**
	 * Stores the widget for crypto wallets. It is null if it has not been
	 * initialized yet.
	 */
	protected static WidgetCryptoWallets cryptoWallets;

	/**
	 * Stores the widget for security depots. It is null if it has not been
	 * initialized yet.
	 */
	protected static WidgetSecurityDepots securityDepots;

	/**
	 * @return the totalBalanceLabel
	 */
	public static Label getTotalBalanceLabel() {
		if (DashBoardWidgets.totalBalanceLabel != null) {
			return totalBalanceLabel;
		} else {
			throw new RuntimeException("The total balance label was not initalized (is null)");
		}
	}

	/**
	 * @return the cashAccounts
	 */
	public static WidgetCashAccounts getCashAccounts() {
		if (DashBoardWidgets.cashAccounts != null) {
			return cashAccounts;
		} else {
			throw new RuntimeException("The cashAccounts widget was not initalized (is null)");
		}
	}

	/**
	 * @return the cryptoWallets
	 */
	public static WidgetCryptoWallets getCryptoWallets() {
		if (DashBoardWidgets.cryptoWallets != null) {
			return cryptoWallets;
		} else {
			throw new RuntimeException("The cryptowallets widget was not initalized (is null)");
		}
	}

	/**
	 * @return the securityDepots
	 */
	public static WidgetSecurityDepots getSecurityDepots() {
		if (DashBoardWidgets.securityDepots != null) {
			return securityDepots;
		} else {
			throw new RuntimeException("The security depots widget was not initalized (is null)");
		}
	}

	/**
	 * @param totalBalanceLabel
	 *            the totalBalanceLabel to set
	 */
	public static void setTotalBalanceLabel(Label totalBalanceLabel) {
		DashBoardWidgets.totalBalanceLabel = totalBalanceLabel;
	}

	/**
	 * @param cashAccounts
	 *            the cashAccounts to set
	 */
	public static void setCashAccounts(WidgetCashAccounts cashAccounts) {
		DashBoardWidgets.cashAccounts = cashAccounts;
	}

	/**
	 * @param cryptoWallets
	 *            the cryptoWallets to set
	 */
	public static void setCryptoWallets(WidgetCryptoWallets cryptoWallets) {
		DashBoardWidgets.cryptoWallets = cryptoWallets;
	}

	/**
	 * @param securityDepots
	 *            the securityDepots to set
	 */
	public static void setSecurityDepots(WidgetSecurityDepots securityDepots) {
		DashBoardWidgets.securityDepots = securityDepots;
	}

}
