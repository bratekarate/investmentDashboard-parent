package org.goetheuni.investmentdashboard.shared.api;

import java.math.BigDecimal;
import java.util.Date;

/**
 * An object with this interface represents an executed payment in crypto
 * currency. As GWT is based on source code mapping, these interface can only be
 * used in the server-side code.
 */
public interface ICryptoPayment {

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount();

	/**
	 * @return the currencyCode
	 */
	public String getCurrencyCode();

	/**
	 * @return the counterPartyAddress
	 */
	public String getCounterPartyAddress();

	/**
	 * @return the dateOfExecution
	 */
	public Date getDateOfExecution();

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
