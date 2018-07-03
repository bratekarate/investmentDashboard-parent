package org.goetheuni.investmentdashboard.client.global;

import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData;


/**
 * This class provides global methods to store crypto market data.
 */
public class CryptoMarketDataStorage {

	/**
	 * The stored data.
	 */
	protected static CryptoMarketData data;
	
	/**
	 * Writes the given data into the storage.
	 * The previous data object will be replaced.
	 * @param newData The new crypto market data.
	 */
	public static void put(CryptoMarketData newData) {
		Objects.requireNonNull(newData, "The new security market data must not be null");
		synchronized (data) {
			CryptoMarketDataStorage.data = newData; // put the new data 
		}
	}
	
	/**
	 * Retrieves the stored crypto market data.
	 * @return the stored data.
	 * @throws a RuntimeException, if the storage is null.
	 */
	public static CryptoMarketData get() {
		if(CryptoMarketDataStorage.data != null) {
			return CryptoMarketDataStorage.data;
		}else {
			throw new RuntimeException("The crypto market data at the storage was requested but is null");
		}
	}
}
