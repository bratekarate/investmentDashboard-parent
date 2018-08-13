package org.goetheuni.investmentdashboard.server.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.jetty.http.HttpGenerator.RequestInfo;
import org.goetheuni.investmentdashboard.server.data.DataDummy;
import org.goetheuni.investmentdashboard.shared.ServicePaths;
import org.goetheuni.investmentdashboard.shared.impl.Customer;

/**
 * This is the server-side implementation of the service for customer data.
 */
@Path(ServicePaths.CUSTOMER_DATA_SERVICE)
public class CustomerDataService {

	/**
	 * Returns JSON representation of a sample customer.
	 * 
	 * @param token
	 *            a dummy token
	 * @return a sample customer
	 */
	@POST
	@Path(ServicePaths.CUSTOMER_RESOURCE)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer requestCustomerData(RequestInfo requestInfo) {
		return DataDummy.getDummyCustomer();
	}
}
