package org.goetheuni.investmentdashboard.shared.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.api.ICryptoMarketData;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objects of this class represent crypto-market data provided by the bank. It
 * also contains reference data for comparison. The concerning point of time
 * must be specified. It may not contain information about all crypto currencies
 * in the market, but only about those, that are relevant for the customer.
 * 
 * JAVADOC DONE
 */
public class CryptoMarketData implements ICryptoMarketData {

	/**
	 * Maps a crypto currency's identifier to its exchange rate to EUR.
	 */
	protected Map<String, BigDecimal> exchangeRates;

	/**
	 * Maps a crypto currency's identifier to its reference exchange rate to EUR.
	 */
	protected Map<String, BigDecimal> referenceValues;

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
	 * @return the referenceValues
	 */
	@Override
	public Map<String, BigDecimal> getReferenceValues() {
		return referenceValues;
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
		return "CryptoMarketData [exchangeRates=" + exchangeRates + ", referenceValues=" + referenceValues
				+ ", dateAndTime=" + dateAndTime + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateAndTime == null) ? 0 : dateAndTime.hashCode());
		result = prime * result + ((exchangeRates == null) ? 0 : exchangeRates.hashCode());
		result = prime * result + ((referenceValues == null) ? 0 : referenceValues.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		if (referenceValues == null) {
			if (other.referenceValues != null) {
				return false;
			}
		} else if (!referenceValues.equals(other.referenceValues)) {
			return false;
		}
		return true;
	}

	/**
	 * Creates a container for crypto market and reference data.
	 * 
	 * @param exchangeRates
	 *            the crypto market data
	 * @param referenceValues
	 *            the reference data for comparison
	 * @param dateAndTime
	 *            the concerning point of time
	 */
	@JsonCreator
	public CryptoMarketData(final @JsonProperty("exchangeRates") Map<String, BigDecimal> exchangeRates,
			final @JsonProperty("referenceValues") Map<String, BigDecimal> referenceValues,
			final @JsonProperty("dateAndTime") Date dateAndTime) {
		this.exchangeRates = Objects.requireNonNull(exchangeRates, "The exchange rates map must not be null");
		this.referenceValues = Objects.requireNonNull(referenceValues, "The reference values must not be nul");
		this.dateAndTime = Objects.requireNonNull(dateAndTime, "The execution date must not be null");
	}

	/**
	 * NOT A PART OF THE API
	 */
	protected CryptoMarketData() {
		// required by GWT
	}

}
