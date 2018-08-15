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
