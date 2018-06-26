package org.goetheuni.investmentdashboard.shared.api;

import java.math.BigDecimal;
import java.util.Date;

import org.goetheuni.investmentdashboard.shared.impl.Security;



/**
 * An object with this interface represents an executed transaction of
 * securities. As GWT is based on source code mapping, these interface can only
 * be used in the server-side code.
 */
public interface ISecurityTransaction {

	/**
	 * @return the quantity
	 */
	public long getQuantity();

	/**
	 * @return the totalPrize
	 */
	public BigDecimal getTotalPrize();

	/**
	 * @return the security
	 */
	public Security getSecurity();

	/**
	 * @return the dateOfExecution
	 */
	public Date getDateOfExecution();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString();
}
