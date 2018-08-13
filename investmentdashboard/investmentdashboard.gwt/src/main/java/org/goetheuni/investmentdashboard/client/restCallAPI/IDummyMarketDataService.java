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
 * 
 * This is the client-side interface of the market data service.
 */
@Path("/" + ServicePaths.MARKET_DIRECTORY + "/" + ServicePaths.MARKET_DATA_SERVICE)
public interface IDummyMarketDataService extends RestService {

	/**
	 * Asynchronous method returning sample data for the security market.
	 * 
	 * @param token
	 *            dummy token
	 * @param securitiesData
	 *            callback for a sample for security market data
	 */
	@POST
	@Path(ServicePaths.SECURITIES_RESOURCE)
	@Produces(MediaType.APPLICATION_JSON)
	public void requestSecurityData(RequestInfo requestInfo, MethodCallback<SecurityMarketData> securitiesData);

	/**
	 * Asynchronous method returning sample data for the crypto market.
	 * 
	 * @param token
	 *            dummy token
	 * @param securitiesData
	 *            callback for a sample for crypto market data
	 */
	@POST
	@Path(ServicePaths.CRYPTO_RESOURCE)
	@Produces(MediaType.APPLICATION_JSON)
	public void requestCryptoData(RequestInfo requestInfo, MethodCallback<CryptoMarketData> cryptoData);
}
