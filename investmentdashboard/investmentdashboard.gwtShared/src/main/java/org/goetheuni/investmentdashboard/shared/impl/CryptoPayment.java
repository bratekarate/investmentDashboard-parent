package org.goetheuni.investmentdashboard.shared.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.api.ICryptoPayment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object of this class represents an executed payment in crypto currency.
 */
public class CryptoPayment implements ICryptoPayment {

	/**
	 * The payment's amount. It is negative if the customer paid. It is positive if
	 * the customer received crypto currency.
	 */
	protected BigDecimal amount;

	/**
	 * The code of the currency used for this payment.
	 */
	protected String currencyCode;

	/**
	 * The counter-party's wallet's address.
	 */
	protected String counterPartyAddress;

	/**
	 * The date and time of the execution.
	 */
	protected Date dateOfExecution;

	/**
	 * @return the amount
	 */
	@Override
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @return the currencyCode
	 */
	@Override
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @return the counterPartyAddress
	 */
	@Override
	public String getCounterPartyAddress() {
		return counterPartyAddress;
	}

	/**
	 * @return the dateOfExecution
	 */
	@Override
	public Date getDateOfExecution() {
		return dateOfExecution;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.goetheuni.investmentdashboard.shared.domain.api.ICryptoPayment#
	 * getFormattedAmount()
	 */
	@Override
	public String getFormattedAmount() {
		return "Sorry, not yet implemented";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((counterPartyAddress == null) ? 0 : counterPartyAddress.hashCode());
		result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((dateOfExecution == null) ? 0 : dateOfExecution.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		CryptoPayment other = (CryptoPayment) obj;
		if (amount == null) {
			if (other.amount != null) {
				return false;
			}
		} else if (!amount.equals(other.amount)) {
			return false;
		}
		if (counterPartyAddress == null) {
			if (other.counterPartyAddress != null) {
				return false;
			}
		} else if (!counterPartyAddress.equals(other.counterPartyAddress)) {
			return false;
		}
		if (currencyCode == null) {
			if (other.currencyCode != null) {
				return false;
			}
		} else if (!currencyCode.equals(other.currencyCode)) {
			return false;
		}
		if (dateOfExecution == null) {
			if (other.dateOfExecution != null) {
				return false;
			}
		} else if (!dateOfExecution.equals(other.dateOfExecution)) {
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
		return "CryptoPayment [amount=" + amount + ", currencyCode=" + currencyCode + ", counterPartyAddress="
				+ counterPartyAddress + ", dateOfExecution=" + dateOfExecution + "]";
	}

	/**
	 * Creates a crypto currency payment. All parameters must be initialized.
	 * 
	 * @param amount
	 * @param currencyCode
	 * @param counterPartyAddress
	 * @param dateOfExecution
	 */
	@JsonCreator
	public CryptoPayment(final @JsonProperty("amount") BigDecimal amount,
			final @JsonProperty("currencyCode") String currencyCode,
			final @JsonProperty("counterPartyAddress") String counterPartyAddress,
			final @JsonProperty("dateOfExecution") Date dateOfExecution) {
		this.amount = Objects.requireNonNull(amount, "Amount must not be null");
		this.currencyCode = Objects.requireNonNull(currencyCode, "The currency code must not be null");
		this.counterPartyAddress = Objects.requireNonNull(counterPartyAddress,
				"The counterparty's address must not be null");
		this.dateOfExecution = Objects.requireNonNull(dateOfExecution, "The date of execution must not be null");
	}

	protected CryptoPayment() {
		// required by GWT
	}
}
