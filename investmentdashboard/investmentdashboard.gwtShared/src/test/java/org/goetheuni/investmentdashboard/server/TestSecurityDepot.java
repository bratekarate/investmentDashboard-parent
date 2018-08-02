package org.goetheuni.investmentdashboard.server;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.goetheuni.investmentdashboard.shared.impl.Security;
import org.goetheuni.investmentdashboard.shared.impl.SecurityDepot;
import org.goetheuni.investmentdashboard.shared.impl.SecurityInvestment;
import org.goetheuni.investmentdashboard.shared.impl.SecurityTransaction;
import org.junit.Assert;
import org.junit.Test;


/**
 * Represents a test suite for the class CashPayment.
 */
public class TestSecurityDepot {
	private static Map<String, SecurityDepot> getTestResources() {
		Map<String, SecurityDepot> result = new HashMap<>();
		
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		Security oracle = new Security("22222","Oracle Corporation","ORACLE");
		
		List<SecurityInvestment> investmentList1 = Arrays.asList(new SecurityInvestment(sun,1110), new SecurityInvestment(sun,0513));
		List<SecurityInvestment> investmentList2 = Arrays.asList(new SecurityInvestment(oracle,85), new SecurityInvestment(oracle,9494));
		
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 7, 29, 17, 15, 15);
		LocalDateTime date3 = LocalDateTime.of(2015, 12, 3, 10, 28, 00);
		LocalDateTime date4 = LocalDateTime.of(2016, 1, 10, 8, 30, 45);
		
		SecurityTransaction transaction1 = new SecurityTransaction(5713, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1), false);
		SecurityTransaction transaction2 = new SecurityTransaction(23, BigDecimal.valueOf(2341), sun, DateConversionUtil.toDate(date2), false);
		SecurityTransaction transaction3 = new SecurityTransaction(456, BigDecimal.valueOf(2573), sun, DateConversionUtil.toDate(date3), false);
		SecurityTransaction transaction4 = new SecurityTransaction(2549, BigDecimal.valueOf(113423), sun, DateConversionUtil.toDate(date4), false);
		
		List<SecurityTransaction> transactionList1 = Arrays.asList(transaction1,transaction2,transaction4);
		List<SecurityTransaction> transactionList2 = Arrays.asList(transaction3,transaction1);
		
		result.put("sun", new SecurityDepot(investmentList1, "depotID_sun", "sun", transactionList1));
		result.put("oracle", new SecurityDepot(investmentList2, "depotID_oracle", "oracle", transactionList2));
		
		return result;
		
		
	}

	@Test
	public void testGetter() {
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		Security oracle = new Security("22222","Oracle Corporation","ORACLE");
		
		List<SecurityInvestment> investmentList1 = Arrays.asList(new SecurityInvestment(sun,1110), new SecurityInvestment(sun,0513));
		List<SecurityInvestment> investmentList2 = Arrays.asList(new SecurityInvestment(oracle,85), new SecurityInvestment(oracle,9494));
		
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 7, 29, 17, 15, 15);
		LocalDateTime date3 = LocalDateTime.of(2015, 12, 3, 10, 28, 00);
		LocalDateTime date4 = LocalDateTime.of(2016, 1, 10, 8, 30, 45);
		
		SecurityTransaction transaction1 = new SecurityTransaction(5713, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1), false);
		SecurityTransaction transaction2 = new SecurityTransaction(23, BigDecimal.valueOf(2341), sun, DateConversionUtil.toDate(date2), false);
		SecurityTransaction transaction3 = new SecurityTransaction(456, BigDecimal.valueOf(2573), sun, DateConversionUtil.toDate(date3), false);
		SecurityTransaction transaction4 = new SecurityTransaction(2549, BigDecimal.valueOf(113423), sun, DateConversionUtil.toDate(date4), false);
		
		List<SecurityTransaction> transactionList1 = Arrays.asList(transaction1,transaction2,transaction4);
		List<SecurityTransaction> transactionList2 = Arrays.asList(transaction3,transaction1);
		
		// get resources
		Map<String, SecurityDepot> resources = TestSecurityDepot.getTestResources();
				
		SecurityDepot depotToTest1 = resources.get("sun");
		SecurityDepot depotToTest2 = resources.get("oracle");
				
		//test getter methode
		Assert.assertEquals("Error in get method", investmentList1, depotToTest1.getPortfolio());
		Assert.assertEquals("Error in get method", investmentList2, depotToTest2.getPortfolio());
		
		Assert.assertEquals("Error in get method", "depotID_sun", depotToTest1.getDepotID());
		Assert.assertEquals("Error in get method", "depotID_oracle", depotToTest2.getDepotID());
		
		Assert.assertEquals("Error in get method", "sun", depotToTest1.getName());
		Assert.assertEquals("Error in get method", "oracle", depotToTest2.getName());
		
		Assert.assertEquals("Error in get method", transactionList1, depotToTest1.getRecentTransactions());
		Assert.assertEquals("Error in get method", transactionList2, depotToTest2.getRecentTransactions());
		

	}
	
	
	//test non null input
	@Test(expected = NullPointerException.class)
	public void testPortFolioNoneNull() {
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		//List<SecurityInvestment> investmentList1 = Arrays.asList(new SecurityInvestment(sun,1110), new SecurityInvestment(sun,0513));
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		SecurityTransaction transaction1 = new SecurityTransaction(5713, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1), false);
		List<SecurityTransaction> transactionList1 = Arrays.asList(transaction1);
		
		new SecurityDepot(null, "depotID_sun", "sun", transactionList1);
	}
	
	@Test(expected = NullPointerException.class)
	public void testDepotIDNoneNull() {
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		List<SecurityInvestment> investmentList1 = Arrays.asList(new SecurityInvestment(sun,1110), new SecurityInvestment(sun,0513));
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		SecurityTransaction transaction1 = new SecurityTransaction(5713, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1), false);
		List<SecurityTransaction> transactionList1 = Arrays.asList(transaction1);
		
		new SecurityDepot(investmentList1, null, "sun", transactionList1);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNameNoneNull() {
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		List<SecurityInvestment> investmentList1 = Arrays.asList(new SecurityInvestment(sun,1110), new SecurityInvestment(sun,0513));
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		SecurityTransaction transaction1 = new SecurityTransaction(5713, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1), false);
		List<SecurityTransaction> transactionList1 = Arrays.asList(transaction1);
		
		new SecurityDepot(investmentList1, "depotID_sun", null, transactionList1);
	}
	
	@Test(expected = NullPointerException.class)
	public void testRecentTrasactionsNoneNull() {
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		List<SecurityInvestment> investmentList1 = Arrays.asList(new SecurityInvestment(sun,1110), new SecurityInvestment(sun,0513));
		//LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		//SecurityTransaction transaction1 = new SecurityTransaction(5713, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1));
		//List<SecurityTransaction> transactionList1 = Arrays.asList(transaction1);
		
		new SecurityDepot(investmentList1, "depotID_sun", "sun", null);
	}
	
	@Test(expected = NullPointerException.class)
	public void testReferenceValueNoneNull() {
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		List<SecurityInvestment> investmentList1 = Arrays.asList(new SecurityInvestment(sun,1110), new SecurityInvestment(sun,0513));
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		SecurityTransaction transaction1 = new SecurityTransaction(5713, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1), false);
		List<SecurityTransaction> transactionList1 = Arrays.asList(transaction1);
		
		new SecurityDepot(investmentList1, "depotID_sun", "sun", transactionList1);
	}
	
	
	@Test
	public void testEquals() {
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		Security oracle = new Security("22222","Oracle Corporation","ORACLE");
		
		List<SecurityInvestment> investmentList1 = Arrays.asList(new SecurityInvestment(sun,1110), new SecurityInvestment(sun,0513));
		List<SecurityInvestment> investmentList2 = Arrays.asList(new SecurityInvestment(oracle,85), new SecurityInvestment(oracle,9494));
		
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 7, 29, 17, 15, 15);
		LocalDateTime date3 = LocalDateTime.of(2015, 12, 3, 10, 28, 00);
		LocalDateTime date4 = LocalDateTime.of(2016, 1, 10, 8, 30, 45);
		
		SecurityTransaction transaction1 = new SecurityTransaction(5713, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1), false);
		SecurityTransaction transaction2 = new SecurityTransaction(23, BigDecimal.valueOf(2341), sun, DateConversionUtil.toDate(date2), false);
		SecurityTransaction transaction3 = new SecurityTransaction(456, BigDecimal.valueOf(2573), sun, DateConversionUtil.toDate(date3), false);
		SecurityTransaction transaction4 = new SecurityTransaction(2549, BigDecimal.valueOf(113423), sun, DateConversionUtil.toDate(date4), false);
		
		List<SecurityTransaction> transactionList1 = Arrays.asList(transaction1,transaction2,transaction4);
		List<SecurityTransaction> transactionList2 = Arrays.asList(transaction3,transaction1);
		
		SecurityDepot referenceDepot1 = new SecurityDepot(investmentList1, "depotID_sun", "sun", transactionList1);
		SecurityDepot referenceDepot2 = new SecurityDepot(investmentList2, "depotID_oracle", "oracle", transactionList2);
		
		// get resources
		Map<String, SecurityDepot> resources = TestSecurityDepot.getTestResources();
				
		SecurityDepot case1 = resources.get("sun");
		SecurityDepot case2 = resources.get("oracle");
		
		String msg = "Error in equals method";
		
		// test equals 
		Assert.assertTrue(msg, case1.equals(case1));
		Assert.assertTrue(msg, case2.equals(case2));
		
		Assert.assertFalse(msg, case1.equals(case2));
		Assert.assertFalse(msg, case2.equals(case1));
		
		Assert.assertFalse(msg, case1.equals(null));
		Assert.assertFalse(msg, case2.equals(null));
		
		
		Assert.assertTrue(msg, case1.equals(referenceDepot1));
		Assert.assertTrue(msg, case2.equals(referenceDepot2));
	}
	
	
	@Test
	public void testHashCode() {
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		Security oracle = new Security("22222","Oracle Corporation","ORACLE");
		
		List<SecurityInvestment> investmentList1 = Arrays.asList(new SecurityInvestment(sun,1110), new SecurityInvestment(sun,0513));
		List<SecurityInvestment> investmentList2 = Arrays.asList(new SecurityInvestment(oracle,85), new SecurityInvestment(oracle,9494));
		
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 7, 29, 17, 15, 15);
		LocalDateTime date3 = LocalDateTime.of(2015, 12, 3, 10, 28, 00);
		LocalDateTime date4 = LocalDateTime.of(2016, 1, 10, 8, 30, 45);
		
		SecurityTransaction transaction1 = new SecurityTransaction(5713, BigDecimal.valueOf(567890), sun, DateConversionUtil.toDate(date1), false);
		SecurityTransaction transaction2 = new SecurityTransaction(23, BigDecimal.valueOf(2341), sun, DateConversionUtil.toDate(date2), false);
		SecurityTransaction transaction3 = new SecurityTransaction(456, BigDecimal.valueOf(2573), sun, DateConversionUtil.toDate(date3), false);
		SecurityTransaction transaction4 = new SecurityTransaction(2549, BigDecimal.valueOf(113423), sun, DateConversionUtil.toDate(date4), false);
		
		List<SecurityTransaction> transactionList1 = Arrays.asList(transaction1,transaction2,transaction4);
		List<SecurityTransaction> transactionList2 = Arrays.asList(transaction3,transaction1);
		
		SecurityDepot referenceDepot1 = new SecurityDepot(investmentList1, "depotID_sun", "sun", transactionList1);
		SecurityDepot referenceDepot2 = new SecurityDepot(investmentList2, "depotID_oracle", "oracle", transactionList2);
		
		
		// get resources
		Map<String, SecurityDepot> resources = TestSecurityDepot.getTestResources();
				
		SecurityDepot case1 = resources.get("sun");
		SecurityDepot case2 = resources.get("oracle");
		
		String msg = "Error in hashcode method";
		
		Assert.assertEquals(msg, case1.hashCode(), case1.hashCode());
		Assert.assertEquals(msg, case2.hashCode(), case2.hashCode());
		
		
		Assert.assertEquals(msg, case1.hashCode(), referenceDepot1.hashCode());
		Assert.assertEquals(msg, case2.hashCode(), referenceDepot2.hashCode());
		
		Assert.assertFalse(msg, case2.hashCode() == case1.hashCode());
	}
	
			
}
