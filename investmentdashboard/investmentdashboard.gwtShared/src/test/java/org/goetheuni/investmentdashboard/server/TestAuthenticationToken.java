package org.goetheuni.investmentdashboard.server;

import java.util.HashMap;
import java.util.Map;

import org.goetheuni.investmentdashboard.shared.impl.AuthenticationToken;
import org.junit.Assert;
import org.junit.Test;

public class TestAuthenticationToken {	
	//generate test resources
	private static Map<String, AuthenticationToken> getTestResources() {
		Map<String, AuthenticationToken> result = new HashMap<>();
		result.put("test_case_1", new AuthenticationToken("test_token_asdfk@#1jnwkejrniuxc1"));
		result.put("tset_case_2", new AuthenticationToken("test_token_iunoqi3uwbr87bzxocv98"));
		return result;
	}
	
	
	//test get functions
	@Test
	public void testGetter() {
		// get resources
		Map<String, AuthenticationToken> resources = TestAuthenticationToken.getTestResources();
		AuthenticationToken case1 = resources.get("test_case_1");
		AuthenticationToken case2 = resources.get("tset_case_2");
		
		//test getter methode
		Assert.assertEquals("Error in get method", "test_token_asdfk@#1jnwkejrniuxc1", case1.getToken());
		Assert.assertEquals("Error in get method", "test_token_iunoqi3uwbr87bzxocv98", case2.getToken());		
	}
}


