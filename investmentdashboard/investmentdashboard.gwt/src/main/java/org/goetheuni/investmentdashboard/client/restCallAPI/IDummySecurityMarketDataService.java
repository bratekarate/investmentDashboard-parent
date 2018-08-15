package org.goetheuni.investmentdashboard.client.restCallAPI;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import org.goetheuni.investmentdashboard.shared.impl.RequestInfo;
import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;
import org.goetheuni.investmentdashboard.shared.metadata.ServicePaths;

/**
 * This is the client-side interface the service for securities' market and
 * reference data.
 * 
 * JAVADOC DONE
 */
@Path("/" + ServicePaths.MARKET_DIRECTORY + "/" + ServicePaths.MARKET_DATA_SERVICE)
public interface IDummySecurityMarketDataService extends RestService {

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

}
