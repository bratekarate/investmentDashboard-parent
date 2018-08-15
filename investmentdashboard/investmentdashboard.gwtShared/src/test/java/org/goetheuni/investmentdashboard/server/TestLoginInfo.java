package org.goetheuni.investmentdashboard.server;

import java.util.HashMap;
import java.util.Map;

import org.goetheuni.investmentdashboard.shared.impl.LoginInfo;
import org.junit.Assert;
import org.junit.Test;

public class TestLoginInfo {
	private static Map<String, LoginInfo> getTestResources() {
		Map<String, LoginInfo> result = new HashMap<>();
		
		result.put("test_case_1", new LoginInfo("joe_id_34879817234","joe_password_awoeinffi"));
		result.put("test_case_2", new LoginInfo("leo_id_19234709871","leo_password_uibo2345c"));
		
		return result;
	}
	
	@Test
	public void testGetter() {
		// get resources
		Map<String, LoginInfo> resources = TestLoginInfo.getTestResources();
		LoginInfo case1 = resources.get("test_case_1");
		LoginInfo case2 = resources.get("test_case_2");
		
		Assert.assertEquals("Error in get method", "joe_id_34879817234", case1.getCustomerID());
		Assert.assertEquals("Error in get method", "leo_id_19234709871", case2.getCustomerID());
		
		Assert.assertEquals("Error in get method", "joe_password_awoeinffi", case1.getPasswordInfo());
		Assert.assertEquals("Error in get method", "leo_password_uibo2345c", case2.getPasswordInfo());
	}
	
	//test non null input
	@Test(expected = NullPointerException.class)
	public void testCustomerIDNoneNull() {
		new LoginInfo(null,"joe_password_awoeinffi");
	}
	
	@Test(expected = NullPointerException.class)
	public void testPasswordInfoNoneNull() {
		new LoginInfo("joe_id_34879817234",null);
	}
	
}
