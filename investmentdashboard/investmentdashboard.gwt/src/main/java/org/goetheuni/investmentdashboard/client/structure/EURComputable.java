/**
 * 
 */
package org.goetheuni.investmentdashboard.client.structure;

import java.math.BigDecimal;

import org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData;
import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;

/**
 * Objects with this interface have balance, that can be computed in EUR.
 */
public interface EURComputable {

	/**
	 * Computes the balance in EUR for this cash account and updates the cached
	 * value
	 * 
	 * @return The balance in EUR.
	 */
	public BigDecimal computeBalanceInEUR(SecurityMarketData secMarket, CryptoMarketData cryptoMarket);

	/**
	 * 
	 * @return The latest computed value for the depot's or account's balance.
	 */
	public BigDecimal getCachedBalanceInEUR();
}
