package org.goetheuni.investmentdashboard.shared.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.api.ICashAccount;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object of this class represents a cash account.
 *
 * JAVADOC DONE
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
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountBalance == null) ? 0 : accountBalance.hashCode());
		result = prime * result + ((accountID == null) ? 0 : accountID.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((iban == null) ? 0 : iban.hashCode());
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
		CashAccount other = (CashAccount) obj;
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
		if (currency == null) {
			if (other.currency != null) {
				return false;
			}
		} else if (!currency.equals(other.currency)) {
			return false;
		}
		if (iban == null) {
			if (other.iban != null) {
				return false;
			}
		} else if (!iban.equals(other.iban)) {
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
		return "CashAccount [accountID=" + accountID + ", iban=" + iban + ", name=" + name + ", recentPayments="
				+ recentPayments + ", accountBalance=" + accountBalance + ", currency=" + currency + "]";
	}

	/**
	 * Creates a cash account object. All parameters must not be null.
	 * 
	 * @param accountID
	 *            The account's ID
	 * @param iban
	 *            The accounts's IBAN (displayed in the UI)
	 * @param name
	 *            THE account's name (displayed in the UI)
	 * @param recentPayments
	 *            a list of recent payments (partially displayed in the UI)
	 * @param accountBalance
	 *            the accounts balance in EUR
	 * @param currency
	 *            The currency code of the account's currency. Only EUR is allowed
	 *            so far.
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

		// only EUR accounts fully supported at this point
		if ("EUR".equals(currency)) {
			// this is fine
		} else {
			throw new RuntimeException(
					"Only EUR accounts are full supported at this point. Currency code was: " + currency);
		}

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

	/**
	 * NOT A PART OF THE API
	 */
	protected CashAccount() {
		// required by GWT
	}

}
