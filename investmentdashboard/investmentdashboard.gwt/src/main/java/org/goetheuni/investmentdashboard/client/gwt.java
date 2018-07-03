package org.goetheuni.investmentdashboard.client;

import org.fusesource.restygwt.client.Defaults;
import org.goetheuni.investmentdashboard.client.global.CryptoMarketDataStorage;
import org.goetheuni.investmentdashboard.client.global.CustomerDataStorage;
import org.goetheuni.investmentdashboard.client.global.SecurityMarketDataStorage;
import org.goetheuni.investmentdashboard.client.load.Loader;
import org.goetheuni.investmentdashboard.client.load.LoaderForDummyBackend;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

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
		final VerticalPanel verticalPanel = new VerticalPanel();

		// add the new vertical panel to the root
		rootPanel.add(verticalPanel);

		// load data
		Loader loader = new LoaderForDummyBackend();
		loader.loadAndStore(new Runnable() {
			
			// action after the loading process has finished
			@Override
			public void run() {
				verticalPanel.add(new Label(CustomerDataStorage.get().toString()));
				verticalPanel.add(new Label(SecurityMarketDataStorage.get().toString()));
				verticalPanel.add(new Label(CryptoMarketDataStorage.get().toString()));
			}
		});
		
	}
}
