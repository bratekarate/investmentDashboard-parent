package org.goetheuni.investmentdashboard.shared.domain.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.domain.api.ICryptoMarketData;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objects of this class represent crypto-market data provided by the bank. The
 * concerning point of time must be specified. An object of this class may not
 * contain information about all crypto currencies in the market.
 * 
 */
public class CryptoMarketData implements ICryptoMarketData {

	/**
	 * Maps a crypto currency's identifier to its exchange rate to EUR.
	 */
	protected Map<String, BigDecimal> exchangeRates;

	/**
	 * Specifies the date and time of this market data
	 */
	protected Date dateAndTime;

	/**
	 * @return the exchangeRates
	 */
	@Override
	public Map<String, BigDecimal> getExchangeRates() {
		return exchangeRates;
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
		return "CryptoMarketData [exchangeRates=" + exchangeRates + ", dateAndTime=" + dateAndTime + "]";
	}

	/**
	 * Creates an object for crypto market data. All parameters must be initialized.
	 * 
	 * @param exchangeRates
	 * @param dateAndTime
	 */
	@JsonCreator
	public CryptoMarketData(final @JsonProperty("exchangeRates") Map<String, BigDecimal> exchangeRates,
			final @JsonProperty("dateAndTime") Date dateAndTime) {
		this.exchangeRates = Objects.requireNonNull(exchangeRates, "The exchange rates map must not be null");
		this.dateAndTime = Objects.requireNonNull(dateAndTime, "The execution date must not be null");
	}

	protected CryptoMarketData() {
		// required by GWT
	}

}
