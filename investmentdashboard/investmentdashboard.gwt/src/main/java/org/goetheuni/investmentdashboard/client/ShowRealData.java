package org.goetheuni.investmentdashboard.client;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.goetheuni.investmentdashboard.client.restCallAPI.ICustomerDataService;
import org.goetheuni.investmentdashboard.client.restCallAPI.IMarketDataService;
import org.goetheuni.investmentdashboard.shared.domain.impl.CryptoMarketData;
import org.goetheuni.investmentdashboard.shared.domain.impl.Customer;
import org.goetheuni.investmentdashboard.shared.domain.impl.SecurityMarketData;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Retrieves sample data from the server and plots it.
 */
public class ShowRealData {

	protected static void showData(VerticalPanel verticalPanel) {

		String token = "token";
		// load market data
		IMarketDataService marketService = GWT.create(IMarketDataService.class);

		// get and show security market data
		marketService.requestSecurityData(token, new MethodCallback<SecurityMarketData>() {

			@Override
			public void onSuccess(Method method, SecurityMarketData response) {
				verticalPanel.add(new Label("------------------------------"));
				verticalPanel.add(new Label("Security market data: "));
				verticalPanel.add(new Label(response.toString()));
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				Window.alert(exception.toString());

			}
		});

		// // get and show crypto market data
		marketService.requestCryptoData(token, new MethodCallback<CryptoMarketData>() {

			@Override
			public void onSuccess(Method method, CryptoMarketData response) {
				verticalPanel.add(new Label("------------------------------"));
				verticalPanel.add(new Label("Crypto market data: "));
				verticalPanel.add(new Label(response.toString()));
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				Window.alert(exception.toString());
			}
		});

		// get and show customer data
		ICustomerDataService customerService = GWT.create(ICustomerDataService.class);

		// load and show customer data
		customerService.requestCustomerData(token, new MethodCallback<Customer>() {

			@Override
			public void onFailure(Method method, Throwable exception) {
				Window.alert(exception.toString());

			}

			@Override
			public void onSuccess(Method method, Customer response) {
				verticalPanel.add(new Label("------------------------------"));
				verticalPanel.add(new Label("Customer data: "));
				verticalPanel.add(new Label(response.toString()));

			}
		});

	}
}
