/**
 * 
 */
package org.goetheuni.investmentdashboard.client.structure;

import java.math.BigDecimal;

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
	protected BigDecimal cachedValue;

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
			// put the result into the cache and return the result
			this.cachedValue = result;
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
		return this.cachedValue;
	}

	/**
	 * Creates a structure object for the given SecurityInvestment.
	 * 
	 * @param data
	 *            The corresponding data object.
	 */
	protected SecurityInvestmentStruct(SecurityInvestment data) {
		this.cachedValue = BigDecimal.ZERO;
		this.data = data;
	}

}
