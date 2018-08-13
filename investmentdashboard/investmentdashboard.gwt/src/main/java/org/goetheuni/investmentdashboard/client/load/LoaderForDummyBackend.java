package org.goetheuni.investmentdashboard.client.load;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.goetheuni.investmentdashboard.client.global.TokenStorage;
import org.goetheuni.investmentdashboard.client.restCallAPI.IDummyLoginService;
import org.goetheuni.investmentdashboard.client.ui.HeaderLabelBlack;
import org.goetheuni.investmentdashboard.shared.impl.AuthenticationToken;
import org.goetheuni.investmentdashboard.shared.impl.LoginInfo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Objects of this class are helper objects for the loading process. These
 * objects access the services of the dummy backend and store the retrieved
 * data.
 * 
 * JAVADOC DONE
 */
public class LoaderForDummyBackend implements Loader {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.goetheuni.investmentdashboard.client.load.Loader#performLogin(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public void performLoginAndStoreToken(String customerID, String passwordInfo, Runnable actionAfterLoginAttempt) {
		IDummyLoginService loginService = GWT.create(IDummyLoginService.class);

		// create the login info
		LoginInfo loginInfo = new LoginInfo(customerID, passwordInfo);

		// start request
		loginService.performLogin(loginInfo, new MethodCallback<AuthenticationToken>() {

			@Override
			public void onSuccess(Method method, AuthenticationToken response) {
				if (response != null) {
					// this is fine, the response is the token
					// store the token
					TokenStorage.put(response.getToken());
					// perform the follow-up actions
					actionAfterLoginAttempt.run();
				} else {
					RootPanel.get().add(
							new HeaderLabelBlack("The login rest call was successful but the login was unsuccessful"));
				}
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				RootPanel.get().add(new HeaderLabelBlack("The login rest call failed."));
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.goetheuni.investmentdashboard.client.load.Loader#loadAndStore(java.lang.
	 * String, java.lang.Runnable)
	 */
	@Override
	public void loadAndStore(String token, Runnable actionAfterLoadingCompleted) {
		new DummyParentDataService(token, actionAfterLoadingCompleted).startRequest();
	}

}
