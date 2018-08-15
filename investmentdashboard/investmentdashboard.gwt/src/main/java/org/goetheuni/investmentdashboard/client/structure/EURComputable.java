/**
 * 
 */
package org.goetheuni.investmentdashboard.client.structure;

import java.math.BigDecimal;

import org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData;
import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;

/**
 * Objects with this interface have a balance, that can be computed in EUR.
 * 
 * JAVADOC DONE
 */
public interface EURComputable {

	/**
	 * Computes the balance in EUR for this substructure and updates the cache for
	 * the total balance. For SecurityInvestmentStructs it also updates to delta
	 * cache.
	 * 
	 * @return The balance in EUR.
	 */
	public BigDecimal computeBalanceInEUR(SecurityMarketData secMarket, CryptoMarketData cryptoMarket);

	/**
	 * Accesses the cache for the total balance and returns the stored value.
	 * 
	 * @return The latest computed value for the depot's, wallet's or account's
	 *         balance.
	 */
	public BigDecimal getCachedBalanceInEUR();
}
