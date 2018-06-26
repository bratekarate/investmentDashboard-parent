package org.goetheuni.investmentdashboard.server;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.goetheuni.investmentdashboard.shared.impl.CashPayment;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * Represents a test suite for the class CashPayment.
 */
public class TestCashPayment {

	/**
	 * This method provides test resources for this test.
	 * 
	 * @return A map containing sample payments.
	 */
	private static Map<String, CashPayment> getTestResources() {
		Map<String, CashPayment> result = new HashMap<>();

		// proper way of defining a date in java
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 14, 33, 30);
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);

		// add test payments
		result.put("150EUR",
				new CashPayment(BigDecimal.valueOf(150), "EUR", "DE1111XYZ", DateConversionUtil.toDate(date1)));
		result.put("-40EUR",
				new CashPayment(BigDecimal.valueOf(-40), "EUR", "DE2222XYZ", DateConversionUtil.toDate(date2)));
		result.put("10000EUR",
				new CashPayment(BigDecimal.valueOf(10000), "EUR", "DE3333XYZ", DateConversionUtil.toDate(date3)));

		return result;
	}

	/**
	 * Represents a test for the CashPayment's getter methods.
	 */
	@Test
	public void testGetter() {
		// get resources
		Map<String, CashPayment> resources = TestCashPayment.getTestResources();

		// get two payments
		CashPayment paymentNegative = resources.get("-40EUR");
		CashPayment paymentBig = resources.get("10000EUR");

		// test getter methods
		// for the negative payment
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 14, 33, 30); // date of execution

		Assert.assertEquals("Error in get method", BigDecimal.valueOf(-40), paymentNegative.getAmount());
		Assert.assertEquals("Error in get method", "EUR", paymentNegative.getCurrencyCode());
		Assert.assertEquals("Error in get method", "DE2222XYZ", paymentNegative.getCounterPartyIBAN());
		Assert.assertEquals("Error in get method", DateConversionUtil.toDate(date2),
				paymentNegative.getDateOfExecution());

		// for the big payment
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);

		Assert.assertEquals("Error in get method", BigDecimal.valueOf(10000), paymentBig.getAmount());
		Assert.assertEquals("Error in get method", "EUR", paymentBig.getCurrencyCode());
		Assert.assertEquals("Error in get method", "DE3333XYZ", paymentBig.getCounterPartyIBAN());
		Assert.assertEquals("Error in get method", DateConversionUtil.toDate(date3), paymentBig.getDateOfExecution());
	}

	// null safety tests

	@Test(expected = RuntimeException.class)
	public void testNullSafetyAmount() {
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		new CashPayment(null, "EUR", "DE1111XYZ", DateConversionUtil.toDate(date1));
	}

	@Test(expected = RuntimeException.class)
	public void testNullSafetyCurrencyCode() {
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		new CashPayment(BigDecimal.valueOf(150), null, "DE1111XYZ", DateConversionUtil.toDate(date1));
	}

	@Test(expected = RuntimeException.class)
	public void testNullSafetyCounterPartyIBAN() {
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		new CashPayment(BigDecimal.valueOf(150), "EUR", null, DateConversionUtil.toDate(date1));
	}

	@Test(expected = RuntimeException.class)
	public void testNullSafetyDateOfExecution() {
		new CashPayment(BigDecimal.valueOf(150), "EUR", "DE1111XYZ", null);
	}

	/**
	 * Tests for the JSON conversion. Does not verify the correctness of results.
	 */
	@Test
	public void testJSON() {
		// proper way of defining a date in java
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 14, 33, 30);
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);

		// add test payments
		CashPayment paymentNormal = new CashPayment(BigDecimal.valueOf(150), "EUR", "DE1111XYZ",
				DateConversionUtil.toDate(date1));
		CashPayment paymentNegative = new CashPayment(BigDecimal.valueOf(-40), "EUR", "DE2222XYZ",
				DateConversionUtil.toDate(date2));
		CashPayment paymentBig = new CashPayment(BigDecimal.valueOf(10000), "EUR", "DE3333XYZ",
				DateConversionUtil.toDate(date3));

		// attempt to convert to JSON
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();

		try {
			writer.writeValueAsString(paymentNormal);
		} catch (JsonProcessingException e) {
			Assert.fail(e.toString());
		}

		try {
			writer.writeValueAsString(paymentNegative);
		} catch (JsonProcessingException e) {
			Assert.fail(e.toString());
		}

		try {
			writer.writeValueAsString(paymentBig);
		} catch (JsonProcessingException e) {
			Assert.fail(e.toString());
		}
	}
	
	@Test
	public void testEquals() {
		CashPayment paymentNegative = TestCashPayment.getTestResources().get("-40EUR");
		CashPayment paymentBig = TestCashPayment.getTestResources().get("10000EUR");
		
		String msg = "Error in equals method";
		
		// test equals 
		Assert.assertTrue(msg, paymentNegative.equals(paymentNegative));
		Assert.assertTrue(msg, paymentBig.equals(paymentBig));
		
		Assert.assertFalse(msg, paymentNegative.equals(paymentBig));
		Assert.assertFalse(msg, paymentBig.equals(paymentNegative));
		
		Assert.assertFalse(msg, paymentNegative.equals(null));
		Assert.assertFalse(msg, paymentBig.equals(null));
		
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 14, 33, 30);
		Assert.assertTrue(msg, paymentNegative.equals(new CashPayment(BigDecimal.valueOf(-40), "EUR", "DE2222XYZ", DateConversionUtil.toDate(date2))));
		
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);
		Assert.assertTrue(msg, paymentBig.equals(new CashPayment(BigDecimal.valueOf(10000), "EUR", "DE3333XYZ", DateConversionUtil.toDate(date3))));
		
	}
	
	@Test
	public void testHashCode() {
		CashPayment paymentNegative = TestCashPayment.getTestResources().get("-40EUR");
		CashPayment paymentBig = TestCashPayment.getTestResources().get("10000EUR");
		
		String msg = "Error in hashcode method";
		
		Assert.assertEquals(msg, paymentNegative.hashCode(), paymentNegative.hashCode());
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 14, 33, 30);
		Assert.assertEquals(msg, paymentNegative.hashCode(), new CashPayment(BigDecimal.valueOf(-40), "EUR", "DE2222XYZ", DateConversionUtil.toDate(date2)).hashCode());
		
		Assert.assertEquals(msg, paymentBig.hashCode(), paymentBig.hashCode());
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);
		Assert.assertEquals(msg, paymentBig.hashCode(), new CashPayment(BigDecimal.valueOf(10000), "EUR", "DE3333XYZ", DateConversionUtil.toDate(date3)).hashCode());
		
		Assert.assertFalse(msg, paymentBig.hashCode() == paymentNegative.hashCode());
		
		
	}

}
