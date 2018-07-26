package org.goetheuni.investmentdashboard.client.ui;

import java.util.List;



import org.goetheuni.investmentdashboard.shared.impl.CashPayment;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.Grid;

public class DetailWidgetCashAccount extends Grid implements AbstractDetailWidget<SelectableCashAccount> {

	static private int NUMBER_OF_PAYMENTS = 3;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.goetheuni.investmentdashboard.client.ui.AbstractDetailWidget#update(org.
	 * goetheuni.investmentdashboard.client.ui.Selectable)
	 */
	@Override
	public void update(SelectableCashAccount correspondingObject) {
		// get recent payments
		List<CashPayment> payments = correspondingObject
				.getRecentPaymentsSorted(DetailWidgetCashAccount.NUMBER_OF_PAYMENTS);

		// reset the table
		this.clear();

		// plot payments
		for (int row = 0; row < payments.size(); row++) {
			// get the payment
			CashPayment payment = payments.get(row);

			// set the date
			this.setText(row, 0,
					DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_MEDIUM).format(payment.getDateOfExecution()));

			// set the counter party name
			this.setText(row, 1, payment.getCounterPartyName());

			// set the amount
			this.getCellFormatter().getElement(row, 2).getStyle().setTextAlign(TextAlign.RIGHT);
			this.setText(row, 2, NumberFormat.getCurrencyFormat("EUR").format(payment.getAmount()));
			
			// set the color
			String color = payment.getAmount().signum() < 0 ? StyleConstants.NEGATIVE_COLOR : StyleConstants.POSITIVE_COLOR;
			this.getCellFormatter().getElement(row, 2).getStyle().setColor(color);

		}
	}

	public DetailWidgetCashAccount() {
		super(DetailWidgetCashAccount.NUMBER_OF_PAYMENTS, 3);
		this.getColumnFormatter().setWidth(0, "40%");
		this.getColumnFormatter().setWidth(1, "40%");
		this.getColumnFormatter().setWidth(2, "20%");
		this.setWidth(SizeConstants.ForCatWidgets.getWidth());
	}

}
