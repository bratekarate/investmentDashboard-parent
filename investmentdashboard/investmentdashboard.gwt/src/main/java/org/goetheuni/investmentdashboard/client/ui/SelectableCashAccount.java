/**
 * 
 */
package org.goetheuni.investmentdashboard.client.ui;

import java.util.List;

import org.goetheuni.investmentdashboard.shared.impl.CashPayment;

/**
 * Extends the Selectable interface for cash accounts. Please notice the
 * super-interface.
 * 
 * JAVADOC DONE
 */
public interface SelectableCashAccount extends Selectable {

	/**
	 * Returns a sorted list of the most recent payments of this cash account
	 * 
	 * @param numberOfPayments
	 *            The maximum number of payments in the result
	 * @return sorted list of the most recent payments (The most recent payment at
	 *         first position)
	 */
	List<CashPayment> getRecentPaymentsSorted(int numberOfPayments);
}
