package org.goetheuni.investmentdashboard.shared.api;

import java.util.List;

import org.goetheuni.investmentdashboard.shared.impl.SecurityInvestment;
import org.goetheuni.investmentdashboard.shared.impl.SecurityTransaction;

/**
 * An object with this interface represents a security depot. As GWT is based on
 * source code mapping, these interface can only be used in the server-side
 * code.
 * 
 * JAVADOC DONE
 */
public interface ISecurityDepot {

	/**
	 * @return the portfolio
	 */
	public List<SecurityInvestment> getPortfolio();

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
	public List<SecurityTransaction> getRecentTransactions();

	/**
	 * Maps an object's values to a number in a deterministic way.
	 * 
	 * @return the number
	 */
	public int hashCode();

	/**
	 * Returns true if the objects values are equal to the given object. Otherwise
	 * false.
	 * 
	 * @param obj
	 *            The object for comparison.
	 * @return True if the object's values are equal otherwise false.
	 */
	public boolean equals(Object obj);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString();
}
