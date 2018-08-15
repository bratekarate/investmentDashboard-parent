package org.goetheuni.investmentdashboard.server.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.goetheuni.investmentdashboard.server.data.DataDummy;
import org.goetheuni.investmentdashboard.shared.impl.RequestInfo;
import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;
import org.goetheuni.investmentdashboard.shared.metadata.ServicePaths;

/**
 * This is the server-side implementation of the service for security market and
 * reference data.
 * 
 * JAVADOC DONE
 */
@Path(ServicePaths.MARKET_DATA_SERVICE)
public class SecurityMarketDataService {

	/**
	 * Returns the required market and reference data for securities.
	 * 
	 * @param requestInfo
	 *            The authentication token and the customer ID
	 * @return the required market and reference data for securities
	 */
	@POST
	@Path(ServicePaths.SECURITIES_RESOURCE)
	@Produces(MediaType.APPLICATION_JSON)
	public SecurityMarketData requestSecurityMarketData(RequestInfo requestInfo) {
		// ignore the token as it is a dummy
		return DataDummy.getDummySecurities();
	}

}
