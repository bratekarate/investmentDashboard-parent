package org.goetheuni.investmentdashboard.client.restCallAPI;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData;
import org.goetheuni.investmentdashboard.shared.impl.RequestInfo;
import org.goetheuni.investmentdashboard.shared.metadata.ServicePaths;

/**
 * This is the client-side interface for services for crypto assets' market and
 * reference data.
 * 
 * JAVADOC DONE
 */
@Path("/" + ServicePaths.CRYPTOMARKET_DIRECTORY + "/" + ServicePaths.CRYPTOMARKET_DATA_SERVICE)
public interface IDummyCryptoMarketDataService extends RestService {

	/**
	 * Asynchronous method returning for retrieving market and reference data for
	 * crypto assets.
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
