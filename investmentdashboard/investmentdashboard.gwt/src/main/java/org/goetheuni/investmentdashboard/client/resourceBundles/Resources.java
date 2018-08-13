package org.goetheuni.investmentdashboard.client.resourceBundles;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

/**
 * This class provides access to all resources (images, text, ...) stored at the
 * client-side.
 * 
 * JAVADOC DONE
 */
public class Resources {

	/**
	 * The CAPGEMINI pictogram.
	 */
	private static ImageResource pictogram;

	/**
	 * The desired width of the pictogram in pixles. Will be used for re-scaling.
	 */
	private static int pictogramWidth = 40;

	/**
	 * @return The width of the pictogram after re-scaling.
	 */
	public static int getPictogramWidth() {
		return Resources.pictogramWidth;
	}

	public static Image getPictogram() {
		Image result;
		if (Resources.pictogram != null) {
			result = new Image(Resources.pictogram);
		} else {
			ImageBundle bundle = GWT.create(ImageBundle.class);
			Resources.pictogram = bundle.getPictogram();
			result = new Image(Resources.pictogram);
		}
		int newWidth = Resources.pictogramWidth;
		result.setPixelSize(newWidth, Resources.pictogram.getHeight() * newWidth / Resources.pictogram.getWidth());
		return result;
	}
}
