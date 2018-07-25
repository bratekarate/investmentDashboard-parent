package org.goetheuni.investmentdashboard.server.data;

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
 * This class provides dummy customers.
 */
public class DataDummy {

	public static SecurityMarketData getDummySecurities() {
		HashMap<String, BigDecimal> marketPrizes = new HashMap<>();
		Date dateAndTime = new Date(50000);

		// add prizes
		marketPrizes.put("0001", BigDecimal.valueOf(6.83));
		marketPrizes.put("0002", BigDecimal.valueOf(12.83));
		marketPrizes.put("0003", BigDecimal.valueOf(0.72));
		marketPrizes.put("0004", BigDecimal.valueOf(100000.50));

		SecurityMarketData result = new SecurityMarketData(marketPrizes, dateAndTime);
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

		CryptoMarketData result = new CryptoMarketData(exchangeRates, dateAndTime);
		return result;
	}

	public static Customer getDummyCustomer() {

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
		CashPayment cp01 = new CashPayment(BigDecimal.valueOf(22.22), "EUR", "DEABC001", new Date(483500));
		CashPayment cp02 = new CashPayment(BigDecimal.valueOf(-26.82), "EUR", "DEABC001", new Date(478800));
		CashPayment cp03 = new CashPayment(BigDecimal.valueOf(200.2), "EUR", "DEABC002", new Date(479500));
		CashPayment cp04 = new CashPayment(BigDecimal.valueOf(1435.2), "EUR", "DEABC003", new Date(483400));
		CashPayment cp05 = new CashPayment(BigDecimal.valueOf(-1223.22), "EUR", "DEABC008", new Date(490500));
		CashPayment cp06 = new CashPayment(BigDecimal.valueOf(322.22), "EUR", "DEABC023", new Date(492200));
		CashPayment cp07 = new CashPayment(BigDecimal.valueOf(467.50), "EUR", "DEABC489", new Date(493300));
		CashPayment cp08 = new CashPayment(BigDecimal.valueOf(785.78), "EUR", "DEABC789", new Date(497500));
		CashPayment cp09 = new CashPayment(BigDecimal.valueOf(900.80), "EUR", "DEABC555", new Date(496900));
		CashPayment cp10 = new CashPayment(BigDecimal.valueOf(-5.67), "EUR", "DEABC234", new Date(499900));

		List<CashPayment> cashPayments1 = new ArrayList<>();
		cashPayments1.add(cp01);
		cashPayments1.add(cp02);
		cashPayments1.add(cp03);

		List<CashPayment> cashPayments2 = new ArrayList<>();
		cashPayments2.add(cp04);
		cashPayments2.add(cp05);
		cashPayments2.add(cp06);

		List<CashPayment> cashPayments3 = new ArrayList<>();
		cashPayments3.add(cp07);
		cashPayments3.add(cp08);
		cashPayments3.add(cp09);
		cashPayments3.add(cp10);

		CashAccount cashAcc0 = new CashAccount("0", "DEXYZ00001", "Girokonto", cashPayments1,
				BigDecimal.valueOf(500.00), "EUR");
		CashAccount cashAcc1 = new CashAccount("1", "DEXYZ00111", "Girokonto", cashPayments2,
				BigDecimal.valueOf(265.50), "EUR");
		CashAccount cashAcc2 = new CashAccount("2", "DEXYZ22222", "Tagesgeldkonto", cashPayments3,
				BigDecimal.valueOf(2222.40), "EUR");

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
		cashAccounts.add(cashAcc0);
		cashAccounts.add(cashAcc1);
		cashAccounts.add(cashAcc2);
		List<CryptoWallet> cryptoWallets = new ArrayList<>();
		cryptoWallets.add(wallet);
		List<SecurityDepot> securityDepots = new ArrayList<>();
		securityDepots.add(depot);

		Customer result = new Customer("Mr X", "0000354", cashAccounts, cryptoWallets, securityDepots);
		return result;
	}
}
