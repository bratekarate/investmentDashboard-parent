package org.goetheuni.investmentdashboard.shared.impl;

import java.util.List;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.api.ICustomer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objects of this class represent the bank's customers.
 * 
 * JAVADOC DONE
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
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cashAccounts == null) ? 0 : cashAccounts.hashCode());
		result = prime * result + ((cryptoWallets == null) ? 0 : cryptoWallets.hashCode());
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
		result = prime * result + ((nameForAdress == null) ? 0 : nameForAdress.hashCode());
		result = prime * result + ((securityDepots == null) ? 0 : securityDepots.hashCode());
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
		Customer other = (Customer) obj;
		if (cashAccounts == null) {
			if (other.cashAccounts != null) {
				return false;
			}
		} else if (!cashAccounts.equals(other.cashAccounts)) {
			return false;
		}
		if (cryptoWallets == null) {
			if (other.cryptoWallets != null) {
				return false;
			}
		} else if (!cryptoWallets.equals(other.cryptoWallets)) {
			return false;
		}
		if (customerID == null) {
			if (other.customerID != null) {
				return false;
			}
		} else if (!customerID.equals(other.customerID)) {
			return false;
		}
		if (nameForAdress == null) {
			if (other.nameForAdress != null) {
				return false;
			}
		} else if (!nameForAdress.equals(other.nameForAdress)) {
			return false;
		}
		if (securityDepots == null) {
			if (other.securityDepots != null) {
				return false;
			}
		} else if (!securityDepots.equals(other.securityDepots)) {
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
		return "Customer [nameForAdress=" + nameForAdress + ", customerID=" + customerID + ", cashAccounts="
				+ cashAccounts + ", cryptoWallets=" + cryptoWallets + ", securityDepots=" + securityDepots + "]";
	}

	/**
	 * Creates an object representing a customer.
	 * 
	 * @param nameForAdress
	 *            A string that will be used to address the customer. It should be
	 *            chosen appropriately.
	 * @param customerID
	 *            The customer ID
	 * @param cashAccounts
	 *            The customer's cash accounts
	 * @param cryptoWallets
	 *            The customer's crypto wallets
	 * @param securityDepots
	 *            The customer's security depots
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

	/**
	 * NOT A PART OF THE API
	 */
	protected Customer() {
		// required by GWT
	}
}
