package org.goetheuni.investmentdashboard.client.global;

import java.util.Objects;

/**
 * Provides a storage for the customerID. The ID is set after a successful
 * login.
 *
 * JAVADOC DONE
 */
public class CustomerIDStorage {

	/**
	 * The customer's ID after a successful login.
	 */
	protected static String customerID;

	/**
	 * A method to check whether a customer id is currently present at the storage.
	 * 
	 * @return true if an ID is present, otherwise false
	 */
	public static boolean isPresent() {
		return CustomerIDStorage.customerID != null;
	}

	/**
	 * Returns the currently stored customerID.
	 * 
	 * @throws a
	 *             NullPointerException if no ID is present
	 * @return
	 */
	public static String get() {
		if (CustomerIDStorage.customerID != null) {
			// an ID is present which is fine
			return CustomerIDStorage.customerID;
		} else {
			throw new RuntimeException("There is no customer id present currently");
		}
	}

	/**
	 * Puts the customerID into the storage.
	 * 
	 * @param newCustomerID
	 */
	public static void put(String newCustomerID) {
		// no need for synchronization because the browser is single-threaded
		CustomerIDStorage.customerID = Objects.requireNonNull(newCustomerID, "The given customer id must not be null");
	}

	/**
	 * Resets the customer ID storage to null.
	 */
	public void reset() {
		CustomerIDStorage.customerID = null;
	}

}
