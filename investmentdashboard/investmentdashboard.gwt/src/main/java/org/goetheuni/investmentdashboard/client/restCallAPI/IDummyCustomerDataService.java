package org.goetheuni.investmentdashboard.client.restCallAPI;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import org.goetheuni.investmentdashboard.shared.impl.Customer;
import org.goetheuni.investmentdashboard.shared.impl.RequestInfo;
import org.goetheuni.investmentdashboard.shared.metadata.ServicePaths;

/**
 * This is the client-side interface for the customer data service.
 * 
 * JAVADOC DONE
 */
@Path("/" + ServicePaths.CUSTOMER_DIRECTORY + "/" + ServicePaths.CUSTOMER_DATA_SERVICE)
public interface IDummyCustomerDataService extends RestService {

	/**
	 * Asynchronous method to retrieve customer data from the mid-tier.
	 * 
	 * @param requestInfo
	 *            the authentication token and the customer id.
	 * @param customerData
	 *            callback returning the retrieved data
	 */
	@POST
	@Path(ServicePaths.CUSTOMER_RESOURCE)
	public void requestCustomerData(RequestInfo requestInfo, MethodCallback<Customer> customerData);
}
