package org.goetheuni.investmentdashboard.shared.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.api.ICashPayment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object of this class represents an executed payment in cash. It is
 * generated for a customer and therefore contains only the counter-party IBAN.
 */
public class CashPayment implements ICashPayment {

	/**
	 * The payment's amount. It is negative if the customer sent cash. It is
	 * positive if the customer received cash.
	 */
	protected BigDecimal amount;

	/**
	 * The code of the currency used for this payment.
	 */
	protected String currencyCode;

	/**
	 * The counter-party's IBAN.
	 */
	protected String counterPartyIBAN;

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
	 * @return the currency code
	 */
	@Override
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @return the counterPartyIBAN
	 */
	@Override
	public String getCounterPartyIBAN() {
		return counterPartyIBAN;
	}

	/**
	 * @return the dateOfExecution
	 */
	@Override
	public Date getDateOfExecution() {
		return dateOfExecution;
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((counterPartyIBAN == null) ? 0 : counterPartyIBAN.hashCode());
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
		CashPayment other = (CashPayment) obj;
		if (amount == null) {
			if (other.amount != null) {
				return false;
			}
		} else if (!amount.equals(other.amount)) {
			return false;
		}
		if (counterPartyIBAN == null) {
			if (other.counterPartyIBAN != null) {
				return false;
			}
		} else if (!counterPartyIBAN.equals(other.counterPartyIBAN)) {
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
		return "CashPayment [amount=" + amount + ", currency=" + currencyCode + ", counterPartyIBAN=" + counterPartyIBAN
				+ ", dateOfExecution=" + dateOfExecution + "]";
	}

	/**
	 * Creates a cash payment object. All parameters must not be null.
	 * 
	 * @param amount
	 * @param currency
	 * @param counterPartyIBAN
	 * @param dateOfExecution
	 */
	@JsonCreator
	public CashPayment(final @JsonProperty("amount") BigDecimal amount,
			final @JsonProperty("currencyCode") String currencyCode,
			final @JsonProperty("counterPartyIBAN") String counterPartyIBAN,
			final @JsonProperty("dateOfExecution") Date dateOfExecution) {
		this.amount = Objects.requireNonNull(amount, "Amount must not be null");
		this.currencyCode = Objects.requireNonNull(currencyCode, "Currency must not be null");
		this.counterPartyIBAN = Objects.requireNonNull(counterPartyIBAN, "The counterparty's IBAN must not be null");
		this.dateOfExecution = Objects.requireNonNull(dateOfExecution, "The date of execution must not be null");
	}

	protected CashPayment() {
		// required by GWT
	}
}
