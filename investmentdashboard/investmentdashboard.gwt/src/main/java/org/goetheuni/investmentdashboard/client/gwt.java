package org.goetheuni.investmentdashboard.client;

import org.fusesource.restygwt.client.Defaults;
import org.goetheuni.investmentdashboard.client.global.CustomerDataStorage;
import org.goetheuni.investmentdashboard.client.global.TokenStorage;
import org.goetheuni.investmentdashboard.client.load.Loader;
import org.goetheuni.investmentdashboard.client.load.LoaderForDummyBackend;
import org.goetheuni.investmentdashboard.client.structure.RootStructure;
import org.goetheuni.investmentdashboard.client.ui.UIBuilder;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class gwt implements EntryPoint {

	/**
	 * This is the entry point method. It is the first method, that will be
	 * executed, if the GWT project is run. It is similar to a main method.
	 */
	public void onModuleLoad() {

		Defaults.setServiceRoot(GWT.getHostPageBaseURL());
		Defaults.setDateFormat(null);

		RootPanel rootPanel = RootPanel.get();

		Loader loader = new LoaderForDummyBackend();

		// the demo login information "custjw2X".equals(customerID) &&
		// "pwjw2X".equals(passwordInfo
		String customerID = "utjw2X";
		String passwordInfo = "wjw2X";

		// perform login
		loader.performLoginAndStoreToken(customerID, passwordInfo, new Runnable() {

			// action after a successful login (the token is present at the storage)
			@Override
			public void run() {

				// load data
				loader.loadAndStore(TokenStorage.get(), new Runnable() {

					// action after the loading process has finished (data is at the storages)
					@Override
					public void run() {

						// create the logical structure of the page
						RootStructure.initialize(CustomerDataStorage.get());

						// build UI
						UIBuilder.buildUI(rootPanel, RootStructure.get());

					}
				});
			}
		});

	}
}
