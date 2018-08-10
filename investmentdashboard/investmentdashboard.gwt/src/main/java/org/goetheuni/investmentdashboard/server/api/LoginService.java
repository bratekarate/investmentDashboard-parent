package org.goetheuni.investmentdashboard.server.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.goetheuni.investmentdashboard.shared.ServicePaths;
import org.goetheuni.investmentdashboard.shared.impl.AuthenticationToken;
import org.goetheuni.investmentdashboard.shared.impl.LoginInfo;

@Path(ServicePaths.LOGIN_SERVICE)
public class LoginService {

	@POST
	@Path(ServicePaths.LOGIN_RESOURCE)
	@Produces(MediaType.APPLICATION_JSON)
	public AuthenticationToken performLogin(LoginInfo loginInfo) {

		// validate demo login info
		if ("utjw2X".equals(loginInfo.getCustomerID()) && "wjw2X".equals(loginInfo.getPasswordInfo())) {
			return new AuthenticationToken("totallyAToken");
		} else {
			return null;
		}

	}

}
