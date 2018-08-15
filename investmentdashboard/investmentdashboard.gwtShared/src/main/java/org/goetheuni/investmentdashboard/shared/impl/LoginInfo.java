package org.goetheuni.investmentdashboard.shared.impl;

import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.api.ILoginInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object of this class encapsulates login information.
 * 
 * JAVADOC DONE
 */
public class LoginInfo implements ILoginInfo {

	/**
	 * Represents the customer's ID.
	 */
	protected String customerID;

	/**
	 * Represents the password info. Should be a hash in an application with real
	 * customers.
	 */
	protected String passwordInfo;

	/**
	 * @return the customerID
	 */
	public String getCustomerID() {
		return customerID;
	}

	/**
	 * @return the passwordInfo
	 */
	public String getPasswordInfo() {
		return passwordInfo;
	}

	/**
	 * Creates a shared object for the login process.
	 * 
	 * @param customerID
	 *            Represents the customer's ID. (Must be non-null)
	 * @param passwordInfo
	 *            Represents the password info. (Must be non-null)
	 */
	@JsonCreator
	public LoginInfo(final @JsonProperty("customerID") String customerID,
			final @JsonProperty("passwordInfo") String passwordInfo) {
		this.customerID = Objects.requireNonNull(customerID, "The given customer ID must not be null");
		this.passwordInfo = Objects.requireNonNull(passwordInfo, "The given password info must not be null");
	}

	/**
	 * NOT A PART OF THE API
	 */
	protected LoginInfo() {
		// required by GWT
	}
}
