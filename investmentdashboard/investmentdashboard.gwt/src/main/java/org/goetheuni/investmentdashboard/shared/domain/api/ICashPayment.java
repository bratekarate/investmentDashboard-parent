package org.goetheuni.investmentdashboard.shared.domain.api;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

/**
 * An object with this interface represents an executed payment in cash. It is
 * generated for a customer and therefore contains only the counter-party IBAN.
 * As GWT is based on source code mapping, these interface can only be used in
 * the server-side code.
 */
public interface ICashPayment {

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount();

	/**
	 * @return the currency code
	 */
	public String getCurrency();

	/**
	 * @return the counterPartyIBAN
	 */
	public String getCounterPartyIBAN();

	/**
	 * @return the dateOfExecution
	 */
	public Date getDateOfExecution();
	
	/**
	 * This method creates a formatted String for the UI.
	 * It must get the amount, format the number in the desired way, then get the currency code and generate the String with the correct currency symbol.
	 * The static method getCurrencyFormat(String currencyCode) of com.google.gwt.i18n.client.NumberFormat should be used.
	 * @return a formatted String that represents the amount of the payment.
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
