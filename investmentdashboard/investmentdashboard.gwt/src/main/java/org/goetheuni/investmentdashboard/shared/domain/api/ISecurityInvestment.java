package org.goetheuni.investmentdashboard.shared.domain.api;

import org.goetheuni.investmentdashboard.shared.domain.impl.Security;

/**
 * An object with this interface represents an investment in one security. It
 * knows its number of instances of that security.
 */
public interface ISecurityInvestment {

	/**
	 * @return the security
	 */
	public Security getSecurity();

	/**
	 * @return the quantity
	 */
	public long getQuantity();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString();
}
