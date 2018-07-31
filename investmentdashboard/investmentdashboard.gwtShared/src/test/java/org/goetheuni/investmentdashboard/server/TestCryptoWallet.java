package org.goetheuni.investmentdashboard.server;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.goetheuni.investmentdashboard.shared.impl.CryptoPayment;
import org.goetheuni.investmentdashboard.shared.impl.CryptoWallet;

import org.junit.Assert;
import org.junit.Test;


public class TestCryptoWallet {
	private static Map<String, CryptoWallet> getTestResources() {
		Map<String, CryptoWallet> result = new HashMap<>();
		// proper way of defining a date in java
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 19, 33, 30);
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);
		LocalDateTime date4 = LocalDateTime.of(2016, 1, 10, 5, 13, 0);
		
		CryptoPayment payment1 = new CryptoPayment(BigDecimal.valueOf(15), "BTC", "DE12345", DateConversionUtil.toDate(date1));
		CryptoPayment payment2 = new CryptoPayment(BigDecimal.valueOf(50), "BTC", "DE23456", DateConversionUtil.toDate(date2));
		CryptoPayment payment3 = new CryptoPayment(BigDecimal.valueOf(-4), "LTC", "DE678910", DateConversionUtil.toDate(date3));
		CryptoPayment payment4 = new CryptoPayment(BigDecimal.valueOf(1000), "LTC", "DE111213", DateConversionUtil.toDate(date4));
		
		//as mentioned in TestCashAccount that stream is not supported in GWT
		//we can use Arrays.asList to create a list variable quickly
		List<CryptoPayment> paymentList1 = Arrays.asList(payment1, payment2);
		List<CryptoPayment> paymentList2 = Arrays.asList(payment3, payment4);

	      
		CryptoWallet tom_wallet = new CryptoWallet("MrTom", "BTC", "Tom", BigDecimal.valueOf(2000), paymentList1);
		CryptoWallet joe_wallet = new CryptoWallet("MrJoe", "LTC", "Joe", BigDecimal.valueOf(1000), paymentList2);
		result.put("Tom", tom_wallet);
		result.put("Joe", joe_wallet);
		
		return result;
	}
	
	@Test
	public void testGetter() {
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 19, 33, 30);
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);
		LocalDateTime date4 = LocalDateTime.of(2016, 1, 10, 5, 13, 0);
		
		CryptoPayment payment1 = new CryptoPayment(BigDecimal.valueOf(15), "BTC", "DE12345", DateConversionUtil.toDate(date1));
		CryptoPayment payment2 = new CryptoPayment(BigDecimal.valueOf(50), "BTC", "DE23456", DateConversionUtil.toDate(date2));
		CryptoPayment payment3 = new CryptoPayment(BigDecimal.valueOf(-4), "LTC", "DE678910", DateConversionUtil.toDate(date3));
		CryptoPayment payment4 = new CryptoPayment(BigDecimal.valueOf(1000), "LTC", "DE111213", DateConversionUtil.toDate(date4));
		
		//as mentioned in TestCashAccount that stream is not supported in GWT
		//we can use Arrays.asList to create a list variable quickly
		List<CryptoPayment> paymentList1 = Arrays.asList(payment1, payment2);
		List<CryptoPayment> paymentList2 = Arrays.asList(payment3, payment4);
		
		
		// get resources
		CryptoWallet case1 = TestCryptoWallet.getTestResources().get("Tom");
		CryptoWallet case2 = TestCryptoWallet.getTestResources().get("Joe");
		
		Assert.assertEquals("Error in get method", "MrTom", case1.getAccountID());
		Assert.assertEquals("Error in get method", "MrJoe", case2.getAccountID());
		
		Assert.assertEquals("Error in get method", "BTC", case1.getCurrencyCode());
		Assert.assertEquals("Error in get method", "LTC", case2.getCurrencyCode());
		
		Assert.assertEquals("Error in get method", "Tom", case1.getName());
		Assert.assertEquals("Error in get method", "Joe", case2.getName());
		
		Assert.assertEquals("Error in get method", BigDecimal.valueOf(2000), case1.getAccountBalance());
		Assert.assertEquals("Error in get method", BigDecimal.valueOf(1000), case2.getAccountBalance());
		
		Assert.assertEquals("Error in get method", paymentList1, case1.getRecentPayments());
		Assert.assertEquals("Error in get method", paymentList2, case2.getRecentPayments());
	}
	
	//test non null input
	@Test(expected = NullPointerException.class)
	public void testAccountIDNoneNull() {
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		CryptoPayment payment1 = new CryptoPayment(BigDecimal.valueOf(15), "BTC", "DE12345", DateConversionUtil.toDate(date1));
		List<CryptoPayment> paymentList1 = Arrays.asList(payment1);
		new CryptoWallet(null, "BTC", "Tom", BigDecimal.valueOf(2000), paymentList1);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCurrencyCodeNoneNull() {
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		CryptoPayment payment1 = new CryptoPayment(BigDecimal.valueOf(15), "BTC", "DE12345", DateConversionUtil.toDate(date1));
		List<CryptoPayment> paymentList1 = Arrays.asList(payment1);
		new CryptoWallet("MrTom", null, "Tom", BigDecimal.valueOf(2000), paymentList1);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNameNoneNull() {
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		CryptoPayment payment1 = new CryptoPayment(BigDecimal.valueOf(15), "BTC", "DE12345", DateConversionUtil.toDate(date1));
		List<CryptoPayment> paymentList1 = Arrays.asList(payment1);
		new CryptoWallet("MrTom", "BTC", null, BigDecimal.valueOf(2000), paymentList1);
	}
	
	@Test(expected = NullPointerException.class)
	public void testAccountBalanceNoneNull() {
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		CryptoPayment payment1 = new CryptoPayment(BigDecimal.valueOf(15), "BTC", "DE12345", DateConversionUtil.toDate(date1));
		List<CryptoPayment> paymentList1 = Arrays.asList(payment1);
		new CryptoWallet("MrTom", "BTC", "Tom", null, paymentList1);
	}
	
	@Test(expected = NullPointerException.class)
	public void testRecentPaymentsNoneNull() {
		new CryptoWallet("MrTom", "BTC", "Tom", BigDecimal.valueOf(2000), null);
	}
	
	
	//test validate payments
	@Test(expected = IllegalArgumentException.class)
	public void testPaymentsValid() {
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		CryptoPayment payment1 = new CryptoPayment(BigDecimal.valueOf(15), "BTC", "DE12345", DateConversionUtil.toDate(date1));
		List<CryptoPayment> paymentList1 = Arrays.asList(payment1);
		new CryptoWallet("MrTom", "LTC", "Tom", BigDecimal.valueOf(2000), paymentList1);
	}
	
	
	@Test
	public void testEquals() {
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 19, 33, 30);
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);
		LocalDateTime date4 = LocalDateTime.of(2016, 1, 10, 5, 13, 0);
		
		CryptoPayment payment1 = new CryptoPayment(BigDecimal.valueOf(15), "BTC", "DE12345", DateConversionUtil.toDate(date1));
		CryptoPayment payment2 = new CryptoPayment(BigDecimal.valueOf(50), "BTC", "DE23456", DateConversionUtil.toDate(date2));
		CryptoPayment payment3 = new CryptoPayment(BigDecimal.valueOf(-4), "LTC", "DE678910", DateConversionUtil.toDate(date3));
		CryptoPayment payment4 = new CryptoPayment(BigDecimal.valueOf(1000), "LTC", "DE111213", DateConversionUtil.toDate(date4));
		
		//as mentioned in TestCashAccount that stream is not supported in GWT
		//we can use Arrays.asList to create a list variable quickly
		List<CryptoPayment> paymentList1 = Arrays.asList(payment1, payment2);
		List<CryptoPayment> paymentList2 = Arrays.asList(payment3, payment4);
		
		CryptoWallet tom_wallet = new CryptoWallet("MrTom", "BTC", "Tom", BigDecimal.valueOf(2000), paymentList1);
		CryptoWallet joe_wallet = new CryptoWallet("MrJoe", "LTC", "Joe", BigDecimal.valueOf(1000), paymentList2);
		
		
		// get resources
		CryptoWallet case1 = TestCryptoWallet.getTestResources().get("Tom");
		CryptoWallet case2 = TestCryptoWallet.getTestResources().get("Joe");
		
		String msg = "Error in equals method";
		
		// test equals 
		Assert.assertTrue(msg, case1.equals(case1));
		Assert.assertTrue(msg, case2.equals(case2));
		
		Assert.assertFalse(msg, case1.equals(case2));
		Assert.assertFalse(msg, case2.equals(case1));
		
		Assert.assertFalse(msg, case1.equals(null));
		Assert.assertFalse(msg, case2.equals(null));
		
		Assert.assertTrue(msg, case1.equals(tom_wallet));
		Assert.assertTrue(msg, case2.equals(joe_wallet));
	}
	
	
	@Test
	public void testHashCode() {
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 19, 33, 30);
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);
		LocalDateTime date4 = LocalDateTime.of(2016, 1, 10, 5, 13, 0);
		
		CryptoPayment payment1 = new CryptoPayment(BigDecimal.valueOf(15), "BTC", "DE12345", DateConversionUtil.toDate(date1));
		CryptoPayment payment2 = new CryptoPayment(BigDecimal.valueOf(50), "BTC", "DE23456", DateConversionUtil.toDate(date2));
		CryptoPayment payment3 = new CryptoPayment(BigDecimal.valueOf(-4), "LTC", "DE678910", DateConversionUtil.toDate(date3));
		CryptoPayment payment4 = new CryptoPayment(BigDecimal.valueOf(1000), "LTC", "DE111213", DateConversionUtil.toDate(date4));
		
		//as mentioned in TestCashAccount that stream is not supported in GWT
		//we can use Arrays.asList to create a list variable quickly
		List<CryptoPayment> paymentList1 = Arrays.asList(payment1, payment2);
		List<CryptoPayment> paymentList2 = Arrays.asList(payment3, payment4);
		
		CryptoWallet tom_wallet = new CryptoWallet("MrTom", "BTC", "Tom", BigDecimal.valueOf(2000), paymentList1);
		CryptoWallet joe_wallet = new CryptoWallet("MrJoe", "LTC", "Joe", BigDecimal.valueOf(1000), paymentList2);
		
		
		// get resources
		CryptoWallet case1 = TestCryptoWallet.getTestResources().get("Tom");
		CryptoWallet case2 = TestCryptoWallet.getTestResources().get("Joe");
		
		String msg = "Error in hashcode method";
		
		Assert.assertEquals(msg, case1.hashCode(), case1.hashCode());
		Assert.assertEquals(msg, case1.hashCode(), tom_wallet.hashCode());
		
		Assert.assertEquals(msg, case2.hashCode(), case2.hashCode());
		Assert.assertEquals(msg, case2.hashCode(), joe_wallet.hashCode());
		
		Assert.assertFalse(msg, case2.hashCode() == case1.hashCode());
	}
}
