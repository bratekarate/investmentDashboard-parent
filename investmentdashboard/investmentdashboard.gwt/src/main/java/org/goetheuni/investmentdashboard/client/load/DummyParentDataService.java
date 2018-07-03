package org.goetheuni.investmentdashboard.client.load;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.goetheuni.investmentdashboard.client.global.CryptoMarketDataStorage;
import org.goetheuni.investmentdashboard.client.global.CustomerDataStorage;
import org.goetheuni.investmentdashboard.client.global.SecurityMarketDataStorage;
import org.goetheuni.investmentdashboard.client.restCallAPI.IDummyCustomerDataService;
import org.goetheuni.investmentdashboard.client.restCallAPI.IDummyMarketDataService;
import org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData;
import org.goetheuni.investmentdashboard.shared.impl.Customer;
import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;

import com.google.gwt.core.client.GWT;

/**
 * This class synchronizes the asynchronous calls to the microservices.
 * 
 */
public class DummyParentDataService {

	/**
	 * The number of children data rest calls. Must be updated, if new calls is
	 * added.
	 */
	protected static int NUMBER_OF_CHILDREN = 3;

	/**
	 * The action that will be executed after the loading is completed.
	 */
	protected Runnable actionAfterLoadingCompleted;

	/**
	 * The token for authentication
	 */
	protected String token;

	/**
	 * Counts the number of children, which have finished.
	 */
	protected AtomicInteger numberOfDones;

	protected void done() {
		// register the child service call as done
		this.numberOfDones.incrementAndGet();

		if (0 < this.numberOfDones.get() && this.numberOfDones.get() < DummyParentDataService.NUMBER_OF_CHILDREN) {
			// not all children have finished -> continue
		} else if (this.numberOfDones.get() == DummyParentDataService.NUMBER_OF_CHILDREN) {
			// all children have finished -> execute next action
			this.actionAfterLoadingCompleted.run();
		} else {
			throw new RuntimeException(
					"The number of dones is not in the valid range, was: " + this.numberOfDones.get());
		}
	}

	protected static void storeCustomerData(Customer data) {
		CustomerDataStorage.put(data);
	}

	protected static void storeSecMarketData(SecurityMarketData data) {
		SecurityMarketDataStorage.put(data);
	}

	protected static void storeCryptoMarketData(CryptoMarketData data) {
		CryptoMarketDataStorage.put(data);
	}

	/**
	 * This method starts the parent request.
	 * All child requests are executed.
	 * After all children have finished, the given next action will be executed.
	 */
	public void startRequest() {

		DummyParentDataService that = this;

		// create interfaces to the micro-services
		IDummyCustomerDataService customerService = GWT.create(IDummyCustomerDataService.class);
		IDummyMarketDataService marketService = GWT.create(IDummyMarketDataService.class);

		// load and store customer data
		customerService.requestCustomerData(token, new MethodCallback<Customer>() {

			@Override
			public void onFailure(Method method, Throwable exception) {
				throw new RuntimeException(exception);
			}

			@Override
			public void onSuccess(Method method, Customer response) {
				DummyParentDataService.storeCustomerData(response);
				that.done();
			}
		});

		// load and store security market data
		marketService.requestSecurityData(token, new MethodCallback<SecurityMarketData>() {

			@Override
			public void onSuccess(Method method, SecurityMarketData response) {
				DummyParentDataService.storeSecMarketData(response);
				that.done();
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				throw new RuntimeException(exception);
			}
		});

		// get and store crypto market data
		marketService.requestCryptoData(token, new MethodCallback<CryptoMarketData>() {

			@Override
			public void onSuccess(Method method, CryptoMarketData response) {
				DummyParentDataService.storeCryptoMarketData(response);
				that.done();
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				throw new RuntimeException(exception);
			}
		});
	}

	public DummyParentDataService(String authToken, Runnable actionAfterLoadingCompleted) {
		this.numberOfDones = new AtomicInteger(0);
		this.token = Objects.requireNonNull(authToken, "The given authentification token must not be null");
		this.actionAfterLoadingCompleted = Objects.requireNonNull(actionAfterLoadingCompleted,
				"The object containing the action after loading must not be null");
	}

}
