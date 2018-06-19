package org.goetheuni.investmentdashboard.shared.domain.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.domain.api.ISecurityTransaction;

/**
 * An object of this class represents an executed transaction of securities.
 */
public class SecurityTransaction implements ISecurityTransaction {

	/**
	 * The quantity that has been traded. Positive for a buy transaction and
	 * negative for a sell transaction.
	 */
	protected long quantity;

	/**
	 * The total prize of the securities. It is assumed to be non-negative.
	 */
	protected BigDecimal totalPrize;

	/**
	 * The security that has been traded.
	 */
	protected Security security;

	/**
	 * The date and time of the execution.
	 */
	protected Date dateOfExecution;

	/**
	 * @return the quantity
	 */
	@Override
	public long getQuantity() {
		return quantity;
	}

	/**
	 * @return the totalPrize
	 */
	@Override
	public BigDecimal getTotalPrize() {
		return totalPrize;
	}

	/**
	 * @return the security
	 */
	@Override
	public Security getSecurity() {
		return security;
	}

	/**
	 * @return the dateOfExecution
	 */
	@Override
	public Date getDateOfExecution() {
		return dateOfExecution;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SecurityTransaction [quantity=" + quantity + ", totalPrize=" + totalPrize + ", security=" + security
				+ ", dateOfExecution=" + dateOfExecution + "]";
	}

	/**
	 * Creates a transaction of securities. All parameters must not be null.
	 * 
	 * @param quantity
	 * @param totalPrize
	 * @param security
	 * @param dateOfExecution
	 */
	public SecurityTransaction(long quantity, BigDecimal totalPrize, Security security, Date dateOfExecution) {
		this.quantity = quantity;
		this.totalPrize = Objects.requireNonNull(totalPrize, "The object for the total prize must not be null");

		// the price is assumed to be non negative
		if (totalPrize.signum() < 0) {
			throw new IllegalArgumentException(
					"The total prize of a security transaction must not be negative. It is: "
							+ totalPrize.doubleValue());
		}

		this.security = Objects.requireNonNull(security, "The given security must not be null");
		this.dateOfExecution = Objects.requireNonNull(dateOfExecution, "The date must not be null");
	}

	protected SecurityTransaction() {
		// required by GWT
	}
}
