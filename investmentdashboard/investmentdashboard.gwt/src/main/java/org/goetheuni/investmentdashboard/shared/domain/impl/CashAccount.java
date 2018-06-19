package org.goetheuni.investmentdashboard.shared.domain.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.domain.api.ICashAccount;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object of this class represents a cash account.
 *
 */
public class CashAccount implements ICashAccount {

	/**
	 * A technical ID of the cash account.
	 */
	protected String accountID;

	/**
	 * The account's IBAN
	 */
	protected String iban;

	/**
	 * The account's name
	 */
	protected String name;

	/**
	 * A list of recent payments affecting this account.
	 */
	protected List<CashPayment> recentPayments;

	/**
	 * The account's balance.
	 */
	protected BigDecimal accountBalance;

	/**
	 * The currency code of the money in this account.
	 */
	protected String currency;

	/**
	 * @return the accountID
	 */
	@Override
	public String getAccountID() {
		return accountID;
	}

	/**
	 * @return the iban
	 */
	@Override
	public String getIban() {
		return iban;
	}

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @return the recentPayments
	 */
	@Override
	public List<CashPayment> getRecentPayments() {
		return recentPayments;
	}

	/**
	 * @return the accountBalance
	 */
	@Override
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	/**
	 * @return the currency
	 */
	@Override
	public String getCurrency() {
		return currency;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.shared.domain.api.ICashAccount#
	 * getFormattedAmount()
	 */
	@Override
	public String getFormattedAmount() {
		return "Sorry, not yet implemented";
		// TODO
		// NumberFormat.getCurrencyFormat("insert currency code here");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CashAccount [accountID=" + accountID + ", iban=" + iban + ", name=" + name + ", recentPayments="
				+ recentPayments + ", accountBalance=" + accountBalance + ", currency=" + currency + "]";
	}

	/**
	 * Creates a cash account object. All parameters must not be null.
	 * 
	 * @param accountID
	 * @param iban
	 * @param name
	 * @param recentPayments
	 * @param accountBalance
	 * @param currency
	 */
	@JsonCreator
	public CashAccount(final @JsonProperty("accountID") String accountID, final @JsonProperty("iban") String iban,
			final @JsonProperty("name") String name,
			final @JsonProperty("recentPayments") List<CashPayment> recentPayments,
			final @JsonProperty("accountBalance") BigDecimal accountBalance,
			final @JsonProperty("currency") String currency) {
		this.accountID = Objects.requireNonNull(accountID, "The account ID must not be null");
		this.iban = Objects.requireNonNull(iban, "The IBAN must not be null");
		this.name = Objects.requireNonNull(name, "The account's name must not be null");
		this.recentPayments = Objects.requireNonNull(recentPayments, "The list of recent payments must not be null");
		this.accountBalance = Objects.requireNonNull(accountBalance, "The account balance must not be null");
		this.currency = Objects.requireNonNull(currency, "The currency used must not be null");

		// validate payments
		for (CashPayment payment : this.recentPayments) {
			if (payment.getCurrencyCode().equals(this.getCurrency())) {
				// payment's currency is equal to the account's currency
				// -> continue
			} else {
				// currency mismatch
				String msg = "Account's currency = " + this.getCurrency()
						+ ", must be equal to payment's currency, payment = " + payment.toString();
				throw new IllegalArgumentException(msg);
			}
		}
	}

	protected CashAccount() {
		// required by GWT
	}

}
