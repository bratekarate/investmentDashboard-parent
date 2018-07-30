package org.goetheuni.investmentdashboard.server.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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

import com.google.gwt.user.datepicker.client.CalendarUtil;

/**
 * This class provides dummy customers.
 */
public class DataDummy {

	public static Random R = new Random();
	
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
		referenceValues.put("0001", BigDecimal.valueOf(6.90));
		referenceValues.put("0002", BigDecimal.valueOf(12.83));
		referenceValues.put("0003", BigDecimal.valueOf(0.82));
		referenceValues.put("0004", BigDecimal.valueOf(100000.50));

		SecurityMarketData result = new SecurityMarketData(marketPrizes, referenceValues, dateAndTime);
		return result;
	}

	public static CryptoMarketData getDummyCrypto() {
		Date dateAndTime = new Date(600000);
		HashMap<String, BigDecimal> exchangeRates = new HashMap<>();

		// add exchange rates
		exchangeRates.put("BTC", BigDecimal.valueOf(6582.24));
		exchangeRates.put("LTC", BigDecimal.valueOf(72.41));
		exchangeRates.put("ABC", BigDecimal.valueOf(0.09));
		exchangeRates.put("XYZ", BigDecimal.valueOf(200000.50));

		// add reference values
		HashMap<String, BigDecimal> referenceValues = new HashMap<>();
		referenceValues.put("BTC", BigDecimal.valueOf(6333.54));
		referenceValues.put("LTC", BigDecimal.valueOf(75.67));
		referenceValues.put("ABC", BigDecimal.valueOf(0.10));
		referenceValues.put("XYZ", BigDecimal.valueOf(200000.50));

		CryptoMarketData result = new CryptoMarketData(exchangeRates, referenceValues, dateAndTime);
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

		// create sample dates
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime yesterday = now.minusDays(1);
		LocalDateTime twoDaysBeforeYest = now.minusDays(3);
		
		
		// create cash account
		Date date = rndmDate(yesterday);
		CashPayment cp01 = new CashPayment(BigDecimal.valueOf(1045.00), "EUR", "DEABC001", "TOM", rndmDate(now));
		CashPayment cp02 = new CashPayment(BigDecimal.valueOf(-244.52), "EUR", "DEABC001", "GOTAR VVaG", rndmDate(yesterday));
		CashPayment cp03 = new CashPayment(BigDecimal.valueOf(1200.0), "EUR", "DEABC002", "JANE", rndmDate(now));
		CashPayment cp04 = new CashPayment(BigDecimal.valueOf(-120.55), "EUR", "DEABC003", "AMAZIN DE", rndmDate(now));
		CashPayment cp05 = new CashPayment(BigDecimal.valueOf(-323.22), "EUR", "DEABC008", "VIZA", rndmDate(now));
		CashPayment cp06 = new CashPayment(BigDecimal.valueOf(1500.00), "EUR", "DEABC023", "JIM", date);
		CashPayment cp07 = new CashPayment(BigDecimal.valueOf(-1500.00), "EUR", "DEABC489", "JIM", date);
		CashPayment cp08 = new CashPayment(BigDecimal.valueOf(4425.78), "EUR", "DEABC789", "JIM'S BOSS", rndmDate(yesterday.minusMonths(1)));
		CashPayment cp09 = new CashPayment(BigDecimal.valueOf(4425.78), "EUR", "DEABC789", "JIM'S BOSS", rndmDate(yesterday));
		CashPayment cp10 = new CashPayment(BigDecimal.valueOf(+300.00), "EUR", "DEABC234", "JIM", rndmDate(yesterday));
		CashPayment cp11 = new CashPayment(BigDecimal.valueOf(-60.00), "EUR", "DEABC234", "JIM", rndmDate(yesterday.minusDays(1)));
		CashPayment cp12 = new CashPayment(BigDecimal.valueOf(-100.00), "EUR", "DEABC011", "CG BANK AG", rndmDate(now));
		CashPayment cp13 = new CashPayment(BigDecimal.valueOf(-1355.42), "EUR", "DEABC222", "MAINOWA", rndmDate(twoDaysBeforeYest.minusDays(9)));

		List<CashPayment> cashPayments1 = new ArrayList<>();
		cashPayments1.add(cp01);
		cashPayments1.add(cp02);
		cashPayments1.add(cp03);
		cashPayments1.add(cp13);

		List<CashPayment> cashPayments2 = new ArrayList<>();
		cashPayments2.add(cp04);
		cashPayments2.add(cp05);
		cashPayments2.add(cp06);
		cashPayments2.add(cp12);

		List<CashPayment> cashPayments3 = new ArrayList<>();
		cashPayments3.add(cp07);
		cashPayments3.add(cp08);
		cashPayments3.add(cp09);
		cashPayments3.add(cp10);
		cashPayments3.add(cp11);

		CashAccount cashAcc0 = new CashAccount("0", "DEXYZ00001", "Girokonto", cashPayments1,
				BigDecimal.valueOf(531.74), "EUR");
		CashAccount cashAcc1 = new CashAccount("1", "DEXYZ00111", "Girokonto", cashPayments2,
				BigDecimal.valueOf(265.50), "EUR");
		CashAccount cashAcc2 = new CashAccount("2", "DEXYZ22222", "Tagesgeldkonto", cashPayments3,
				BigDecimal.valueOf(2222.40), "EUR");

		// create crypto wallet
		CryptoPayment cryPay1 = new CryptoPayment(BigDecimal.valueOf(2.500), "BTC", "1P82rBjJMDFSay2Rq",
				rndmDate(now));
		CryptoPayment cryPay2 = new CryptoPayment(BigDecimal.valueOf(-0.015), "BTC", "1HP56rvOLzdFSay4Me",
				rndmDate(yesterday));
		CryptoPayment cryPay3 = new CryptoPayment(BigDecimal.valueOf(-0.015), "BTC", "1HP56rvOLzdFSay4Me",
				rndmDate(yesterday));
		List<CryptoPayment> cryPayments = new ArrayList<>();
		cryPayments.add(cryPay1);
		cryPayments.add(cryPay2);
		cryPayments.add(cryPay3);

		CryptoWallet wallet1 = new CryptoWallet("BTC000725112", "BTC", "Bitcoin-Wallet", BigDecimal.valueOf(7.534),
				cryPayments);

		// create another crypto wallet
		CryptoPayment cryPay4 = new CryptoPayment(BigDecimal.valueOf(63.000), "LTC", "1P82rBjJMDFSay2Rq",
				rndmDate(now));
		CryptoPayment cryPay5 = new CryptoPayment(BigDecimal.valueOf(-144.0155), "LTC", "1HP56rvOLzdFSay4Me",
				rndmDate(twoDaysBeforeYest));

		List<CryptoPayment> cryPayments2 = new ArrayList<>();
		cryPayments2.add(cryPay4);
		cryPayments2.add(cryPay5);

		CryptoWallet wallet2 = new CryptoWallet("LTC000835321", "LTC", "Litecoin-Wallet", BigDecimal.valueOf(110),
				cryPayments2);

		// create customer
		List<CashAccount> cashAccounts = new ArrayList<>();
		cashAccounts.add(cashAcc0);
		cashAccounts.add(cashAcc1);
		cashAccounts.add(cashAcc2);
		List<CryptoWallet> cryptoWallets = new ArrayList<>();
		cryptoWallets.add(wallet1);
		cryptoWallets.add(wallet2);
		List<SecurityDepot> securityDepots = new ArrayList<>();
		securityDepots.add(depot);

		Customer result = new Customer("JIM", "0000354", cashAccounts, cryptoWallets, securityDepots);
		return result;
		
	}
	
	private static Date rndmDate(LocalDateTime day) {
		LocalDateTime result = day.minusHours(R.nextInt(day.getHour()));
		result = result.minusMinutes(R.nextInt(result.getMinute()));
		result = result.minusSeconds(R.nextInt(result.getSecond()));
		ZonedDateTime dateZoned = result.atZone(ZoneId.systemDefault());
		return Date.from(dateZoned.toInstant());
	}
}
