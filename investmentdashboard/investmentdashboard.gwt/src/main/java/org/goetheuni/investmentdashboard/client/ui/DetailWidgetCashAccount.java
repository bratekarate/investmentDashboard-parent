package org.goetheuni.investmentdashboard.client.ui;

import java.util.List;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.impl.CashPayment;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.Grid;

public class DetailWidgetCashAccount extends Grid implements AbstractDetailWidget<SelectableCashAccount> {

	protected SelectableCashAccount currentCorrespondingObject;

	private static final int NUMBER_OF_PAYMENTS = 4;

	/**
	 * @return the currentCorrespondingObject
	 */
	public SelectableCashAccount getCurrentCorrespondingObject() {
		return currentCorrespondingObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.goetheuni.investmentdashboard.client.ui.AbstractDetailWidget#update(org.
	 * goetheuni.investmentdashboard.client.ui.Selectable)
	 */
	@Override
	public void update(SelectableCashAccount correspondingObject) {

		// set the current corresponding object
		this.currentCorrespondingObject = Objects.requireNonNull(correspondingObject,
				"The given structure object must not be null");

		// ensure visibility
		this.setTableContentVisibility(true);
		
		// get recent payments
		List<CashPayment> payments = correspondingObject
				.getRecentPaymentsSorted(DetailWidgetCashAccount.NUMBER_OF_PAYMENTS);

		// reset the table, but only the content
		for (int row = 0; row < this.getRowCount(); row++) {
			for (int col = 0; col < this.getColumnCount(); col++) {
				this.setText(row, col, "");
			}
		}

		// add description
		this.setText(0, 0, "letzte Buchungen:");

		// plot payments
		for (int indexOfPayment = 0; indexOfPayment < payments.size(); indexOfPayment++) {
			// get the payment
			CashPayment payment = payments.get(indexOfPayment);

			// set the date
			this.setText(indexOfPayment + 1, 0,
					DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_MEDIUM).format(payment.getDateOfExecution()));

			// set the counter party name
			this.setText(indexOfPayment + 1, 1, payment.getCounterPartyName());

			// set the amount
			this.getCellFormatter().getElement(indexOfPayment + 1, 2).getStyle().setTextAlign(TextAlign.RIGHT);
			this.setText(indexOfPayment + 1, 2, NumberFormat.getCurrencyFormat("EUR").format(payment.getAmount()));

			// set the color
			String color = payment.getAmount().signum() < 0 ? StyleConstants.NEGATIVE_COLOR
					: StyleConstants.POSITIVE_COLOR;
			this.getCellFormatter().getElement(indexOfPayment + 1, 2).getStyle().setColor(color);

		}
	}

	

	
	/* (non-Javadoc)
	 * @see org.goetheuni.investmentdashboard.client.ui.AbstractDetailWidget#resetAppearance()
	 */
	@Override
	public void resetAppearance() {
		// hide table content
		this.setTableContentVisibility(false);
	}
	
	/**
	 * Allows to set the visibility of the contained HTML tables content.
	 * 
	 * @param visibility true = visible, false = not visible
	 */
	protected void setTableContentVisibility(boolean visibility) {
		if(visibility) {
			for(int index = 0; index<this.getRowCount(); index++) {
				// set visible
				this.getRowFormatter().getElement(index).getStyle().setVisibility(Style.Visibility.VISIBLE);
			}
		}else {
			for(int index = 0; index<this.getRowCount(); index++) {
				// set invisible
				this.getRowFormatter().getElement(index).getStyle().setVisibility(Style.Visibility.HIDDEN);
			}
		}
	}

	public DetailWidgetCashAccount() {
		super(DetailWidgetCashAccount.NUMBER_OF_PAYMENTS + 1, 3);
		this.getColumnFormatter().setWidth(0, "40%");
		this.getColumnFormatter().setWidth(1, "40%");
		this.getColumnFormatter().setWidth(2, "20%");
		this.setWidth(SizeConstants.ForCatWidgets.getWidth());
	}

}
