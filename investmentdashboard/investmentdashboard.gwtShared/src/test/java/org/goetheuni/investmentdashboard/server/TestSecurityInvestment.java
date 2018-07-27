package org.goetheuni.investmentdashboard.server;


import java.util.HashMap;
import java.util.Map;

import org.goetheuni.investmentdashboard.shared.impl.Security;
import org.goetheuni.investmentdashboard.shared.impl.SecurityInvestment;
import org.junit.Assert;
import org.junit.Test;


/**
 * Represents a test suite for the class CashPayment.
 */
public class TestSecurityInvestment {
	private static Map<String, SecurityInvestment> getTestResources() {
		Map<String, SecurityInvestment> result = new HashMap<>();
		//result.put("sun", new SecurityDepot("11111","SUN MicroSystems INC.","SUN Ms"));
		Security sun = new Security("11111","SUN MicroSystems INC.","SUN Ms");
		Security oracle = new Security("22222","Oracle Corporation","ORACLE");
		result.put("sun", new SecurityInvestment(sun,1110));
		result.put("oracle", new SecurityInvestment(oracle,7829));
		return result;
		
		
	}

	@Test
	public void testGetter() {
		// get resources
		Map<String, SecurityInvestment> resources = TestSecurityInvestment.getTestResources();
		
		SecurityInvestment sun = resources.get("sun");
		SecurityInvestment oracle = resources.get("oracle");
		
		//test getter methode
		
		//test getSecurity()
		Assert.assertEquals("Error in get method", new Security("11111","SUN MicroSystems INC.","SUN Ms"), sun.getSecurity());
		Assert.assertEquals("Error in get method", new Security("22222","Oracle Corporation","ORACLE"), oracle.getSecurity());
		
		//test getQuantity()
		Assert.assertEquals("Error in get method", 1110, sun.getQuantity());
		Assert.assertEquals("Error in get method", 7829, oracle.getQuantity());
		
		
	}
	
	//test non null input
	@Test(expected = NullPointerException.class)
	public void testSecurityRequireNoneNull() {
		new SecurityInvestment(null,1);
	}
	
	@Test
	public void testEquals() {
		SecurityInvestment case1 = TestSecurityInvestment.getTestResources().get("sun");
		SecurityInvestment case2 = TestSecurityInvestment.getTestResources().get("oracle");
		
		String msg = "Error in equals method";
		
		// test equals 
		Assert.assertTrue(msg, case1.equals(case1));
		Assert.assertTrue(msg, case2.equals(case2));
		
		Assert.assertFalse(msg, case1.equals(case2));
		Assert.assertFalse(msg, case2.equals(case1));
		
		Assert.assertFalse(msg, case1.equals(null));
		Assert.assertFalse(msg, case2.equals(null));
		
		Assert.assertTrue(msg, case1.equals(new SecurityInvestment(new Security("11111","SUN MicroSystems INC.","SUN Ms"),1110)));
		Assert.assertTrue(msg, case2.equals(new SecurityInvestment(new Security("22222","Oracle Corporation","ORACLE"),7829)));
	}
	
	@Test
	public void testHashCode() {
		SecurityInvestment case1 = TestSecurityInvestment.getTestResources().get("sun");
		SecurityInvestment case2 = TestSecurityInvestment.getTestResources().get("oracle");
		
		String msg = "Error in hashcode method";
		
		Assert.assertEquals(msg, case1.hashCode(), case1.hashCode());
		Assert.assertEquals(msg, case1.hashCode(), new SecurityInvestment(new Security("11111","SUN MicroSystems INC.","SUN Ms"),1110).hashCode());
		
		Assert.assertEquals(msg, case2.hashCode(), case2.hashCode());
		Assert.assertEquals(msg, case2.hashCode(), new SecurityInvestment(new Security("22222","Oracle Corporation","ORACLE"),7829).hashCode());
		
		Assert.assertFalse(msg, case2.hashCode() == case1.hashCode());
	}
	
}


