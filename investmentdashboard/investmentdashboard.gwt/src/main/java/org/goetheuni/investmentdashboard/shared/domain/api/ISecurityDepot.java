package org.goetheuni.investmentdashboard.shared.domain.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.goetheuni.investmentdashboard.shared.domain.impl.Security;
import org.goetheuni.investmentdashboard.shared.domain.impl.SecurityTransaction;

/**
 * An object with this interface represents a security depot. As GWT is based on
 * source code mapping, these interface can only be used in the server-side
 * code.
 */
public interface ISecurityDepot {

	/**
	 * @return the portfolio
	 */
	public Map<? extends Security, Long> getPortfolio();

	/**
	 * @return the depotID
	 */
	public String getDepotID();

	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * @return the recentTransactions
	 */
	public List<? extends SecurityTransaction> getRecentTransactions();

	/**
	 * @return the referenceValue
	 */
	public BigDecimal getReferenceValue();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString();
}
