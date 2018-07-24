package org.goetheuni.investmentdashboard.client.structure;

public interface Formattable {

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
}
