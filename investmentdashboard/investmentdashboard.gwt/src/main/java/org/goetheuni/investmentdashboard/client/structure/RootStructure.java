package org.goetheuni.investmentdashboard.client.structure;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.impl.CashAccount;
import org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData;
import org.goetheuni.investmentdashboard.shared.impl.CryptoWallet;
import org.goetheuni.investmentdashboard.shared.impl.Customer;
import org.goetheuni.investmentdashboard.shared.impl.SecurityDepot;
import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;

/**
 * This class provides access to the logical structure of the investment dash board.
 */
public class RootStructure {

	/**
	 * The logical structure's root.
	 */
	protected static RootStructure root;
	
	/**
	 * All cash account substructures
	 */
	protected List<CashAccountStruct> cashAccounts;
	
	/**
	 * All security depot substructures
	 */
	protected List<SecurityDepotStruct> depots;
	
	/**
	 * All crypto wallet substructures
	 */
	protected List<CryptoWalletStruct> wallets;
	
	/**
	 * The corresponding Customer data object 
	 */
	protected Customer data;
	
	/**
	 * @return the cashAccounts
	 */
	public List<CashAccountStruct> getCashAccounts() {
		return cashAccounts;
	}

	/**
	 * @return the depots
	 */
	public List<SecurityDepotStruct> getDepots() {
		return depots;
	}

	/**
	 * @return the wallets
	 */
	public List<CryptoWalletStruct> getWallets() {
		return wallets;
	}
	

	/**
	 * Computes the total balance in EUR incorporating all cash accounts, wallets and depots. 
	 * @param secMarket The list of security prizes used.
	 * @param cryptoMarket The list of crypto prizes used.
	 * @return the total balance in EUR incorporating all cash accounts, wallets and depots
	 */
	public BigDecimal computeTotalBalanceInEUR(SecurityMarketData secMarket, CryptoMarketData cryptoMarket) {
		// validate input
		Objects.requireNonNull(secMarket, "The security market data object must not be null");
		Objects.requireNonNull(cryptoMarket, "The crypto market data object must not be null");
		
		BigDecimal result = BigDecimal.valueOf(0);
		
		// add cash 
		for(CashAccountStruct cash : this.cashAccounts) {
			result = result.add(cash.computeBalanceInEUR(secMarket, cryptoMarket));
		}
		
		// add securities
		for(SecurityDepotStruct depot : this.depots) {
			result = result.add(depot.computeBalanceInEUR(secMarket, cryptoMarket));
		}
		
		// add wallets
		for(CryptoWalletStruct wallet : this.wallets) {
			result = result.add(wallet.computeBalanceInEUR(secMarket, cryptoMarket));
		}
		
		return result;
	}


	/**
	 * Provides access to the root element of the dash boards logical structure.
	 * @return The logical structure's root.
	 */
	public static RootStructure get() {
		return RootStructure.root;
	}
	
	/**
	 * This method initializes the logical structure of the dash board page.
	 * It should only be called once in the page setup process.
	 * @param customerData The customer data as a basis for the structure.
	 */
	public static void initialize(Customer customerData) {
		// validate input
		Objects.requireNonNull(customerData, "Cannot build the structure because the given Customer data object was null.");
		
		// create substructures
		// cash accounts
		List<CashAccountStruct> cashAccounts = new ArrayList<>();
		for(CashAccount aCashAccount : customerData.getCashAccounts()) {
			// create a substructure for each account in the data
			cashAccounts.add(new CashAccountStruct(aCashAccount)); 
		}
		
		// depots
		List<SecurityDepotStruct> depots = new ArrayList<>();
		for(SecurityDepot depot : customerData.getSecurityDepots()) {
			// create a substructure for each depot
			depots.add(new SecurityDepotStruct(depot));
		}
		
		// crypto wallet
		List<CryptoWalletStruct> wallets = new ArrayList<>();
		for(CryptoWallet wallet : customerData.getCryptoWallets()) {
			// create a substructure for each wallet
			wallets.add(new CryptoWalletStruct(wallet));
		}
		
		// create and put the new root structure
		RootStructure.root = new RootStructure(cashAccounts, depots, wallets, customerData);
	}
	
	/**
	 * Creates a root struct. This method should only be called in once in the page setup process.
	 * 
	 * @param cashAccounts sub-structure
	 * @param depots sub-structures
	 * @param wallets sub-structures
	 * @param data The corresponding customer data object.
	 */
	protected RootStructure(List<CashAccountStruct> cashAccounts, List<SecurityDepotStruct> depots,
			List<CryptoWalletStruct> wallets, Customer data) {
		this.cashAccounts = Objects.requireNonNull(cashAccounts, "The list of cash account substructures must not be null");
		this.depots = Objects.requireNonNull(depots, "The list of security depot substructures must not be null");
		this.wallets = Objects.requireNonNull(wallets, "The list of crypto wallet substructures must not be null");
		this.data = Objects.requireNonNull(data, "The data object given must not be null");
	}
	
	
}
