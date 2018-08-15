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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
		result = prime * result + ((passwordInfo == null) ? 0 : passwordInfo.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		LoginInfo other = (LoginInfo) obj;
		if (customerID == null) {
			if (other.customerID != null) {
				return false;
			}
		} else if (!customerID.equals(other.customerID)) {
			return false;
		}
		if (passwordInfo == null) {
			if (other.passwordInfo != null) {
				return false;
			}
		} else if (!passwordInfo.equals(other.passwordInfo)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginInfo [customerID=" + customerID + ", passwordInfo=" + passwordInfo + "]";
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
