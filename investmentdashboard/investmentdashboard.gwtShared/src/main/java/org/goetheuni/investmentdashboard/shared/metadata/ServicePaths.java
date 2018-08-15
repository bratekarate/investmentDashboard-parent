package org.goetheuni.investmentdashboard.shared.metadata;

/**
 * This enumeration contains Strings that are parts of the Rest-Paths. They
 * should be used in the JAX-RS @Path annotation.
 * 
 * JAVA-DOC DONE
 */
public class ServicePaths {

	/*
	 * Identifies the service' directories from the root of the application.
	 */
	public static final String LOGIN_DIRECTORY = "login";

	public static final String MARKET_DIRECTORY = "securitiesmarket";

	public static final String CRYPTOMARKET_DIRECTORY = "cryptomarket";

	public static final String CUSTOMER_DIRECTORY = "customer";

	// identify services in directories services

	public static final String LOGIN_SERVICE = "login";

	public static final String MARKET_DATA_SERVICE = "securitiesmarket";

	public static final String CRYPTOMARKET_DATA_SERVICE = "cryptomarket";

	public static final String CUSTOMER_DATA_SERVICE = "customer";

	// identify resources in services

	public static final String LOGIN_RESOURCE = "login";

	public static final String SECURITIES_RESOURCE = "securitiesmarket";

	public static final String CRYPTO_RESOURCE = "cryptomarket";

	public static final String CUSTOMER_RESOURCE = "data";

}
