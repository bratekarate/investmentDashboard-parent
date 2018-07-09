package org.goetheuni.investmentdashboard.server;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.goetheuni.investmentdashboard.shared.impl.CashPayment;
import org.goetheuni.investmentdashboard.shared.impl.Security;
import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * represent a test for the Security class.
 *
 */
public class TestSecurity {

	private static Map<String, Security> getTestResources() {
		Map<String, Security> result = new HashMap<>();
		result.put("sun", new Security("11111","SUN MicroSystems INC.","SUN Ms"));
		result.put("Oracle", new Security("22222","Oracle Corporation","ORACLE"));
		
		return result;
		
		
	}

	@Test
	public void testGetter() {
		// get resources
		Map<String, Security> resources = TestSecurity.getTestResources();
		
		Security sun = resources.get("sun");
		Security oracle = resources.get("Oracle");
		//test getter methode
		Assert.assertEquals("Error in get method","11111", sun.getIsin());
		Assert.assertEquals("Error in get method", "22222", oracle.getIsin());
		Assert.assertEquals("Error in get method", "SUN MicroSystems INC.", sun.getName());
		Assert.assertEquals("Error in get method", "Oracle Corporation", oracle.getName());
		Assert.assertEquals("Error in get method", "SUN Ms", sun.getShortName());
		Assert.assertEquals("Error in get method", "ORACLE", oracle.getShortName());
	}
}
