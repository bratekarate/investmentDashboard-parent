package org.goetheuni.investmentdashboard.shared.impl;

import org.goetheuni.investmentdashboard.shared.api.IAuthenticationToken;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object of this class encapsulates an authentication token for resty-gwt.
 */
public class AuthenticationToken implements IAuthenticationToken {

	/**
	 * A authentication token or null.
	 */
	protected String token;

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	@JsonCreator
	public AuthenticationToken(final @JsonProperty("token") String token) {
		// the token is null if the login was unsuccessful
		this.token = token;
	}
}
