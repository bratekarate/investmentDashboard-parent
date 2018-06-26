package org.goetheuni.investmentdashboard.shared.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Objects with this interface represent crypto-market data provided by the
 * bank. The concerning point of time must be specified. It may not contain
 * information about all crypto currencies in the market. As GWT is based on
 * source code mapping, these interface can only be used in the server-side
 * code.
 */
public interface ICryptoMarketData {

	/**
	 * @return the exchangeRates
	 */
	public Map<String, BigDecimal> getExchangeRates();

	/**
	 * @return the dateAndTime
	 */
	public Date getDateAndTime();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString();
}
