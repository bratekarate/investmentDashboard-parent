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
import org.goetheuni.investmentdashboard.shared.impl.RequestInfo;
import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;

import com.google.gwt.core.client.GWT;

/**
 * This class synchronizes the asynchronous calls to the microservices. The
 * calls are performed in parallel. Therefore they require serialization. A
 * sequential procedure would be too slow and would render the microservice
 * concept infeasible.
 * 
 * JAVADOC DONE
 */
public class DummyParentDataService {

	/**
	 * The number of children data rest calls. Must be updated, if new calls are
	 * added.
	 */
	protected static int NUMBER_OF_CHILDREN = 3;

	/**
	 * The action that will be executed after the loading is completed.
	 */
	protected Runnable actionAfterLoadingCompleted;

	/**
	 * The authentication token and the customer id.
	 */
	protected RequestInfo requestInfo;

	/**
	 * Counts the number of child-calls, that have terminated successfully.
	 */
	protected AtomicInteger numberOfDones;

	/**
	 * This method will be called by the child requests. Either all children have
	 * finished successfully or not. Only after all children have finished
	 * successfully, the action after loading will be executed.
	 */
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

	/**
	 * Stores the given data at the client.
	 * 
	 * @param data
	 *            retrived customer data
	 */
	protected static void storeCustomerData(Customer data) {
		CustomerDataStorage.put(data);
	}

	/**
	 * Stores the given data at the client.
	 * 
	 * @param data
	 *            retrieved security market data
	 */
	protected static void storeSecMarketData(SecurityMarketData data) {
		SecurityMarketDataStorage.put(data);
	}

	/**
	 * Stores the given data at the client.
	 * 
	 * @param data
	 *            retrieved crypto market data
	 */
	protected static void storeCryptoMarketData(CryptoMarketData data) {
		CryptoMarketDataStorage.put(data);
	}

	/**
	 * This method starts the parent request. All child requests are executed. After
	 * all children have finished successfully, the next action given to the
	 * constructor will be executed.
	 */
	public void startRequest() {

		// required because "this" points to the method callback in the method
		// callback's definition.
		DummyParentDataService that = this;

		// create interfaces to the micro-services
		IDummyCustomerDataService customerService = GWT.create(IDummyCustomerDataService.class);
		IDummyMarketDataService marketService = GWT.create(IDummyMarketDataService.class);

		// load and store customer data
		customerService.requestCustomerData(this.requestInfo, new MethodCallback<Customer>() {

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
		marketService.requestSecurityData(this.requestInfo, new MethodCallback<SecurityMarketData>() {

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
		marketService.requestCryptoData(this.requestInfo, new MethodCallback<CryptoMarketData>() {

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

	/**
	 * This method creates a new parent service request for the initial loading
	 * process.
	 * 
	 * @param requestInfo
	 *            The authentication token for the mid-tier and the customer id.
	 * @param actionAfterLoadingCompleted
	 *            The action that will be executed after all child requests have
	 *            finished successfully.
	 */
	public DummyParentDataService(RequestInfo requestInfo, Runnable actionAfterLoadingCompleted) {
		this.numberOfDones = new AtomicInteger(0);
		this.requestInfo = Objects.requireNonNull(requestInfo, "The given request information must not be null");
		this.actionAfterLoadingCompleted = Objects.requireNonNull(actionAfterLoadingCompleted,
				"The object containing the action after loading must not be null");
	}

}
