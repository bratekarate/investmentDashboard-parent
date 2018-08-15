/**
 * 
 */
package org.goetheuni.investmentdashboard.client.ui;

import java.math.BigDecimal;
import java.util.List;

import org.goetheuni.investmentdashboard.shared.impl.CryptoPayment;

/**
 * Extends the selectable interface for crypto wallets.
 * 
 * JAVADOC DONE
 */
public interface SelectableCryptoWallet extends Selectable {

	/**
	 * @return A formatted string for the amount in the crypto currency
	 */
	String getFormattedAmountInX();

	/**
	 * @return A formatted string for the euro-value of one unit of the crypot
	 *         currency.
	 */
	String getFormattedExchangeRate();

	/**
	 * @return The reference value for the exchange rate
	 */
	BigDecimal getReferenceValue();

	/**
	 * @return The currently stored value for the exchange rate
	 */
	BigDecimal getExchangeRate();

	/**
	 * Returns a sorted list of the most recent payments of this crypto wallet.
	 * 
	 * @param numberOfPayments
	 *            The maximum number of payments in the result
	 * @return sorted list of the most recent payments (The most recent payment at
	 *         first position)
	 */
	List<CryptoPayment> getRecentPaymentsSorted(int numberOfPayments);

}
