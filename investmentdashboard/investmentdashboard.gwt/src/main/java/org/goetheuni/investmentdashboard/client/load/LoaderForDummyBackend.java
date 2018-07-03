package org.goetheuni.investmentdashboard.client.load;

/**
 * Objects of this class are helper objects for the loading process. These
 * objects access the services of the dummy backend and store the retrieved
 * data.
 */
public class LoaderForDummyBackend implements Loader {

	@Override
	public void loadAndStore(Runnable actionAfterLoadingCompleted) {
		String dummyToken = "abc123";
		new DummyParentDataService(dummyToken, actionAfterLoadingCompleted).startRequest();
	}
}
