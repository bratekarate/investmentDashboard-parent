package org.goetheuni.investmentdashboard.client.structure;

import java.math.BigDecimal;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData;
import org.goetheuni.investmentdashboard.shared.impl.CryptoWallet;
import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;

/**
 * Objects of this class represent crypto wallets in the logical structure of the dash board page. 
 */
public class CryptoWalletStruct implements EURComputable{
	
	/**
	 * The data of this crypto wallet.
	 */
	protected CryptoWallet data;
	
	/* (non-Javadoc)
	 * @see org.goetheuni.investmentdashboard.client.structure.EURComputable#computeBalanceInEUR(org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData, org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData)
	 */
	@Override
	public BigDecimal computeBalanceInEUR(SecurityMarketData secMarket, CryptoMarketData cryptoMarket) {
		// validate input
		Objects.requireNonNull(cryptoMarket, "Cannot compute the balance because the given crypto market data was null");
		
		// get the account balance in the crypto currency and compute the EUR value.
		String currencyCode = this.data.getCurrencyCode();
		if(cryptoMarket.getExchangeRates().containsKey(currencyCode)) {
			// the exchange rate <crypto> -> EUR is known
			BigDecimal result = this.data.getAccountBalance().multiply(cryptoMarket.getExchangeRates().get(currencyCode));
			return result;
		}else {
			// the exchange rate for this crypto currency is unknown.
			throw new RuntimeException("The exchange rate for this crypto currency was required but is unknown: "+currencyCode+", the list of exchange rates was: "+cryptoMarket.getExchangeRates().toString());
		}
	}

	protected CryptoWalletStruct(CryptoWallet data) {
		this.data = Objects.requireNonNull(data, "The given CryptoWallet data object must not be null.");
	}
	
}
