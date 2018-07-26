package org.goetheuni.investmentdashboard.client.structure;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import org.goetheuni.investmentdashboard.client.global.CryptoMarketDataStorage;
import org.goetheuni.investmentdashboard.client.global.SecurityMarketDataStorage;
import org.goetheuni.investmentdashboard.client.ui.SelectableCashAccount;
import org.goetheuni.investmentdashboard.shared.impl.CashAccount;
import org.goetheuni.investmentdashboard.shared.impl.CashPayment;
import org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData;
import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.datepicker.client.CalendarUtil;

/**
 * Objects of this class represent cash account substructures.
 */
public class CashAccountStruct implements EURComputable, SelectableCashAccount {

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.client.structure.EURComputable#
	 * getCachedBalanceInEUR()
	 */
	@Override
	public BigDecimal getCachedBalanceInEUR() {
		return this.data.getAccountBalance();
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
		return this.data.getIban();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.client.ui.Selectable#
	 * getFormattedAmountInEUR()
	 */
	@Override
	public String getFormattedAmountInEUR() {
		double result = this.getCachedBalanceInEUR().doubleValue();
		return NumberFormat.getCurrencyFormat("EUR").format(result);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.client.ui.SelectableCashAccount#
	 * getRecentPaymentsSorted(int)
	 */
	@Override
	public List<CashPayment> getRecentPaymentsSorted(int numberOfPayments) {
		List<CashPayment> payments = this.data.getRecentPayments();
		payments.sort(new Comparator<CashPayment>() {

			@Override
			public int compare(CashPayment a, CashPayment b) {
				long difference = Long.valueOf(b.getDateOfExecution().getTime() - a.getDateOfExecution().getTime());
				return Long.signum(difference);
			}
		});

		// get the most recent payments
		List<CashPayment> result = new ArrayList<>();

		for (int i = 0; i < numberOfPayments && i < payments.size(); i++) {
			result.add(payments.get(i));
		}

		return result;
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

	/**
	 * Creates a new structure element representing a cash account.
	 */
	protected CashAccountStruct(CashAccount data) {
		this.data = Objects.requireNonNull(data, "The cash account data object given must not be null.");
	}
}
