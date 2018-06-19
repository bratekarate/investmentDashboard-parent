package org.goetheuni.investmentdashboard.shared.domain.impl;

import java.util.List;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.domain.api.ICustomer;

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
	protected List<? extends CashAccount> cashAccounts;

	/**
	 * The customer's crypto wallets
	 */
	protected List<? extends CryptoWallet> cryptoWallets;

	/**
	 * The customer's security depots
	 */
	protected List<? extends SecurityDepot> securityDepots;

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
	public List<? extends CashAccount> getCashAccounts() {
		return cashAccounts;
	}

	/**
	 * @return the cryptoWallets
	 */
	@Override
	public List<? extends CryptoWallet> getCryptoWallets() {
		return cryptoWallets;
	}

	/**
	 * @return the securityDepots
	 */
	@Override
	public List<? extends SecurityDepot> getSecurityDepots() {
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
	public Customer(String nameForAdress, String customerID, List<? extends CashAccount> cashAccounts,
			List<? extends CryptoWallet> cryptoWallets, List<? extends SecurityDepot> securityDepots) {
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
