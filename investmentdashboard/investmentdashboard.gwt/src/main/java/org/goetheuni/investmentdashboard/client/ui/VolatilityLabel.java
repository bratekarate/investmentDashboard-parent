package org.goetheuni.investmentdashboard.client.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.google.gwt.user.client.ui.Label;

public class VolatilityLabel extends Label {

	public VolatilityLabel(String formattedAmount, BigDecimal value, BigDecimal referenceValue) {

		if (/* non-empty */referenceValue.signum() > 0) {

			// compute the difference and determine the color
			BigDecimal difference = value.subtract(referenceValue).setScale(6, RoundingMode.DOWN);
			boolean isNegaitve = difference.signum() < 0;
			String color = isNegaitve ? StyleConstants.NEGATIVE_COLOR : StyleConstants.POSITIVE_COLOR;

			// set the style
			this.getElement().getStyle().setColor(color);
			this.getElement().getStyle().setFontSize(FontConstants.CATEGORYCONTENT, FontConstants.UNIT);

			// generate text
			BigDecimal relativeDifference = difference.divide(referenceValue.setScale(6, RoundingMode.UP),
					RoundingMode.DOWN);
			BigDecimal inPercentage = relativeDifference.movePointRight(2).setScale(2, RoundingMode.DOWN);

			String potentialPlus = isNegaitve ? "" : "+";

			this.setText(formattedAmount + "  " + "(" + potentialPlus + inPercentage.toString() + "%)");
		} else /* must be an empty depot or wallet */ {
			throw new RuntimeException(
					"Cannot construct a volatility label for a reference value of 0 or smaller. Empty depots or wallets are not allowed for this method. Was: "
							+ referenceValue.toString());
		}

	}

	public VolatilityLabel() {
		// default
	}
}
