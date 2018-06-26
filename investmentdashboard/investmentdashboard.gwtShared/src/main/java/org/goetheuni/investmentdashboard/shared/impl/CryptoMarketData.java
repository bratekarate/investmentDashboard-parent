package org.goetheuni.investmentdashboard.shared.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.api.ICryptoMarketData;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateAndTime == null) ? 0 : dateAndTime.hashCode());
		result = prime * result + ((exchangeRates == null) ? 0 : exchangeRates.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CryptoMarketData other = (CryptoMarketData) obj;
		if (dateAndTime == null) {
			if (other.dateAndTime != null) {
				return false;
			}
		} else if (!dateAndTime.equals(other.dateAndTime)) {
			return false;
		}
		if (exchangeRates == null) {
			if (other.exchangeRates != null) {
				return false;
			}
		} else if (!exchangeRates.equals(other.exchangeRates)) {
			return false;
		}
		return true;
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
