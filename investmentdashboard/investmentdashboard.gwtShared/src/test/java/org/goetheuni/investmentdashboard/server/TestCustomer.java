package org.goetheuni.investmentdashboard.server;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.goetheuni.investmentdashboard.shared.impl.CashAccount;
import org.goetheuni.investmentdashboard.shared.impl.CashPayment;
import org.goetheuni.investmentdashboard.shared.impl.CryptoPayment;
import org.goetheuni.investmentdashboard.shared.impl.CryptoWallet;
import org.goetheuni.investmentdashboard.shared.impl.Customer;
import org.goetheuni.investmentdashboard.shared.impl.Security;
import org.goetheuni.investmentdashboard.shared.impl.SecurityDepot;
import org.goetheuni.investmentdashboard.shared.impl.SecurityInvestment;
import org.goetheuni.investmentdashboard.shared.impl.SecurityTransaction;
import org.junit.Assert;
import org.junit.Test;


public class TestCustomer {

	private static Map<String, Customer> getTestResources() {
		Map<String, Customer> result = new HashMap<>();

		//create cash accounts
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 19, 33, 30);
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);
		LocalDateTime date4 = LocalDateTime.of(2016, 1, 10, 5, 13, 0);
		
		CashPayment normal = new CashPayment(BigDecimal.valueOf(150), "EUR", "DE1111XYZ", "X",
				DateConversionUtil.toDate(date1));
		CashPayment negative = new CashPayment(BigDecimal.valueOf(-40), "EUR", "DE2222XYZ", "X",
				DateConversionUtil.toDate(date2));
		CashPayment big = new CashPayment(BigDecimal.valueOf(10000), "EUR", "DE3333XYZ", "X",
				DateConversionUtil.toDate(date3));

		List<CashPayment> cash_payment_list_1 = Arrays.asList(normal, negative, big);
		List<CashPayment> cash_payment_list_2 = Arrays.asList(normal, negative);
		
		CashAccount account1 = new CashAccount("MrTom", "00001", "Cash Account(EUR)", cash_payment_list_1, BigDecimal.valueOf(2000),"EUR");
		CashAccount account2 = new CashAccount("MrJoe", "00002", "Cash Account(EUR)", cash_payment_list_2, BigDecimal.valueOf(180),"EUR");
		
		List<CashAccount> account_list_1 = Arrays.asList(account1);
		List<CashAccount> account_list_2 = Arrays.asList(account2);
		
		//create crypto wallets
		CryptoPayment payment1 = new CryptoPayment(BigDecimal.valueOf(15), "BTC", "DE12345", DateConversionUtil.toDate(date1));
		CryptoPayment payment2 = new CryptoPayment(BigDecimal.valueOf(50), "BTC", "DE23456", DateConversionUtil.toDate(date2));
		CryptoPayment payment3 = new CryptoPayment(BigDecimal.valueOf(-4), "LTC", "DE678910", DateConversionUtil.toDate(date3));
		CryptoPayment payment4 = new CryptoPayment(BigDecimal.valueOf(1000), "LTC", "DE111213", DateConversionUtil.toDate(date4));
		
		List<CryptoPayment> crypto_payment_list_1 = Arrays.asList(payment1, payment2);
		List<CryptoPayment> crypto_payment_list_2 = Arrays.asList(payment3, payment4);
		
		CryptoWallet wallet1 = new CryptoWallet("MrTom", "BTC", "Tom", BigDecimal.valueOf(2000), crypto_payment_list_1);
		CryptoWallet wallet2 = new CryptoWallet("MrJoe", "LTC", "Joe", BigDecimal.valueOf(1000), crypto_payment_list_2);
		
		List<CryptoWallet> wallet_list_1 = Arrays.asList(wallet1);
		List<CryptoWallet> wallet_list_2 = Arrays.asList(wallet2);
		
		//create security depots
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		Security oracle = new Security("22222","Oracle Corporation","ORACLE");
		
		List<SecurityInvestment> investmentList1 = Arrays.asList(new SecurityInvestment(sun,1110), new SecurityInvestment(sun,0513));
		List<SecurityInvestment> investmentList2 = Arrays.asList(new SecurityInvestment(oracle,85), new SecurityInvestment(oracle,9494));
		
		SecurityTransaction transaction1 = new SecurityTransaction(5713, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1), false);
		SecurityTransaction transaction2 = new SecurityTransaction(23, BigDecimal.valueOf(2341), sun, DateConversionUtil.toDate(date2), false);
		SecurityTransaction transaction3 = new SecurityTransaction(456, BigDecimal.valueOf(2573), sun, DateConversionUtil.toDate(date3), false);
		SecurityTransaction transaction4 = new SecurityTransaction(2549, BigDecimal.valueOf(113423), sun, DateConversionUtil.toDate(date4), false);
		
		List<SecurityTransaction> transactionList1 = Arrays.asList(transaction1,transaction2,transaction4);
		List<SecurityTransaction> transactionList2 = Arrays.asList(transaction3,transaction1);
		
		SecurityDepot security_depot_1 = new SecurityDepot(investmentList1, "depotID_sun", "sun", transactionList1);
		SecurityDepot security_depot_2 = new SecurityDepot(investmentList2, "depotID_oracle", "oracle", transactionList2);
		
		List<SecurityDepot> security_depot_list_1 = Arrays.asList(security_depot_1);
		List<SecurityDepot> security_depot_list_2 = Arrays.asList(security_depot_2);
		
		result.put("test_case_1", new Customer("name1", "asdfkjn", account_list_1, wallet_list_1, security_depot_list_1));
		result.put("test_case_2", new Customer("name2", "12i3u4n", account_list_2, wallet_list_2, security_depot_list_2));
		return result;
	}
	
	//test non null input
	@Test(expected = NullPointerException.class)
	public void testNameForAdressNoneNull() {
		//create cash accounts
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 19, 33, 30);
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);
		LocalDateTime date4 = LocalDateTime.of(2016, 1, 10, 5, 13, 0);
		
		CashPayment normal = new CashPayment(BigDecimal.valueOf(150), "EUR", "DE1111XYZ", "X",
				DateConversionUtil.toDate(date1));
		CashPayment negative = new CashPayment(BigDecimal.valueOf(-40), "EUR", "DE2222XYZ", "X",
				DateConversionUtil.toDate(date2));
		CashPayment big = new CashPayment(BigDecimal.valueOf(10000), "EUR", "DE3333XYZ", "X",
				DateConversionUtil.toDate(date3));

		List<CashPayment> cash_payment_list_1 = Arrays.asList(normal, negative, big);
		List<CashPayment> cash_payment_list_2 = Arrays.asList(normal, negative);
		
		CashAccount account1 = new CashAccount("MrTom", "00001", "Cash Account(EUR)", cash_payment_list_1, BigDecimal.valueOf(2000),"EUR");
		CashAccount account2 = new CashAccount("MrJoe", "00002", "Cash Account(EUR)", cash_payment_list_2, BigDecimal.valueOf(180),"EUR");
		
		List<CashAccount> account_list_1 = Arrays.asList(account1,account2);
		
		//create crypto wallets
		CryptoPayment payment1 = new CryptoPayment(BigDecimal.valueOf(15), "BTC", "DE12345", DateConversionUtil.toDate(date1));
		CryptoPayment payment2 = new CryptoPayment(BigDecimal.valueOf(50), "BTC", "DE23456", DateConversionUtil.toDate(date2));
		CryptoPayment payment3 = new CryptoPayment(BigDecimal.valueOf(-4), "LTC", "DE678910", DateConversionUtil.toDate(date3));
		CryptoPayment payment4 = new CryptoPayment(BigDecimal.valueOf(1000), "LTC", "DE111213", DateConversionUtil.toDate(date4));
		
		List<CryptoPayment> crypto_payment_list_1 = Arrays.asList(payment1, payment2);
		List<CryptoPayment> crypto_payment_list_2 = Arrays.asList(payment3, payment4);
		
		CryptoWallet wallet1 = new CryptoWallet("MrTom", "BTC", "Tom", BigDecimal.valueOf(2000), crypto_payment_list_1);
		CryptoWallet wallet2 = new CryptoWallet("MrJoe", "LTC", "Joe", BigDecimal.valueOf(1000), crypto_payment_list_2);
		
		List<CryptoWallet> wallet_list_1 = Arrays.asList(wallet1,wallet2);
		
		//create security depots
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		Security oracle = new Security("22222","Oracle Corporation","ORACLE");
		
		List<SecurityInvestment> investmentList1 = Arrays.asList(new SecurityInvestment(sun,1110), new SecurityInvestment(sun,0513));
		List<SecurityInvestment> investmentList2 = Arrays.asList(new SecurityInvestment(oracle,85), new SecurityInvestment(oracle,9494));
		
		SecurityTransaction transaction1 = new SecurityTransaction(5713, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1), false);
		SecurityTransaction transaction2 = new SecurityTransaction(23, BigDecimal.valueOf(2341), sun, DateConversionUtil.toDate(date2), false);
		SecurityTransaction transaction3 = new SecurityTransaction(456, BigDecimal.valueOf(2573), sun, DateConversionUtil.toDate(date3), false);
		SecurityTransaction transaction4 = new SecurityTransaction(2549, BigDecimal.valueOf(113423), sun, DateConversionUtil.toDate(date4), false);
		
		List<SecurityTransaction> transactionList1 = Arrays.asList(transaction1,transaction2,transaction4);
		List<SecurityTransaction> transactionList2 = Arrays.asList(transaction3,transaction1);
		
		SecurityDepot security_depot_1 = new SecurityDepot(investmentList1, "depotID_sun", "sun", transactionList1);
		SecurityDepot security_depot_2 = new SecurityDepot(investmentList2, "depotID_oracle", "oracle", transactionList2);
		
		List<SecurityDepot> security_depot_list_1 = Arrays.asList(security_depot_1, security_depot_2);
		
		new Customer(null, "asdfkjn", account_list_1, wallet_list_1, security_depot_list_1);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCustomerIDNoneNull() {
		//create cash accounts
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 19, 33, 30);
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);
		LocalDateTime date4 = LocalDateTime.of(2016, 1, 10, 5, 13, 0);
		
		CashPayment normal = new CashPayment(BigDecimal.valueOf(150), "EUR", "DE1111XYZ", "X",
				DateConversionUtil.toDate(date1));
		CashPayment negative = new CashPayment(BigDecimal.valueOf(-40), "EUR", "DE2222XYZ", "X",
				DateConversionUtil.toDate(date2));
		CashPayment big = new CashPayment(BigDecimal.valueOf(10000), "EUR", "DE3333XYZ", "X",
				DateConversionUtil.toDate(date3));

		List<CashPayment> cash_payment_list_1 = Arrays.asList(normal, negative, big);
		List<CashPayment> cash_payment_list_2 = Arrays.asList(normal, negative);
		
		CashAccount account1 = new CashAccount("MrTom", "00001", "Cash Account(EUR)", cash_payment_list_1, BigDecimal.valueOf(2000),"EUR");
		CashAccount account2 = new CashAccount("MrJoe", "00002", "Cash Account(EUR)", cash_payment_list_2, BigDecimal.valueOf(180),"EUR");
		
		List<CashAccount> account_list_1 = Arrays.asList(account1,account2);
		
		//create crypto wallets
		CryptoPayment payment1 = new CryptoPayment(BigDecimal.valueOf(15), "BTC", "DE12345", DateConversionUtil.toDate(date1));
		CryptoPayment payment2 = new CryptoPayment(BigDecimal.valueOf(50), "BTC", "DE23456", DateConversionUtil.toDate(date2));
		CryptoPayment payment3 = new CryptoPayment(BigDecimal.valueOf(-4), "LTC", "DE678910", DateConversionUtil.toDate(date3));
		CryptoPayment payment4 = new CryptoPayment(BigDecimal.valueOf(1000), "LTC", "DE111213", DateConversionUtil.toDate(date4));
		
		List<CryptoPayment> crypto_payment_list_1 = Arrays.asList(payment1, payment2);
		List<CryptoPayment> crypto_payment_list_2 = Arrays.asList(payment3, payment4);
		
		CryptoWallet wallet1 = new CryptoWallet("MrTom", "BTC", "Tom", BigDecimal.valueOf(2000), crypto_payment_list_1);
		CryptoWallet wallet2 = new CryptoWallet("MrJoe", "LTC", "Joe", BigDecimal.valueOf(1000), crypto_payment_list_2);
		
		List<CryptoWallet> wallet_list_1 = Arrays.asList(wallet1,wallet2);
		
		//create security depots
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		Security oracle = new Security("22222","Oracle Corporation","ORACLE");
		
		List<SecurityInvestment> investmentList1 = Arrays.asList(new SecurityInvestment(sun,1110), new SecurityInvestment(sun,0513));
		List<SecurityInvestment> investmentList2 = Arrays.asList(new SecurityInvestment(oracle,85), new SecurityInvestment(oracle,9494));
		
		SecurityTransaction transaction1 = new SecurityTransaction(5713, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1), false);
		SecurityTransaction transaction2 = new SecurityTransaction(23, BigDecimal.valueOf(2341), sun, DateConversionUtil.toDate(date2), false);
		SecurityTransaction transaction3 = new SecurityTransaction(456, BigDecimal.valueOf(2573), sun, DateConversionUtil.toDate(date3), false);
		SecurityTransaction transaction4 = new SecurityTransaction(2549, BigDecimal.valueOf(113423), sun, DateConversionUtil.toDate(date4), false);
		
		List<SecurityTransaction> transactionList1 = Arrays.asList(transaction1,transaction2,transaction4);
		List<SecurityTransaction> transactionList2 = Arrays.asList(transaction3,transaction1);
		
		SecurityDepot security_depot_1 = new SecurityDepot(investmentList1, "depotID_sun", "sun", transactionList1);
		SecurityDepot security_depot_2 = new SecurityDepot(investmentList2, "depotID_oracle", "oracle", transactionList2);
		
		List<SecurityDepot> security_depot_list_1 = Arrays.asList(security_depot_1, security_depot_2);
		
		new Customer("name1", null, account_list_1, wallet_list_1, security_depot_list_1);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCashAccountsNoneNull() {
		//create cash accounts
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 19, 33, 30);
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);
		LocalDateTime date4 = LocalDateTime.of(2016, 1, 10, 5, 13, 0);
		
		//create crypto wallets
		CryptoPayment payment1 = new CryptoPayment(BigDecimal.valueOf(15), "BTC", "DE12345", DateConversionUtil.toDate(date1));
		CryptoPayment payment2 = new CryptoPayment(BigDecimal.valueOf(50), "BTC", "DE23456", DateConversionUtil.toDate(date2));
		CryptoPayment payment3 = new CryptoPayment(BigDecimal.valueOf(-4), "LTC", "DE678910", DateConversionUtil.toDate(date3));
		CryptoPayment payment4 = new CryptoPayment(BigDecimal.valueOf(1000), "LTC", "DE111213", DateConversionUtil.toDate(date4));
		
		List<CryptoPayment> crypto_payment_list_1 = Arrays.asList(payment1, payment2);
		List<CryptoPayment> crypto_payment_list_2 = Arrays.asList(payment3, payment4);
		
		CryptoWallet wallet1 = new CryptoWallet("MrTom", "BTC", "Tom", BigDecimal.valueOf(2000), crypto_payment_list_1);
		CryptoWallet wallet2 = new CryptoWallet("MrJoe", "LTC", "Joe", BigDecimal.valueOf(1000), crypto_payment_list_2);
		
		List<CryptoWallet> wallet_list_1 = Arrays.asList(wallet1,wallet2);
		
		//create security depots
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		Security oracle = new Security("22222","Oracle Corporation","ORACLE");
		
		List<SecurityInvestment> investmentList1 = Arrays.asList(new SecurityInvestment(sun,1110), new SecurityInvestment(sun,0513));
		List<SecurityInvestment> investmentList2 = Arrays.asList(new SecurityInvestment(oracle,85), new SecurityInvestment(oracle,9494));
		
		SecurityTransaction transaction1 = new SecurityTransaction(5713, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1), false);
		SecurityTransaction transaction2 = new SecurityTransaction(23, BigDecimal.valueOf(2341), sun, DateConversionUtil.toDate(date2), false);
		SecurityTransaction transaction3 = new SecurityTransaction(456, BigDecimal.valueOf(2573), sun, DateConversionUtil.toDate(date3), false);
		SecurityTransaction transaction4 = new SecurityTransaction(2549, BigDecimal.valueOf(113423), sun, DateConversionUtil.toDate(date4), false);
		
		List<SecurityTransaction> transactionList1 = Arrays.asList(transaction1,transaction2,transaction4);
		List<SecurityTransaction> transactionList2 = Arrays.asList(transaction3,transaction1);
		
		SecurityDepot security_depot_1 = new SecurityDepot(investmentList1, "depotID_sun", "sun", transactionList1);
		SecurityDepot security_depot_2 = new SecurityDepot(investmentList2, "depotID_oracle", "oracle", transactionList2);
		
		List<SecurityDepot> security_depot_list_1 = Arrays.asList(security_depot_1, security_depot_2);
		
		new Customer("name1", "asdfkjn", null, wallet_list_1, security_depot_list_1);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCryptoWalletsNoneNull() {
		//create cash accounts
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 19, 33, 30);
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);
		LocalDateTime date4 = LocalDateTime.of(2016, 1, 10, 5, 13, 0);
		
		CashPayment normal = new CashPayment(BigDecimal.valueOf(150), "EUR", "DE1111XYZ", "X",
				DateConversionUtil.toDate(date1));
		CashPayment negative = new CashPayment(BigDecimal.valueOf(-40), "EUR", "DE2222XYZ", "X",
				DateConversionUtil.toDate(date2));
		CashPayment big = new CashPayment(BigDecimal.valueOf(10000), "EUR", "DE3333XYZ", "X",
				DateConversionUtil.toDate(date3));
	
		List<CashPayment> cash_payment_list_1 = Arrays.asList(normal, negative, big);
		List<CashPayment> cash_payment_list_2 = Arrays.asList(normal, negative);
		
		CashAccount account1 = new CashAccount("MrTom", "00001", "Cash Account(EUR)", cash_payment_list_1, BigDecimal.valueOf(2000),"EUR");
		CashAccount account2 = new CashAccount("MrJoe", "00002", "Cash Account(EUR)", cash_payment_list_2, BigDecimal.valueOf(180),"EUR");
		
		List<CashAccount> account_list_1 = Arrays.asList(account1,account2);
		
		//create security depots
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		Security oracle = new Security("22222","Oracle Corporation","ORACLE");
		
		List<SecurityInvestment> investmentList1 = Arrays.asList(new SecurityInvestment(sun,1110), new SecurityInvestment(sun,0513));
		List<SecurityInvestment> investmentList2 = Arrays.asList(new SecurityInvestment(oracle,85), new SecurityInvestment(oracle,9494));
		
		SecurityTransaction transaction1 = new SecurityTransaction(5713, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1), false);
		SecurityTransaction transaction2 = new SecurityTransaction(23, BigDecimal.valueOf(2341), sun, DateConversionUtil.toDate(date2), false);
		SecurityTransaction transaction3 = new SecurityTransaction(456, BigDecimal.valueOf(2573), sun, DateConversionUtil.toDate(date3), false);
		SecurityTransaction transaction4 = new SecurityTransaction(2549, BigDecimal.valueOf(113423), sun, DateConversionUtil.toDate(date4), false);
		
		List<SecurityTransaction> transactionList1 = Arrays.asList(transaction1,transaction2,transaction4);
		List<SecurityTransaction> transactionList2 = Arrays.asList(transaction3,transaction1);
		
		SecurityDepot security_depot_1 = new SecurityDepot(investmentList1, "depotID_sun", "sun", transactionList1);
		SecurityDepot security_depot_2 = new SecurityDepot(investmentList2, "depotID_oracle", "oracle", transactionList2);
		
		List<SecurityDepot> security_depot_list_1 = Arrays.asList(security_depot_1, security_depot_2);
		
		new Customer("name1", "asdfkjn", account_list_1, null, security_depot_list_1);
	}
	
	@Test(expected = NullPointerException.class)
	public void testSecurityDepotsNoneNull() {
		//create cash accounts
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 19, 33, 30);
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);
		LocalDateTime date4 = LocalDateTime.of(2016, 1, 10, 5, 13, 0);
		
		CashPayment normal = new CashPayment(BigDecimal.valueOf(150), "EUR", "DE1111XYZ", "X",
				DateConversionUtil.toDate(date1));
		CashPayment negative = new CashPayment(BigDecimal.valueOf(-40), "EUR", "DE2222XYZ", "X",
				DateConversionUtil.toDate(date2));
		CashPayment big = new CashPayment(BigDecimal.valueOf(10000), "EUR", "DE3333XYZ", "X",
				DateConversionUtil.toDate(date3));

		List<CashPayment> cash_payment_list_1 = Arrays.asList(normal, negative, big);
		List<CashPayment> cash_payment_list_2 = Arrays.asList(normal, negative);
		
		CashAccount account1 = new CashAccount("MrTom", "00001", "Cash Account(EUR)", cash_payment_list_1, BigDecimal.valueOf(2000),"EUR");
		CashAccount account2 = new CashAccount("MrJoe", "00002", "Cash Account(EUR)", cash_payment_list_2, BigDecimal.valueOf(180),"EUR");
		
		List<CashAccount> account_list_1 = Arrays.asList(account1,account2);
		
		//create crypto wallets
		CryptoPayment payment1 = new CryptoPayment(BigDecimal.valueOf(15), "BTC", "DE12345", DateConversionUtil.toDate(date1));
		CryptoPayment payment2 = new CryptoPayment(BigDecimal.valueOf(50), "BTC", "DE23456", DateConversionUtil.toDate(date2));
		CryptoPayment payment3 = new CryptoPayment(BigDecimal.valueOf(-4), "LTC", "DE678910", DateConversionUtil.toDate(date3));
		CryptoPayment payment4 = new CryptoPayment(BigDecimal.valueOf(1000), "LTC", "DE111213", DateConversionUtil.toDate(date4));
		
		List<CryptoPayment> crypto_payment_list_1 = Arrays.asList(payment1, payment2);
		List<CryptoPayment> crypto_payment_list_2 = Arrays.asList(payment3, payment4);
		
		CryptoWallet wallet1 = new CryptoWallet("MrTom", "BTC", "Tom", BigDecimal.valueOf(2000), crypto_payment_list_1);
		CryptoWallet wallet2 = new CryptoWallet("MrJoe", "LTC", "Joe", BigDecimal.valueOf(1000), crypto_payment_list_2);
		
		List<CryptoWallet> wallet_list_1 = Arrays.asList(wallet1,wallet2);
		
		new Customer("name1", "asdfkjn", account_list_1, wallet_list_1, null);
	}
	
	
	@Test
	public void testEquals() {
		//create cash accounts
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 19, 33, 30);
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);
		LocalDateTime date4 = LocalDateTime.of(2016, 1, 10, 5, 13, 0);
		
		CashPayment normal = new CashPayment(BigDecimal.valueOf(150), "EUR", "DE1111XYZ", "X",
				DateConversionUtil.toDate(date1));
		CashPayment negative = new CashPayment(BigDecimal.valueOf(-40), "EUR", "DE2222XYZ", "X",
				DateConversionUtil.toDate(date2));
		CashPayment big = new CashPayment(BigDecimal.valueOf(10000), "EUR", "DE3333XYZ", "X",
				DateConversionUtil.toDate(date3));

		List<CashPayment> cash_payment_list_1 = Arrays.asList(normal, negative, big);
		List<CashPayment> cash_payment_list_2 = Arrays.asList(normal, negative);
		
		CashAccount account1 = new CashAccount("MrTom", "00001", "Cash Account(EUR)", cash_payment_list_1, BigDecimal.valueOf(2000),"EUR");
		CashAccount account2 = new CashAccount("MrJoe", "00002", "Cash Account(EUR)", cash_payment_list_2, BigDecimal.valueOf(180),"EUR");
		
		List<CashAccount> account_list_1 = Arrays.asList(account1);
		List<CashAccount> account_list_2 = Arrays.asList(account2);
		
		//create crypto wallets
		CryptoPayment payment1 = new CryptoPayment(BigDecimal.valueOf(15), "BTC", "DE12345", DateConversionUtil.toDate(date1));
		CryptoPayment payment2 = new CryptoPayment(BigDecimal.valueOf(50), "BTC", "DE23456", DateConversionUtil.toDate(date2));
		CryptoPayment payment3 = new CryptoPayment(BigDecimal.valueOf(-4), "LTC", "DE678910", DateConversionUtil.toDate(date3));
		CryptoPayment payment4 = new CryptoPayment(BigDecimal.valueOf(1000), "LTC", "DE111213", DateConversionUtil.toDate(date4));
		
		List<CryptoPayment> crypto_payment_list_1 = Arrays.asList(payment1, payment2);
		List<CryptoPayment> crypto_payment_list_2 = Arrays.asList(payment3, payment4);
		
		CryptoWallet wallet1 = new CryptoWallet("MrTom", "BTC", "Tom", BigDecimal.valueOf(2000), crypto_payment_list_1);
		CryptoWallet wallet2 = new CryptoWallet("MrJoe", "LTC", "Joe", BigDecimal.valueOf(1000), crypto_payment_list_2);
		
		List<CryptoWallet> wallet_list_1 = Arrays.asList(wallet1);
		List<CryptoWallet> wallet_list_2 = Arrays.asList(wallet2);
		
		//create security depots
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		Security oracle = new Security("22222","Oracle Corporation","ORACLE");
		
		List<SecurityInvestment> investmentList1 = Arrays.asList(new SecurityInvestment(sun,1110), new SecurityInvestment(sun,0513));
		List<SecurityInvestment> investmentList2 = Arrays.asList(new SecurityInvestment(oracle,85), new SecurityInvestment(oracle,9494));
		
		SecurityTransaction transaction1 = new SecurityTransaction(5713, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1), false);
		SecurityTransaction transaction2 = new SecurityTransaction(23, BigDecimal.valueOf(2341), sun, DateConversionUtil.toDate(date2), false);
		SecurityTransaction transaction3 = new SecurityTransaction(456, BigDecimal.valueOf(2573), sun, DateConversionUtil.toDate(date3), false);
		SecurityTransaction transaction4 = new SecurityTransaction(2549, BigDecimal.valueOf(113423), sun, DateConversionUtil.toDate(date4), false);
		
		List<SecurityTransaction> transactionList1 = Arrays.asList(transaction1,transaction2,transaction4);
		List<SecurityTransaction> transactionList2 = Arrays.asList(transaction3,transaction1);
		
		SecurityDepot security_depot_1 = new SecurityDepot(investmentList1, "depotID_sun", "sun", transactionList1);
		SecurityDepot security_depot_2 = new SecurityDepot(investmentList2, "depotID_oracle", "oracle", transactionList2);
		
		List<SecurityDepot> security_depot_list_1 = Arrays.asList(security_depot_1);
		List<SecurityDepot> security_depot_list_2 = Arrays.asList(security_depot_2);
		
		Customer target1 = new Customer("name1", "asdfkjn", account_list_1, wallet_list_1, security_depot_list_1);
		Customer target2 = new Customer("name2", "12i3u4n", account_list_2, wallet_list_2, security_depot_list_2);
		
		
		// get resources
		Customer case1 = TestCustomer.getTestResources().get("test_case_1");
		Customer case2 = TestCustomer.getTestResources().get("test_case_2");
		
		String msg = "Error in equals method";
		
		// test equals 
		Assert.assertTrue(msg, case1.equals(case1));
		Assert.assertTrue(msg, case2.equals(case2));
		
		Assert.assertFalse(msg, case1.equals(case2));
		Assert.assertFalse(msg, case2.equals(case1));
		
		Assert.assertFalse(msg, case1.equals(null));
		Assert.assertFalse(msg, case2.equals(null));
		
		Assert.assertTrue(msg, case1.equals(target1));
		Assert.assertTrue(msg, case2.equals(target2));
	}
	
	
	@Test
	public void testHashCode() {
		//create cash accounts
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 19, 33, 30);
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);
		LocalDateTime date4 = LocalDateTime.of(2016, 1, 10, 5, 13, 0);
		
		CashPayment normal = new CashPayment(BigDecimal.valueOf(150), "EUR", "DE1111XYZ", "X",
				DateConversionUtil.toDate(date1));
		CashPayment negative = new CashPayment(BigDecimal.valueOf(-40), "EUR", "DE2222XYZ", "X",
				DateConversionUtil.toDate(date2));
		CashPayment big = new CashPayment(BigDecimal.valueOf(10000), "EUR", "DE3333XYZ", "X",
				DateConversionUtil.toDate(date3));

		List<CashPayment> cash_payment_list_1 = Arrays.asList(normal, negative, big);
		List<CashPayment> cash_payment_list_2 = Arrays.asList(normal, negative);
		
		CashAccount account1 = new CashAccount("MrTom", "00001", "Cash Account(EUR)", cash_payment_list_1, BigDecimal.valueOf(2000),"EUR");
		CashAccount account2 = new CashAccount("MrJoe", "00002", "Cash Account(EUR)", cash_payment_list_2, BigDecimal.valueOf(180),"EUR");
		
		List<CashAccount> account_list_1 = Arrays.asList(account1);
		List<CashAccount> account_list_2 = Arrays.asList(account2);
		
		//create crypto wallets
		CryptoPayment payment1 = new CryptoPayment(BigDecimal.valueOf(15), "BTC", "DE12345", DateConversionUtil.toDate(date1));
		CryptoPayment payment2 = new CryptoPayment(BigDecimal.valueOf(50), "BTC", "DE23456", DateConversionUtil.toDate(date2));
		CryptoPayment payment3 = new CryptoPayment(BigDecimal.valueOf(-4), "LTC", "DE678910", DateConversionUtil.toDate(date3));
		CryptoPayment payment4 = new CryptoPayment(BigDecimal.valueOf(1000), "LTC", "DE111213", DateConversionUtil.toDate(date4));
		
		List<CryptoPayment> crypto_payment_list_1 = Arrays.asList(payment1, payment2);
		List<CryptoPayment> crypto_payment_list_2 = Arrays.asList(payment3, payment4);
		
		CryptoWallet wallet1 = new CryptoWallet("MrTom", "BTC", "Tom", BigDecimal.valueOf(2000), crypto_payment_list_1);
		CryptoWallet wallet2 = new CryptoWallet("MrJoe", "LTC", "Joe", BigDecimal.valueOf(1000), crypto_payment_list_2);
		
		List<CryptoWallet> wallet_list_1 = Arrays.asList(wallet1);
		List<CryptoWallet> wallet_list_2 = Arrays.asList(wallet2);
		
		//create security depots
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		Security oracle = new Security("22222","Oracle Corporation","ORACLE");
		
		List<SecurityInvestment> investmentList1 = Arrays.asList(new SecurityInvestment(sun,1110), new SecurityInvestment(sun,0513));
		List<SecurityInvestment> investmentList2 = Arrays.asList(new SecurityInvestment(oracle,85), new SecurityInvestment(oracle,9494));
		
		SecurityTransaction transaction1 = new SecurityTransaction(5713, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1), false);
		SecurityTransaction transaction2 = new SecurityTransaction(23, BigDecimal.valueOf(2341), sun, DateConversionUtil.toDate(date2), false);
		SecurityTransaction transaction3 = new SecurityTransaction(456, BigDecimal.valueOf(2573), sun, DateConversionUtil.toDate(date3), false);
		SecurityTransaction transaction4 = new SecurityTransaction(2549, BigDecimal.valueOf(113423), sun, DateConversionUtil.toDate(date4), false);
		
		List<SecurityTransaction> transactionList1 = Arrays.asList(transaction1,transaction2,transaction4);
		List<SecurityTransaction> transactionList2 = Arrays.asList(transaction3,transaction1);
		
		SecurityDepot security_depot_1 = new SecurityDepot(investmentList1, "depotID_sun", "sun", transactionList1);
		SecurityDepot security_depot_2 = new SecurityDepot(investmentList2, "depotID_oracle", "oracle", transactionList2);
		
		List<SecurityDepot> security_depot_list_1 = Arrays.asList(security_depot_1);
		List<SecurityDepot> security_depot_list_2 = Arrays.asList(security_depot_2);
		
		Customer target1 = new Customer("name1", "asdfkjn", account_list_1, wallet_list_1, security_depot_list_1);
		Customer target2 = new Customer("name2", "12i3u4n", account_list_2, wallet_list_2, security_depot_list_2);
		
		// get resources
		Map<String, Customer> resources = TestCustomer.getTestResources();
		Customer case1 = resources.get("test_case_1");
		Customer case2 = resources.get("test_case_2");
		
		String msg = "Error in hashcode method";
		
		Assert.assertEquals(msg, case1.hashCode(), case1.hashCode());
		Assert.assertEquals(msg, case1.hashCode(), target1.hashCode());
		
		Assert.assertEquals(msg, case2.hashCode(), case2.hashCode());
		Assert.assertEquals(msg, case2.hashCode(), target2.hashCode());
		
		Assert.assertFalse(msg, case2.hashCode() == case1.hashCode());
	}
}
