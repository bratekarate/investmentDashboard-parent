package org.goetheuni.investmentdashboard.shared.impl;

import org.goetheuni.investmentdashboard.shared.api.IAuthenticationToken;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object of this class encapsulates an authentication token for resty-gwt.
 * If it contains null, the login failed.
 * 
 * JAVADOC DONE
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

	/**
	 * Creates an authentication token container.
	 * 
	 * @param token
	 *            The authentication token or null if the login failed
	 */
	@JsonCreator
	public AuthenticationToken(final @JsonProperty("token") String token) {
		// the token is null if the login was unsuccessful
		this.token = token;
	}

	/**
	 * NOT A PART OF THE API
	 */
	protected AuthenticationToken() {
		// required by GWT
	}
}
