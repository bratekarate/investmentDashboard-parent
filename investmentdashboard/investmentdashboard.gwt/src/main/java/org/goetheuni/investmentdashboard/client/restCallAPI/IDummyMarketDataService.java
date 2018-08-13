package org.goetheuni.investmentdashboard.client.restCallAPI;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import org.goetheuni.investmentdashboard.shared.ServicePaths;
import org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData;
import org.goetheuni.investmentdashboard.shared.impl.RequestInfo;
import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;

/**
 * This is the client-side interface for services for securities' and crypto asset' market and reference data.
 * 
 * JAVADOC DONE
 */
@Path("/" + ServicePaths.MARKET_DIRECTORY + "/" + ServicePaths.MARKET_DATA_SERVICE)
public interface IDummyMarketDataService extends RestService {

	/**
	 * Asynchronous method for retrieving market and reference data for securities.
	 * 
	 * @param requestInfo
	 *            The customer ID and the authentication token
	 * @param securitiesData
	 *            callback that returns the requested data
	 */
	@POST
	@Path(ServicePaths.SECURITIES_RESOURCE)
	@Produces(MediaType.APPLICATION_JSON)
	public void requestSecurityData(RequestInfo requestInfo, MethodCallback<SecurityMarketData> securitiesData);

	/**
	 * Asynchronous method returning for retrieving market and reference data for crypto assets.
	 * 
	 * @param requestInfo
	 *            The customer ID and the authentication token
	 * @param cryptoData
	 *            callback that returns the requested data
	 */
	@POST
	@Path(ServicePaths.CRYPTO_RESOURCE)
	@Produces(MediaType.APPLICATION_JSON)
	public void requestCryptoData(RequestInfo requestInfo, MethodCallback<CryptoMarketData> cryptoData);
}
