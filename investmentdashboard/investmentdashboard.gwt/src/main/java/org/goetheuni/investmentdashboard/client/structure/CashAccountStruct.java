package org.goetheuni.investmentdashboard.client.structure;

import java.math.BigDecimal;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.impl.CashAccount;
import org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData;
import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;

/**
 * Objects of this class represent cash account substructures.
 */
public class CashAccountStruct implements EURComputable {

	/**
	 * The data of this cash account.
	 */
	protected CashAccount data;
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.client.structure.EURComputable#
	 * computeBalanceInEUR()
	 */
	@Override
	public BigDecimal computeBalanceInEUR(SecurityMarketData secMarket, CryptoMarketData cryptoMarket) {
		if (this.data.getCurrency().equals("EUR")) {
			// this is fine
			return this.data.getAccountBalance();
		} else {
			// other currencies than EUR are not supported at the moment
			throw new RuntimeException(
					"Other currencies than EUR are not supported at the moment, was: " + this.data.getCurrency());
		}
	}

	/* (non-Javadoc)
	 * @see org.goetheuni.investmentdashboard.client.structure.EURComputable#getCachedBalanceInEUR()
	 */
	@Override
	public BigDecimal getCachedBalanceInEUR() {
		return this.data.getAccountBalance();
	}

	/**
	 * Creates a new structure element representing a cash account.
	 */
	protected CashAccountStruct(CashAccount data) {
		this.data = Objects.requireNonNull(data, "The cash account data object given must not be null.");
	}
}
