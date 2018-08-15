package org.goetheuni.investmentdashboard.shared.impl;

import java.util.List;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.api.ISecurityDepot;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object of this class represents a security depot.
 * 
 * JAVADOC DONE
 */
public class SecurityDepot implements ISecurityDepot {

	/**
	 * A list of security investments of the portfolio. There must be exactly one
	 * investment for every contained security.
	 */
	protected List<SecurityInvestment> portfolio;

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
	protected List<SecurityTransaction> recentTransactions;

	/**
	 * @return the portfolio
	 */
	@Override
	public List<SecurityInvestment> getPortfolio() {
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
	public List<SecurityTransaction> getRecentTransactions() {
		return recentTransactions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((depotID == null) ? 0 : depotID.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((portfolio == null) ? 0 : portfolio.hashCode());
		result = prime * result + ((recentTransactions == null) ? 0 : recentTransactions.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SecurityDepot other = (SecurityDepot) obj;
		if (depotID == null) {
			if (other.depotID != null) {
				return false;
			}
		} else if (!depotID.equals(other.depotID)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (portfolio == null) {
			if (other.portfolio != null) {
				return false;
			}
		} else if (!portfolio.equals(other.portfolio)) {
			return false;
		}
		if (recentTransactions == null) {
			if (other.recentTransactions != null) {
				return false;
			}
		} else if (!recentTransactions.equals(other.recentTransactions)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SecurityDepot [portfolio=" + portfolio + ", depotID=" + depotID + ", name=" + name
				+ ", recentTransactions=" + recentTransactions + "]";
	}

	/**
	 * Creates a security depot. All parameters must be non-null.
	 * 
	 * @param portfolio
	 *            A list of security investments of the portfolio. There must be
	 *            exactly one investment for every contained security.
	 * @param depotID
	 *            The depot's ID
	 * @param name
	 *            The depot's name
	 * @param recentTransactions
	 *            Some recent transactions
	 * 
	 */
	@JsonCreator
	public SecurityDepot(final @JsonProperty("portfolio") List<SecurityInvestment> portfolio,
			final @JsonProperty("depotID") String depotID, final @JsonProperty("name") String name,
			final @JsonProperty("recentTransactions") List<SecurityTransaction> recentTransactions) {
		this.portfolio = Objects.requireNonNull(portfolio, "The collection of securities must not be null");
		this.depotID = Objects.requireNonNull(depotID, "The depotID must not be null");
		this.name = Objects.requireNonNull(name, "The depot's name must not be null");
		this.recentTransactions = Objects.requireNonNull(recentTransactions,
				"The list of transactions must not be null");

	}

	/**
	 * NOT A PART OF THE API
	 */
	protected SecurityDepot() {
		// required by GWT
	}
}
