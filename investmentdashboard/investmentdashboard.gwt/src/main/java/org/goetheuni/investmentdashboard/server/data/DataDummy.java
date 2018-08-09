package org.goetheuni.investmentdashboard.server.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
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

/**
 * This class provides dummy customers.
 */
public class DataDummy {

	public static Random R = new Random();

	private static final Security SECA01 = new Security("0001", "Baier", "Baier");
	private static final Security SECA02 = new Security("0002", "Allians", "Alliants");
	private static final Security SECA03 = new Security("0003", "BAZF", "BAZF");
	private static final Security SECA04 = new Security("0004", "VMAG Vz.", "VMAG Vz.");
	private static final Security SECA05 = new Security("0005", "D.Telecom", "D.Telecom");
	private static final Security SECA06 = new Security("0006", "Daymlehr AG", "Daymlehr AG");
	private static final Security SECA07 = new Security("0007", "BWM AG", "BWM AG");
	private static final Security SECA08 = new Security("0008", "Centinental", "Centinetal");
	private static final Security SECA09 = new Security("0009", "Minich Re", "Minich Re");
	private static final Security SECA10 = new Security("0010", "adydas AG", "adyads AG");
	private static final Security SECA11 = new Security("0011", "Frisinius MC", "Frisinius MC");
	private static final Security SECA12 = new Security("0012", "Baiersdorff", "Baiersdorf");

	private static final Security SECT01 = new Security("0013", "SAMSANG ADRs", "SAUMSANG ADRs");
	private static final Security SECT02 = new Security("0014", "Intal Corp.", "Intal Corp.");
	private static final Security SECT03 = new Security("0015", "Cesco Inc.", "Cesco Inc.");
	private static final Security SECT04 = new Security("0016", "NVDYA Corp.", "NVDYA Corp.");
	private static final Security SECT05 = new Security("0017", "3W Co.", "3W Co.");
	private static final Security SECT06 = new Security("0018", "Taxes I. Inc.", "Taxes I. Inc.");
	private static final Security SECT07 = new Security("0019", "Sany Corp.", "Sany Corp.");
	private static final Security SECT08 = new Security("0020", "Toshabi", "Toshabi");
	private static final Security SECT09 = new Security("0021", "Rockwall ATM", "Rockwall ATM");
	private static final Security SECT10 = new Security("0022", "AMT Inc.", "AMT Inc.");
	private static final Security SECT11 = new Security("0023", "Novartes AG", "Novartes AG");
	private static final Security SECT12 = new Security("0024", "Johnsen & J.", "Johnsen & J.");

	public static SecurityMarketData getDummySecurities() {
		HashMap<String, BigDecimal> marketPrizes = new HashMap<>();
		Date dateAndTime = new Date();

		// add prizes
		marketPrizes.put(SECA01.getIsin(), BigDecimal.valueOf(95.54));
		marketPrizes.put(SECA02.getIsin(), BigDecimal.valueOf(189.42));
		marketPrizes.put(SECA03.getIsin(), BigDecimal.valueOf(80.39));
		marketPrizes.put(SECA04.getIsin(), BigDecimal.valueOf(147.76));
		marketPrizes.put(SECA05.getIsin(), BigDecimal.valueOf(14.28));
		marketPrizes.put(SECA06.getIsin(), BigDecimal.valueOf(59.01));
		marketPrizes.put(SECA07.getIsin(), BigDecimal.valueOf(84.78));
		marketPrizes.put(SECA08.getIsin(), BigDecimal.valueOf(188.95));
		marketPrizes.put(SECA09.getIsin(), BigDecimal.valueOf(183.30));
		marketPrizes.put(SECA10.getIsin(), BigDecimal.valueOf(208.8));
		marketPrizes.put(SECA11.getIsin(), BigDecimal.valueOf(84.30));
		marketPrizes.put(SECA12.getIsin(), BigDecimal.valueOf(98.22));
		marketPrizes.put(SECT01.getIsin(), BigDecimal.valueOf(736.11));
		marketPrizes.put(SECT02.getIsin(), BigDecimal.valueOf(43.09));
		marketPrizes.put(SECT03.getIsin(), BigDecimal.valueOf(37.91));
		marketPrizes.put(SECT04.getIsin(), BigDecimal.valueOf(222.59));
		marketPrizes.put(SECT05.getIsin(), BigDecimal.valueOf(177.50));
		marketPrizes.put(SECT06.getIsin(), BigDecimal.valueOf(99.67));
		marketPrizes.put(SECT07.getIsin(), BigDecimal.valueOf(47.40));
		marketPrizes.put(SECT08.getIsin(), BigDecimal.valueOf(2.57));
		marketPrizes.put(SECT09.getIsin(), BigDecimal.valueOf(118.06));
		marketPrizes.put(SECT10.getIsin(), BigDecimal.valueOf(16.73));
		marketPrizes.put(SECT11.getIsin(), BigDecimal.valueOf(71.92));
		marketPrizes.put(SECT12.getIsin(), BigDecimal.valueOf(112.99));

		// generate reference value
		HashMap<String, BigDecimal> referenceValues = new HashMap<>();
		referenceValues.put(SECA01.getIsin(), BigDecimal.valueOf(95));
		referenceValues.put(SECA02.getIsin(), BigDecimal.valueOf(183));
		referenceValues.put(SECA03.getIsin(), BigDecimal.valueOf(81));
		referenceValues.put(SECA04.getIsin(), BigDecimal.valueOf(155));
		referenceValues.put(SECA05.getIsin(), BigDecimal.valueOf(14.78));
		referenceValues.put(SECA06.getIsin(), BigDecimal.valueOf(60.45));
		referenceValues.put(SECA07.getIsin(), BigDecimal.valueOf(84.5));
		referenceValues.put(SECA08.getIsin(), BigDecimal.valueOf(190.73));
		referenceValues.put(SECA09.getIsin(), BigDecimal.valueOf(165));
		referenceValues.put(SECA10.getIsin(), BigDecimal.valueOf(210.52));
		referenceValues.put(SECA11.getIsin(), BigDecimal.valueOf(83.45));
		referenceValues.put(SECA12.getIsin(), BigDecimal.valueOf(99));
		referenceValues.put(SECT01.getIsin(), BigDecimal.valueOf(728.43));
		referenceValues.put(SECT02.getIsin(), BigDecimal.valueOf(51.31));
		referenceValues.put(SECT03.getIsin(), BigDecimal.valueOf(39.70));
		referenceValues.put(SECT04.getIsin(), BigDecimal.valueOf(248.47));
		referenceValues.put(SECT05.getIsin(), BigDecimal.valueOf(145.85));
		referenceValues.put(SECT06.getIsin(), BigDecimal.valueOf(98.48));
		referenceValues.put(SECT07.getIsin(), BigDecimal.valueOf(43.63));
		referenceValues.put(SECT08.getIsin(), BigDecimal.valueOf(2.36));
		referenceValues.put(SECT09.getIsin(), BigDecimal.valueOf(100.82));
		referenceValues.put(SECT10.getIsin(), BigDecimal.valueOf(17.49));
		referenceValues.put(SECT11.getIsin(), BigDecimal.valueOf(71.55));
		referenceValues.put(SECT12.getIsin(), BigDecimal.valueOf(111.65));

		SecurityMarketData result = new SecurityMarketData(marketPrizes, referenceValues, dateAndTime);
		return result;
	}

	public static CryptoMarketData getDummyCrypto() {
		Date dateAndTime = new Date();
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

		// create sample dates
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime yesterday = now.minusDays(1);
		LocalDateTime twoDaysBeforeYest = now.minusDays(3);

		List<SecurityInvestment> portfolioAlter = new ArrayList<>();

		portfolioAlter.add(new SecurityInvestment(SECA02, 12));
		portfolioAlter.add(new SecurityInvestment(SECA03, 3));
		portfolioAlter.add(new SecurityInvestment(SECA04, 4));
		portfolioAlter.add(new SecurityInvestment(SECA05, 1));
		portfolioAlter.add(new SecurityInvestment(SECA06, 10));
		portfolioAlter.add(new SecurityInvestment(SECA07, 5));
		portfolioAlter.add(new SecurityInvestment(SECA08, 2));
		portfolioAlter.add(new SecurityInvestment(SECA09, 11));
		portfolioAlter.add(new SecurityInvestment(SECA10, 1));
		portfolioAlter.add(new SecurityInvestment(SECA11, 7));

		List<SecurityTransaction> recentTrAlter = new ArrayList<>();

		SecurityTransaction t1 = new SecurityTransaction(3, BigDecimal.valueOf(552.86), SECA02, rndmDate(yesterday),
				false);
		SecurityTransaction t2 = new SecurityTransaction(4, BigDecimal.valueOf(725.25), SECA09, rndmDate(yesterday),
				false);
		SecurityTransaction t3 = new SecurityTransaction(2, BigDecimal.valueOf(162.52), SECA07,
				rndmDate(now.minusDays(5)), true);
		SecurityTransaction t4 = new SecurityTransaction(10, BigDecimal.valueOf(2009.2), SECA10,
				rndmDate(now.minusDays(8)), true);
		SecurityTransaction t5 = new SecurityTransaction(1, BigDecimal.valueOf(186.83), SECA08,
				rndmDate(now.minusDays(15)), false);

		recentTrAlter.add(t1);
		recentTrAlter.add(t2);
		recentTrAlter.add(t3);
		recentTrAlter.add(t4);
		recentTrAlter.add(t5);

		SecurityDepot depotAlter = new SecurityDepot(portfolioAlter, "000440222", "Altersvorsorge", recentTrAlter);

		List<SecurityInvestment> portfolioTech = new ArrayList<>();

		portfolioTech.add(new SecurityInvestment(SECT01, 1));
		portfolioTech.add(new SecurityInvestment(SECT02, 15));
		portfolioTech.add(new SecurityInvestment(SECT04, 8));
		portfolioTech.add(new SecurityInvestment(SECT05, 12));
		portfolioTech.add(new SecurityInvestment(SECT06, 3));
		portfolioTech.add(new SecurityInvestment(SECT07, 5));
		portfolioTech.add(new SecurityInvestment(SECT08, 60));
		portfolioTech.add(new SecurityInvestment(SECT09, 15));
		portfolioTech.add(new SecurityInvestment(SECT10, 5));
		portfolioTech.add(new SecurityInvestment(SECT12, 2));

		List<SecurityTransaction> recentTrTech = new ArrayList<>();

		SecurityTransaction tTech1 = new SecurityTransaction(15, BigDecimal.valueOf(1653.34), SECT09, rndmDate(now),
				false);
		SecurityTransaction tTech2 = new SecurityTransaction(3, BigDecimal.valueOf(654.71), SECT04, rndmDate(now),
				true);
		SecurityTransaction tTech3 = new SecurityTransaction(1, BigDecimal.valueOf(156.90), SECT10, rndmDate(yesterday),
				false);
		SecurityTransaction tTech4 = new SecurityTransaction(5, BigDecimal.valueOf(214.98), SECT02,
				rndmDate(yesterday.minusDays(3)), false);
		SecurityTransaction tTech5 = new SecurityTransaction(2, BigDecimal.valueOf(1473.55), SECT01,
				rndmDate(yesterday.minusDays(10)), true);
		SecurityTransaction tTech6 = new SecurityTransaction(8, BigDecimal.valueOf(90.13), SECT02,
				rndmDate(yesterday.minusMonths(1)), false);

		recentTrTech.add(tTech1);
		recentTrTech.add(tTech2);
		recentTrTech.add(tTech3);
		recentTrTech.add(tTech4);
		recentTrTech.add(tTech5);
		recentTrTech.add(tTech6);

		SecurityDepot depotTech = new SecurityDepot(portfolioTech, "000440395", "Technologie", recentTrTech);

		// create cash account
		Date date = rndmDate(yesterday);
		CashPayment cp01 = new CashPayment(BigDecimal.valueOf(1045.00), "EUR", "DEABC001", "TOM", rndmDate(now));
		CashPayment cp02 = new CashPayment(BigDecimal.valueOf(-244.52), "EUR", "DEABC001", "GOTAR VVaG",
				rndmDate(yesterday));
		CashPayment cp03 = new CashPayment(BigDecimal.valueOf(1200.0), "EUR", "DEABC002", "JANE", rndmDate(now));
		CashPayment cp04 = new CashPayment(BigDecimal.valueOf(-120.55), "EUR", "DEABC003", "AMAZIN DE", rndmDate(now));
		CashPayment cp05 = new CashPayment(BigDecimal.valueOf(-323.22), "EUR", "DEABC008", "VIZA", rndmDate(now));
		CashPayment cp06 = new CashPayment(BigDecimal.valueOf(1500.00), "EUR", "DEABC023", "JIM", date);
		CashPayment cp07 = new CashPayment(BigDecimal.valueOf(-1500.00), "EUR", "DEABC489", "JIM", date);
		CashPayment cp08 = new CashPayment(BigDecimal.valueOf(4425.78), "EUR", "DEABC789", "JIM'S BOSS",
				rndmDate(yesterday.minusMonths(1)));
		CashPayment cp09 = new CashPayment(BigDecimal.valueOf(4425.78), "EUR", "DEABC789", "JIM'S BOSS",
				rndmDate(yesterday));
		CashPayment cp10 = new CashPayment(BigDecimal.valueOf(+300.00), "EUR", "DEABC234", "JIM", rndmDate(yesterday));
		CashPayment cp11 = new CashPayment(BigDecimal.valueOf(-60.00), "EUR", "DEABC234", "JIM",
				rndmDate(yesterday.minusDays(1)));
		CashPayment cp12 = new CashPayment(BigDecimal.valueOf(-100.00), "EUR", "DEABC011", "CG BANK AG", rndmDate(now));
		CashPayment cp13 = new CashPayment(BigDecimal.valueOf(-1355.42), "EUR", "DEABC222", "MAINOWA",
				rndmDate(twoDaysBeforeYest.minusDays(9)));

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
		CryptoPayment cryPay1 = new CryptoPayment(BigDecimal.valueOf(2.500), "BTC", "1P82rBjJMDFSay2Rq", rndmDate(now));
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
		CryptoPayment cryPay4 = new CryptoPayment(BigDecimal.valueOf(63.000), "LTC", "1MDFSay2P82rBjJRq",
				rndmDate(now));
		CryptoPayment cryPay5 = new CryptoPayment(BigDecimal.valueOf(-144.0155), "LTC", "1H7kzdFSaP56rvy4Ke",
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
		securityDepots.add(depotAlter);
		securityDepots.add(depotTech);

		Customer result = new Customer("JIM", "0000354", cashAccounts, cryptoWallets, securityDepots);
		return result;

	}

	private static Date rndmDate(LocalDateTime day) {
		LocalDateTime result = day.minusHours(R.nextInt(day.getHour() + 1));
		result = result.minusMinutes(R.nextInt(result.getMinute() + 1));
		result = result.minusSeconds(R.nextInt(result.getSecond() + 1));
		ZonedDateTime dateZoned = result.atZone(ZoneId.systemDefault());
		return Date.from(dateZoned.toInstant());
	}
}
