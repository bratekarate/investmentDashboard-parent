package org.goetheuni.investmentdashboard.shared.api;

import java.math.BigDecimal;
import java.util.List;

import org.goetheuni.investmentdashboard.shared.impl.CashPayment;



/**
 * An object with this interface represents a cash account. As GWT is based on
 * source code mapping, these interface can only be used in the server-side
 * code.
 */
public interface ICashAccount {
	/**
	 * @return the accountID
	 */
	public String getAccountID();

	/**
	 * @return the iban
	 */
	public String getIban();

	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * @return the recentPayments
	 */
	public List<CashPayment> getRecentPayments();

	/**
	 * @return the accountBalance
	 */
	public BigDecimal getAccountBalance();

	/**
	 * @return the currency code
	 */
	public String getCurrency();

	/**
	 * This method creates a formatted String for the UI. It must get the account
	 * balance, format the number in the desired way, then get the currency code and
	 * generate the String with the correct currency symbol. The static method
	 * getCurrencyFormat(String currencyCode) of
	 * com.google.gwt.i18n.client.NumberFormat should be used.
	 * 
	 * @return a formatted String that represents the account balance.
	 */
	public String getFormattedAmount();
	
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
