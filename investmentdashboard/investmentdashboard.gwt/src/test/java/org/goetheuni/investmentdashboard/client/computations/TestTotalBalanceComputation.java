package org.goetheuni.investmentdashboard.client.computations;

import java.math.BigDecimal;

import org.goetheuni.investmentdashboard.client.structure.RootStructure;
import org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData;
import org.goetheuni.investmentdashboard.shared.impl.Customer;
import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;
import org.junit.Assert;
import org.junit.Test;

/**
 * A class for tests for the total balance computation.
 */
public class TestTotalBalanceComputation {

	/**
	 * A test for the computation of total balance for a simple customer. This
	 * customer has one depot with 2 security investments 1 crypto wallet and 1 cash
	 * account.
	 * 
	 * The test uses two scenarios. (two different sets of market prizes)
	 */
	@Test
	public void testSimpleCustomer() {
		Customer simpleCustomer = TestResources.getSimpleCustomer();

		SecurityMarketData securityData = TestResources.getDummySecurities();

		CryptoMarketData cryptoData = TestResources.getDummyCrypto();

		/**
		 * cash 500
		 * 
		 * securities (prize * qnty) 
		 * 0001: 6.83 * 45 
		 * 0002: 12.83 * 22 
		 * _________________
		 * 589.61
		 * 
		 * 
		 * crypto investment 
		 * BTC : 4.3 * 1020.45
		 *  ____________________ 
		 *  4387.935
		 * 
		 * total = 5477.545
		 */

		// initialize root structure and compute the value
		RootStructure.initialize(simpleCustomer);

		// perform test
		Assert.assertEquals(new BigDecimal("5477.545"),
				RootStructure.get().computeTotalBalanceInEUR(securityData, cryptoData));
		Assert.assertNotEquals(new BigDecimal("-1"),
				RootStructure.get().computeTotalBalanceInEUR(securityData, cryptoData));

		// perform test with increased security prizes and crypto exchange rates

		// get new data
		SecurityMarketData securityDataBoom = TestResources.getDummySecuritiesBoom();

		CryptoMarketData cryptoDataBoom = TestResources.getDummyCryptoBoom();

		/**
		 * cash 500
		 * 
		 * securities (prize * qnty) 
		 * 0001: 2986.83 * 45 
		 * 0002: 12333.83 * 22
		 * _________________ 
		 * 405751.61
		 * 
		 * 
		 * crypto investment 
		 * BTC : 465.3 * 1020.45 
		 * ____________________ 
		 * 474815.385
		 * 
		 * total = 881066.995
		 */

		// perform test
		Assert.assertEquals(new BigDecimal("881066.995"),
				RootStructure.get().computeTotalBalanceInEUR(securityDataBoom, cryptoDataBoom));
		Assert.assertNotEquals(new BigDecimal("-1"),
				RootStructure.get().computeTotalBalanceInEUR(securityDataBoom, cryptoDataBoom));
	}
	
	@Test
	public void testBlankCustomer() {

		SecurityMarketData securityData = TestResources.getDummySecurities();
		
		CryptoMarketData cryptoData = TestResources.getDummyCrypto();

		// get data after the boom
		SecurityMarketData securityDataBoom = TestResources.getDummySecuritiesBoom();

		CryptoMarketData cryptoDataBoom = TestResources.getDummyCryptoBoom();
		
		// get test customer
		Customer blankCustomer = TestResources.getBlankCustomer();
		
		// perform the tests
		
		// initialize root structure and compute the value
		RootStructure.initialize(blankCustomer);

		// perform test
		Assert.assertEquals(new BigDecimal("0"),
				RootStructure.get().computeTotalBalanceInEUR(securityData, cryptoData));
		Assert.assertNotEquals(new BigDecimal("-1"),
				RootStructure.get().computeTotalBalanceInEUR(securityData, cryptoData));

		// perform test with increased security prizes and crypto exchange rates

		Assert.assertEquals(new BigDecimal("0"),
				RootStructure.get().computeTotalBalanceInEUR(securityDataBoom, cryptoDataBoom));
		Assert.assertNotEquals(new BigDecimal("-1"),
				RootStructure.get().computeTotalBalanceInEUR(securityDataBoom, cryptoDataBoom));
	}
	
	@Test
	public void testExtensiveCustomer() {
	
		SecurityMarketData securityData = TestResources.getDummySecurities();
		
		CryptoMarketData cryptoData = TestResources.getDummyCrypto();

		// get data after the boom
		SecurityMarketData securityDataBoom = TestResources.getDummySecuritiesBoom();

		CryptoMarketData cryptoDataBoom = TestResources.getDummyCryptoBoom();
		
		// get test customer
		Customer extensiveCustomer = TestResources.getExtensiveCustomer();
		
		// perform the tests
				//TODO
	}
}
