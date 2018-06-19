package org.goetheuni.investmentdashboard.client.restCallAPI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import org.goetheuni.investmentdashboard.shared.ServicePaths;
import org.goetheuni.investmentdashboard.shared.StringForRest;

@Path("/" + ServicePaths.STRING_DIRECTORY + "/" + ServicePaths.STRING_TEST_SERVICE)
public interface IStringRestService extends RestService {

	@GET
	public void getStringObjectAsync(MethodCallback<StringForRest> obj);

}
