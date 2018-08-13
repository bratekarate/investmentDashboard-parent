package org.goetheuni.investmentdashboard.client.restCallAPI;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import org.goetheuni.investmentdashboard.shared.ServicePaths;
import org.goetheuni.investmentdashboard.shared.impl.Customer;
import org.goetheuni.investmentdashboard.shared.impl.RequestInfo;

/**
 * This is the client-side interface for the customer data service.
 */
@Path("/" + ServicePaths.CUSTOMER_DIRECTORY + "/" + ServicePaths.CUSTOMER_DATA_SERVICE)
public interface IDummyCustomerDataService extends RestService {

	/**
	 * Asynchronous method returning sample data for a customer.
	 * 
	 * @param token
	 *            dummy token
	 * @param customerData
	 *            callback for a sample customer
	 */
	@POST
	@Path(ServicePaths.CUSTOMER_RESOURCE)
	public void requestCustomerData(RequestInfo requestInfo, MethodCallback<Customer> customerData);
}
