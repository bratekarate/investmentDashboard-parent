package org.goetheuni.investmentdashboard.client.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import org.goetheuni.investmentdashboard.client.structure.SecurityInvestmentStruct;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AbstractInvestmentWidget extends HorizontalPanel {

	protected SecurityInvestmentStruct correspondingObject;

	protected VerticalPanel quotationPanel;

	protected VerticalPanel volumePanel;

	protected Label name;

	protected Label quotation;

	protected Label quotationDelta;

	protected Label delta;

	protected Label quantity;

	protected static Label createQuotationDeltaLabel(SecurityInvestmentStruct correspondingObject) {

		BigDecimal referenceValue = correspondingObject.getSingleSecurityReferenceValue();
		BigDecimal quotation = correspondingObject.getSingleSecurityQuotation();

		Label result = new SmallContentLabelDefault();

		if (/* non-empty */referenceValue.signum() > 0) {

			// compute the difference in percentage and determine the color
			BigDecimal difference = quotation.subtract(referenceValue).setScale(6, RoundingMode.DOWN);
			boolean isNegaitve = difference.signum() < 0;

			// generate and set the color
			String color = isNegaitve ? StyleConstants.NEGATIVE_COLOR : StyleConstants.POSITIVE_COLOR;
			result.getElement().getStyle().setColor(color);

			// generate text
			BigDecimal relativeDifference = difference.divide(referenceValue.setScale(6, RoundingMode.UP),
					RoundingMode.DOWN);
			BigDecimal inPercentage = relativeDifference.movePointRight(2).setScale(2, RoundingMode.DOWN);

			String potentialPlus = isNegaitve ? "" : "+";

			// set the text and return
			result.setText("(" + potentialPlus + inPercentage.toString() + "%)");
			return result;

		} else /* must be an empty structure object */ {
			throw new RuntimeException("Cannot construct a label for a reference value of 0 or smaller. Was: "
					+ referenceValue.toString());
		}
	}

	protected static Label createQuantityLabel(SecurityInvestmentStruct correspondingObject) {
		// generate the text and return the label
		String content = correspondingObject.getQuantity() + " Stk.";
		return new SmallContentLabelDefault(content);
	}

	protected static Label createDeltaLabel(SecurityInvestmentStruct correspondingObject) {
		// generate the text
		BigDecimal delta = correspondingObject.getCachedDelta();
		boolean isNegaitve = delta.signum() < 0;
		String deltaString = NumberFormat.getCurrencyFormat("EUR").format(delta);
		String optionalPlus = isNegaitve ? "" : "+";
		String content = "(" + optionalPlus + deltaString + ")";
		Label result = new SmallContentLabelDefault(content);

		// set the color
		String color = isNegaitve ? StyleConstants.NEGATIVE_COLOR : StyleConstants.POSITIVE_COLOR;
		result.getElement().getStyle().setColor(color);

		return result;
	}

	protected AbstractInvestmentWidget(SecurityInvestmentStruct correspondingObject) {
		// validate input
		this.correspondingObject = Objects.requireNonNull(correspondingObject,
				"The given structure object must not be null");

		this.setWidth("100%");

		// configure the first level of child widgets
		Label newName = new SmallContentLabelBlack(correspondingObject.getSecurityShortName());
		this.name = newName;
		this.add(newName);
		this.setCellWidth(newName, "40%");
		newName.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		this.setCellHorizontalAlignment(newName, HasHorizontalAlignment.ALIGN_LEFT);

		VerticalPanel newQuotPanel = new VerticalPanel();
		this.quotationPanel = newQuotPanel;
		this.add(newQuotPanel);
		this.setCellWidth(newQuotPanel, "30%");
		newQuotPanel.setWidth("100%");
		newQuotPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.setCellHorizontalAlignment(newQuotPanel, HasHorizontalAlignment.ALIGN_RIGHT);

		VerticalPanel newVolumePanel = new VerticalPanel();
		this.volumePanel = newVolumePanel;
		this.add(newVolumePanel);
		this.setCellWidth(newVolumePanel, "30%");
		newVolumePanel.setWidth("100%");
		newVolumePanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.setCellHorizontalAlignment(newVolumePanel, HasHorizontalAlignment.ALIGN_RIGHT);

		// configure the second level of child widgets
		String quotationString = NumberFormat.getCurrencyFormat("EUR")
				.format(correspondingObject.getSingleSecurityQuotation()) + "/Stk.";
		Label newQuotation = new SmallContentLabelDefault(quotationString);
		this.quotation = newQuotation;
		this.quotationPanel.add(newQuotation);

		this.quotationPanel.add(AbstractInvestmentWidget.createQuotationDeltaLabel(correspondingObject));

		Label newQuantity = AbstractInvestmentWidget.createQuantityLabel(correspondingObject);
		this.quantity = newQuantity;
		this.volumePanel.add(newQuantity);

		Label newDelta = AbstractInvestmentWidget.createDeltaLabel(correspondingObject);
		this.delta = newDelta;
		this.volumePanel.add(newDelta);

	}

}
