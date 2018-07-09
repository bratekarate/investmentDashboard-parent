package org.goetheuni.investmentdashboard.shared.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.api.ISecurityMarketData;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objects of this class represent security market data provided by the bank.
 * The concerning point of time must be specified. An object of this class may
 * not contain information about all securities in the market.
 * 
 */
public class SecurityMarketData implements ISecurityMarketData {

	/**
	 * Maps a security's ISIN to its prize.
	 */
	protected Map<String, BigDecimal> marketPrizes;

	/**
	 * Specifies the date and time of this market data
	 */
	protected Date dateAndTime;

	/**
	 * @return the marketPrizes
	 */
	@Override
	public Map<String, BigDecimal> getMarketPrizes() {
		return marketPrizes;
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
		result = prime * result + ((marketPrizes == null) ? 0 : marketPrizes.hashCode());
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
		SecurityMarketData other = (SecurityMarketData) obj;
		if (dateAndTime == null) {
			if (other.dateAndTime != null) {
				return false;
			}
		} else if (!dateAndTime.equals(other.dateAndTime)) {
			return false;
		}
		if (marketPrizes == null) {
			if (other.marketPrizes != null) {
				return false;
			}
		} else if (!marketPrizes.equals(other.marketPrizes)) {
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
		return "SecurityMarketData [marketPrizes=" + marketPrizes + ", dateAndTime=" + dateAndTime + "]";
	}

	/**
	 * Creates an object for security market data. All parameters must not be null.
	 * 
	 * @param marketPrizes
	 * @param dateAndTime
	 */
	@JsonCreator
	public SecurityMarketData(final @JsonProperty("marketPrizes") Map<String, BigDecimal> marketPrizes,
			final @JsonProperty("dateAndTime") Date dateAndTime) {
		this.marketPrizes = Objects.requireNonNull(marketPrizes,
				"The collection for the market prizes must not be null");
		this.dateAndTime = Objects.requireNonNull(dateAndTime, "The date of execution must not be null");
	}

	protected SecurityMarketData() {
		// required by GWT
	}
}
