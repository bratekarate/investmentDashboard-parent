package org.goetheuni.investmentdashboard.client.restCallAPI;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import org.goetheuni.investmentdashboard.shared.ServicePaths;
import org.goetheuni.investmentdashboard.shared.impl.AuthenticationToken;
import org.goetheuni.investmentdashboard.shared.impl.LoginInfo;

@Path("/" + ServicePaths.LOGIN_DIRECTORY + "/" + ServicePaths.LOGIN_SERVICE)
public interface IDummyLoginService extends RestService {

	@POST
	@Path(ServicePaths.LOGIN_RESOURCE)
	@Produces(MediaType.APPLICATION_JSON)
	public void performLogin(LoginInfo loginInfo, MethodCallback<AuthenticationToken> token);

}
