/**
 * 
 */
package org.goetheuni.investmentdashboard.client.ui;

import java.math.BigDecimal;
import java.util.List;

import org.goetheuni.investmentdashboard.client.structure.SecurityInvestmentStruct;
import org.goetheuni.investmentdashboard.shared.impl.SecurityTransaction;

/**
 * Extends the Selectable interface for security depots
 * 
 * JAVADOC DONE
 */
public interface SelectableSecurityDepot extends Selectable {

	/**
	 * @return the sum of reference values of all contained investments
	 */
	public BigDecimal getReferenceValue();

	/**
	 * @return the sum of market value of all contained investments
	 */
	public BigDecimal getAmount();

	/**
	 * @return all investments contained in the portfolio
	 */
	List<SecurityInvestmentStruct> getInvestments();

	/**
	 * @param numberOfTransactions
	 *            The maximum number of transaction in the result
	 * @return the sorted list of the most recent transaction (the most recent at
	 *         first position)
	 */
	List<SecurityTransaction> getRecentTransactionsSorted(int numberOfTransactions);

}
