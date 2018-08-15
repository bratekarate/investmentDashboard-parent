package org.goetheuni.investmentdashboard.shared.api;

/**
 * An object with this interface encapsulates an authentication token for
 * resty-gwt. If it contains null, the login failed.
 * 
 * JAVADOC DONE
 */
public interface IAuthenticationToken {

	/**
	 * @return the token
	 */
	public String getToken();

}
