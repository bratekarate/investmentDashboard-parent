package org.goetheuni.investmentdashboard.shared.api;

import java.util.List;

import org.goetheuni.investmentdashboard.shared.impl.CashAccount;
import org.goetheuni.investmentdashboard.shared.impl.CryptoWallet;
import org.goetheuni.investmentdashboard.shared.impl.SecurityDepot;



/**
 * Objects with this interface represent the bank's customers. As GWT is based
 * on source code mapping, these interface can only be used in the server-side
 * code.
 */
public interface ICustomer {

	/**
	 * @return the nameForAdress
	 */
	public String getNameForAdress();

	/**
	 * @return the customerID
	 */
	public String getCustomerID();

	/**
	 * @return the cashAccounts
	 */
	public List<CashAccount> getCashAccounts();

	/**
	 * @return the cryptoWallets
	 */
	public List<CryptoWallet> getCryptoWallets();

	/**
	 * @return the securityDepots
	 */
	public List<SecurityDepot> getSecurityDepots();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString();

}
