package org.goetheuni.investmentdashboard.client.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.google.gwt.user.client.ui.Label;

/**
 * Objects of this class are labels, which express volatility.
 * 
 * JAVADOC DONE
 */
public class VolatilityLabel extends Label {

	/**
	 * Creates a new volatility label with the given data. for example: new
	 * V.-L.("TOTAL: 10€", 10, 20) will be a label with red colored text "TOTAL: 10€
	 * (-50.00%)"
	 * 
	 * @param formattedAmount
	 *            The left part of the label's text. Can be the amount as a
	 *            formatted string.
	 * @param value
	 *            The asset's value
	 * @param referenceValue
	 *            The asset's reference value
	 */
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

		} else if (referenceValue.signum() == 0)/* must be an empty depot or wallet */ {
			// set the style
			this.getElement().getStyle().setFontSize(FontConstants.CATEGORYCONTENT, FontConstants.UNIT);

			this.setText(formattedAmount + "  " + "(+0%)");

		} else {
			// must be an error
			throw new RuntimeException("Cannot construct a volatility label for a negative reference value. Was: "
					+ referenceValue.toString());
		}
	}

	/**
	 * Creates an empty label. The font size is the category dontent size.
	 */
	public VolatilityLabel() {
		// default empty label
		this.getElement().getStyle().setFontSize(FontConstants.CATEGORYCONTENT, FontConstants.UNIT);
	}
}
