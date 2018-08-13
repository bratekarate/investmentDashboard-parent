package org.goetheuni.investmentdashboard.client.load;

/**
 * Objects with this interface are helper objects for the initial client-server
 * loading process. Each method represents one step in the loading process.
 * 
 * JAVADOC DONE
 */
public interface Loader {

	/**
	 * This method represents the second step of the initial loading process. It
	 * performs parallel and synchronized calls. It retrieves the customer and
	 * market data from the mid-tier.
	 * 
	 * @param customerID
	 *            The customer's ID
	 * @param token
	 *            The token retrieved by the login process.
	 * @param actionAfterLoadingCompleted
	 *            The action, that will be executed, on success.
	 */
	public void loadAndStore(String customerID, String token, Runnable actionAfterLoadingCompleted);

	/**
	 * This method performs the login at the server with the given login
	 * information. It serves demonstration purposes. It represents the first step
	 * of the initial loading process.
	 * 
	 * @param customerID
	 *            The customer's ID
	 * @param passwordInfo
	 *            The customer's password. (In an application with real customers
	 *            this must be a hash)
	 * @param actionAfterLoginAttempt
	 *            The action, that will be executed, on success.
	 * @return A token, if the login was successful. Otherwise null.
	 */
	public void performLoginAndStoreToken(String customerID, String passwordInfo, Runnable actionAfterLoginAttempt);
}
