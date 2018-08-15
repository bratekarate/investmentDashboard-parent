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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		AuthenticationToken other = (AuthenticationToken) obj;
		if (token == null) {
			if (other.token != null) {
				return false;
			}
		} else if (!token.equals(other.token)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthenticationToken [token=" + token + "]";
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
