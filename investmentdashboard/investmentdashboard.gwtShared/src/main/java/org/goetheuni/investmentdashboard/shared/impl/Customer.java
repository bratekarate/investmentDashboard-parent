package org.goetheuni.investmentdashboard.shared.impl;

import java.util.List;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.api.ICustomer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objects of this class represent the bank's customers
 *
 */
public class Customer implements ICustomer {

	/**
	 * A string that will be used to address the customer. It should be chosen
	 * appropriately.
	 */
	protected String nameForAdress;

	/**
	 * A technical ID that should identify the customer. It is assumed to be
	 * identical with the customer number.
	 */
	protected String customerID;

	/**
	 * The customer's cash accounts
	 */
	protected List<CashAccount> cashAccounts;

	/**
	 * The customer's crypto wallets
	 */
	protected List<CryptoWallet> cryptoWallets;

	/**
	 * The customer's security depots
	 */
	protected List<SecurityDepot> securityDepots;

	/**
	 * @return the nameForAdress
	 */
	@Override
	public String getNameForAdress() {
		return nameForAdress;
	}

	/**
	 * @return the customerID
	 */
	@Override
	public String getCustomerID() {
		return customerID;
	}

	/**
	 * @return the cashAccounts
	 */
	@Override
	public List<CashAccount> getCashAccounts() {
		return cashAccounts;
	}

	/**
	 * @return the cryptoWallets
	 */
	@Override
	public List<CryptoWallet> getCryptoWallets() {
		return cryptoWallets;
	}

	/**
	 * @return the securityDepots
	 */
	@Override
	public List<SecurityDepot> getSecurityDepots() {
		return securityDepots;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [nameForAdress=" + nameForAdress + ", customerID=" + customerID + ", cashAccounts="
				+ cashAccounts + ", cryptoWallets=" + cryptoWallets + ", securityDepots=" + securityDepots + "]";
	}

	/**
	 * Creates a customer object. All parameters must not be null.
	 * 
	 * @param nameForAdress
	 * @param customerID
	 * @param cashAccounts
	 * @param cryptoWallets
	 * @param securityDepots
	 */
	@JsonCreator
	public Customer(final @JsonProperty("nameForAdress") String nameForAdress,
			final @JsonProperty("customerID") String customerID,
			final @JsonProperty("cashAccounts") List<CashAccount> cashAccounts,
			final @JsonProperty("cryptoWallets") List<CryptoWallet> cryptoWallets,
			final @JsonProperty("securityDepots") List<SecurityDepot> securityDepots) {
		this.nameForAdress = Objects.requireNonNull(nameForAdress, "The name must not be null");
		this.customerID = Objects.requireNonNull(customerID, "The customerID must not be null");
		this.cashAccounts = Objects.requireNonNull(cashAccounts, "The list of cash accounts may not be null");
		this.cryptoWallets = Objects.requireNonNull(cryptoWallets, "The list of wallets must not be null");
		this.securityDepots = Objects.requireNonNull(securityDepots, "The list of wallets must not be null");
	}

	protected Customer() {
		// required by GWT
	}
}
