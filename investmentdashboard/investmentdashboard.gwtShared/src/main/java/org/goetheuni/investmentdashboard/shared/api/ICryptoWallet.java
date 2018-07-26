package org.goetheuni.investmentdashboard.shared.api;

import java.math.BigDecimal;
import java.util.List;

import org.goetheuni.investmentdashboard.shared.impl.CryptoPayment;



/**
 * An object with this interface represents an account for a crypto currency. As
 * GWT is based on source code mapping, these interface can only be used in the
 * server-side code.
 */
public interface ICryptoWallet {

	/**
	 * @return the accountID
	 */
	public String getAccountID();

	/**
	 * @return the currencyCode
	 */
	public String getCurrencyCode();

	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * @return the accountBalance
	 */
	public BigDecimal getAccountBalance();

	/**
	 * @return the recentPayments
	 */
	public List<CryptoPayment> getRecentPayments();

	
	/**
	 * Maps an object's values to a number in a deterministic way.
	 * 
	 * @return the number 
	 */
	public int hashCode();


	/**
	 * Returns true if the objects values are equal to the given object.
	 * Otherwise false.
	 * @param obj The object for comparison.
	 * @return	True if the object's values are equal otherwise false.
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
