package org.goetheuni.investmentdashboard.client.load;

/**
 * Objects with this interface are helper objects for the client-server loading process.
 *
 */
public interface Loader {

	/**
	 * This method loads data of the backend and stores it.
	 */
	public void loadAndStore(Runnable actionAfterLoadingCompleted);
}
