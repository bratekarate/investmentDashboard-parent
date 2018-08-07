/**
 * 
 */
package org.goetheuni.investmentdashboard.client.ui;

import java.math.BigDecimal;
import java.util.List;

import org.goetheuni.investmentdashboard.client.structure.SecurityInvestmentStruct;
import org.goetheuni.investmentdashboard.shared.impl.SecurityTransaction;

/**
 *
 */
public interface SelectableSecurityDepot extends Selectable {

	public BigDecimal getReferenceValue();

	public BigDecimal getAmount();

	boolean isEmpty();

	List<SecurityInvestmentStruct> getInvestments();

	List<SecurityTransaction> getRecentTransactionsSorted(int numberOfTransactions);

}
