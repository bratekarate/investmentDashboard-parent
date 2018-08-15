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
