package org.goetheuni.investmentdashboard.shared.domain.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.domain.api.ISecurityDepot;

/**
 * An object of this class represents a security depot.
 */
public class SecurityDepot implements ISecurityDepot {

	/**
	 * A map that describes the portfolio. A security will be mapped to its quantity
	 * in the portfolio.
	 */
	protected Map<? extends Security, Long> portfolio;

	/**
	 * An ID for the depot.
	 */
	protected String depotID;

	/**
	 * The depot's name.
	 */
	protected String name;

	/**
	 * Recent transactions, that affect this portfolio.
	 */
	protected List<? extends SecurityTransaction> recentTransactions;

	/**
	 * The depot's base value provide by the bank. It is used for comparison with
	 * the current value.
	 */
	protected BigDecimal referenceValue;

	/**
	 * @return the portfolio
	 */
	@Override
	public Map<? extends Security, Long> getPortfolio() {
		return portfolio;
	}

	/**
	 * @return the depotID
	 */
	@Override
	public String getDepotID() {
		return depotID;
	}

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @return the recentTransactions
	 */
	@Override
	public List<? extends SecurityTransaction> getRecentTransactions() {
		return recentTransactions;
	}

	/**
	 * @return the referenceValue
	 */
	@Override
	public BigDecimal getReferenceValue() {
		return referenceValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SecurityDepot [portfolio=" + portfolio + ", depotID=" + depotID + ", name=" + name
				+ ", recentTransactions=" + recentTransactions + ", referenceValue=" + referenceValue + "]";
	}

	/**
	 * Creates a security depot. All parameters must not be null.
	 * 
	 * @param portfolio
	 * @param depotID
	 * @param name
	 * @param recentTransactions
	 * @param referenceValue
	 */
	public SecurityDepot(Map<? extends Security, Long> portfolio, String depotID, String name,
			List<? extends SecurityTransaction> recentTransactions, BigDecimal referenceValue) {
		this.portfolio = Objects.requireNonNull(portfolio, "The collection of securities must not be null");
		this.depotID = Objects.requireNonNull(depotID, "The depotID must not be null");
		this.name = Objects.requireNonNull(name, "The depot's name must not be null");
		this.recentTransactions = Objects.requireNonNull(recentTransactions,
				"The list of transactions must not be null");
		this.referenceValue = Objects.requireNonNull(referenceValue, "The reference value must not be null");
	}

	protected SecurityDepot() {
		// required by GWT
	}
}
