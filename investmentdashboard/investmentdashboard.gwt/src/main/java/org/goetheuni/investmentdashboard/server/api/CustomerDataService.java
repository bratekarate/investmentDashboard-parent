package org.goetheuni.investmentdashboard.server.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.goetheuni.investmentdashboard.server.data.DataDummy;
import org.goetheuni.investmentdashboard.shared.impl.Customer;
import org.goetheuni.investmentdashboard.shared.impl.RequestInfo;
import org.goetheuni.investmentdashboard.shared.metadata.ServicePaths;

/**
 * This is the server-side implementation of the service for customer data.
 * 
 * JAVADOC DONE
 */
@Path(ServicePaths.CUSTOMER_DATA_SERVICE)
public class CustomerDataService {

	/**
	 * Returns JSON representation of customer's data.
	 * 
	 * @param requestInfo
	 *            an authentication token and the customer ID
	 * @return JSON representation of the data of the customer with the given
	 *         customer ID
	 */
	@POST
	@Path(ServicePaths.CUSTOMER_RESOURCE)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer requestCustomerData(RequestInfo requestInfo) {
		return DataDummy.getDummyCustomer();
	}
}
