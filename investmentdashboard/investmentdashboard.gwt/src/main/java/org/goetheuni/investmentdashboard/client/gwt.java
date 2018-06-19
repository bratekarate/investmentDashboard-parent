package org.goetheuni.investmentdashboard.client;

import org.fusesource.restygwt.client.Defaults;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
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

		// add a load button
		Button load = new Button("Load");
		verticalPanel.add(load);
		load.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				ShowRealData.showData(verticalPanel);

			}
		});

	}
}
