package org.goetheuni.investmentdashboard.client.global;

import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.impl.Customer;

/**
 * This class provides global methods for the storage of the customer's data.
 * The storage must be filled with data from a rest call. Data is not
 * automatically present. This global storage simplifies the code of
 * microservice-access serialization tremendously.
 * 
 * JAVADOC DONE
 */
public class CustomerDataStorage {

	/**
	 * The stored data.
	 */
	protected static Customer data;

	/**
	 * Writes the given customer data into the storage. The previous data object
	 * will be replaced.
	 * 
	 * @param newData
	 *            The new customer data.
	 */
	public static void put(Customer newData) {
		Objects.requireNonNull(newData, "The new customer data must not be null");
		synchronized (data) {
			CustomerDataStorage.data = newData; // put the new data
		}
	}

	/**
	 * Retrieves the stored customer data.
	 * 
	 * @return the stored customer data.
	 * @throws a
	 *             RuntimeException, if the storage is null.
	 */
	public static Customer get() {
		if (CustomerDataStorage.data != null) {
			return CustomerDataStorage.data;
		} else {
			throw new RuntimeException("The customer data at the storage was requested but is null");
		}
	}
}
