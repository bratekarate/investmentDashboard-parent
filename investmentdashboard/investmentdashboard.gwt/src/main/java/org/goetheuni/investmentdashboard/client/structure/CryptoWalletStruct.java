package org.goetheuni.investmentdashboard.client.structure;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import org.goetheuni.investmentdashboard.client.global.CryptoMarketDataStorage;
import org.goetheuni.investmentdashboard.client.global.SecurityMarketDataStorage;
import org.goetheuni.investmentdashboard.client.ui.SelectableCryptoWallet;
import org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData;
import org.goetheuni.investmentdashboard.shared.impl.CryptoPayment;
import org.goetheuni.investmentdashboard.shared.impl.CryptoWallet;
import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;

import com.google.gwt.i18n.client.NumberFormat;

/**
 * Objects of this class represent crypto wallets in the logical structure of
 * the dash board front-end. Structure objects are a logical representation of
 * the the dashboard's UI's content.
 * 
 * JAVADOC DONE
 */
public class CryptoWalletStruct implements EURComputable, SelectableCryptoWallet {

	/**
	 * The data of this crypto wallet.
	 */
	protected CryptoWallet data;

	/**
	 * The latest value for the balance.
	 */
	protected BigDecimal cachedBalance;

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
		// validate input
		Objects.requireNonNull(cryptoMarket,
				"Cannot compute the balance because the given crypto market data was null");

		// get the account balance in the crypto currency and compute the EUR value.
		String currencyCode = this.data.getCurrencyCode();
		if (cryptoMarket.getExchangeRates().containsKey(currencyCode)) {
			// the exchange rate <crypto> -> EUR is known
			BigDecimal result = this.data.getAccountBalance()
					.multiply(cryptoMarket.getExchangeRates().get(currencyCode));
			// put the result in the cache and return it
			this.cachedBalance = result;
			return result;
		} else {
			// the exchange rate for this crypto currency is unknown.
			throw new RuntimeException("The exchange rate for this crypto currency was required but is unknown: "
					+ currencyCode + ", the list of exchange rates was: " + cryptoMarket.getExchangeRates().toString());
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
		return this.cachedBalance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.client.ui.Selectable#getName()
	 */
	@Override
	public String getName() {
		return this.data.getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.client.ui.Selectable#getID()
	 */
	@Override
	public String getID() {
		return this.data.getAccountID();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.client.ui.Selectable#
	 * getFormattedAmountInEUR()
	 */
	@Override
	public String getFormattedAmountInEUR() {
		BigDecimal rounded = this.cachedBalance.setScale(2, RoundingMode.DOWN);
		return NumberFormat.getCurrencyFormat("EUR").format(rounded);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.client.ui.SelectableCryptoWallet#
	 * getFormattedExchangeRate()
	 */
	@Override
	public String getFormattedExchangeRate() {
		BigDecimal ex = this.getExchangeRate();
		return this.data.getCurrencyCode() + "-Kurs: " + NumberFormat.getCurrencyFormat("EUR").format(ex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.goetheuni.investmentdashboard.client.ui.Selectable#refreshComputations()
	 */
	@Override
	public void refreshComputations() {
		this.computeBalanceInEUR(SecurityMarketDataStorage.get(), CryptoMarketDataStorage.get());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.client.ui.SelectableCryptoWallet#
	 * getFormattedAmountInX()
	 */
	@Override
	public String getFormattedAmountInX() {
		return this.data.getCurrencyCode() + this.data.getAccountBalance().toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.client.ui.SelectableCryptoWallet#
	 * getReferenceValue()
	 */
	@Override
	public BigDecimal getReferenceValue() {
		String key = this.data.getCurrencyCode();
		BigDecimal result = CryptoMarketDataStorage.get().getReferenceValues().get(key);
		if (result != null) {
			return result;
		} else {
			throw new RuntimeException("Could not find a reference value for the following key: " + key
					+ "/n The data object was: " + String.valueOf(this.data));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.client.ui.SelectableCryptoWallet#
	 * getExchangeRate()
	 */
	@Override
	public BigDecimal getExchangeRate() {
		String key = this.data.getCurrencyCode();
		BigDecimal result = CryptoMarketDataStorage.get().getExchangeRates().get(key);
		if (result != null) {
			return result;
		} else {
			throw new RuntimeException("Could not find an exchange rate for the following key: " + key
					+ "/n The data object was: " + String.valueOf(this.data));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.client.ui.SelectableCryptoWallet#
	 * getRecentPaymentsSorted(int)
	 */
	@Override
	public List<CryptoPayment> getRecentPaymentsSorted(int numberOfPayments) {
		List<CryptoPayment> payments = this.data.getRecentPayments();

		payments.sort(new Comparator<CryptoPayment>() {

			@Override
			public int compare(CryptoPayment a, CryptoPayment b) {
				long difference = Long.valueOf(b.getDateOfExecution().getTime() - a.getDateOfExecution().getTime());
				return Long.signum(difference);
			}
		});

		// get at most the given number of payments

		List<CryptoPayment> result = new ArrayList<>();
		for (int i = 0; i < numberOfPayments && i < payments.size(); i++) {
			result.add(payments.get(i));
		}

		return result;
	}

	/**
	 * Creates a sub-structure for the given crypto wallet.
	 * 
	 * @param data
	 *            the given crypto wallet
	 */
	protected CryptoWalletStruct(CryptoWallet data) {
		this.cachedBalance = BigDecimal.ZERO;
		this.data = Objects.requireNonNull(data, "The given CryptoWallet data object must not be null.");
	}

}
