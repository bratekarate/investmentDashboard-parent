package org.goetheuni.investmentdashboard.shared;

/**
 * This enumeration contains Strings that are parts of the Rest-Paths. They
 * should be used in the JAX-RS @Path annotation.
 */
public class ServicePaths {

	/**
	 * Identifies the service' directory from the root of the application.
	 */
	public static final String LOGIN_DIRECTORY = "login";

	public static final String MARKET_DIRECTORY = "market";

	public static final String CUSTOMER_DIRECTORY = "customer";

	// services

	public static final String LOGIN_SERVICE = "login";

	public static final String MARKET_DATA_SERVICE = "market";

	public static final String CUSTOMER_DATA_SERVICE = "customer";

	// Strings to identify resources in services

	public static final String LOGIN_RESOURCE = "login";

	public static final String SECURITIES_RESOURCE = "securities";

	public static final String CRYPTO_RESOURCE = "crypto";

	public static final String CUSTOMER_RESOURCE = "data";

}
