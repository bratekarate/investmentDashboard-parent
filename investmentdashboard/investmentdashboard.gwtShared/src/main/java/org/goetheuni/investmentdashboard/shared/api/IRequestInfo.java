package org.goetheuni.investmentdashboard.shared.api;

import org.goetheuni.investmentdashboard.shared.impl.AuthenticationToken;
import org.goetheuni.investmentdashboard.shared.impl.CustomerID;

/**
 * Objects with this interface represent information needed for a request at the
 * mid-tier.
 * 
 * JAVADOC DONE
 */
public interface IRequestInfo {

	/**
	 * @return the customerID
	 */
	public CustomerID getCustomerID();

	/**
	 * @return the token
	 */
	public AuthenticationToken getToken();
}
