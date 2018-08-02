/**
 * 
 */
package org.goetheuni.investmentdashboard.client.ui;

import java.math.BigDecimal;
import java.util.List;

import org.goetheuni.investmentdashboard.shared.impl.CryptoPayment;

/**
 *
 */
public interface SelectableCryptoWallet extends Selectable {

	String getFormattedAmountInX();

	String getFormattedExchangeRate();

	BigDecimal getReferenceValue();

	BigDecimal getExchangeRate();

	List<CryptoPayment> getRecentPaymentsSorted(int numberOfPayments);

	boolean isEmpty();

}
