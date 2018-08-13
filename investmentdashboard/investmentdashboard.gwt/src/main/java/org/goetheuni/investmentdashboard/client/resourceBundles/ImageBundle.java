package org.goetheuni.investmentdashboard.client.resourceBundles;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * This interface bundels all image resources, that are located at the
 * client-side.
 * 
 * JAVADOC DONE
 */
interface ImageBundle extends ClientBundle {

	/**
	 * @return loads and returns the CAPGEMINI pictogram.
	 */
	@Source("CGpicto.jpg")
	public ImageResource getPictogram();

}
