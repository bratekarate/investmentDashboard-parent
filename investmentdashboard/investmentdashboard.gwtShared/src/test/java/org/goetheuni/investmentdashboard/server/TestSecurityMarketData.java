package org.goetheuni.investmentdashboard.server;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;
import org.junit.Assert;
import org.junit.Test;

public class TestSecurityMarketData {
	private static Map<String, SecurityMarketData> getTestResources() {
		Map<String, SecurityMarketData> result = new HashMap<>();
		
		Map<String, BigDecimal> marketPrizes1 = new HashMap<>();
		Map<String, BigDecimal> marketPrizes2 = new HashMap<>();
		
		Map<String, BigDecimal> referenceValues1 = new HashMap<>();
		Map<String, BigDecimal> referenceValues2 = new HashMap<>();
		
		LocalDateTime date1 = LocalDateTime.of(2018, 8, 10, 20, 31, 30);
		LocalDateTime date2 = LocalDateTime.of(2018, 8, 9, 5, 32, 30);
		
		marketPrizes1.put("BTC",BigDecimal.valueOf(2093));
		referenceValues1.put("BTC",BigDecimal.valueOf(2000));
		marketPrizes1.put("LTC",BigDecimal.valueOf(35));
		referenceValues1.put("LTC",BigDecimal.valueOf(50));
		
		marketPrizes2.put("LTC",BigDecimal.valueOf(2093));
		referenceValues2.put("LTC",BigDecimal.valueOf(2000));
		marketPrizes2.put("ETH",BigDecimal.valueOf(350));
		referenceValues2.put("ETH",BigDecimal.valueOf(300));
		
		result.put("test_case_1", new SecurityMarketData(marketPrizes1, referenceValues1, DateConversionUtil.toDate(date1)));
		result.put("test_case_2", new SecurityMarketData(marketPrizes2, referenceValues2, DateConversionUtil.toDate(date2)));
		
		return result;
	}
	
	@Test
	public void testGetter() {
		Map<String, BigDecimal> marketPrizes1 = new HashMap<>();
		Map<String, BigDecimal> marketPrizes2 = new HashMap<>();
		
		Map<String, BigDecimal> referenceValues1 = new HashMap<>();
		Map<String, BigDecimal> referenceValues2 = new HashMap<>();
		
		LocalDateTime date1 = LocalDateTime.of(2018, 8, 10, 20, 31, 30);
		LocalDateTime date2 = LocalDateTime.of(2018, 8, 9, 5, 32, 30);
		
		marketPrizes1.put("BTC",BigDecimal.valueOf(2093));
		referenceValues1.put("BTC",BigDecimal.valueOf(2000));
		marketPrizes1.put("LTC",BigDecimal.valueOf(35));
		referenceValues1.put("LTC",BigDecimal.valueOf(50));
		
		marketPrizes2.put("LTC",BigDecimal.valueOf(2093));
		referenceValues2.put("LTC",BigDecimal.valueOf(2000));
		marketPrizes2.put("ETH",BigDecimal.valueOf(350));
		referenceValues2.put("ETH",BigDecimal.valueOf(300));
		
		
		// get resources
		Map<String, SecurityMarketData> resources = TestSecurityMarketData.getTestResources();
		SecurityMarketData case1 = resources.get("test_case_1");
		SecurityMarketData case2 = resources.get("test_case_2");
		
		Assert.assertEquals("Error in get method", marketPrizes1, case1.getMarketPrizes());
		Assert.assertEquals("Error in get method", marketPrizes2, case2.getMarketPrizes());
		
		Assert.assertEquals("Error in get method", referenceValues1, case1.getReferenceValues());
		Assert.assertEquals("Error in get method", referenceValues2, case2.getReferenceValues());
		
		Assert.assertEquals("Error in get method", DateConversionUtil.toDate(date1), case1.getDateAndTime());
		Assert.assertEquals("Error in get method", DateConversionUtil.toDate(date2), case2.getDateAndTime());
	}
	
	
	//test non null input
	@Test(expected = NullPointerException.class)
	public void testExchangeRatesNoneNull() {
		Map<String, BigDecimal> marketPrizes1 = new HashMap<>();
		
		Map<String, BigDecimal> referenceValues1 = new HashMap<>();
		
		LocalDateTime date1 = LocalDateTime.of(2018, 8, 10, 20, 31, 30);
		
		marketPrizes1.put("BTC",BigDecimal.valueOf(2093));
		referenceValues1.put("BTC",BigDecimal.valueOf(2000));
		marketPrizes1.put("LTC",BigDecimal.valueOf(35));
		referenceValues1.put("LTC",BigDecimal.valueOf(50));
		
		new SecurityMarketData(null, referenceValues1, DateConversionUtil.toDate(date1));
	}
	
	@Test(expected = NullPointerException.class)
	public void testReferenceValuesNoneNull() {
		Map<String, BigDecimal> marketPrizes1 = new HashMap<>();
		
		Map<String, BigDecimal> referenceValues1 = new HashMap<>();
		
		LocalDateTime date1 = LocalDateTime.of(2018, 8, 10, 20, 31, 30);
		
		marketPrizes1.put("BTC",BigDecimal.valueOf(2093));
		referenceValues1.put("BTC",BigDecimal.valueOf(2000));
		marketPrizes1.put("LTC",BigDecimal.valueOf(35));
		referenceValues1.put("LTC",BigDecimal.valueOf(50));
		
		new SecurityMarketData(marketPrizes1, null, DateConversionUtil.toDate(date1));
	}
	
	@Test(expected = NullPointerException.class)
	public void testDateAndTimeNoneNull() {
		Map<String, BigDecimal> marketPrizes1 = new HashMap<>();
		Map<String, BigDecimal> referenceValues1 = new HashMap<>();
		
		marketPrizes1.put("BTC",BigDecimal.valueOf(2093));
		referenceValues1.put("BTC",BigDecimal.valueOf(2000));
		marketPrizes1.put("LTC",BigDecimal.valueOf(35));
		referenceValues1.put("LTC",BigDecimal.valueOf(50));
		
		new SecurityMarketData(marketPrizes1, referenceValues1, null);
	}
	
	
	@Test
	public void testEquals() {
		Map<String, BigDecimal> marketPrizes1 = new HashMap<>();
		Map<String, BigDecimal> marketPrizes2 = new HashMap<>();
		
		Map<String, BigDecimal> referenceValues1 = new HashMap<>();
		Map<String, BigDecimal> referenceValues2 = new HashMap<>();
		
		LocalDateTime date1 = LocalDateTime.of(2018, 8, 10, 20, 31, 30);
		LocalDateTime date2 = LocalDateTime.of(2018, 8, 9, 5, 32, 30);
		
		marketPrizes1.put("BTC",BigDecimal.valueOf(2093));
		referenceValues1.put("BTC",BigDecimal.valueOf(2000));
		marketPrizes1.put("LTC",BigDecimal.valueOf(35));
		referenceValues1.put("LTC",BigDecimal.valueOf(50));
		
		marketPrizes2.put("LTC",BigDecimal.valueOf(2093));
		referenceValues2.put("LTC",BigDecimal.valueOf(2000));
		marketPrizes2.put("ETH",BigDecimal.valueOf(350));
		referenceValues2.put("ETH",BigDecimal.valueOf(300));
		
		SecurityMarketData target1 = new SecurityMarketData(marketPrizes1, referenceValues1, DateConversionUtil.toDate(date1));
		SecurityMarketData target2 = new SecurityMarketData(marketPrizes2, referenceValues2, DateConversionUtil.toDate(date2));
		
		// get resources
		Map<String, SecurityMarketData> resources = TestSecurityMarketData.getTestResources();
		SecurityMarketData case1 = resources.get("test_case_1");
		SecurityMarketData case2 = resources.get("test_case_2");
		
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
		Map<String, BigDecimal> marketPrizes1 = new HashMap<>();
		Map<String, BigDecimal> marketPrizes2 = new HashMap<>();
		
		Map<String, BigDecimal> referenceValues1 = new HashMap<>();
		Map<String, BigDecimal> referenceValues2 = new HashMap<>();
		
		LocalDateTime date1 = LocalDateTime.of(2018, 8, 10, 20, 31, 30);
		LocalDateTime date2 = LocalDateTime.of(2018, 8, 9, 5, 32, 30);
		
		marketPrizes1.put("BTC",BigDecimal.valueOf(2093));
		referenceValues1.put("BTC",BigDecimal.valueOf(2000));
		marketPrizes1.put("LTC",BigDecimal.valueOf(35));
		referenceValues1.put("LTC",BigDecimal.valueOf(50));
		
		marketPrizes2.put("LTC",BigDecimal.valueOf(2093));
		referenceValues2.put("LTC",BigDecimal.valueOf(2000));
		marketPrizes2.put("ETH",BigDecimal.valueOf(350));
		referenceValues2.put("ETH",BigDecimal.valueOf(300));
		
		SecurityMarketData target1 = new SecurityMarketData(marketPrizes1, referenceValues1, DateConversionUtil.toDate(date1));
		SecurityMarketData target2 = new SecurityMarketData(marketPrizes2, referenceValues2, DateConversionUtil.toDate(date2));
		
		// get resources
		Map<String, SecurityMarketData> resources = TestSecurityMarketData.getTestResources();
		SecurityMarketData case1 = resources.get("test_case_1");
		SecurityMarketData case2 = resources.get("test_case_2");
		
		String msg = "Error in hashcode method";
		
		Assert.assertEquals(msg, case1.hashCode(), case1.hashCode());
		Assert.assertEquals(msg, case1.hashCode(), target1.hashCode());
		
		Assert.assertEquals(msg, case2.hashCode(), case2.hashCode());
		Assert.assertEquals(msg, case2.hashCode(), target2.hashCode());
		
		Assert.assertFalse(msg, case2.hashCode() == case1.hashCode());
	}
}
