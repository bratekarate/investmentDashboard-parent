package org.goetheuni.investmentdashboard.shared.impl;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objects of this class encapsulate a customerID as String for resty-gwt.
 * 
 * JAVADOC DONE
 */
public class CustomerID {

	/**
	 * The customer's id
	 */
	protected String customerID;

	/**
	 * @return the customerID
	 */
	public String getCustomerID() {
		return customerID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
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
		CustomerID other = (CustomerID) obj;
		if (customerID == null) {
			if (other.customerID != null) {
				return false;
			}
		} else if (!customerID.equals(other.customerID)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerID [customerID=" + customerID + "]";
	}

	/**
	 * Creates a container for the given customer ID.
	 * 
	 * @param customerID
	 *            The customer ID (must not be null)
	 */
	@JsonCreator
	public CustomerID(final @JsonProperty("customerID") String customerID) {
		this.customerID = Objects.requireNonNull(customerID, "The given customerID must not be null");
	}

	/**
	 * NOT A PART OF THE API
	 */
	protected CustomerID() {
		// required by GWT
	}

}
