package org.goetheuni.investmentdashboard.server;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.goetheuni.investmentdashboard.shared.impl.CashPayment;
import org.goetheuni.investmentdashboard.shared.impl.CryptoPayment;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class TestCryptoPayment {
	private static Map<String, CryptoPayment> getTestResources() {
		Map<String, CryptoPayment> result = new HashMap<>();

		// proper way of defining a date in java
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 19, 33, 30);
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);

		// add test payments
		result.put("15BTC",
				new CryptoPayment(BigDecimal.valueOf(15), "BTC", "DE12345", DateConversionUtil.toDate(date1)));
		result.put("-4XRP",
				new CryptoPayment(BigDecimal.valueOf(-4), "XRP", "DE678910", DateConversionUtil.toDate(date2)));
		result.put("1000LTC",
				new CryptoPayment(BigDecimal.valueOf(1000), "LTC", "DE111213", DateConversionUtil.toDate(date3)));

		return result;
			}
	
 
public void testGetter() {
	// get resources
	Map<String, CryptoPayment> resources = TestCryptoPayment.getTestResources();

	// get two payments
	CryptoPayment paymentXRP = resources.get("-4XRP");
	CryptoPayment paymentLitecoin = resources.get("1000LTC");

	// test getter methods
	// for the negative payment
	LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 19, 33, 30); // date of execution

	Assert.assertEquals("Error in get method", BigDecimal.valueOf(-4), paymentXRP.getAmount());
	Assert.assertEquals("Error in get method", "XRP", paymentXRP.getCurrencyCode());
	Assert.assertEquals("Error in get method", "DE678910", paymentXRP.getCounterPartyAddress());
	Assert.assertEquals("Error in get method", DateConversionUtil.toDate(date2),paymentXRP.getDateOfExecution());

	// for the big payment
	LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);

	Assert.assertEquals("Error in get method", BigDecimal.valueOf(1000), paymentLitecoin.getAmount());
	Assert.assertEquals("Error in get method", "LTC", paymentLitecoin.getCurrencyCode());
	Assert.assertEquals("Error in get method", "DE111213", paymentLitecoin.getCounterPartyAddress());
	Assert.assertEquals("Error in get method", DateConversionUtil.toDate(date3), paymentLitecoin.getDateOfExecution());
			}

//null safety tests

	@Test(expected = RuntimeException.class)
	public void testNullSafetyAmount() {
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		new CryptoPayment(null, "BTC", "DE12345", DateConversionUtil.toDate(date1));
	}

	@Test(expected = RuntimeException.class)
	public void testNullSafetyCurrencyCode() {
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		new CashPayment(BigDecimal.valueOf(15), null, "DE12345", DateConversionUtil.toDate(date1));
	}

	@Test(expected = RuntimeException.class)
	public void testNullSafetyCounterPartyIBAN() {
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		new CashPayment(BigDecimal.valueOf(15), "BTC", null, DateConversionUtil.toDate(date1));
	}

	@Test(expected = RuntimeException.class)
	public void testNullSafetyDateOfExecution() {
		new CashPayment(BigDecimal.valueOf(15), "BTC", "DE12345", null);
	}

	/**
	 * Tests for the JSON conversion. Does not verify the correctness of results.
	 */
	@Test
	public void testJSON() {
		// proper way of defining a date in java
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 28, 20, 31, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 19, 33, 30);
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);

		// add test payments
		CryptoPayment paymentBTC = new CryptoPayment(BigDecimal.valueOf(15), "BTC", "DE12345",
				DateConversionUtil.toDate(date1));
		CryptoPayment paymentXRP = new CryptoPayment(BigDecimal.valueOf(-4), "XRP", "DE678910",
				DateConversionUtil.toDate(date2));
		CryptoPayment paymentLitecoin = new CryptoPayment(BigDecimal.valueOf(1000), "LTC", "DE111213",
				DateConversionUtil.toDate(date3));

		// attempt to convert to JSON
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();

		try {
			writer.writeValueAsString(paymentBTC);
		} catch (JsonProcessingException e) {
			Assert.fail(e.toString());
		}

		try {
			writer.writeValueAsString(paymentXRP);
		} catch (JsonProcessingException e) {
			Assert.fail(e.toString());
		}

		try {
			writer.writeValueAsString(paymentLitecoin);
		} catch (JsonProcessingException e) {
			Assert.fail(e.toString());
		}
		
	}
	@Test
	public void testEquals() {
		CryptoPayment paymentXRP = TestCryptoPayment.getTestResources().get("-4XRP");
		CryptoPayment paymentLitecoin = TestCryptoPayment.getTestResources().get("1000LTC");
		
		String msg = "Error in equals method";
		
		// test equals 
		Assert.assertTrue(msg, paymentXRP.equals(paymentXRP));
		Assert.assertTrue(msg, paymentLitecoin.equals(paymentLitecoin));
		
		Assert.assertFalse(msg, paymentXRP.equals(paymentLitecoin));
		Assert.assertFalse(msg, paymentLitecoin.equals(paymentXRP));
		
		Assert.assertFalse(msg, paymentXRP.equals(null));
		Assert.assertFalse(msg, paymentLitecoin.equals(null));
		
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 19, 33, 30);
		Assert.assertTrue(msg, paymentXRP.equals(new CryptoPayment(BigDecimal.valueOf(-4), "XRP", "DE678910", DateConversionUtil.toDate(date2))));
		
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);
		Assert.assertTrue(msg, paymentLitecoin.equals(new CryptoPayment(BigDecimal.valueOf(1000), "LTC", "DE111213", DateConversionUtil.toDate(date3))));
		
	}
	
	@Test
	public void testHashCode() {
		CryptoPayment paymentXRP = TestCryptoPayment.getTestResources().get("-4XRP");
		CryptoPayment paymentLitecoin = TestCryptoPayment.getTestResources().get("1000LTC");
		
		String msg = "Error in hashcode method";
		
		Assert.assertEquals(msg, paymentXRP.hashCode(), paymentXRP.hashCode());
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 19, 33, 30);
		Assert.assertEquals(msg, paymentXRP.hashCode(), new CryptoPayment(BigDecimal.valueOf(-4), "XRP", "DE678910", DateConversionUtil.toDate(date2)).hashCode());
		
		Assert.assertEquals(msg, paymentLitecoin.hashCode(), paymentLitecoin.hashCode());
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);
		Assert.assertEquals(msg, paymentLitecoin.hashCode(), new CryptoPayment(BigDecimal.valueOf(1000), "LTC", "DE111213", DateConversionUtil.toDate(date3)).hashCode());
		
		Assert.assertFalse(msg, paymentLitecoin.hashCode() == paymentXRP.hashCode());
		
		
	}

}

