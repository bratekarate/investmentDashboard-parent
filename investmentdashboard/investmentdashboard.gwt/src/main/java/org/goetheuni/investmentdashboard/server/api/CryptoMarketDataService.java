package org.goetheuni.investmentdashboard.server.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.goetheuni.investmentdashboard.server.data.DataDummy;
import org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData;
import org.goetheuni.investmentdashboard.shared.impl.RequestInfo;
import org.goetheuni.investmentdashboard.shared.metadata.ServicePaths;

/**
 * This is the server-side implementation of the service for crypto market and
 * reference data.
 * 
 * JAVADOC DONE
 */
@Path(ServicePaths.CRYPTOMARKET_DATA_SERVICE)
public class CryptoMarketDataService {

	/**
	 * Returns the required market and reference data for crypto assets.
	 * 
	 * @param requestInfo
	 *            An authentication token and the customer ID
	 * @return the required market and reference data for crypto assets.
	 */
	@POST
	@Path(ServicePaths.CRYPTO_RESOURCE)
	@Produces(MediaType.APPLICATION_JSON)
	public CryptoMarketData requestCryptoMarketData(RequestInfo requestInfo) {
		// ignore the token as it is a dummy
		return DataDummy.getDummyCrypto();
	}
}
