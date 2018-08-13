package org.goetheuni.investmentdashboard.server;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.goetheuni.investmentdashboard.shared.impl.CashAccount;
import org.goetheuni.investmentdashboard.shared.impl.CashPayment;
import org.junit.Test;

public class TestCashAccount {

	private static Map<String, CashAccount> getTestResources() {
		Map<String, CashAccount> result = new HashMap<>();

		// create test dates
		LocalDateTime date1 = LocalDateTime.of(2018, 6, 26, 14, 33, 30);
		LocalDateTime date2 = LocalDateTime.of(2017, 6, 26, 14, 33, 30);
		LocalDateTime date3 = LocalDateTime.of(2018, 1, 1, 0, 0, 0);

		// create test payments
		CashPayment normal = new CashPayment(BigDecimal.valueOf(150), "EUR", "DE1111XYZ", "X",
				DateConversionUtil.toDate(date1));
		CashPayment negative = new CashPayment(BigDecimal.valueOf(-40), "EUR", "DE2222XYZ", "X",
				DateConversionUtil.toDate(date2));
		CashPayment big = new CashPayment(BigDecimal.valueOf(10000), "EUR", "DE3333XYZ", "X",
				DateConversionUtil.toDate(date3));

		// fancy way of creating a list from a set of variables
		// Unfortunately streams are not supported in GWT client-side or shared code
		List<CashPayment> tomsPayments = Stream.of(normal, negative, big).collect(Collectors.toList());
		List<CashPayment> joesPayments = Stream.of(normal, negative).collect(Collectors.toList());

		// create test accounts
		CashAccount tom = new CashAccount("MrTom", "00001", "Cash Account(EUR)", tomsPayments, BigDecimal.valueOf(2000),
				"EUR");
		CashAccount joe = new CashAccount("MrJoe", "00002", "Cash Account(EUR)", joesPayments, BigDecimal.valueOf(180),
				"EUR");

		result.put("Tom", tom);
		result.put("Joe", joe);

		return result;

	}

	/**
	 * Represents a test for the CashPayment's getter methods.
	 */
	@Test
	public void testGetter() {
		// get resources
		Map<String, CashAccount> resources = TestCashAccount.getTestResources();

		// get two accounts
		CashAccount tom = resources.get("Tom");
		CashAccount joe = resources.get("Joe");

		// TODO
	}

	// null safety tests

	@Test(expected = RuntimeException.class)
	public void testNullSafetyAccountID() {
		// get resources
		Map<String, CashAccount> resources = TestCashAccount.getTestResources();

		// get two accounts
		CashAccount tom = resources.get("Tom");
		CashAccount joe = resources.get("Joe");

		// TODO
		throw new RuntimeException();
	}

	@Test(expected = RuntimeException.class)
	public void testNullSafetyIban() {
		// get resources
		Map<String, CashAccount> resources = TestCashAccount.getTestResources();

		// get two accounts
		CashAccount tom = resources.get("Tom");
		CashAccount joe = resources.get("Joe");

		// TODO
		throw new RuntimeException();
	}

	@Test(expected = RuntimeException.class)
	public void testNullSafetyName() {
		// get resources
		Map<String, CashAccount> resources = TestCashAccount.getTestResources();

		// get two accounts
		CashAccount tom = resources.get("Tom");
		CashAccount joe = resources.get("Joe");

		// TODO
		throw new RuntimeException();
	}

	@Test(expected = RuntimeException.class)
	public void testNullSafetyRecentPayments() {
		// get resources
		Map<String, CashAccount> resources = TestCashAccount.getTestResources();

		// get two accounts
		CashAccount tom = resources.get("Tom");
		CashAccount joe = resources.get("Joe");

		// TODO
		throw new RuntimeException();
	}
	
	@Test(expected = RuntimeException.class)
	public void testNullSafetyAccountBalance() {
		// get resources
		Map<String, CashAccount> resources = TestCashAccount.getTestResources();

		// get two accounts
		CashAccount tom = resources.get("Tom");
		CashAccount joe = resources.get("Joe");

		// TODO
		throw new RuntimeException();
	}
	
	@Test(expected = RuntimeException.class)
	public void testNullSafetyCurrency() {
		// get resources
		Map<String, CashAccount> resources = TestCashAccount.getTestResources();

		// get two accounts
		CashAccount tom = resources.get("Tom");
		CashAccount joe = resources.get("Joe");

		// TODO
		throw new RuntimeException();
	}

	/**
	 * Tests for the JSON conversion. Does not verify the correctness of results.
	 */
	@Test
	public void testJSON() {
		// get resources
		Map<String, CashAccount> resources = TestCashAccount.getTestResources();

		// get two accounts
		CashAccount tom = resources.get("Tom");
		CashAccount joe = resources.get("Joe");

		// TODO
		
	}

	@Test
	public void testEquals() {
		// get resources
		Map<String, CashAccount> resources = TestCashAccount.getTestResources();

		// get two accounts
		CashAccount tom = resources.get("Tom");
		CashAccount joe = resources.get("Joe");

		// TODO

	}

	@Test
	public void testHashCode() {
		// get resources
		Map<String, CashAccount> resources = TestCashAccount.getTestResources();

		// get two accounts
		CashAccount tom = resources.get("Tom");
		CashAccount joe = resources.get("Joe");

		// TODO

	}

}
