package org.goetheuni.investmentdashboard.shared.domain.api;

import java.math.BigDecimal;
import java.util.List;

import org.goetheuni.investmentdashboard.shared.domain.impl.CryptoPayment;

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
	 * This method creates a formatted String for the UI. It must get the account
	 * balance, format the number in the desired way, then get the currency code and
	 * generate the String with the correct currency symbol.
	 * 
	 * @return a formatted String that represents the account balance.
	 */
	public String getFormattedAmount();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString();

}
