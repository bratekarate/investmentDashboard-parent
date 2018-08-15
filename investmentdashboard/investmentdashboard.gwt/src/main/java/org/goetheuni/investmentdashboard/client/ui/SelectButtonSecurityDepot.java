package org.goetheuni.investmentdashboard.client.ui;

import org.goetheuni.investmentdashboard.client.resourceBundles.Resources;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

/**
 * Objects of this class represent select buttons for security depots.
 * 
 * JAVADOC DONE
 */
public class SelectButtonSecurityDepot extends AbstractSelectButton<SelectableSecurityDepot> {

	/**
	 * Creates the button's volatility label
	 * 
	 * @param correspondingObject
	 *            The security depot
	 * @return A label, that expresses the securities depot volatility
	 */
	private static VolatilityLabel createLabel(SelectableSecurityDepot correspondingObject) {
		return new VolatilityLabel("Entwicklung zum Vortag: ", correspondingObject.getAmount(),
				correspondingObject.getReferenceValue());
	}

	/**
	 * Creates a select button for the given security depot.
	 * 
	 * @param correspondingObject
	 *            The security depot
	 */
	public SelectButtonSecurityDepot(SelectableSecurityDepot correspondingObject) {
		this(Resources.getPictogram(), correspondingObject, createLabel(correspondingObject), new Label());
	}

	/**
	 * NOT A PART OF THE API
	 * 
	 * @param icon
	 *            please see the superclass constructor
	 * @param correspondingStructure
	 *            please see the superclass constructor
	 * @param optionalVolatilityLabel
	 *            please see the superclass constructor
	 * @param optionalAmountLabel
	 *            please see the superclass constructor
	 */
	protected SelectButtonSecurityDepot(Image icon, SelectableSecurityDepot correspondingStructure,
			VolatilityLabel optionalVolatilityLabel, Label optionalAmountLabel) {
		super(icon, correspondingStructure, optionalVolatilityLabel, optionalAmountLabel);
	}

}
