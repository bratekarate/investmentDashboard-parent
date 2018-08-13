package org.goetheuni.investmentdashboard.server.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.goetheuni.investmentdashboard.server.data.DataDummy;
import org.goetheuni.investmentdashboard.shared.ServicePaths;
import org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData;
import org.goetheuni.investmentdashboard.shared.impl.RequestInfo;
import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;

/**
 * This is the server-side implementation of the service for market data.
 * 
 */
@Path(ServicePaths.MARKET_DATA_SERVICE)
public class MarketDataService {

	/**
	 * Returns sample data for the security market.
	 * 
	 * @param token
	 * @return a sample for security market data.
	 */
	@POST
	@Path(ServicePaths.SECURITIES_RESOURCE)
	@Produces(MediaType.APPLICATION_JSON)
	public SecurityMarketData requestSecurityMarketData(RequestInfo requestInfo) {
		// ignore the token as it is a dummy
		return DataDummy.getDummySecurities();
	}

	/**
	 * Returns sample data for the crypto market.
	 * 
	 * @param token
	 * @return a sample for crypto market data.
	 */
	@POST
	@Path(ServicePaths.CRYPTO_RESOURCE)
	@Produces(MediaType.APPLICATION_JSON)
	public CryptoMarketData requestCryptoMarketData(RequestInfo requestInfo) {
		// ignore the token as it is a dummy
		return DataDummy.getDummyCrypto();
	}
}
