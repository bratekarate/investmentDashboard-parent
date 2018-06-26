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
	 * This method creates a formatted String for the UI. It must get the amount,
	 * format the number in the desired way, then get the currency code and generate
	 * the String with the correct currency symbol.
	 * 
	 * @return a formatted String that represents the amount.
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
