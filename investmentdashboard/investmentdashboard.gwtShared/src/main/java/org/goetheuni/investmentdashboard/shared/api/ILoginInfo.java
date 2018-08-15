package org.goetheuni.investmentdashboard.shared.api;

/**
 * An object with this interface encapsulates login information.
 */
public interface ILoginInfo {

	/**
	 * @return the customerID
	 */
	public String getCustomerID();

	/**
	 * @return the passwordInfo
	 */
	public String getPasswordInfo();
}
