
package org.goetheuni.investmentdashboard.shared.impl;

import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.api.ISecurityInvestment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an investment in one security.
 */
public class SecurityInvestment implements ISecurityInvestment {

	/**
	 * The security used for this investment.
	 */
	protected Security security;

	/**
	 * The number of instances of the security in this investment.
	 */
	protected long quantity;

	/**
	 * @return the security
	 */
	@Override
	public Security getSecurity() {
		return security;
	}

	/**
	 * @return the quantity
	 */
	@Override
	public long getQuantity() {
		return quantity;
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
		result = prime * result + (int) (quantity ^ (quantity >>> 32));
		result = prime * result + ((security == null) ? 0 : security.hashCode());
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
		SecurityInvestment other = (SecurityInvestment) obj;
		if (quantity != other.quantity) {
			return false;
		}
		if (security == null) {
			if (other.security != null) {
				return false;
			}
		} else if (!security.equals(other.security)) {
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
		return "SecurityInvestment [security=" + security + ", quantity=" + quantity + "]";
	}

	/**
	 * Creates an investment for the given security
	 * 
	 * @param security
	 * @param quantity
	 */
	@JsonCreator
	public SecurityInvestment(final @JsonProperty("security") Security security,
			final @JsonProperty("quantity") long quantity) {
		this.security = Objects.requireNonNull(security, "The given security must not be null");
		this.quantity = quantity;
	}

	protected SecurityInvestment() {
		// required by GWT
	}
}
