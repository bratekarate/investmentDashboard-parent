package org.goetheuni.investmentdashboard.client.global;

import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;

/**
 * This class provides global methods for the storage of security market data.
 */
public class SecurityMarketDataStorage {

	/**
	 * The stored data.
	 */
	protected static SecurityMarketData data;

	/**
	 * Writes the given data into the storage. The previous data object will be
	 * replaced.
	 * 
	 * @param newData
	 *            The new security market data.
	 */
	public static void put(SecurityMarketData newData) {
		Objects.requireNonNull(newData, "The new security market data must not be null");
		synchronized (data) {
			SecurityMarketDataStorage.data = newData; // put the new data
		}
	}

	/**
	 * Retrieves the stored security market data.
	 * 
	 * @return the stored data.
	 * @throws a
	 *             RuntimeException, if the storage is null.
	 */
	public static SecurityMarketData get() {
		if (SecurityMarketDataStorage.data != null) {
			return SecurityMarketDataStorage.data;
		} else {
			throw new RuntimeException("The security market data at the storage was requested but is null");
		}
	}
}
