package org.goetheuni.investmentdashboard.client;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.goetheuni.investmentdashboard.client.restCallAPI.IStringRestService;
import org.goetheuni.investmentdashboard.shared.domain.impl.StringForRest;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * A class with the functionality to load the test Rest Data into the provided
 * vertical panel.
 */
public class ShowRestResults {

	protected static void load(VerticalPanel verticalPanel) {
		// generate the service
		IStringRestService service = GWT.create(IStringRestService.class);

		// get 3 objects and show them on the vertical panel

		for (int i = 0; i < 3; i++) {
			service.getStringObjectAsync(new MethodCallback<StringForRest>() {

				@Override
				public void onSuccess(Method method, StringForRest response) {
					// add the data to the vertical panel
					verticalPanel.add(new Label("object: " + response.getKey() + " | " + response.getValue()));
				}

				@Override
				public void onFailure(Method method, Throwable exception) {
					throw new RuntimeException(exception);
				}
			});
		}

	}
}
