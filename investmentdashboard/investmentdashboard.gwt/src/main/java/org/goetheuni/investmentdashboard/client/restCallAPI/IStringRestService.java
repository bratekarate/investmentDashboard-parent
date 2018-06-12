package org.goetheuni.investmentdashboard.client.restCallAPI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import org.goetheuni.investmentdashboard.server.api.ServicePaths;
import org.goetheuni.investmentdashboard.shared.domain.impl.StringForRest;

@Path("/"+ServicePaths.DIRECTORY_OF_SERVICES+"/"+ServicePaths.STRING_TEST_SERVICE)
public interface IStringRestService extends RestService {
	
	@GET
	public void getStringObjectAsync(MethodCallback<StringForRest> obj);
	
}
