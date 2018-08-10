package org.goetheuni.investmentdashboard.client.global;

import java.util.Objects;

/**
 * Provides a storage for the authentication token. The token is present after a
 * successful login.
 * 
 * @author UniSven
 *
 */
public class TokenStorage {

	/**
	 * The authentication token after a successful login.
	 */
	protected static String token;

	/**
	 * A method to check whether a token is currently present in the storage.
	 * 
	 * @return true if a token is present, otherwise false
	 */
	public static boolean isPresent() {
		return TokenStorage.token != null;
	}

	/**
	 * Returns the currently stored token.
	 * 
	 * @throws a
	 *             NullPointerException if no token is present
	 * @return
	 */
	public static String get() {
		if (TokenStorage.token != null) {
			// a token is present which is fine
			return TokenStorage.token;
		} else {
			throw new RuntimeException("There is no token present currently");
		}
	}

	/**
	 * Puts the new token into the storage.
	 * 
	 * @param newToken
	 */
	public static void put(String newToken) {
		// no need for synchronization because the browser is single-threaded
		TokenStorage.token = Objects.requireNonNull(newToken, "The given token must not be null");
	}

	/**
	 * Resets the token storage to null.
	 */
	public void reset() {
		TokenStorage.token = null;
	}

}
