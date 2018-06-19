package org.goetheuni.investmentdashboard.shared.domain.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.domain.api.ISecurityMarketData;

/**
 * Objects of this class represent security market data provided by the bank.
 * The concerning point of time must be specified. An object of this class may
 * not contain information about all securities in the market.
 * 
 */
public class SecurityMarketData implements ISecurityMarketData{

	/**
	 * Maps a security's ISIN to its prize.
	 */
	protected Map<String, ? extends BigDecimal> marketPrizes;

	/**
	 * Specifies the date and time of this market data
	 */
	protected Date dateAndTime;

	/**
	 * @return the marketPrizes
	 */
	@Override
	public Map<String, ? extends BigDecimal> getMarketPrizes() {
		return marketPrizes;
	}

	/**
	 * @return the dateAndTime
	 */
	@Override
	public Date getDateAndTime() {
		return dateAndTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SecurityMarketData [marketPrizes=" + marketPrizes + ", dateAndTime=" + dateAndTime + "]";
	}

	/**
	 * Creates an object for security market data. All parameters must not be null.
	 * 
	 * @param marketPrizes
	 * @param dateAndTime
	 */
	public SecurityMarketData(Map<String, ? extends BigDecimal> marketPrizes, Date dateAndTime) {
		this.marketPrizes = Objects.requireNonNull(marketPrizes,
				"The collection for the market prizes must not be null");
		this.dateAndTime = Objects.requireNonNull(dateAndTime, "The date of execution must not be null");
	}

	protected SecurityMarketData() {
		// required by GWT
	}
}
