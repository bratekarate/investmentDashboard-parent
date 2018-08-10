package org.goetheuni.investmentdashboard.client.load;

/**
 * Objects with this interface are helper objects for the client-server loading
 * process.
 *
 */
public interface Loader {

	/**
	 * This method loads data from the backend and stores it.
	 */
	public void loadAndStore(String token, Runnable actionAfterLoadingCompleted);

	/**
	 * This method performs the login at the server with the given login
	 * information. It serves demonstration purposes.
	 * 
	 * @param customerID
	 *            The customer's ID
	 * @param passwordInfo
	 *            The customer's password. (In an application with real customers
	 *            this must be a hash)
	 * @param actionAfterLoginAttempt
	 *            The actions after the attempt.
	 * @return A token, if the login was successful. Otherwise null.
	 */
	public void performLoginAndStoreToken(String customerID, String passwordInfo, Runnable actionAfterLoginAttempt);
}
