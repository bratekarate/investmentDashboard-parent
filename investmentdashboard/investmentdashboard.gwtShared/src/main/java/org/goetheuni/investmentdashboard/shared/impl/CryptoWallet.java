package org.goetheuni.investmentdashboard.shared.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.api.ICryptoWallet;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object of this class represents an account for a crypto currency.
 */
public class CryptoWallet implements ICryptoWallet {

	/**
	 * A technical ID of the wallet.
	 */
	protected String accountID;

	/**
	 * The code of the crypto currency used for account.
	 */
	protected String currencyCode;

	/**
	 * The wallet's name.
	 */
	protected String name;

	/**
	 * The amount of crypto currency in this wallet. It is supposed to be
	 * non-negative.
	 */
	protected BigDecimal accountBalance;

	/**
	 * A list of recent payments affecting this payment.
	 */
	protected List<CryptoPayment> recentPayments;

	/**
	 * @return the accountID
	 */
	@Override
	public String getAccountID() {
		return accountID;
	}

	/**
	 * @return the currencyCode
	 */
	@Override
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @return the accountBalance
	 */
	@Override
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	/**
	 * @return the recentPayments
	 */
	@Override
	public List<CryptoPayment> getRecentPayments() {
		return recentPayments;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountBalance == null) ? 0 : accountBalance.hashCode());
		result = prime * result + ((accountID == null) ? 0 : accountID.hashCode());
		result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((recentPayments == null) ? 0 : recentPayments.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		CryptoWallet other = (CryptoWallet) obj;
		if (accountBalance == null) {
			if (other.accountBalance != null) {
				return false;
			}
		} else if (!accountBalance.equals(other.accountBalance)) {
			return false;
		}
		if (accountID == null) {
			if (other.accountID != null) {
				return false;
			}
		} else if (!accountID.equals(other.accountID)) {
			return false;
		}
		if (currencyCode == null) {
			if (other.currencyCode != null) {
				return false;
			}
		} else if (!currencyCode.equals(other.currencyCode)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (recentPayments == null) {
			if (other.recentPayments != null) {
				return false;
			}
		} else if (!recentPayments.equals(other.recentPayments)) {
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
		return "CryptoWallet [accountID=" + accountID + ", currencyCode=" + currencyCode + ", name=" + name
				+ ", accountBalance=" + accountBalance + ", recentPayments=" + recentPayments + "]";
	}

	/**
	 * Creates a crypto wallet object. All parameters must not be null.
	 * 
	 * @param accountID
	 * @param currencyCode
	 * @param name
	 * @param accountBalance
	 * @param recentPayments
	 */
	@JsonCreator
	public CryptoWallet(final @JsonProperty("accountID") String accountID,
			final @JsonProperty("currencyCode") String currencyCode, final @JsonProperty("name") String name,
			final @JsonProperty("accountBalance") BigDecimal accountBalance,
			final @JsonProperty("recentPayments") List<CryptoPayment> recentPayments) {
		this.accountID = Objects.requireNonNull(accountID, "Account ID must not be null");
		this.currencyCode = Objects.requireNonNull(currencyCode, "The currency code must not be null");
		this.name = Objects.requireNonNull(name, "The name must not be null");
		this.accountBalance = Objects.requireNonNull(accountBalance, "The account balance object must not be null");
		this.recentPayments = Objects.requireNonNull(recentPayments, "The list of recent payments must not be null");

		// validate payments
		for (CryptoPayment payment : this.recentPayments) {
			if (payment.getCurrencyCode().equals(this.getCurrencyCode())) {
				// payment's currency is equal to the wallet's currency
				// -> continue
			} else {
				// currency mismatch
				String msg = "Wallets's currency = " + this.getCurrencyCode()
						+ ", must be equal to payment's currency, payment = " + payment.toString();
				throw new IllegalArgumentException(msg);
			}
		}
	}

	protected CryptoWallet() {
		// required by GWT
	}
}
