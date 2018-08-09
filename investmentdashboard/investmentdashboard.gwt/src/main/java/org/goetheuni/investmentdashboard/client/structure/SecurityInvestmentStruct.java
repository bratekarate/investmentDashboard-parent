/**
 * 
 */
package org.goetheuni.investmentdashboard.client.structure;

import java.math.BigDecimal;

import org.goetheuni.investmentdashboard.client.global.SecurityMarketDataStorage;
import org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData;
import org.goetheuni.investmentdashboard.shared.impl.SecurityInvestment;
import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;

/**
 * Objects of this class represent substructures for security investments.
 *
 */
public class SecurityInvestmentStruct implements EURComputable {

	/**
	 * The corresponding data object of this structure.
	 */
	protected SecurityInvestment data;

	/**
	 * The latest value for the balance
	 */
	protected BigDecimal valueCache;

	/**
	 * The latest value for the difference of current value and reference value.
	 */
	protected BigDecimal deltaCache;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.client.structure.EURComputable#
	 * computeBalanceInEUR(org.goetheuni.investmentdashboard.shared.impl.
	 * SecurityMarketData,
	 * org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData)
	 */
	@Override
	public BigDecimal computeBalanceInEUR(SecurityMarketData secMarket, CryptoMarketData cryptoMarket) {
		// try to get the prize from the prize list
		BigDecimal prize = secMarket.getMarketPrizes().get(this.data.getSecurity().getIsin());

		if (prize != null) {
			// a prize for the ISIN is known -> this is fine
			// result = prize * quantity
			BigDecimal result = prize.multiply(BigDecimal.valueOf(this.data.getQuantity()));
			// put the result into the cache
			this.valueCache = result;
			// put the delta into to cache, delta = total value - total reference value
			this.deltaCache = result.subtract(this.getTotalInvestmentReferenceValue());
			// return the result
			return result;
		} else {
			throw new RuntimeException(
					"The prize for the following ISIN was unkown: " + this.data.getSecurity().getIsin()
							+ " , the prize list was: " + secMarket.getMarketPrizes().toString());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.client.structure.EURComputable#
	 * getCachedBalanceInEUR()
	 */
	@Override
	public BigDecimal getCachedBalanceInEUR() {
		return this.valueCache;
	}

	/**
	 * @return the deltaCache
	 */
	public BigDecimal getCachedDelta() {
		return this.deltaCache;
	}

	public String getISIN() {
		return this.data.getSecurity().getIsin();
	}

	public long getQuantity() {
		return this.data.getQuantity();
	}

	public BigDecimal getSingleSecurityQuotation() {
		String key = this.getISIN();
		BigDecimal result = SecurityMarketDataStorage.get().getMarketPrizes().get(key);
		if (result != null) {
			return result;
		} else {
			throw new RuntimeException("Could not find a quotation for the following key: " + key
					+ "/n The data object was: " + String.valueOf(this.data));
		}
	}

	public BigDecimal getTotalInvestmentEuroVolume() {
		return this.getSingleSecurityQuotation().multiply(BigDecimal.valueOf(this.getQuantity()));
	}

	public BigDecimal getSingleSecurityReferenceValue() {
		String key = this.getISIN();
		BigDecimal result = SecurityMarketDataStorage.get().getReferenceValues().get(key);
		if (result != null) {
			return result;
		} else {
			throw new RuntimeException("Could not find a reference value for the following key: " + key
					+ "/n The data object was: " + String.valueOf(this.data));
		}
	}

	public BigDecimal getTotalInvestmentReferenceValue() {
		return this.getSingleSecurityReferenceValue().multiply(BigDecimal.valueOf(this.getQuantity()));
	}

	public String getSecurityShortName() {
		return this.data.getSecurity().getShortName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SecurityInvestmentStruct [data=" + data + ", valueCache=" + valueCache + ", deltaCache=" + deltaCache
				+ "]";
	}

	/**
	 * Creates a structure object for the given SecurityInvestment.
	 * 
	 * @param data
	 *            The corresponding data object.
	 */
	protected SecurityInvestmentStruct(SecurityInvestment data) {
		this.valueCache = BigDecimal.ZERO;
		this.deltaCache = BigDecimal.ZERO;
		this.data = data;
	}

}
