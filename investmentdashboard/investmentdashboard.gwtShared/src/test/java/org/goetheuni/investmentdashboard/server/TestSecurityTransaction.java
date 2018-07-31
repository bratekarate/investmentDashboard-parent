package org.goetheuni.investmentdashboard.server;

import java.util.HashMap;
import java.util.Map;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.goetheuni.investmentdashboard.shared.impl.Security;
import org.goetheuni.investmentdashboard.shared.impl.SecurityTransaction;
import org.junit.Assert;
import org.junit.Test;


/**
 * Represents a test suite for the class CashPayment.
 */
public class TestSecurityTransaction {
	private static Map<String, SecurityTransaction> getTestResources() {
		Map<String, SecurityTransaction> result = new HashMap<>();
		//result.put("sun", new SecurityDepot("11111","SUN MicroSystems INC.","SUN Ms"));
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		Security oracle = new Security("22222","Oracle Corporation","ORACLE");
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 14, 33, 30);

		result.put("sun", new SecurityTransaction(1110, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1)));
		result.put("oracle", new SecurityTransaction(7829, BigDecimal.valueOf(150), oracle,DateConversionUtil.toDate(date2)));
		
		return result;
	}

	
	@Test
	public void testGetter() {
		// get resources
		Map<String, SecurityTransaction> resources = TestSecurityTransaction.getTestResources();
		
		SecurityTransaction case1 = resources.get("sun");
		SecurityTransaction case2 = resources.get("oracle");
		
		Assert.assertEquals("Error in get method", 1110, case1.getQuantity());
		Assert.assertEquals("Error in get method", 7829, case2.getQuantity());
		
		Assert.assertEquals("Error in get method", BigDecimal.valueOf(567890), case1.getTotalPrize());
		Assert.assertEquals("Error in get method", BigDecimal.valueOf(150), case2.getTotalPrize());

		Assert.assertEquals("Error in get method", new Security("11111","SUN MicroSystems INC.","SUN Ms"), case1.getSecurity());
		Assert.assertEquals("Error in get method", new Security("22222","Oracle Corporation","ORACLE"), case2.getSecurity());
		
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 14, 33, 30);
		
		Assert.assertEquals("Error in get method", DateConversionUtil.toDate(date1), case1.getDateOfExecution());
		Assert.assertEquals("Error in get method", DateConversionUtil.toDate(date2), case2.getDateOfExecution());
	}
	
	
	//test non null input
	@Test(expected = NullPointerException.class)
	public void testTotalPrizeRequireNoneNull() {
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		new SecurityTransaction(1110, null, sun, DateConversionUtil.toDate(date1));
	}
	
	@Test(expected = NullPointerException.class)
	public void testSecurityRequireNoneNull() {
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		new SecurityTransaction(1110, BigDecimal.valueOf(567890), null, DateConversionUtil.toDate(date1));
	}
	
	@Test(expected = NullPointerException.class)
	public void testDateOfExecutionRequireNoneNull() {
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		new SecurityTransaction(1110, BigDecimal.valueOf(567890), sun, null);
	}
	
	
	//test not negative input
	@Test(expected = IllegalArgumentException.class)
	public void testTotalPrizeNotNegative() {
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		new SecurityTransaction(1110, BigDecimal.valueOf(-400), sun, DateConversionUtil.toDate(date1));
	}
	
	
	@Test
	public void testEquals() {
		SecurityTransaction case1 = TestSecurityTransaction.getTestResources().get("sun");
		SecurityTransaction case2 = TestSecurityTransaction.getTestResources().get("oracle");
		
		String msg = "Error in equals method";
		
		// test equals 
		Assert.assertTrue(msg, case1.equals(case1));
		Assert.assertTrue(msg, case2.equals(case2));
		
		Assert.assertFalse(msg, case1.equals(case2));
		Assert.assertFalse(msg, case2.equals(case1));
		
		Assert.assertFalse(msg, case1.equals(null));
		Assert.assertFalse(msg, case2.equals(null));
		
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		Security oracle = new Security("22222","Oracle Corporation","ORACLE");
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 14, 33, 30);

		Assert.assertTrue(msg, case1.equals(new SecurityTransaction(1110, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1))));
		Assert.assertTrue(msg, case2.equals(new SecurityTransaction(7829, BigDecimal.valueOf(150), oracle, DateConversionUtil.toDate(date2))));
	}
	
	
	@Test
	public void testHashCode() {
		SecurityTransaction case1 = TestSecurityTransaction.getTestResources().get("sun");
		SecurityTransaction case2 = TestSecurityTransaction.getTestResources().get("oracle");
		
		String msg = "Error in hashcode method";
		
		Assert.assertEquals(msg, case1.hashCode(), case1.hashCode());
		Assert.assertEquals(msg, case2.hashCode(), case2.hashCode());
		
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		Security oracle = new Security("22222","Oracle Corporation","ORACLE");
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 14, 33, 30);
		
		Assert.assertEquals(msg, case1.hashCode(), new SecurityTransaction(1110, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1)).hashCode());
		Assert.assertEquals(msg, case2.hashCode(), new SecurityTransaction(7829, BigDecimal.valueOf(150), oracle, DateConversionUtil.toDate(date2)).hashCode());
		
		Assert.assertFalse(msg, case2.hashCode() == case1.hashCode());
	}
	
}