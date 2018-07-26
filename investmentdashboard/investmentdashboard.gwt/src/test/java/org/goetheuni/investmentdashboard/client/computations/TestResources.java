package org.goetheuni.investmentdashboard.client.computations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.goetheuni.investmentdashboard.shared.impl.CashAccount;
import org.goetheuni.investmentdashboard.shared.impl.CashPayment;
import org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData;
import org.goetheuni.investmentdashboard.shared.impl.CryptoPayment;
import org.goetheuni.investmentdashboard.shared.impl.CryptoWallet;
import org.goetheuni.investmentdashboard.shared.impl.Customer;
import org.goetheuni.investmentdashboard.shared.impl.Security;
import org.goetheuni.investmentdashboard.shared.impl.SecurityDepot;
import org.goetheuni.investmentdashboard.shared.impl.SecurityInvestment;
import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;
import org.goetheuni.investmentdashboard.shared.impl.SecurityTransaction;

/**
 * Provides test resources for the 
 *
 */
class TestResources {

	public static SecurityMarketData getDummySecurities() {
		HashMap<String, BigDecimal> marketPrizes = new HashMap<>();
		Date dateAndTime = new Date(50000);

		// add prizes
		marketPrizes.put("0001", BigDecimal.valueOf(6.83));
		marketPrizes.put("0002", BigDecimal.valueOf(12.83));
		marketPrizes.put("0003", BigDecimal.valueOf(0.72));
		marketPrizes.put("0004", BigDecimal.valueOf(100000.50));
		
		// generate reference value
		HashMap<String, BigDecimal> referenceValues = new HashMap<>();
		referenceValues.put("0001", BigDecimal.valueOf(6.83));
		referenceValues.put("0002", BigDecimal.valueOf(12.83));
		referenceValues.put("0003", BigDecimal.valueOf(0.72));
		referenceValues.put("0004", BigDecimal.valueOf(100000.50));

		SecurityMarketData result = new SecurityMarketData(marketPrizes, referenceValues, dateAndTime);
		return result;
	}

	public static CryptoMarketData getDummyCrypto() {
		Date dateAndTime = new Date(600000);
		HashMap<String, BigDecimal> exchangeRates = new HashMap<>();

		// add exchange rates
		exchangeRates.put("BTC", BigDecimal.valueOf(4.3));
		exchangeRates.put("LTC", BigDecimal.valueOf(26.38));
		exchangeRates.put("ABC", BigDecimal.valueOf(0.09));
		exchangeRates.put("XYZ", BigDecimal.valueOf(200000.50));
		
		// add reference values
		HashMap<String, BigDecimal> referenceValues = new HashMap<>();
		referenceValues.put("BTC", BigDecimal.valueOf(4.3));
		referenceValues.put("LTC", BigDecimal.valueOf(26.38));
		referenceValues.put("ABC", BigDecimal.valueOf(0.09));
		referenceValues.put("XYZ", BigDecimal.valueOf(200000.50));

		CryptoMarketData result = new CryptoMarketData(exchangeRates, referenceValues, dateAndTime);
		return result;
	}
	
	public static SecurityMarketData getDummySecuritiesBoom() {
		HashMap<String, BigDecimal> marketPrizes = new HashMap<>();
		Date dateAndTime = new Date(50000);

		// add prizes
		marketPrizes.put("0001", BigDecimal.valueOf(2986.83));
		marketPrizes.put("0002", BigDecimal.valueOf(12333.83));
		marketPrizes.put("0003", BigDecimal.valueOf(19998.05));
		marketPrizes.put("0004", BigDecimal.valueOf(150000.50));

		// generate reference value
		HashMap<String, BigDecimal> referenceValues = new HashMap<>();
		referenceValues.put("0001", BigDecimal.valueOf(6.83));
		referenceValues.put("0002", BigDecimal.valueOf(12.83));
		referenceValues.put("0003", BigDecimal.valueOf(0.72));
		referenceValues.put("0004", BigDecimal.valueOf(100000.50));

		SecurityMarketData result = new SecurityMarketData(marketPrizes, referenceValues, dateAndTime);
		return result;
	}

	public static CryptoMarketData getDummyCryptoBoom() {
		Date dateAndTime = new Date(600000);
		HashMap<String, BigDecimal> exchangeRates = new HashMap<>();

		// add exchange rates
		exchangeRates.put("BTC", BigDecimal.valueOf(465.3));
		exchangeRates.put("LTC", BigDecimal.valueOf(2699.38));
		exchangeRates.put("ABC", BigDecimal.valueOf(53502.09));
		exchangeRates.put("XYZ", BigDecimal.valueOf(1200000.50));

		// add reference values
		HashMap<String, BigDecimal> referenceValues = new HashMap<>();
		referenceValues.put("BTC", BigDecimal.valueOf(4.3));
		referenceValues.put("LTC", BigDecimal.valueOf(26.38));
		referenceValues.put("ABC", BigDecimal.valueOf(0.09));
		referenceValues.put("XYZ", BigDecimal.valueOf(200000.50));

		CryptoMarketData result = new CryptoMarketData(exchangeRates, referenceValues, dateAndTime);
		return result;
	}

	public static Customer getSimpleCustomer() {

		// create depot
		Security sec1 = new Security("0001", "COMP1", "C1");
		Security sec2 = new Security("0002", "COMP2", "C2");

		SecurityInvestment i1 = new SecurityInvestment(sec1, 45);
		SecurityInvestment i2 = new SecurityInvestment(sec2, 22);

		SecurityTransaction t1 = new SecurityTransaction(5, BigDecimal.valueOf(50.00), sec1, new Date(50000));
		SecurityTransaction t2 = new SecurityTransaction(-1, BigDecimal.valueOf(5.00), sec2, new Date(50000));

		List<SecurityInvestment> portfolio = new ArrayList<>();
		portfolio.add(i1);
		portfolio.add(i2);

		List<SecurityTransaction> recentTransactions = new ArrayList<>();
		recentTransactions.add(t1);
		recentTransactions.add(t2);

		SecurityDepot depot = new SecurityDepot(portfolio, "ID", "name", recentTransactions, BigDecimal.valueOf(100));

		// create cash account
		CashPayment cp1 = new CashPayment(BigDecimal.valueOf(22.22), "EUR", "DEABC", "X", new Date(470000));

		List<CashPayment> cashPayments = new ArrayList<>();
		cashPayments.add(cp1);

		CashAccount cashAcc = new CashAccount("accountID", "iban", "Bargeldkonto", cashPayments,
				BigDecimal.valueOf(500.00), "EUR");

		// create crypto wallet
		CryptoPayment cryPay1 = new CryptoPayment(BigDecimal.valueOf(2000.00), "BTC", "counterPartyAddress1",
				new Date(64545));
		CryptoPayment cryPay2 = new CryptoPayment(BigDecimal.valueOf(-250.00), "BTC", "counterPartyAddress2",
				new Date(78645));
		List<CryptoPayment> cryPayments = new ArrayList<>();
		cryPayments.add(cryPay1);
		cryPayments.add(cryPay2);

		CryptoWallet wallet = new CryptoWallet("accountID", "BTC", "Bitcoin-Wallet", BigDecimal.valueOf(1020.45),
				cryPayments);

		// create customer
		List<CashAccount> cashAccounts = new ArrayList<>();
		cashAccounts.add(cashAcc);
		List<CryptoWallet> cryptoWallets = new ArrayList<>();
		cryptoWallets.add(wallet);
		List<SecurityDepot> securityDepots = new ArrayList<>();
		securityDepots.add(depot);

		Customer result = new Customer("Mr X", "0000354", cashAccounts, cryptoWallets, securityDepots);
		return result;
	}
	
	/**
	 * @return a default customer with no assets.
	 * For test purposes.
	 */
	public static Customer getBlankCustomer() {

		// create customer
		List<CashAccount> cashAccounts = new ArrayList<>();
		
		List<CryptoWallet> cryptoWallets = new ArrayList<>();
		
		List<SecurityDepot> securityDepots = new ArrayList<>();
		
		Customer result = new Customer("Mr X", "0000354", cashAccounts, cryptoWallets, securityDepots);
		return result;
	}
	
	public static Customer getExtensiveCustomer() {
		// TODO
		return null;
	}
}
