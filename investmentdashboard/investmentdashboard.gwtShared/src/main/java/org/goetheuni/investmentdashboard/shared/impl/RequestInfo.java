package org.goetheuni.investmentdashboard.shared.impl;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objects of this class represent information needed for a request at the mid-tier.
 */
public class RequestInfo {
	
	/**
	 * The customer's id
	 */
	protected CustomerID customerID;
	
	/**
	 * The token for authentication
	 */
	protected AuthenticationToken token;

	/**
	 * @return the customerID
	 */
	public CustomerID getCustomerID() {
		return customerID;
	}

	/**
	 * @return the token
	 */
	public AuthenticationToken getToken() {
		return token;
	}
	
	
	@JsonCreator
	public RequestInfo(final @JsonProperty("customerID") CustomerID customerID, final @JsonProperty("token") AuthenticationToken token) {
		this.customerID = Objects.requireNonNull(customerID, "The given customerID must not be null");
		this.token = Objects.requireNonNull(token, "The given authentication token must not be null");
	}

}
