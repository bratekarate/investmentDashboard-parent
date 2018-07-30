package org.goetheuni.investmentdashboard.client.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.goetheuni.investmentdashboard.shared.impl.CashPayment;
import org.goetheuni.investmentdashboard.shared.impl.CryptoPayment;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.user.client.ui.Grid;

public class DetailWidgetCryptoWallet extends Grid implements AbstractDetailWidget<SelectableCryptoWallet> {

	private static int NUMBER_OF_PAYMENTS = 2;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.goetheuni.investmentdashboard.client.ui.AbstractDetailWidget#update(org.
	 * goetheuni.investmentdashboard.client.ui.Selectable)
	 */
	@Override
	public void update(SelectableCryptoWallet correspondingObject) {
		// get recent payments
		List<CryptoPayment> payments = correspondingObject
				.getRecentPaymentsSorted(DetailWidgetCryptoWallet.NUMBER_OF_PAYMENTS);

		// reset the table, but only the content
		for (int row = 0; row < this.getRowCount(); row++) {
			for (int col = 0; col < this.getColumnCount(); col++) {
				this.setText(row, col, "");
			}
		}
		
		// add description in the first row
		this.setText(0, 0, "letzte Buchungen:");

		// plot payments
		for (int indexOfPayments = 0; indexOfPayments < payments.size(); indexOfPayments++) {
			// get the payment
			CryptoPayment payment = payments.get(indexOfPayments);

			// set the date
			this.setText(indexOfPayments+1, 0,
					DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_MEDIUM).format(payment.getDateOfExecution()));

			// set the counter party name
			this.setText(indexOfPayments+1, 1, payment.getCounterPartyAddress());

			// format the amount
			BigDecimal rounded = payment.getAmount().setScale(6, RoundingMode.DOWN);
			String sign = rounded.signum() < 0 ? "-" : "";
			NumberFormat format = NumberFormat.getDecimalFormat().overrideFractionDigits(2, 6);
			BigDecimal absolute = rounded.abs();

			// set the amount
			this.getCellFormatter().getElement(indexOfPayments+1, 2).getStyle().setTextAlign(TextAlign.RIGHT);
			this.setText(indexOfPayments+1, 2, sign + payment.getCurrencyCode() + format.format(absolute.doubleValue()));

			// set the color
			String color = payment.getAmount().signum() < 0 ? StyleConstants.NEGATIVE_COLOR
					: StyleConstants.POSITIVE_COLOR;
			this.getCellFormatter().getElement(indexOfPayments+1, 2).getStyle().setColor(color);
		}
	}

	public DetailWidgetCryptoWallet() {
		super(DetailWidgetCryptoWallet.NUMBER_OF_PAYMENTS+1, 3);
		this.getColumnFormatter().setWidth(0, "40%");
		this.getColumnFormatter().setWidth(1, "40%");
		this.getColumnFormatter().setWidth(2, "20%");
		this.setWidth(SizeConstants.ForCatWidgets.getWidth());
	}

}
