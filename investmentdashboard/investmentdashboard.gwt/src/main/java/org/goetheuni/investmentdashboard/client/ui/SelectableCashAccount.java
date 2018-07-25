/**
 * 
 */
package org.goetheuni.investmentdashboard.client.ui;

import java.util.List;

import org.goetheuni.investmentdashboard.shared.impl.CashPayment;

/**
 * Objects with this interface can be connected to a SelectButtonCashAccount.
 * Please notice the super-interface.
 */
public interface SelectableCashAccount extends Selectable {

	List<CashPayment> getRecentPaymentsSorted(int numberOfPayments);
}
