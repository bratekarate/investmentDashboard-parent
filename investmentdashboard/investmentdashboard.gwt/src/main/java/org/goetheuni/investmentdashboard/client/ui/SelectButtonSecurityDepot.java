package org.goetheuni.investmentdashboard.client.ui;

import org.goetheuni.investmentdashboard.client.resourceBundles.Resources;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class SelectButtonSecurityDepot extends AbstractSelectButton<SelectableSecurityDepot> {

	private static VolatilityLabel createLabel(SelectableSecurityDepot correspondingObject) {
		return new VolatilityLabel("Entwicklung zum Vortag: ", correspondingObject.getAmount(),
				correspondingObject.getReferenceValue());
	}

	public SelectButtonSecurityDepot(SelectableSecurityDepot correspondingObject) {
		this(Resources.getPictogram(), correspondingObject, createLabel(correspondingObject), new Label());
	}

	protected SelectButtonSecurityDepot(Image icon, SelectableSecurityDepot correspondingStructure,
			VolatilityLabel optionalVolatilityLabel, Label optionalAmountLabel) {
		super(icon, correspondingStructure, optionalVolatilityLabel, optionalAmountLabel);
	}

}
